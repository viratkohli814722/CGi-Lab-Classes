package com.orangehrm.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	private static ExtentReports extent;
	static String projectpath=System.getProperty("user.dir");
	
	public static ExtentReports getinstance() {
		ExtentReports extent=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter(projectpath+"\\src\\test\\resources\\Orangehrm_Reports\\listeners.html");
		extent.attachReporter(spark);
		return extent;
	}
}
