package com.SnapDeals.Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.SnapDeals.Base.BaseTest;
import com.SnapDeals.Pages.LoginPage;
import com.SnapDeals.Pages.MenSelection;
import com.aventstack.extentreports.Status;

public class MenSelectionTest extends BaseTest {

	LoginPage loginPage;
	MenSelection ms;
	@BeforeClass
	public void setupPage() {
		loginPage = new LoginPage(driver);
		ms = new MenSelection(driver);
        test = extent.createTest("Hover, Filters and Cart Checks");
    }
	
	
	@Test(priority=1)
    public void loginToSnapdeal() throws InterruptedException {
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
	
	
	@Test(priority = 2)
	public void menSelectionCheck() throws InterruptedException {
	    if(ms.mensFashionEle().isDisplayed()) {
	    	test.log(Status.PASS, "Mens Fashion Element displayed");
        }
        else {
        	test.log(Status.FAIL, "Mens Fashion Element not displayed");
	    }
	    Thread.sleep(5000);
	    ms.hoverAndClickLapiBags();
	    ms.selectPriceRange(150, 1500);
	}
	
	@Test(priority = 3)
	public void zipFilterCheck() throws InterruptedException {
		ms.selectZipFilter();
		if(ms.zipClosure().isEnabled()) {
			test.log(Status.PASS, "Zip closure Filter Selected");
        }
        else {
        	test.log(Status.FAIL, "Zip closure Filter not Selected");
	    }
	}
	
	@Test(priority = 4)
	public void selectDiscountCheck() throws InterruptedException {
		ms.expandDiscountFilter();
    	if(ms.discountEle().isDisplayed()) {
    		test.log(Status.PASS, "Discount Filter - Expanded");
    		ms.selectDiscount();
    		if(ms.discountEle().isEnabled()) {
    			test.log(Status.PASS, "Discount Selected");
            }
    		else {
    			test.log(Status.FAIL, "Discount not Selected");
    			//take ss
    		}
    	}
    	else {
    		test.log(Status.FAIL, "Discount Filter - not Expanded");
    		//take ss
    	}
	}
	
	@Test(priority = 5) 
	public void itemSelectionCheck() {
		ms.selectItem();
		if(ms.addToCartEle().isDisplayed()) {
			test.log(Status.PASS, "Item Selected");
		}
		else {
			test.log(Status.FAIL, "Item not Selected");
		}
	}
	
	@Test(priority = 6)
	public void itemAddedToCartCheck() {
		ms.addToCart();
		if(ms.checkOut().isDisplayed()) {
			test.log(Status.PASS, "Item Added to Cart");
		}
		else {
			test.log(Status.FAIL, "Item not Added to Cart");
		}
	}
}
