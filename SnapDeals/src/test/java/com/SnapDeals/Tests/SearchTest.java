package com.SnapDeals.Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.SnapDeals.Base.BaseTest;
import com.SnapDeals.Pages.LoginPage;
import com.SnapDeals.Pages.MenSelection;
import com.SnapDeals.Pages.RegisterPage;
import com.SnapDeals.Pages.SearchPage;
import com.aventstack.extentreports.Status;

public class SearchTest extends BaseTest {
	
	LoginPage loginPage;
	SearchPage sp;
	@BeforeClass
	public void setupPage() {
		loginPage = new LoginPage(driver);
		sp = new SearchPage(driver);
        test = extent.createTest("Search Checks");
    }
	
//	@Test(priority = 1)
//	public void loginToSnapdeal() throws InterruptedException {
////		driver.manage().deleteAllCookies();
//	  	loginPage.hoverAndClickLogin();
//	  	Thread.sleep(3000);
//	  	loginPage.enterUsername(prop.getProperty("phn"));
//	  	loginPage.clickContinue();
//	  	loginPage.enterOtp();
//	  	if(loginPage.isUserLoggedIn()) {
//	  		System.out.println("Logged in Successfully");
//	  	}
//	  	else {
//	  		System.out.println("Unsuccessful");
//	  	}
////	  	ms = new MenSelection(driver);
//    }
	
	@Test(priority = 1)
	public void searchText() {
		if(sp.searchInput().isDisplayed()) {
			test.log(Status.PASS, "Search Input displayed");
		}
		else {
			test.log(Status.FAIL, "Search Input not displayed");
		}
	}
	
	@Test(priority = 2)
	public void searchButton() {
		sp.searchEle("Lehangas");
		if(sp.searchButton().isDisplayed()) {
			test.log(Status.PASS, "Search Button displayed");
		}
		else {
			test.log(Status.FAIL, "Search Button not displayed");
		}
	}
	
	@Test(priority = 3)
	public void search() {
		sp.searchEnter();
		if(sp.dropDown().isDisplayed()) {
			test.log(Status.PASS, "Search Results displayed");
		}
		else {
			test.log(Status.FAIL, "Search Results not displayed");
		}
	}
	
	@Test(priority = 4)
	public void sortBy() {
		sp.clickOnDropDown();
		if(sp.popularEle().isDisplayed()) {
			test.log(Status.PASS, "Popularity displayed");
		}
		else {
			test.log(Status.FAIL, "Popularity not displayed");
		}
		sp.selectPopular();
	}
	
	@Test(priority = 5)
	public void chooseItem() {
		sp.selectItem();
		if(sp.addToCartEle().isDisplayed()) {
			test.log(Status.PASS, "Item Choosed");
		}
		else {
			test.log(Status.FAIL, "Item not Choosed");
		}
	}
	
	@Test(priority = 6)
	public void addItemToCart() {
		sp.addToCart();
		if(sp.checkOut().isDisplayed()) {
			test.log(Status.PASS, "Item Added to Cart");
		}
		else {
			test.log(Status.FAIL, "Item not Added to Cart");
		}
	}
	
}
