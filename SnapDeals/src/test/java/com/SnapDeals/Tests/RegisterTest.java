package com.SnapDeals.Tests;

import org.testng.annotations.Test;

import com.SnapDeals.Base.BaseTest;
import com.SnapDeals.Pages.RegisterPage;
import com.aventstack.extentreports.Status;
public class RegisterTest extends BaseTest{
	@Test
	public void Register() throws InterruptedException {
		test = extent.createTest("Register Checks");
    	RegisterPage register = new RegisterPage(driver);
    	register.hoverAndClickLogin();
    	Thread.sleep(3000);
    	register.enterUsername(prop.getProperty("phn"));
    	register.clickContinue();
    	if(register.emailEle().isDisplayed()) {
    		register.createAccount(prop.getProperty("email"), prop.getProperty("name"), prop.getProperty("dob"), prop.getProperty("password"));
        	register.enterOtp();
        	test.log(Status.PASS, "New User");
    	}
    	else {
    		test.log(Status.FAIL, "User already Exists");
    	}
    	if(register.isUserLoggedIn()) {
    		test.log(Status.PASS, "User Registered Successfully");
    	}
    	else {
    		test.log(Status.FAIL, "User not Registered");
    	}
    }
}
