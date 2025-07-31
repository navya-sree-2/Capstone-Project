package com.SnapDeals.Tests;

import org.testng.annotations.Test;
import com.SnapDeals.Base.BaseTest;
import com.SnapDeals.Pages.RegisterPage;
<<<<<<< HEAD
=======
import com.aventstack.extentreports.Status;
>>>>>>> 59de8ca (Final Push)

public class RegisterTest extends BaseTest{
	@Test
	public void Register() throws InterruptedException {
<<<<<<< HEAD
=======
		test = extent.createTest("Register Checks");
>>>>>>> 59de8ca (Final Push)
    	RegisterPage register = new RegisterPage(driver);
    	register.hoverAndClickLogin();
    	Thread.sleep(3000);
    	register.enterUsername(prop.getProperty("phn"));
    	register.clickContinue();
<<<<<<< HEAD
    	register.createAccount(prop.getProperty("email"), prop.getProperty("name"), prop.getProperty("dob"), prop.getProperty("password"));
    	register.enterOtp();
    	if(register.isUserLoggedIn()) {
    		System.out.println("Registered Successfully");
    	}
    	else {
    		System.out.println("Unsuccessful");
=======
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
>>>>>>> 59de8ca (Final Push)
    	}
    }
}
