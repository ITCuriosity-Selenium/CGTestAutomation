package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.Services;
import Framework.Waits;

public class HomePage {
	
	WebDriver driver;
	Waits waitService = new Waits();
	Services service = new Services();
	
	@FindBy(css =("span.uhf-logged-out-show.uhf-user-label"))
	WebElement SignInLink;
	
	@FindBy(id =("makes"))
	WebElement CarMakes;
	
	@FindBy(id =("models"))
	WebElement CarModels;
	
	@FindBy(id =("search-submit"))
	WebElement SubmitButton;
	
	@FindBy(css =("h1.h1Text.search--title"))
	WebElement SearchResult;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;		
		// Page Factory init Element will initialize all the web elements		
        PageFactory.initElements(driver, this);		
		System.out.println("HomePage Page Object Model In Use");
	}
	
	public void NavigateToHomePage(String url) {
		// Step2: Navigating to the Web Application
		driver.get(url);		
	}
	
	public void GotoSignInPage() {		
		
		waitService.WaitForElementTobeVisible(driver, SignInLink);
		SignInLink.click();
	}
	
	public void SearchForCar(String Make, String Model) throws InterruptedException {		
		
		waitService.WaitForElementTobeClickable(driver, CarMakes);
		service.SelectFromDropDownByText(CarMakes, Make);
		waitService.Sleep(2000);		
	
		waitService.WaitForElementTobeClickable(driver, CarModels);
		service.SelectFromDropDownByValue(CarModels, Model);
		
		waitService.WaitForElementTobeClickable(driver, SubmitButton);
		SubmitButton.click();

	}
	
	public String GetSearchResults() {		

		waitService.WaitForElementTobeClickable(driver, SearchResult);
		String result = SearchResult.getText();
		
		return result;
		
	}

}
