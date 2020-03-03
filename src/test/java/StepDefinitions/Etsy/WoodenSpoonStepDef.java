package StepDefinitions.Etsy;

import Pages.Etsy.EtsyPage;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class WoodenSpoonStepDef {
WebDriver driver= Driver.getDriver();
EtsyPage page=new EtsyPage();
    @Given("user navigates to the etsy website")
    public void user_navigates_to_the_etsy_website() {
    driver.get("https://www.etsy.com/");
    }


    @When("user searches for {string}")
    public void user_searches_for(String string) {
      page.searchBox.sendKeys(string);
    }

    @Then("user validates the title {string}")
    public void user_validates_the_title(String string) {
        Assert.assertEquals(string,driver.getTitle());
    }


//    @When("user searches for make up organizer")
//    public void user_searches_for_make_up_organizer() {
//    page.searchBox.sendKeys("make up organizer"+Keys.ENTER);
//    }
//
//    @Then("user validates the title {string} text")
//    public void user_validates_the_title_text(String string) {
//   Assert.assertEquals(string,driver.getTitle());
//    }
}
