package com.SnapDeals.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    
    
    By snapdealLogo = By.xpath("//a[@class='notIeLogoHeader']"); 

    By accountTab = By.cssSelector("div.myAccountTab");
    By loginLink = By.xpath("//span[@class='accountBtn btn rippleWhite']/a[text()='login']");
    
    By loginContainer = By.xpath("//div[@class='iframeSignin']");

    By usernameInput = By.xpath("//input[@id='userName']");
    By continueBtn = By.xpath("//button[@id='checkUser']");
    
    By loginBtn = By.id("loginUsingOtp");
    
    By isLogged = By.cssSelector(".accountUserName");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    
    public WebElement findWebPage() {
        return driver.findElement(snapdealLogo);
    }
    
    public void hoverAndClickLogin() {
        WebElement account = wait.until(ExpectedConditions.visibilityOfElementLocated(accountTab));
        Actions actions = new Actions(driver);
        actions.moveToElement(account).perform();

        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        login.click();
        
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
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
    
	public void enterOtp() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(35000);
		WebElement logBtn = driver.findElement(loginBtn);
		logBtn.click();
	}
	
	public boolean isUserLoggedIn() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement userNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(isLogged));
	    return userNameElement.isDisplayed();
	}


	public WebElement findLoginPage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(loginContainer));
	}


	public WebElement findField() {
		return driver.findElement(usernameInput);
	}
	
}
