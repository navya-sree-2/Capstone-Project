package com.SnapDeals.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	
	WebDriver driver;
    WebDriverWait wait;

    By accountTab = By.cssSelector("div.myAccountTab");
    By registerLink = By.xpath("//span[@class='newUserRegister']");

    By usernameInput = By.xpath("//input[@id='userName']");
    By continueBtn = By.xpath("//button[@id='checkUser']");
    
    By emailInput = By.id("j_username_new");
    By nameInput = By.id("j_name");
    By dobInput = By.id("j_dob");
    By pwdInput = By.id("j_password");
    
    By continue2Btn = By.id("userSignup");
    
    By registerButton = By.id("registerUser");
    
    By isLogged = By.cssSelector(".accountUserName");
    

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void hoverAndClickLogin() {
        WebElement account = wait.until(ExpectedConditions.visibilityOfElementLocated(accountTab));
        Actions actions = new Actions(driver);
        actions.moveToElement(account).perform();

        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(registerLink));
        login.click();
        
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0)); // OR use driver.switchTo().frame("frameName");
        } catch (Exception e) {
            System.out.println("No iframe detected or switching failed.");
        }
    }

    public void enterUsername(String username) {
        WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        userField.clear();
        userField.sendKeys(username);
    }

    public void clickContinue() {
        WebElement contBtn = wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        contBtn.click();
    }
    
    public void createAccount(String email, String name, String dob, String pwd) {
    	WebElement emailInp = wait.until(ExpectedConditions.elementToBeClickable(emailInput));
    	emailInp.sendKeys(email);
    	
    	WebElement nameInp = driver.findElement(nameInput);
    	nameInp.sendKeys(name);
    	
    	WebElement dobInp = driver.findElement(dobInput);
    	dobInp.clear();
        dobInp.sendKeys(dob);
        dobInp.sendKeys(Keys.TAB);
    	
    	WebElement pwdInp = driver.findElement(pwdInput);
    	pwdInp.sendKeys(pwd);
    	
    	WebElement continue2 = wait.until(ExpectedConditions.elementToBeClickable(continue2Btn));
    	continue2.click();
    	
    	
    }

	public void enterOtp() throws InterruptedException {
		Thread.sleep(15000);
		WebElement regBtn = driver.findElement(registerButton);
		regBtn.click();
	}
	
	public boolean isUserLoggedIn() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement userNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(isLogged));
	    return userNameElement.isDisplayed();
	}
	
}
