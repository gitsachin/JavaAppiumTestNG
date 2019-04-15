package com.auto.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.auto.base.TestCore;
import com.auto.pageObject.JoinPageObject;
import com.auto.pages.HomePage;
import com.auto.pages.JoinPage;

public class JoinCybraryTest extends TestCore {
	
	HomePage homePage;
	JoinPage joinPage;
	
	@Test(enabled=false)
	public void signUpTest() {
		
		homePage = new HomePage(driver);
		joinPage = new JoinPage(driver);
		
		
		joinPage.clickJoinButton();
		joinPage.enterUserName(JoinPageObject.userName);
		joinPage.enterEmail(JoinPageObject.email);
		joinPage.enterPassword(JoinPageObject.password);
		joinPage.clickJoinButton();
		joinPage.clickSkipButton();
		assertTrue(homePage.verifyHomeScreenHeader("Home"),"not present on screen");
		
		
	}

}
