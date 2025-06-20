package runnerFile;

import org.junit.runner.RunWith;

import com.aventstack.extentreports.ExtentReports;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/featureFiles/getBooksAPI.feature",
		glue = "stepDefinitions",
		monochrome = true,
		//uncomment the below tags line to run a specific scenario
//		tags = "@API_tc_001",
		plugin = {"pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json"}
		)


public class TestRunner {


}