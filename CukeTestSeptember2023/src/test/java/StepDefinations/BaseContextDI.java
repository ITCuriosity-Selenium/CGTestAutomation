package StepDefinations;

import org.openqa.selenium.WebDriver;

public class BaseContextDI {
	
	WebDriver driver;	
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		
		return this.driver;
	}
	

}
