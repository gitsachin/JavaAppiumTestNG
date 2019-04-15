package com.auto.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.auto.base.TestCore;
import com.auto.configProperties.ConfigProperties;
import com.auto.pageObject.JoinPageObject;
import com.auto.pageObject.LoginPageObject;
import com.auto.pages.HomePage;
import com.auto.pages.LoginPage;

public class LoginTest extends TestCore{
	
	LoginPage loginPage;
	HomePage homePage;
	
	@Test(priority=0)
	public void loginWithInvalidCredential() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		
		loginPage.clickLoginButton();
		loginPage.enterUserName(JoinPageObject.email);
		loginPage.enterPassword(JoinPageObject.password);
		loginPage.clickLoginButton();
		assertTrue(loginPage.verifyAlertTitle(LoginPageObject.expectedTitle),LoginPageObject.expectedTitle+" not present on screen");
		loginPage.clickOkButton();
	}
	
	@Test(priority=1, enabled=false)
	public void loginWithvalidCredential() {
		loginPage = new LoginPage(driver);
		
		loginPage.clearField(JoinPageObject.email);
		loginPage.enterUserName(ConfigProperties.email);
		loginPage.enterPassword(ConfigProperties.password);
		loginPage.clickLoginButton();
		assertTrue(homePage.verifyHomeScreenHeader("Home"),"not present on screen");
	}

}
