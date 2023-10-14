package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Services {

	public void SelectFromDropDownByText(WebElement element, String text) {

		Select DropDownList = new Select(element);
		DropDownList.selectByVisibleText(text);
	}

	public void SelectFromDropDownByIndex(WebElement element, int indexNum) {

		Select DropDownList = new Select(element);
		DropDownList.selectByIndex(indexNum);
	}
	
	public void SelectFromDropDownByValue(WebElement element, String value) {

		Select DropDownList = new Select(element);
		DropDownList.selectByValue(value);
	}

	public void PerformHover(WebDriver driver, WebElement element ) {
		
		Actions hover = new Actions(driver);
		hover.moveToElement(element).build().perform();

	}

	public void NavigateToPage(WebDriver driver, String url) {

		driver.get(url);
	}

}
