package com.SnapDeals.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions actions;

	By searchInp = By.id("inputValEnter");
	
	By searchBtn = By.xpath("//button[contains(@onclick, 'submitSearchForm')]");
	
	By sortBy = By.xpath("//div[@class='sort-selected']");
	
	By popularity = By.xpath("//li[normalize-space()='Popularity']");
	
	By firstTile = By.cssSelector("div.product-tuple-listing");
    By firstProduct = By.cssSelector("div.product-tuple-listing a.dp-widget-link");
    
    By prod = By.cssSelector("p.product-title");
    
    By cart = By.xpath("//div[@id='add-cart-button-id']");
    
    By proceedToCheckOut = By.xpath("//a[@id='rzp-quickcart-button']");
    
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
	}

	
	public WebElement searchInput() {
		return driver.findElement(searchInp);
	}


	public void searchEle(String str) {
		driver.findElement(searchInp).sendKeys(str);
	}

	public WebElement searchButton() {
		return driver.findElement(searchBtn);
	}
	
	public void searchEnter() {
		driver.findElement(searchBtn).click();
	}
	
	public WebElement dropDown() {
		return driver.findElement(sortBy);
	}
	
	public void clickOnDropDown() {
		driver.findElement(sortBy).click();
	}
	
	public WebElement popularEle() {
		return driver.findElement(popularity);
	}
	
	public void selectPopular() {
		driver.findElement(popularity).click();
	}
	
	public void selectItem() {
	    try {
	        // Wait and scroll to first tile
	        wait.until(ExpectedConditions.visibilityOfElementLocated(firstTile));
	        WebElement tile = driver.findElements(firstTile).get(0);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", tile);
	        Thread.sleep(500);

	        // Move to element after scroll
	        new Actions(driver).moveToElement(tile).perform();

	        // Wait and click using JS (more stable)
	        wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
	        WebElement product = driver.findElements(firstProduct).get(0);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product);

	        // Wait for the new tab to open
	        String originalWindow = driver.getWindowHandle();
	        new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(d -> driver.getWindowHandles().size() > 1);

	        // Switch to the new tab
	        for (String windowHandle : driver.getWindowHandles()) {
	            if (!windowHandle.equals(originalWindow)) {
	                driver.switchTo().window(windowHandle);
	                break;
	            }
	        }

	        // Wait for product element after tab switch
	        wait.until(ExpectedConditions.visibilityOfElementLocated(prod));
	        WebElement el = driver.findElement(prod); // RE-LOCATE after tab switch

	        if (el.isDisplayed()) {
	            System.out.println("Success");
	        } else {
	            System.out.println("Failure");
	        }

	    } catch (StaleElementReferenceException staleEx) {
	        System.out.println("Caught StaleElementReferenceException, retrying...");
	        selectItem(); // Retry once recursively
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Test failed due to: " + e.getMessage());
	    }
	}


	public WebElement addToCartEle() {
		return driver.findElement(cart);
	}


	public void addToCart() {
		// TODO Auto-generated method stub
		System.out.println(driver.getCurrentUrl());
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(
		    By.xpath("//div[@id='add-cart-button-id' and contains(@class, 'buyLink')]")
		));
		addToCart.click();
	}
	
	public WebElement checkOut() {
		return driver.findElement(proceedToCheckOut);
	}
	
	
}
