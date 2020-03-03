package Pages.Etsy;

import Utils.Driver;
import io.cucumber.java.fr.Et;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsyPage {
    public EtsyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@id='global-enhancements-search-query']")
    public WebElement searchBox;

}
