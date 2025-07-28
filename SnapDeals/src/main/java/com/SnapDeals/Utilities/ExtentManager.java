package com.SnapDeals.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	private static ExtentReports extent;
	public static ExtentReports setupExtent() {
		String projectPath = System.getProperty("user.dir");
		String reportPath = projectPath + "\\Reports\\Report.html";
		System.out.println(reportPath);
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		extent = new ExtentReports();
		spark.config().setDocumentTitle("Login Testing");
		spark.config().setReportName("Selenium Result tests");
		extent.attachReporter(spark);
		
		return extent;
	}
	
}
