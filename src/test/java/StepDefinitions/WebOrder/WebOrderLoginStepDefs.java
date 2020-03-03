package StepDefinitions.WebOrder;

import Pages.Weborder.LoginPage;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class WebOrderLoginStepDefs {
    WebDriver driver= Driver.getDriver();
    LoginPage page=new LoginPage();
    @Given("the user navigates to the web orders page")
    public void the_user_navigates_to_the_web_orders_page() {
        driver.get(ConfigReader.getProperty("URL"));
        System.out.println("Navigated to Web Order page");
    }

    @When("the user provides valid username")
    public void the_user_provides_valid_username() {
        page.username.sendKeys(ConfigReader.getProperty("username"));
        System.out.println("The user sent tester");
    }

    @When("the user provides valid password")
    public void the_user_provides_valid_password() {
        page.password.sendKeys(ConfigReader.getProperty("password"));
        page.loginBtn.click();
        System.out.println("The user sent test");
    }

    @Then("the user should see home page")
    public void the_user_should_see_home_page() {

        System.out.println("The user validated home page");
        String expectedTitle="Web Orders";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @When("the user provides username {string}")
    public void the_user_provides_username(String username) {
        page.username.sendKeys(username);

    }

    @When("the user provides password {string}")
    public void the_user_provides_password(String password) {
      page.password.sendKeys(password);
      page.loginBtn.click();
    }

    @Then("the user should validate text {string}")
    public void the_user_should_validate_text(String message) {
         String a="Invalid Login or Password.";
         Assert.assertEquals(a,page.message.getText());
    }

    @When("the user provides username {int}")
    public void the_user_provides_username(Integer int1) {
    page.username.sendKeys(""+int1);
    }

    @When("the user provides password {int}")
    public void the_user_provides_password(Integer int1) {
    page.password.sendKeys(""+int1);
    page.loginBtn.click();
    }
    @When("the user provides username {string} and password {string}")
    public void the_user_provides_username_and_password(String string, String string2) {
    page.username.sendKeys(string);
    page.password.sendKeys(string2);
    page.loginBtn.click();
    }

}
