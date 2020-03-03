package StepDefinitions.WebOrder;

import Pages.Weborder.AllProductsPage;
import Pages.Weborder.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ViewAllProductsStepDef {
    LoginPage page=new LoginPage();
    AllProductsPage allProductsPage=new AllProductsPage();

    @When("user enters valid credentials {string} and {string}")
    public void user_enters_valid_credentials_and(String string, String string2) {
page.username.sendKeys(string);
page.password.sendKeys(string2);
page.loginBtn.click();
    }

    @When("user clicks to the view all orders button")
    public void user_clicks_to_the_view_all_orders_button() {

    }

    @Then("validates the {string} header displayed")
    public void validates_the_header_displayed(String string) {

        Assert.assertEquals(string,allProductsPage.textListOfAllOrders.getText().trim());
    }
}
