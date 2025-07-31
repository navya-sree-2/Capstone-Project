package com.SnapDeals.Base;

import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.SnapDeals.Utilities.ConfigReader;
import com.SnapDeals.Utilities.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.SnapDeals.Utilities.ScreenshotUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
    public static Properties prop;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public void setupSuite() {
        extent = ExtentManager.setupExtent();
    }

    @Parameters("browser")
    @BeforeClass
    public void launchBrowser(String browser) throws IOException {
        prop = ConfigReader.loadProperties();
        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("edge")) {
        	WebDriverManager.edgedriver().setup();
        	driver = new EdgeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")) {
        	WebDriverManager.firefoxdriver().setup();
        	driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }
    
    @AfterMethod
	public void tearDown(ITestResult result) throws IOException {
	    if (result.getStatus() == ITestResult.FAILURE) {
	        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
	        test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
	        test.addScreenCaptureFromPath(screenshotPath);
	    }
	    else if (result.getStatus() == ITestResult.SUCCESS) {
//	        test.pass("Test Passed");
	    }
	    else if (result.getStatus() == ITestResult.SKIP) {
	        test.skip("Test Skipped: " + result.getThrowable());
	    }
	    extent.flush();
	}

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    public void tearDownSuite() {
        extent.flush();
    }
	
}
