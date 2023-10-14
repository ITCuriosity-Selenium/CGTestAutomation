package Framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverManager {
	
	WebDriver driver;
	
	public WebDriver CreateDriver(DriverType Type) {
	
		switch (Type) {
			case Chrome:
				System.out.println("Web Driver Opening Chrome Browser");
				System.setProperty("webdriver.chrome.driver",
						"C:\\MyWorkSpace\\Curiosity\\Tools\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
				break;
				
			case FireFox:
				System.out.println("Web Driver Opening FireFox Browser");				
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
				break;
				
			case Edge:
				System.out.println("Web Driver Opening edge Browser");
				System.setProperty("webdriver.edge.driver",
						"C:\\MyWorkSpace\\Curiosity\\Tools\\Drivers\\msedgedriver.exe");
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
				break;
				
			case IE:
				System.out.println("Web Driver Opening ie Browser");
				System.setProperty("webdriver.ie.driver",
						"C:\\MyWorkSpace\\Curiosity\\Tools\\Drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
				break;	
			
		}

		return driver;
	}

}
