package com.SnapDeals.Base;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.SnapDeals.Utilities.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
    public static Properties prop;

//    @BeforeSuite
//    public void setupSuite() {
////        ExtentManager.setupExtent();
//    }

    @BeforeSuite
    public void launchBrowser() throws IOException {
        prop = ConfigReader.loadProperties();
        if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }

//    @AfterClass
//    public void tearDown() {
////        driver.quit();
//    }

    @AfterSuite
    public void tearDownSuite() {
//        ExtentManager.flushReport();
    }
	
}
