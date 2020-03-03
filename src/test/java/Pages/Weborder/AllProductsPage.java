package Pages.Weborder;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AllProductsPage {
    public AllProductsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[.='View all products']")
    public WebElement viewAllProducts;
    @FindBy(xpath = "//table[@class='ProductsTable']//tr")
    public List< WebElement> productList;
@FindBy(xpath = "//h2")
public WebElement textListOfAllOrders;

    public List<String> getProductList(){
        List<String> productData=new ArrayList<>();
        for(WebElement element:productList){
            productData.add(element.getText().trim());
        }
        return productData;
    }
    public List<String> expectedData(){
        List<String> expectedData=new ArrayList<>();
        expectedData.add("Product name Price Discount");
        expectedData.add("MyMoney $100 8%");
        expectedData.add("FamilyAlbum $80 15%");
        expectedData.add("ScreenSaver $20 10%");

        return expectedData;

    }

}
