package CukeRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features"
		,glue={"StepDefinations"}		
		,tags="@regression"
		,monochrome =true
		,plugin={"pretty", "html:target/Reports.html"}
		)


public class TestRunner {
	
	
	

}
