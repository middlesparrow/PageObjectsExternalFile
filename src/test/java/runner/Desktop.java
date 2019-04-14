package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features", //filesystem path
        glue = {"e2eTests"}, //package name
        tags = {"not @ignore"},
        plugin = {
                "pretty", //Prints the Gherkin source with additional colors and stack traces for errors
                "html:target/cucumber-reports/html-report",
                "json:target/cucumber-reports/json-reports/CucumberTestReport.json",
                "junit:target/cucumber-reports/junit-reports/CucumberTestReport.xml"
        },
        //dryRun = false //checks that every Step in the Feature File has code written in Step Definition file or not
        monochrome = true //console output for the Cucumber test are much more readable
        )

//Use empty method with AbstractTestNGCucumberTests, the cucumber hooks will be read from the files in glue package
public class Desktop extends AbstractTestNGCucumberTests {

}
