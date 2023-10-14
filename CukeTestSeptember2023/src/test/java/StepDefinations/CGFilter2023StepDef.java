package StepDefinations;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Framework.DriverManager;
import Framework.DriverType;
import Framework.ReadPropertyFile;
import Pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CGFilter2023StepDef {
	
	WebDriver driver;	
	HomePage homePage;
	ReadPropertyFile properties = new ReadPropertyFile();
	
	BaseContextDI baseContextDI;
	
	public CGFilter2023StepDef(BaseContextDI baseContextDI) {
		this.baseContextDI = baseContextDI;
		this.driver = baseContextDI.getDriver();
	}

	@Given("As CarsGuide active User, I'm on the landing Page")
	public void as_cars_guide_active_user_i_m_on_the_landing_page() throws IOException {
	   
		homePage = new HomePage(driver);
		homePage.NavigateToHomePage(properties.ReadConfigFile("url"));
		
	}

	@When("I filter cars by {string} and {string}")
	public void i_filter_cars_by_and(String make, String model) throws InterruptedException {
		
		homePage.SearchForCar(make, model);
	   
	}

	@Then("I should get search {string} displayed on landing Page")
	public void i_should_get_search_displayed_on_landing_page(String expectResult) {
	    
		String resultFromApp = homePage.GetSearchResults();
		//Assert.assertEquals(expectResult,resultFromApp);
		
		Assert.assertTrue(resultFromApp.contains(expectResult));
	}

}
