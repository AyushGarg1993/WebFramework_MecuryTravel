package com.MercuryTravels.pages;

import org.openqa.selenium.WebDriver;

import commonLibraries.implementation.ElementControl;
import commonLibraries.implementation.MouseControl;

public class BasePage {
	
	
	
	
	 MouseControl mouseControl;
		ElementControl elementControl;

		public BasePage(WebDriver driver) {
			mouseControl = new MouseControl(driver);

			elementControl = new ElementControl();
		}

}
