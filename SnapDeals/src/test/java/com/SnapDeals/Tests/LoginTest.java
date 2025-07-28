package com.SnapDeals.Tests;

import org.testng.annotations.Test;

import com.SnapDeals.Base.BaseTest;
import com.SnapDeals.Pages.LoginPage;
import com.aventstack.extentreports.Status;
import org.testng.Assert;

public class LoginTest extends BaseTest {

	LoginPage loginPage;
//    @Test
//    public void loginToSnapdeal() throws InterruptedException {
//    	loginPage.hoverAndClickLogin();
//    	Thread.sleep(3000);
//    	loginPage.enterUsername(prop.getProperty("phn"));
//    	loginPage.clickContinue();
//    	loginPage.enterOtp();
//    	if(loginPage.isUserLoggedIn()) {
//    		System.out.println("Logged in Successfully");
//    	}
//    	else {
//    		System.out.println("Unsuccessful");
//    	}
//    }
    
    @Test(priority = 1)
    public void websiteCheck() {
        test = extent.createTest("Check: Snapdeal web is opened or not");
        loginPage = new LoginPage(driver);
        if(loginPage.findWebPage().isDisplayed()) {
            test.log(Status.PASS, "Snapdeal Website Opened");
        }
        else {
            test.log(Status.FAIL, "Snapdeal Website Not Opened");
        }
    }
    
    @Test(priority = 2)
    public void loginPageCheck() {
        test = extent.createTest("Check: Login Page is displayed or not");
        loginPage = new LoginPage(driver);
        loginPage.hoverAndClickLogin();
        System.out.println(driver.getTitle());
        if(loginPage.findLoginPage().isDisplayed()) {
            test.log(Status.PASS, "Login is Opened");
        }
        else {
        	test.log(Status.FAIL, "Login is not Opened");
        }
    }
    
    @Test(priority = 3)
    public void FieldCheck() {
        test = extent.createTest("Check: Login Fields displayed or not");
        loginPage = new LoginPage(driver);
        loginPage.hoverAndClickLogin();
        if(loginPage.findLoginPage().isDisplayed()) {
            test.log(Status.PASS, "Mobile num field displayed");
        }
        else {
        	test.log(Status.FAIL, "Mobile num field not displayed");
        }
    }
    
    @Test(priority = 4)
    public void LoginCheck() throws InterruptedException {
    	test = extent.createTest("Check: Login Fields displayed or not");
        loginPage = new LoginPage(driver);
        loginPage.hoverAndClickLogin();
    	loginPage.enterUsername(prop.getProperty("phn"));
    	loginPage.clickContinue();
    	loginPage.enterOtp();
    	
    	if(loginPage.isUserLoggedIn()) {
    		test.log(Status.PASS, "User Logged In");
        }
        else {
        	test.log(Status.FAIL, "User not Logged In");
    	}
    	
    }
    
    
}
