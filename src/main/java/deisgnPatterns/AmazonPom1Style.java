package deisgnPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonPom1Style {
	
	
	
	// disadvantage of this is that the all webelement is public which does not allign with OOPS concept
	public WebElement searchBox;
	
	public WebElement searchButton;
	
	public WebElement searchDropdown;
	
	public AmazonPom1Style(WebDriver driver) {
		
		searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		
		searchButton = driver.findElement(By.xpath("//input[@value='Go']"));

		searchDropdown = driver.findElement(By.id("searchDropdownBox"));

		
	}
	
	

	
}
