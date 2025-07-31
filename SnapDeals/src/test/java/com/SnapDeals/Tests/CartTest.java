package com.SnapDeals.Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.SnapDeals.Base.BaseTest;
import com.SnapDeals.Pages.CartPage;
import com.SnapDeals.Pages.LoginPage;
import com.aventstack.extentreports.Status;

public class CartTest extends BaseTest {
	
	LoginPage loginPage;
	CartPage cp;
	@BeforeClass
	public void setupPage() {
		loginPage = new LoginPage(driver);
		cp = new CartPage(driver);
        test = extent.createTest("pincode, inc count, proceed check");
    }
	
	@Test(priority=1)
    public void loginToSnapdeal() throws InterruptedException {
//		driver.manage().deleteAllCookies();
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
//	  	ms = new MenSelection(driver);
    }
	
	@Test(priority = 2)
	public void cartIcon() {
		if(cp.cartEle().isDisplayed()) {
			test.log(Status.PASS, "Cart Icon Displayed");
		}
		else {
			test.log(Status.FAIL, "Cart Icon not displayed");
		}
	}
	
	@Test(priority = 3)
	public void openCart() throws InterruptedException {
		Thread.sleep(3000);
		cp.selectCart();
		if(cp.cartPop().isDisplayed()) {
			test.log(Status.PASS, "Cart Page Displayed");
		}
		else {
			test.log(Status.FAIL, "Cart Page not displayed");
		}
	}
	
	@Test(priority = 4)
	public void editPincode() {
		cp.pincodeEditor().click();
		cp.enterPincode().clear();
		cp.enterPincode().sendKeys(prop.getProperty("pincode"));
		if(cp.pinSubmit().isDisplayed()) {
			test.log(Status.PASS, "Check Pincode button displayed");
			cp.pinSubmit().click();
		}
		else {
			test.log(Status.FAIL, "Check Pincode button not displayed");
		}
	}
	
	@Test(priority = 5)
	public void incQuantity() {
		if(cp.findQtyDrop().isDisplayed()) {
			test.log(Status.PASS, "Quantity dropdown Displayed");
			cp.findQtyDrop().click();
			cp.increase("3");
		}
		else {
			test.log(Status.FAIL, "Quantity dropdown not Displayed");
		}
	}
	
	@Test(priority = 6)
	public void proceed() {
		cp.checkout().click();
	}
	
	
	
}
