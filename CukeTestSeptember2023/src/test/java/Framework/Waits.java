package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

	public void WaitForElementTobeVisible(WebDriver driver, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void WaitForElementTobeClickable(WebDriver driver, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void WaitForTextToBePresent(WebDriver driver, WebElement element, String text) {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));

	}
	
	public void WaitForPageUrlLoad(WebDriver driver, String url) {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.urlContains(url));
	}
	
	public void CheckElementIsInvisible(WebDriver driver, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.invisibilityOf(element));

	}
	
	public void Sleep(int milliSec) throws InterruptedException {
		
		Thread.sleep(milliSec);
		
	}
	

}
