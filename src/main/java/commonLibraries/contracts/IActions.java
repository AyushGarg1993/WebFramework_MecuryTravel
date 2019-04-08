package commonLibraries.contracts;

import org.openqa.selenium.WebElement;

public interface IActions {
	
	
	public void moveToElement(WebElement element) throws Exception;
	
	public void rightClick(WebElement element) throws Exception;
	
	public void doubleClick(WebElement element) throws Exception;
	
	public void moveToElementAndClick(WebElement element) throws Exception;
	
	public void dragAndDrop(WebElement element, WebElement element1) throws Exception;
		

}
