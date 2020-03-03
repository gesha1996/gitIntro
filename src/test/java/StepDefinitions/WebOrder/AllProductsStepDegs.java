package StepDefinitions.WebOrder;

import Pages.Weborder.AllProductsPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AllProductsStepDegs {
    AllProductsPage page=new AllProductsPage();
    @Then("click on view all products")
    public void click_on_view_all_products() {
        page.viewAllProducts.click();

    }

    @Then("then validate the table data")
    public void then_validate_the_table_data() {
        List<String> actualList=page.getProductList();
        List<String> expectedList=page.expectedData();
        Assert.assertTrue(actualList.containsAll(expectedList));
        Assert.assertEquals(actualList,expectedList);
    }
}
