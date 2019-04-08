package deisgnPatterns;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commonLibraries.implementation.CommonDriver;
import commonLibraries.implementation.DropdownControl;
import commonLibraries.implementation.ElementControl;

public class DemoAmazonPom1Style {
	
	CommonDriver cmdriver;
	
	AmazonPom1Style homepage;
	
	WebDriver driver;
	
	ElementControl e;
	DropdownControl d;
	
	@BeforeClass
	public void invokeBrowser() throws Exception{
		
		cmdriver = new CommonDriver("chrome");
		
		e = new ElementControl();
		
		d = new DropdownControl();
		
		driver = cmdriver.getDriver();
		
		cmdriver.navigateToUrl("https://amazon.in");
		
		homepage = new AmazonPom1Style(driver);
		
	}

	
	@Test
	public void searchProduct() throws Exception {
		
		e.setText(homepage.searchBox, "Apple Watch");
		
		d.selectViaVisibleText(homepage.searchDropdown, "Electronics");
		
		e.clickElement(homepage.searchButton);
		
	}
	
	
	
	@AfterClass
	public void closeAllBrowser() throws Exception{
		
		
		cmdriver.closeBrowser();
		
	}
	
	
}


