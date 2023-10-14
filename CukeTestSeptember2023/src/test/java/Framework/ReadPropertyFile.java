package Framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	
	public String ReadConfigFile(String Keyword) throws IOException {
		
		Properties prop = new Properties();		
		FileInputStream ip = new FileInputStream("src/test/resources/Config/Config.properties");
		
		prop.load(ip);
		
		return prop.getProperty(Keyword);
	}

}
