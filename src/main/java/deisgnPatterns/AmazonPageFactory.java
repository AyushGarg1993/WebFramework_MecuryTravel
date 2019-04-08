package deisgnPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibraries.implementation.DropdownControl;
import commonLibraries.implementation.ElementControl;

public class AmazonPageFactory {
	
	
	ElementControl e;
	DropdownControl d;
	
	
	// this i enhanced form
	//This is just the declare part
	
	//Cache look up is used to keep automation fast enhance the performe it will search from cache
	@CacheLookup
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBox;
	
	@CacheLookup
	@FindBy(xpath="//input[@value='Go']")
	private WebElement searchButton;
	
	@FindBy(id="searchDropdownBox")
	private WebElement searchDropdown;
	
	@FindBy(xpath="//span[contains(text(),'1-24 of over 4,000 results for')]")
	private WebElement resultCount;
	
	

	
	
	// We will initize the webelements in constrctor only 
	public AmazonPageFactory(WebDriver driver) {
		
		
		PageFactory.initElements(driver, this);
				
		e = new ElementControl();
		
		d = new DropdownControl();	
		
		
	}
	
	
	public void searchProduct(String product, String category) throws Exception {
		
        e.setText(searchBox,product);
		
		d.selectViaVisibleText(searchDropdown,category);
		
		e.clickElement(searchButton);
		
		
		System.out.println(e.getText(resultCount));
		
	}

	
}
