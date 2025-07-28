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
	public void menSelectionCheck() throws InterruptedException {
	    if(ms.mensFashionEle().isDisplayed()) {
	    	test.log(Status.PASS, "Mens Fashion Element displayed");
        }
        else {
        	test.log(Status.FAIL, "Mens Fashion Element not displayed");
	    }
	    Thread.sleep(5000);
	    ms.hoverAndClickSunGlasses();
	    ms.selectPriceRange(150, 1500);
	}
	
	@Test(priority = 3)
	public void menOnlyFilterCheck() {
		ms.selectMenOnlyFilter();
		if(ms.menOnly().isSelected()) {
			test.log(Status.PASS, "Men Only Filter Selected");
        }
        else {
        	test.log(Status.FAIL, "Men Only Filter not Selected");
	    }
	}
	
	@Test(priority = 4)
	public void metalMaterialCheck() throws InterruptedException {
		if(ms.metalMaterial().isDisplayed()) {
			test.log(Status.PASS, "Material Filter - Metal Displayed");
        }
        else {
        	test.log(Status.FAIL, "Material Filter - Metal not Displayed");
        	// take screenshot
        	ms.expandMaterialFilter();
        	if(ms.metalMaterial().isDisplayed()) {
        		test.log(Status.PASS, "Material Filter - Metal Displayed");
        		ms.selectMaterialMetal();
        		if(ms.metalMaterial().isEnabled()) {
        			test.log(Status.PASS, "Material Filter - Metal Enabled");
                }
        		else {
        			test.log(Status.FAIL, "Material Filter - Metal not Enabled");
        			//take ss
        		}
        	}
        	else {
        		test.log(Status.FAIL, "Material Filter - Metal not Displayed");
        		//take ss
        	}
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
