package com.SnapDeals.Tests;

import org.testng.annotations.Test;

import com.SnapDeals.Base.BaseTest;
import com.SnapDeals.Pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginToSnapdeal() throws InterruptedException {
    	LoginPage loginPage = new LoginPage(driver);
    	loginPage.hoverAndClickLogin();
    	Thread.sleep(3000);
    	loginPage.enterUsername(prop.getProperty("phn"));
    	loginPage.clickContinue();
    	loginPage.enterOtp();
    	if(loginPage.isUserLoggedIn()) {
    		System.out.println("Logged in Successfully");
    	}
    	else {
    		System.out.println("Unsuccessful");
    	}
    }
}
