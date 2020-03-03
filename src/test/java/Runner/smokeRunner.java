package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com.cucumber.features/WebOrderLogin.feature",
        glue="StepDefinitions",
        monochrome=true,
        dryRun = false

)
public class smokeRunner {

}
