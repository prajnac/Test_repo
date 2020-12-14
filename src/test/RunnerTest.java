package test;


import cucumber.api.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber","json:target/cucumber.json"},
        glue = {"src.test.api_test"},
        //features = {"src/test"},
        tags = {"@locationcheck"}
)
public class RunnerTest {
    @BeforeClass
    public static void setup() {
        System.out.println("\n******* RUN STARTS " + new java.util.Date() + " *******************************");
    }
}//end