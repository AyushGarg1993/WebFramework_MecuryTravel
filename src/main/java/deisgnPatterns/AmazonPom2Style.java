package deisgnPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonLibraries.implementation.DropdownControl;
import commonLibraries.implementation.ElementControl;

public class AmazonPom2Style {
	
	
	
	private WebElement searchBox;
	
	private WebElement searchButton;
	
	private WebElement searchDropdown;
	
	ElementControl e;
	DropdownControl d;
	
	public AmazonPom2Style(WebDriver driver) {
		
		searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		
		searchButton = driver.findElement(By.xpath("//input[@value='Go']"));

		searchDropdown = driver.findElement(By.id("searchDropdownBox"));
		
		e = new ElementControl();
		
		d = new DropdownControl();	
		
		
	}
	
	
	public void searchProduct(String product, String category) throws Exception {
		
        e.setText(searchBox,product);
		
		d.selectViaVisibleText(searchDropdown,category);
		
		e.clickElement(searchButton);
		
		
		
	}

	
}
