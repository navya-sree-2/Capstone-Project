package com.SnapDeals.Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotDir = System.getProperty("user.dir") + "/Reports/Screenshots/";
        String screenshotPath = screenshotDir + testName + "_" + timestamp + ".png";

        // Create Screenshots folder if not exists
        new File(screenshotDir).mkdirs();

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(screenshotPath);

        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            System.out.println("Error while saving screenshot: " + e.getMessage());
        }
        System.out.println("Saving screenshot at: " + screenshotPath);
       

        return screenshotPath;


    }
}