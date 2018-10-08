package pageObjects;

import base.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Random;

public class goldStorePageObject extends pageObject {

    public goldStorePageObject(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String baseUrl = "https://stage-frontend.nutaku.net/search/";

    @FindBy(css = ".visachart li")
    public List<WebElement> purchaseGoldOptions;


    public paymentProcessingObjectPage clickRandomGoldQuantity(){
        int rand = new Random().nextInt(purchaseGoldOptions.size());
        WebElement goldBundle = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a:nth-child("+rand+")")));
        goldBundle.click();
        return new paymentProcessingObjectPage (driver, wait);
    }
}
