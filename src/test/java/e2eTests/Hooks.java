package e2eTests;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Hooks extends BaseTest{

    @Before
    public void beforeScenario() throws InterruptedException, ParseException, IOException {
        Checks();
        initialization();
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed())
        {
            System.out.println(scenario.getName());
        }
        getDriver().quit();
    }

}
