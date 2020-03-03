package StepDefinitions.WebOrder;

import Pages.Weborder.HomePage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class HomePageStepDefs{
 HomePage page=new HomePage();
    @Then("the user validates menu order List")
    public void the_user_validates_menu_order_List() {

        for(int i=0; i<page.orderMenu.size(); i++){
            Assert.assertEquals(page.orderMenuData().get(i), page.orderMenu.get(i).getText());
        }

    }


}
