package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {
    public static void switchWindow(String targetTitle) {
        WebDriver driver = Driver.getDriver();
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        if (!driver.getTitle().equals(targetTitle)) {
            for (String window : allWindows) {
                driver.switchTo().window(window);
                if (driver.getTitle().equals(targetTitle)) {
                    break;
                }
            }

        }


    }

    public static void verifyBrokenLink(List<WebElement> tags) {
        for (WebElement links : tags) {
            String hrefValue = links.getAttribute("href");
            try {
                URL url = new URL(hrefValue);
                HttpURLConnection connect = (HttpURLConnection) url.openConnection();
                connect.setConnectTimeout(3000);
                connect.connect();
                if (connect.getResponseCode() >= 400 || connect.getResponseCode() >= 500) {
                    System.out.println(hrefValue);
                    System.out.println("The link is broken   \n" + connect.getResponseMessage() + "   \n" +
                            connect.getResponseCode());

                }
            } catch (IOException a) {
                System.out.println(a.getStackTrace());
            }

        }

    }


    public void hoverOver(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).build().perform();

    }

    public static void dragAndDrop(WebElement from, WebElement to) {
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(from, to).build().perform();

    }

    public static WebElement waitUntilVisibilityOfElement(WebElement element, int timeUnits) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeUnits);
        return wait.until(ExpectedConditions.visibilityOf(element));

    }

    public static void clickabilityOfElement(WebElement element, int timeUnits) {
        Wait wait = new WebDriverWait(Driver.getDriver(), timeUnits);
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public static WebElement waitForVisibilityLocator(By locator, int timeUnits) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeUnits);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void takeScreenshot() throws IOException {
        File src = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        File desFile = new File("ScreenShotFile/" + System.currentTimeMillis() + ".png");
        FileUtils.copyFile(src, desFile);

    }

    public static void waitForSec(int timeUnits) {
        timeUnits = timeUnits * 1000;
        try {
            Thread.sleep(timeUnits);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement waitForCLickabilityLocator(By locator, int timeUnits) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeUnits);

        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement fluentWait(WebElement element, int timeUnits, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait(Driver.getDriver())
                .withTimeout(timeUnits, TimeUnit.SECONDS)
                .pollingEvery(pollingTime, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement element1 = wait.until(
                driver -> element

        );
        return element1;


    }

    public static void selectByVisibleText(WebElement element, String name) {
        Select select = new Select(element);
        select.selectByVisibleText(name);
    }
}
