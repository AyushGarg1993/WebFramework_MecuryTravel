package commonLibraries.implementation;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import commonLibraries.contracts.IDropdown;

public class DropdownControl  implements IDropdown{
	
	
	
	private Select getDropdown(WebElement element)
	{
		Select select = new Select(element);
		
		return select;
		
	}



	public void selectViaVisibleText(WebElement element, String visibleText) throws Exception {
		
		
		getDropdown(element).selectByVisibleText(visibleText);
	}


	public void selectViaValue(WebElement element, String value) throws Exception {
		
		getDropdown(element).selectByValue(value);
	}


	public void selectViaIndex(WebElement element, int Index) throws Exception {
		
		
		getDropdown(element).selectByIndex(Index);
		
	}


	public boolean isMultiple(WebElement element) throws Exception {
		
		
		
		return getDropdown(element).isMultiple();
	}


	public WebElement getFirstSelectedOption(WebElement element) throws Exception {
		
		return getDropdown(element).getFirstSelectedOption();
	}


	public List<WebElement> getAllOptions(WebElement element) throws Exception {
		
		return getDropdown(element).getOptions();
	}


	public List<WebElement> getAllSelectedOptions(WebElement element) throws Exception {
	
		return getDropdown(element).getAllSelectedOptions();
	}

}
