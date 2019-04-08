package com.MercuryTravels.Tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import org.testng.AssertJUnit;


public class HomePageTest extends BaseTest{


	
	
	@Test
	public void verifyLoginToMercuryTravelAsUserWithCorrectCredentials() throws Exception {
		
		
		extentTest = extentReport.createTest("TestCas001: Verify login to mercury travel with correct credentials");

		
		
		String sUserEmailId = configProperties.getProperty("userEmail");
		
		
		String sUserPassword = configProperties.getProperty("userPassword");

		
		
		extentTest.log(Status.INFO, "User Email Id used : "+ sUserEmailId + " and password : "+ sUserPassword);

		homepage.userLogin(sUserEmailId, sUserPassword);
		
		String WelcomeText = homepage.getWelcomeText();
		
		System.out.println(WelcomeText);
		
		
		String actual = "Welcome, Ayush1";
		
		AssertJUnit.assertEquals(actual, WelcomeText);
		
		
		extentTest.log(Status.INFO, "Actual welcome Text : "+ actual + " and expected welcome text : "+ WelcomeText);

		
	}
	
	

	
	
	
	

}
