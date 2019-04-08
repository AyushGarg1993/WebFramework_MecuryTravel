package commonLibraries.implementation;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import commonLibraries.contracts.IScreenshots;





public class ScreenshotControl implements IScreenshots {
	
	
	 WebDriver driver;
	
	public ScreenshotControl(WebDriver driver) {
		this.driver = driver;
	}



	public void saveAndCaptureScreenshot(String filePath) throws Exception {
		
			
		filePath = filePath.trim();
			
			File imgFile, tmpFile;
			
			imgFile = new File(filePath);
		
			
			TakesScreenshot camera;
			
			camera = (TakesScreenshot) driver;
			
			tmpFile = camera.getScreenshotAs(OutputType.FILE);
		
			FileUtils.moveFile(tmpFile, imgFile);
		}
		
		
		
		
	}

	
	