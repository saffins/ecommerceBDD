package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/main/resources/features/LoginPage.feature"},
        glue={"com.steps"},
        plugin= {"pretty","html:target/cucumber-reports/report.html","junit:target/cucumber-reports/report.xml","json:target/cucumber-reports/report.json"},
        monochrome=true,
        tags = "@FunctionalTest"
)
public class TestRunner {
}
