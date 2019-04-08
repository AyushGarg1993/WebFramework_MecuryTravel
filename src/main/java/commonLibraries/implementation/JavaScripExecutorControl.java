package commonLibraries.implementation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commonLibraries.contracts.IJavaScriptExecutor;

public class JavaScripExecutorControl implements IJavaScriptExecutor{
	
	

private WebDriver driver;
	
	
	public JavaScripExecutorControl(WebDriver driver) {
		
		this.driver = driver;
	}
	
	private JavascriptExecutor getJsEngine() {
		
		JavascriptExecutor jsEngine;
		
		jsEngine = (JavascriptExecutor) driver;
		
		return jsEngine;
	}

	
	
	
	public void executeJavaScript(String scriptToExecute) throws Exception {
		
		
		getJsEngine().executeScript(scriptToExecute);
		
	}



	
	public void scrollDown(int x, int y) throws Exception {
		
		
		String jsCommand = String.format("window.scrollBy(%d,%d)",x,y);
		
		getJsEngine().executeScript(jsCommand);

	}

	
	public String executeJavaScriptWithReturnValue(String scriptToExecute) throws Exception {
		
		
		
	return	getJsEngine().executeScript(scriptToExecute).toString();
	}
	
	

	


}
