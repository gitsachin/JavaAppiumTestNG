package com.auto.pageObject;

import com.auto.base.BasePage;

public class JoinPageObject {
	
	public static String userNameField_xpath = "//android.widget.EditText[@text='Username']";
	public static String emailField_xpath  = "//android.widget.EditText[@text='Email']";
	public static String passwordField_xpath = "//android.view.ViewGroup[@index='4']/android.widget.EditText";
	public static String skipButton_xpath = "//android.widget.Button[@text='SKIP >']";
	public static String joinButton_xpath = "//android.widget.Button[@text='JOIN CYBRARY']";
	
	
	public static String userName = "test"+BasePage.currentDate();
	public static String email = "Test"+BasePage.currentDate()+"@mailinator.com";
	public static String password = "Test@123";

}
