package com.auto.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.auto.configProperties.ConfigProperties;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;



public class TestCore extends Page {

	static DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss");
	static Date date = new Date();
	public static Properties object = new Properties();
	public static Properties config = new Properties();
	public static AndroidDriver driver;
	public static String SCREENSHOT_FOLDER = "target/screenshots/";
	public static final String SCREENSHOT_FORMAT = ".png";
	private String os;
	private String deviceName;
	private String version;

	@BeforeSuite
	public void fetchSuiteConfiguration(ITestContext testContext) throws IOException, InterruptedException, MalformedURLException {

		os = ConfigProperties.OS;
		deviceName = ConfigProperties.device_Name;
		version = ConfigProperties.Android_version;
		


		if (os.toLowerCase().contains("android")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, version);
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
			cap.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"//src//main//resources//app//com.cybrary.cybrary-1.0.16.apk");
			cap.setCapability("autoGrantPermissions", "true");
			cap.setCapability(MobileCapabilityType.APP_PACKAGE, "com.cybrary.cybrary");
			cap.setCapability(MobileCapabilityType.APP_ACTIVITY, "md579b83d02395fe328fa80f34ea0dc7985.SplashActivity");
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}

	/**
	 * WebDriver initialization
	 * 
	 * @return WebDriver object
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@BeforeMethod(alwaysRun = true)
	public void setup(Method method) throws IOException, InterruptedException {
	
		log("--------------------------------------------------------", ILogLevel.TESTCASE);
		log("Test [" + method.getName() + "] Started", ILogLevel.TESTCASE);
		log("--------------------------------------------------------", ILogLevel.TESTCASE);

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	/**
	 * capture screenshot on test(pass/fail)
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @throws UnirestException 
	 * 
	 * 
	 */


	@AfterMethod(alwaysRun=true)
	public void setScreenshot(ITestResult result, Method method) throws InterruptedException, IOException{
		if (!result.isSuccess()) { 
			try {
				if ( driver != null) {
					File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					try {
						FileUtils.copyFile(f, new File(SCREENSHOT_FOLDER+ result.getName() + SCREENSHOT_FORMAT)
								.getAbsoluteFile());
					} catch (IOException e) { 
						e.printStackTrace(); 
					}
				}

			} catch (ScreenshotException se) {
				se.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(result.isSuccess()){
			try {
				//WebDriver returned = new Augmenter().augment(webDriver);
				if ( driver != null) {
					log("--------------------------------------------------------", ILogLevel.TESTCASE);
					log("Test [" +method.getName() +" ] Finish", ILogLevel.TESTCASE);
					log("--------------------------------------------------------", ILogLevel.TESTCASE);

				}

			} catch (ScreenshotException se) {
				se.printStackTrace();
			}

		}
	}


	@AfterSuite
	public void tearDown() {
		if(driver!=null){
			// here we make an api call to actually send the score

			// Close the driver
			driver.quit();

		}
	}


}
