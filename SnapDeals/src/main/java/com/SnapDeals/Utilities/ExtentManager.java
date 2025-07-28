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
		extent.attachReporter(spark);
		extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "SnapDeal");
		extent.setSystemInfo("Tester", "Navya Sree");
		extent.setSystemInfo("OS", "Win11");
		extent.setSystemInfo("Browser", "Chrome");

		extent.attachReporter(spark);
		
		return extent;
	}
	
}
