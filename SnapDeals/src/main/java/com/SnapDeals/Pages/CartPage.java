package com.SnapDeals.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions actions;
	
	By cartIcon = By.xpath("//div[@class='cartInner']");
	
	By cartTab = By.id("cartModal");
	
	By qtyDrop = By.cssSelector("div.styledSelect.item-quantity");
	
	By qtySelect = By.xpath("//select[@class='item-quantity customized s-hidden']");
	
	By checoutBtn = By.id("rzp-cart-button");
	
	By pincode = By.className("cart-pin-change");
	
	By pinValue = By.id("pincode-value");
	
	By pinBtn = By.id("send-pincode");
	
	
	
	
	public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }
	
	public WebElement cartEle() {
		return driver.findElement(cartIcon);
	}

	public void selectCart() {
		driver.findElement(cartIcon).click();
		WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(cartTab));
        Actions actions = new Actions(driver);
        actions.moveToElement(cart).perform();
	}
	
	public WebElement cartPop() {
		return driver.findElement(cartTab);
	}
	
	public WebElement pincodeEditor() {
		return wait.until(ExpectedConditions.elementToBeClickable(pincode));
//		return driver.findElement(pincode);
	}
	
	public WebElement enterPincode() {
		return driver.findElement(pinValue);
	}

	public WebElement pinSubmit() {
		return driver.findElement(pinBtn);
	}

	public WebElement findQtyDrop() {
		return (wait.until(ExpectedConditions.visibilityOfElementLocated(qtyDrop)));
	}

	public void increase(String qty) {
		WebElement qtyOption = driver.findElement(By.cssSelector("li[rel='" + qty + "']"));
        qtyOption.click();
	}
	
	public WebElement checkout() {
		return wait.until(ExpectedConditions.elementToBeClickable(checoutBtn));
	}
	
}
