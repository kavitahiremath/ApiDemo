package runnerC;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features="C:\\Users\\SPURGE\\Grhombus\\ApiECommerce\\src\\test\\java\\features\\E2E.feature",
		glue="stepdefinitions",
		plugin = {"pretty","json:target\\jsonReports\\CucumberReports.json",
				"html:target/cucumber-reports/CucumberTestReport.html"},
		dryRun = true
		)
public class RunnerClass extends AbstractTestNGCucumberTests{

}
