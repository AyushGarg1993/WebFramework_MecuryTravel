package commonLibraries.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import commonLibraries.contracts.IActions;


public class MouseControl implements IActions {
	
	
    WebDriver driver;

    public MouseControl(WebDriver driver)
    {
	 
	 this.driver = driver;
    }

    private Actions getMouseControl(){
    	
    	  Actions action = new Actions(driver);
    	  
    	  return action;
    }
    
    
    
    

	public void moveToElement(WebElement element) throws Exception {
		
		
		getMouseControl().moveToElement(element).build().perform();
	}


	public void rightClick(WebElement element) throws Exception {
		
		
		getMouseControl().contextClick(element).build().perform();

	}


	public void doubleClick(WebElement element) throws Exception {
		
		getMouseControl().doubleClick(element).build().perform();
		
	}

	
	public void moveToElementAndClick(WebElement element) throws Exception {
		
		getMouseControl().moveToElement(element).click().build().perform();
		
	}


	public void dragAndDrop(WebElement element, WebElement element1) throws Exception {
		
		getMouseControl().dragAndDrop(element, element1).build().perform();
		
	}

}
