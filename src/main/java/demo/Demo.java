package demo;

import org.openqa.selenium.WebDriver;

import commonLibraries.implementation.CommonDriver;
import commonLibraries.implementation.DropdownControl;
import commonLibraries.implementation.ElementControl;
import commonLibraries.implementation.MouseControl;
import commonLibraries.implementation.ScreenshotControl;

public class Demo {

	public static void main(String[] args) throws Exception {
		
		try {
			CommonDriver cmmdriver = new CommonDriver("chrome");
			
			cmmdriver.setPageLoadTimeout(10);
			
			cmmdriver.setElementDetectionTimeout(10);
			
			cmmdriver.navigateToUrl("https://demo.guru99.com/v4");
			
			WebDriver driver;
			
			driver= cmmdriver.getDriver();
			
			
			ScreenshotControl screenshot;
			
			screenshot = new ScreenshotControl(driver);
			
			
			screenshot.saveAndCaptureScreenshot("/Users/ayushmac/Desktop/SeleniumFrameWork/ModularFramework/screenshots/test.jpeg");
			
			ElementControl elementControl;
			
			DropdownControl dropdownControl;
			
			MouseControl mouseControl;
		
			
			driver = cmmdriver.getDriver();			
			
			elementControl = new ElementControl();
			
			dropdownControl = new DropdownControl();
			
			mouseControl = new MouseControl(driver);
			
			cmmdriver.closeAllBrowser();
		
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
