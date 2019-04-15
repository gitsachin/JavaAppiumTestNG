package com.auto.pages;

import org.openqa.selenium.By;

import com.auto.base.BasePage;
import com.auto.pageObject.JoinPageObject;

import io.appium.java_client.android.AndroidDriver;

public class JoinPage extends BasePage {

	public JoinPage(AndroidDriver driver) {
		super(driver);
	}
	
	public void clickJoinButton() {
		click(By.xpath(JoinPageObject.joinButton_xpath),"Click on join button",0);
	}
	
	public void enterUserName(String _userName) {
		sendKeys(By.xpath(JoinPageObject.userNameField_xpath),_userName,0," "+_userName);
	}
	
	public void enterEmail(String _email) {
		sendKeys(By.xpath(JoinPageObject.emailField_xpath),_email,0," "+_email);
		driver.hideKeyboard();
	}
	
	public void enterPassword(String _password) {
		sendKeys(By.xpath(JoinPageObject.passwordField_xpath)," "+_password, 0," "+_password);
		driver.hideKeyboard();
	}
	
	public void clickSkipButton() {
		pause(15);
		driver.switchTo().frame(1);
		waitForElementDisplayed(By.xpath(JoinPageObject.skipButton_xpath));
		boolean ele = isElementPresent(By.xpath(JoinPageObject.skipButton_xpath));
		if(ele) {
			click(By.xpath(JoinPageObject.skipButton_xpath),"click on skip button",0);
		}
	}

}
