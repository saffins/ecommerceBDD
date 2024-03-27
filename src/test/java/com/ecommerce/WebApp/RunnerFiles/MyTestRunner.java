/**
 * 
 */
package com.ecommerce.WebApp.RunnerFiles;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/featureFiles/LoginPage.feature"},
				glue={"com/ecommerce/WebApp/StepDefinationFiles", "com/ecommerce/WebApp/Base"},
				plugin= {"pretty","html:target/cucumber-reports/report.html","junit:target/cucumber-reports/report.xml","json:target/cucumber-reports/report.json"},
				monochrome=true,
				publish = true
				)
public class MyTestRunner {

}
