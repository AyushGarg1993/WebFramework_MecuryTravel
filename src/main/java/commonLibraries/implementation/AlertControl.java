package commonLibraries.implementation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import commonLibraries.contracts.IAlert;

public class AlertControl implements IAlert {

	WebDriver driver;
	
	AlertControl(WebDriver driver)
	{
		this.driver= driver;
		
		
	}
	
	private Alert getAlert()
	{
		Alert alert = driver.switchTo().alert();
		
		return alert;
		
	}
	
	public void acceptAlret() throws Exception {
		
		getAlert().accept();
		
	}

	public void rejectAlret() throws Exception {
		
		getAlert().dismiss();
	}


	public void getMessgaeFromAlret() throws Exception {
	
		getAlert().getText();
		
	}

}
