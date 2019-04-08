package com.MercuryTravels.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.MercuryTravels.pages.HomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import commonLibraries.Utilits.ConfigReader;
import commonLibraries.implementation.CommonDriver;
import commonLibraries.implementation.ScreenshotControl;

public class BaseTest {
	
	
	
	String CurrentWorkingDirector;
	
	ScreenshotControl screenshot;
	
	long testExecutionStartTime;
	
	CommonDriver cmd;
	
	HomePage homepage;
	
	WebDriver driver;
	
	Properties configProperties;
	
	ExtentHtmlReporter htmlReporter;
	
	ExtentReports extentReport;
	
	ExtentTest extentTest;
	
	
	@BeforeSuite
	public void preSetup() throws Exception {

		initializeTestExecutionStartTime();

		initializeCurentWorkingDirectory();
		
		initializeConfigProperty();
		
		
		initializeHtmlReport();


	}

	@BeforeClass
	public void setUp() throws Exception {
		
		
		extentTest = extentReport.createTest("Setup : Invoking browser");

		
		
		 invokeBrowser();
		
		 initializePages();
		}
	
	
	
	@AfterClass
	public void cleanUp() throws Exception {
		
		cmd.closeAllBrowser();
		
		extentTest = extentReport.createTest("Setup : Closing browser");

	}
	
	
	@AfterMethod
	public void AfterAMethod(ITestResult result) throws Exception
	{
		
		     String testMethodName = result.getName();
		     
		     
		     String filePath = String.format("%s/screenshots/%s_%s.jpeg",CurrentWorkingDirector,testMethodName,testExecutionStartTime);
		
		     
				if (result.getStatus() == ITestResult.FAILURE) {
					extentTest.log(Status.FAIL, testMethodName);

					screenshot.saveAndCaptureScreenshot(filePath);

					extentTest.addScreenCaptureFromPath(filePath);
				} else if (result.getStatus() == ITestResult.SUCCESS) {
					extentTest.log(Status.PASS, testMethodName);
				} else {
					extentTest.log(Status.SKIP, testMethodName);
				}
		
	}
	
	

	@AfterSuite
	public void postCleanup() {
		extentReport.flush();
	}
	
	
	
	
	private void initializeConfigProperty() throws Exception {

		String filename = String.format("%s/config/config.properties", CurrentWorkingDirector);
		
		configProperties = ConfigReader.readProperties(filename);

	}
	
	
	private void initializeCurentWorkingDirectory() {
		
		CurrentWorkingDirector = System.getProperty("user.dir");

	}

	private void initializeTestExecutionStartTime() {
		testExecutionStartTime = System.currentTimeMillis();

	}
	
	
	private void initializePages() {
		
		
		
		homepage = new HomePage(driver);
		
		
		screenshot = new ScreenshotControl(driver);
	}
	
	
	
	private void invokeBrowser() throws Exception {
		
		cmd = new CommonDriver(configProperties.getProperty("browserType"));
		cmd.setPageLoadTimeout(Integer.parseInt(configProperties.getProperty("pageloadTimeout")));
		cmd.setElementDetectionTimeout(20);
		
		driver = cmd.getDriver();
		
		cmd.navigateToFirstUrl(configProperties.getProperty("baseURL"));
	}


	
	
	
	private void initializeHtmlReport() {
		
		String htmlReportFile = String.format("%s/reports/mercuryTravelReport_%s.html", CurrentWorkingDirector,
				testExecutionStartTime);
		
		htmlReporter = new ExtentHtmlReporter(htmlReportFile);

		extentReport = new ExtentReports();
		
		extentReport.attachReporter(htmlReporter);
		
		
	}

	
}


