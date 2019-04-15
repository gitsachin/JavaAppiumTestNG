package com.auto.pages;

import org.openqa.selenium.By;

import com.auto.base.BasePage;
import com.auto.base.ILogLevel;
import com.auto.pageObject.HomePageObject;

import io.appium.java_client.android.AndroidDriver;

public class HomePage extends BasePage {

	public HomePage(AndroidDriver driver) {
		super(driver);
	}
	
	public boolean verifyHomeScreenHeader(String _expectedHeader) {
		waitForElementDisplayed(By.xpath(HomePageObject.Home_xpath));
		String text = getText(By.xpath(HomePageObject.Home_xpath));
		if(text.equals(_expectedHeader)) {
			log(_expectedHeader+" present on home screen",ILogLevel.ASSERTS);
			return true;
		}else {
			return false;
		}
	}

}
