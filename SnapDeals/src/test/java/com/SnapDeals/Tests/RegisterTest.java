package com.SnapDeals.Tests;

import org.testng.annotations.Test;
import com.SnapDeals.Base.BaseTest;
import com.SnapDeals.Pages.RegisterPage;

public class RegisterTest extends BaseTest{
	@Test
	public void Register() throws InterruptedException {
    	RegisterPage register = new RegisterPage(driver);
    	register.hoverAndClickLogin();
    	Thread.sleep(3000);
    	register.enterUsername(prop.getProperty("phn"));
    	register.clickContinue();
    	register.createAccount(prop.getProperty("email"), prop.getProperty("name"), prop.getProperty("dob"), prop.getProperty("password"));
    	register.enterOtp();
    	if(register.isUserLoggedIn()) {
    		System.out.println("Registered Successfully");
    	}
    	else {
    		System.out.println("Unsuccessful");
    	}
    }
}
