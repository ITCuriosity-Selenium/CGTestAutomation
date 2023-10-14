package StepDefinations;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.DriverManager;
import Framework.DriverType;
import Framework.ReadPropertyFile;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CarsGuideSignUp2023September {
	
    WebDriver driver;
	WebDriverWait wait;	
	ReadPropertyFile properties = new ReadPropertyFile();
	
	BaseContextDI baseContextDI;
	
	
	public CarsGuideSignUp2023September(BaseContextDI baseContextDI) {
		this.baseContextDI = baseContextDI;
		this.driver = baseContextDI.getDriver();
	}

	@Given("As new Cars Guide User, I'm on the Signup Page")
	public void as_new_cars_guide_user_i_m_on_the_signup_page() throws InterruptedException, Throwable {
        		
		wait = new WebDriverWait(driver, 10);		
		System.out.println("New User is on Sign Up Page");		
		//driver.get("https://www.carsguide.com.au/");	
		driver.get(properties.ReadConfigFile("url"));	
		
		WebElement SignUPLink =driver.findElement(By.cssSelector("span.uhf-logged-out-show.uhf-user-label"));
		wait.until(ExpectedConditions.elementToBeClickable(SignUPLink));
		SignUPLink.click();
		Thread.sleep(5000);

	}

	@When("I enter user details to SignUp create my account")
	public void i_enter_user_details_to_sign_up_create_my_account(DataTable dataTable) {
		System.out.println("User entering details on Sign Up Page");

		List<List<String>> data = dataTable.cells();
		System.out.println("Get size data::"+data.size());
		
		 for (int i = 0; i < data.size(); i++) {
			 
			 String userName = data.get(i).get(0);
			 System.out.println("Email::"+userName);
			 
			 String password = data.get(i).get(1);
			 System.out.println("password::"+password);
			 
			 String firstName = data.get(i).get(2);
			 System.out.println("FirstName::"+firstName);
			 
			 String lastName = data.get(i).get(3);
			 System.out.println("LastName::"+lastName);
			 
			 WebElement UserName = driver.findElement(By.name("email"));
			 wait.until(ExpectedConditions.visibilityOf(UserName));
			 UserName.clear();
			 UserName.sendKeys(userName);
			 
			 WebElement Password= driver.findElement(By.name("password"));
			 wait.until(ExpectedConditions.visibilityOf(Password));
			 Password.clear();			 
			 Password.sendKeys(password);
			 
			 WebElement FirstName =driver.findElement(By.name("given_name"));
			 wait.until(ExpectedConditions.visibilityOf(FirstName));
			 FirstName.clear();
			 FirstName.sendKeys(firstName);	
			 
			 WebElement LastName=driver.findElement(By.name("family_name"));
			 wait.until(ExpectedConditions.visibilityOf(LastName));
			 LastName.clear();
			 LastName.sendKeys(lastName);			
			 //WebElemet Submit =driver.findElement(By.xpath("//button[@type='submit']"));
			 //Submit.click();
				
		}
	}


}
