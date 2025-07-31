package com.SnapDeals.Pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenSelection {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions actions;
	
	
    By mensFashion = By.xpath("//span[text()=\"Men's Fashion\"]");
<<<<<<< HEAD
    By sg = By.xpath("//span[text()='Sunglasses']");
    
    By filterMenOnly = By.xpath("//a[contains(text(), 'Men Only')]");
    
    By expandMaterial = By.xpath("//div[@data-filtername='FrameMaterial_s']//div[@class='filter-accordian']/i[contains(@class,'sd-icon-plus')]");
    By metal = By.xpath("//a[contains(text(), 'Metal')]");
=======
    By lapiBags = By.xpath("//span[text()='Laptop Bags']");
    
    By closure = By.xpath("//a[contains(text(), ' Zip')]");
    
    By expandMaterial = By.xpath("//div[@data-filtername='discount']//div[@class='filter-accordian']/i[contains(@class,'sd-icon-plus')]");
    By discount = By.xpath("//a[contains(text(), '50 - 60')]");
>>>>>>> 59de8ca (Final Push)
    
    By minPrice = By.xpath("//input[@name='fromVal']");
    By maxPrice = By.xpath("//input[@name='toVal']");
    By priceFilter = By.xpath("//div[contains(@class,'price-go-arrow')]");
    
    By firstTile = By.cssSelector("div.product-tuple-listing");
    By firstProduct = By.cssSelector("div.product-tuple-listing a.dp-widget-link");
    
    By prod = By.cssSelector("p.product-title");
    
    By cart = By.xpath("//div[@id='add-cart-button-id']");
    
    By proceedToCheckOut = By.xpath("//a[@id='rzp-quickcart-button']");


    public MenSelection(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }
    
    public WebElement mensFashionEle() {
    	return driver.findElement(mensFashion);
    }

<<<<<<< HEAD
    public void hoverAndClickSunGlasses() {
=======
    public void hoverAndClickLapiBags() {
>>>>>>> 59de8ca (Final Push)
    	actions = new Actions(driver);
        WebElement mensFashionElement = driver.findElement(mensFashion);
        actions.moveToElement(mensFashionElement).perform();

<<<<<<< HEAD
        WebElement sunGlass = driver.findElement(sg);
        sunGlass.click();
        
    }
    
    public WebElement menOnly() {
    	return driver.findElement(filterMenOnly);
    }
    
    public void selectMenOnlyFilter() {
        WebElement menOnlyCheckbox = wait.until(ExpectedConditions.elementToBeClickable(filterMenOnly));
        js.executeScript("arguments[0].click();", menOnlyCheckbox);
        js.executeScript("window.scrollBy(0, 500);");
    }

    public void expandMaterialFilter() throws InterruptedException {
        WebElement frameMat = wait.until(ExpectedConditions.elementToBeClickable(expandMaterial));
        js.executeScript("arguments[0].scrollIntoView(true);", frameMat);
        Thread.sleep(800);  // Optional: can use WebDriverWait instead
        js.executeScript("arguments[0].click();", frameMat);
    }
    
    public WebElement metalMaterial() {
    	return driver.findElement(metal);
    }

    public void selectMaterialMetal() {
        WebElement metalOpt = wait.until(ExpectedConditions.elementToBeClickable(metal));
=======
        WebElement lapiBg = driver.findElement(lapiBags);
        lapiBg.click();
        
    }
    
    public WebElement zipClosure() {
    	return driver.findElement(closure);
    }
    
    public void selectZipFilter() {
        WebElement zip = wait.until(ExpectedConditions.elementToBeClickable(closure));
        js.executeScript("arguments[0].click();", zip);
        js.executeScript("window.scrollBy(0, 500);");
    }

    public void expandDiscountFilter() throws InterruptedException {
        WebElement disc = wait.until(ExpectedConditions.elementToBeClickable(expandMaterial));
        js.executeScript("arguments[0].scrollIntoView(true);", disc);
        Thread.sleep(800);  // Optional: can use WebDriverWait instead
        js.executeScript("arguments[0].click();", disc);
    }
    
    public WebElement discountEle() {
    	return driver.findElement(discount);
    }

    public void selectDiscount() {
        WebElement metalOpt = wait.until(ExpectedConditions.elementToBeClickable(discount));
>>>>>>> 59de8ca (Final Push)
        js.executeScript("arguments[0].scrollIntoView(true);", metalOpt);
        js.executeScript("arguments[0].click();", metalOpt);
    }

	public void selectPriceRange(int mn, int mx) {
		// TODO Auto-generated method stub
		WebElement minEle = driver.findElement(minPrice);
		minEle.clear();
		minEle.sendKeys(String.valueOf(mn));
		
		WebElement maxEle = driver.findElement(maxPrice);
		maxEle.clear();
		maxEle.sendKeys(String.valueOf(mx));
		
		WebElement go = driver.findElement(priceFilter);
		go.click();
		
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

<<<<<<< HEAD
	        if (el.isDisplayed()) {
	            System.out.println("Success");
	        } else {
	            System.out.println("Failure");
	        }
=======
>>>>>>> 59de8ca (Final Push)

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
<<<<<<< HEAD
=======
		wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckOut));
>>>>>>> 59de8ca (Final Push)
		return driver.findElement(proceedToCheckOut);
	}
}
