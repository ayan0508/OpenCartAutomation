package com.resources;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNg {

	
	static ExtentReports extent;
	
	public static ExtentReports config()
	{
		String str_path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(str_path);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test results");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Testtername", "Ayan");
		
		return extent;
	}
}
