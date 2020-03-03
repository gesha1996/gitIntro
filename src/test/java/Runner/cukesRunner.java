package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//this is the only junit annotation that will be used in cucumber
@CucumberOptions(

        features = "src/test/resources/com.cucumber.features.Etsy/EtsyTest.feature",
        glue="StepDefinitions",
        monochrome=true
     //  tags="@spoon"
      // tags="@makeUpOrganizer"
)
public class cukesRunner {

}
