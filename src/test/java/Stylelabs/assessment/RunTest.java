package Stylelabs.assessment;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//@CucumberOptions(features="features",glue={"stepDefination"})
@CucumberOptions(format = {"pretty", "html:target/cucumber"})
public class RunTest {

}

