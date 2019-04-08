package commonLibraries.Utilits;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	
	
	public static Properties readProperties(String filePath) throws Exception
	{
		
		filePath = filePath.trim();
		
		
		// to read from file we user Input stream 
		
		InputStream filereader = new FileInputStream(filePath);
		
		
		Properties property = new Properties();
		
		
		property.load(filereader);
		
		return property;
		
	}

}
