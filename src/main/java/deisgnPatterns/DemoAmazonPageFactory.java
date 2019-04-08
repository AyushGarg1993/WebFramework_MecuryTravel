package deisgnPatterns;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commonLibraries.implementation.CommonDriver;
import commonLibraries.implementation.DropdownControl;
import commonLibraries.implementation.ElementControl;

public class DemoAmazonPageFactory {
	
	CommonDriver cmdriver;
	
	AmazonPageFactory homepage;
	
	WebDriver driver;
	
	
	@BeforeClass
	public void invokeBrowser() throws Exception{
		
		cmdriver = new CommonDriver("chrome");
		

		
		driver = cmdriver.getDriver();
		
		cmdriver.navigateToUrl("https://amazon.in");
		

		homepage = new AmazonPageFactory(driver);
		
	}

	
	
	// hiding implementation from outside world
	@Test
	public void searchProduct() throws Exception {
		
	homepage.searchProduct("Apple Watch", "Electronics");
		
	}
	
	
	
	@AfterClass
	public void closeAllBrowser() throws Exception{
		
		
		cmdriver.closeBrowser();
		
	}
	
	
}


