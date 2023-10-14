package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.Waits;

public class SignInPage {
	
	WebDriver driver;	
	Waits waitService = new Waits();
	
	//Sign In Page Object Model	
	//Step1: Identify the Web Elements	
	
	@FindBy(linkText = ("SIGN IN"))
	WebElement SignInTab;
	
	@FindBy(xpath = ("//input[@name='email']"))
	WebElement UserName;
	
	@FindBy(xpath = ("//input[@name='password']"))
	WebElement Password;
	
	@FindBy(xpath = ("//button[@class='auth0-lock-submit']"))
	WebElement SubmitButton;
	
	@FindBy(css = ("Span.uhf-logged-in-show.uhf-user-label"))
	WebElement UserAccount;
	
	// Step2: Constructor to initialize all the web elements	
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;		
		// Page Factory init Element will initialize all the web elements		
		PageFactory.initElements(driver, this);		
		System.out.println("Sign in Page Object Model In Use");
		
	}
	
	//Step3: Click on the SignIn Tab
	public void ClickSignInTab() {		
		
		waitService.WaitForElementTobeClickable(driver, SignInTab);
		SignInTab.click();		
		
	}
	
	//Step4: Perform Sign In Action by entering user credentials
	public void SignIn(String userName, String password) {		
		
		waitService.WaitForElementTobeVisible(driver, UserName);
		UserName.clear();
		UserName.sendKeys(userName);		
		
		waitService.WaitForElementTobeVisible(driver, Password);
		Password.clear();
		Password.sendKeys(password);		
		
		waitService.WaitForElementTobeClickable(driver, SubmitButton);
		SubmitButton.click();		
		
	}
	
	//Step5: Get the Account Name
	public String LoginAccountTitle(String expectAccountName) {		
		
		waitService.WaitForTextToBePresent(driver, UserAccount, expectAccountName);
		String accountName = UserAccount.getText();
		System.out.println("Actual value from Application::" + accountName);		
		return accountName;
		
	}
	
	
	
}
