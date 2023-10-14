package StepDefinations;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.DriverManager;
import Framework.DriverType;
import Framework.ReadPropertyFile;
import Pages.HomePage;
import Pages.SignInPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarsGuideLogin2023SeptStepDef {
	
    WebDriver driver;	
	SignInPage loginPage;
	HomePage homePage;
	ReadPropertyFile properties = new ReadPropertyFile();	
	
	BaseContextDI baseContextDI;
	
	public CarsGuideLogin2023SeptStepDef(BaseContextDI baseContextDI) {
		this.baseContextDI = baseContextDI;
		this.driver = baseContextDI.getDriver();
	}

	@Given("As CarsGuide active User, I'm on the Login Page")
	public void as_cars_guide_user_i_m_on_the_login_page() throws InterruptedException, IOException {

		// Using homepage Page POM to Click Sign In Tab
		homePage = new HomePage(driver);
		//homePage.NavigateToHomePage("https://www.carsguide.com.au/");
		homePage.NavigateToHomePage(properties.ReadConfigFile("url"));
		Thread.sleep(2000);
		homePage.GotoSignInPage();

		// Using Sign IN Page POM to Click Sign In Tab
		loginPage = new SignInPage(driver);
		loginPage.ClickSignInTab();

	}

	@When("I enter active Username, Password and SignIn")
	public void i_enter_username_password_and_sign_in() throws InterruptedException {
		
		// Using Sign IN Page POM for User to Login
		loginPage.SignIn("ITCuriosity.selenium@gmail.com", "Test12345");
	}
	
	
	@Then("I should land on the Account Page")
	public void i_should_land_on_the_account_page() {

		// Using Sign IN Page POM for verifying User Account		
		String accountName = loginPage.LoginAccountTitle("John");
		Assert.assertEquals("John", accountName);			
		
	}	
	
	
	@When("I enter active {string}, {string} and SignIn")
	public void i_enter_active_and_sign_in(String userID, String pass) throws InterruptedException {

		// Using Sign IN Page POM for User to Login 
		loginPage.SignIn(userID, pass);
		Thread.sleep(6000);			
	}
	
	@Then("I should land on the Account Page {string}")
	public void i_should_land_on_the_account_page_para(String accName) {

		// Using Sign IN Page POM for verifying User Account
		loginPage.LoginAccountTitle(accName);
	}	

	
	
	

}
