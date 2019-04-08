package commonLibraries.implementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import commonLibraries.contracts.IDriver;

public class CommonDriver implements IDriver{
	
	
	// we use private to restrict the usage in this 
//	class but this driver might use outside so we will 
//	so we will have only getter and not setter as we dont want 
//	anyone change the value 
	// and for other 2 variable we will have setter as we want people from outside to set them 
	
	// driver instance
	private WebDriver driver;
	
	// for page time out
		private int pageLoadTimeout;
		
		// for implicit wait
		private int elementDetectionTimeout;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setPageLoadTimeout(int pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}

	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}
	
	public CommonDriver(String browserType) throws Exception {
		
		// these are defaut value
		elementDetectionTimeout = 10;
		pageLoadTimeout = 30;
		
		
		browserType = browserType.trim();
		
		if(browserType.equalsIgnoreCase("chrome"))
		{
			
			String CurrentWorkingDirectory = System.getProperty("user.dir");
			
			String chromDriverPath =  String.format("%s/Drivers/chromedriver", CurrentWorkingDirectory);
			
			System.out.println("*************************************************************"+chromDriverPath );
			
			System.setProperty("webdriver.chrome.driver",
					chromDriverPath);

			driver = new ChromeDriver();
			
		} else if (browserType.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"C:/Users/Saurabh Dhingra/workspace/libs/chromedriver2.45/chromedriver.exe");

			driver = new FirefoxDriver();
		}
		else
		{
			throw new Exception("Invalid Browser ..... "+ browserType);
		}
		

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();
				
	}


	public void navigateToFirstUrl(String url) throws Exception {
		
		url = url.trim();
	
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);
		
		driver.get(url);
	}


	public void navigateToUrl(String url) throws Exception {
		
		
		url = url.trim();
		
		driver.navigate().to(url);
	
	}


	public void navigateForward() throws Exception {
		
		driver.navigate().forward();
	}


	public void navigateBackward() throws Exception {
		
		driver.navigate().back();

	}


	public void refresh() throws Exception {
		
		driver.navigate().refresh();

	}


	public void closeBrowser() throws Exception {

		
		if(driver != null) {
			driver.close();
		}
	}


	public void closeAllBrowser() throws Exception {
		if(driver != null) {
			driver.quit();
		}		
	}


	public String getTitle() throws Exception {
		
		return driver.getTitle();
	}


	public String getCurrentUrl() throws Exception {
		return driver.getCurrentUrl();
	}


	public String getPageSource() throws Exception {
		return driver.getPageSource();
	}
	
	

}
