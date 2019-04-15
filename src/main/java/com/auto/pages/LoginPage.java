package com.auto.pages;

import org.openqa.selenium.By;

import com.auto.base.BasePage;
import com.auto.base.ILogLevel;
import com.auto.pageObject.HomePageObject;
import com.auto.pageObject.LoginPageObject;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage extends BasePage {
	
	
	public LoginPage(AndroidDriver driver) {
		super(driver);
	}

	public void clickLoginButton() {
		click(By.xpath(LoginPageObject.loginButton_xpath),"Click on login button",0);
		pause(40);
	}
	
	public void enterUserName(String _email) {
		sendKeys(By.xpath(LoginPageObject.usernameAndEmail_xpath),_email,0," "+_email);
		driver.hideKeyboard();
	}
	
	public void clearField(String _email) {
		pause(10);
		System.out.println(LoginPageObject.field_xpath/*+"'"+_email+"']"*/);
		//System.out.println(getText(By.xpath(LoginPageObject.field_xpath/*+"'"+_email+"']"*/)));
		click(By.xpath((LoginPageObject.field_xpath/*+"'"+_email+"']"*/)));
		System.out.println(LoginPageObject.field_xpath/*+"'"+_email+"']"*/);
		driver.findElement(By.xpath(LoginPageObject.field_xpath/*+"'"+_email+"']"*/)).clear();
		log("clear field",ILogLevel.METHOD);
	}

	public void enterPassword(String _password) {
		fieldClear(By.xpath(LoginPageObject.passwordField_xpath));
		sendKeys(By.xpath(LoginPageObject.passwordField_xpath)," "+_password, 0," "+_password);
		driver.hideKeyboard();
	}
	
	public boolean verifyAlertTitle(String _title) {
		waitForElementDisplayed(By.id(LoginPageObject.alertTitle_id));
		String text = getText(By.id(LoginPageObject.alertTitle_id));
		if(text.equals(_title)) {
			log(text+" present on home screen",ILogLevel.ASSERTS);
			return true;
		}else {
			return false;
		}
	}
	
	public void clickOkButton() {
		click(By.xpath(LoginPageObject.okButton_xpath),"Click on ok button",0);
	}

}
