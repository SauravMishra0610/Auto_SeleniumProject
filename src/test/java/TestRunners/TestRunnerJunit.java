package TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        stepNotifications = true,
        plugin = {"pretty","html:target/cucumber-html-reports",
                "json:target/cucumber-reports/cucumber.json", "junit:target/cucumber-reports/cucumber.xml",
                /*"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"*/},
        tags = "@TestCaseUI_PaginationApplicationSearchByText"

)
public class TestRunnerJunit {
}

//plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
//        "junit:target/cucumber-reports/Cucumber.xml",
//        "html:target/cucumber-reports/Cucumber.html"},

//    mvn verify -DskipTests
