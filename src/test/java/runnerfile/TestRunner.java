package runnerfile;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(

        features = {"src/test/resources/com.demo.featurefile"},
        glue = {"/com/demo/stepdefinition","hooks"},
        monochrome = true,
        publish = true,
        plugin ={"pretty","html:target/CucumberReports/CucumberReport.html",
                "json:test-output/jsonReport.json",
                "junit:test-output/junitReport.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}


)

public class TestRunner {

}
