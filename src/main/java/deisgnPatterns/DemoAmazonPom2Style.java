package deisgnPatterns;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commonLibraries.implementation.CommonDriver;
import commonLibraries.implementation.DropdownControl;
import commonLibraries.implementation.ElementControl;

public class DemoAmazonPom2Style {
	
	CommonDriver cmdriver;
	
	AmazonPom2Style homepage;
	
	WebDriver driver;
	
	
	@BeforeClass
	public void invokeBrowser() throws Exception{
		
		cmdriver = new CommonDriver("chrome");
		

		
		driver = cmdriver.getDriver();
		
		cmdriver.navigateToUrl("https://amazon.in");
		
		
		// The disadvanatge of this method is that say if we 
		//have element which will come after @test then test 
		//will fail as constructor already looking for that element 
		//but element will come after @test only 
		homepage = new AmazonPom2Style(driver);
		
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


