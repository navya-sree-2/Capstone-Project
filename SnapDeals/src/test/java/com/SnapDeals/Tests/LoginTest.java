package com.SnapDeals.Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SnapDeals.Base.BaseTest;
import com.SnapDeals.Pages.LoginPage;
import com.SnapDeals.Utilities.ExcelReader;
import com.aventstack.extentreports.Status;

import java.io.IOException;

import org.testng.Assert;

public class LoginTest extends BaseTest {
	public String projectPath = System.getProperty("user.dir");

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
	
	@BeforeClass
    public void setupPage() {
        loginPage = new LoginPage(driver);
        test = extent.createTest("Login Checks");
    }
    
    @Test(priority = 1)
    public void websiteCheck() {
        if(loginPage.findWebPage().isDisplayed()) {
            test.log(Status.PASS, "Snapdeal Website Opened");
        }
        else {
            test.log(Status.FAIL, "Snapdeal Website Not Opened");
        }
    }
    
    @Test(priority = 2)
    public void loginPageCheck() {
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
        if(loginPage.findField().isDisplayed()) {
            test.log(Status.PASS, "Mobile num field displayed");
        }
        else {
        	test.log(Status.FAIL, "Mobile num field not displayed");
        }
    }
    
    @Test(priority = 4, dataProvider="logindata")
    public void LoginCheck(String phn) throws InterruptedException {
    	loginPage.enterUsername(phn);
    	loginPage.clickContinue();
    	loginPage.enterOtp();
    	
    	if(loginPage.isUserLoggedIn()) {
    		test.log(Status.PASS, "User Logged In");
        }
        else {
        	test.log(Status.FAIL, "User not Logged In");
    	}
    	
    }
    
    
//    @DataProvider(name="logindata")
//    public String[] loginCreds() throws IOException {
//        return ExcelReader.readColumn();
//    }
    @DataProvider(name = "logindata")
    public Object[][] phoneDataProvider() throws Exception {
        String filePath = "./data/login.xlsx";
        return ExcelReader.readExcelData(filePath, 0);
    }
    
}
