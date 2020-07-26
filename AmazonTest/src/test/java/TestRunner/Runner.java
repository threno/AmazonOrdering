package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/addtocart.feature",glue={"Steps"},plugin= {"pretty","html:target/reports"}, monochrome=true)

public class Runner {

}
