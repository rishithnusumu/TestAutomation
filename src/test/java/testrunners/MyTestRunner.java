package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/AppFeatures"},
        glue = {"stepdefinitions", "AppHooks"},
        plugin ={"pretty","html:target/cucumber/cucumber.html",
                "json:target/JSONReports/JSONReport.json"}
)


public class MyTestRunner {

}
