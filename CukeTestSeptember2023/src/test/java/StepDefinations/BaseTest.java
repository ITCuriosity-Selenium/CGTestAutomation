package StepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.DriverManager;
import Framework.DriverType;
import Pages.HomePage;
import Pages.SignInPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseTest {

	public WebDriver driver;	
	DriverManager d = new DriverManager();
	BaseContextDI baseContextDI;
	
	public BaseTest(BaseContextDI baseContextDI) {
		this.baseContextDI = baseContextDI;
	}
	

	@Before()
	public void BeforeTest() {

		driver = d.CreateDriver(DriverType.Chrome);
		//After creation of this driver , store it in DI Container
		baseContextDI.setDriver(driver);
	}

	@After()
	public void AfterTest() {

		System.out.println("Cleaning up driver Instance");
		driver.quit();
	}

}
