package pageObjects;

import base.pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class supportCompletePageObject extends pageObject {
    public supportCompletePageObject(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String baseUrl="https://stage-frontend.nutaku.net/support/general-inquiries/complete/";

    @FindBy(css = ".support-new a.mainbtn")
    public WebElement returnToHomepage;

    public homepagePageObject clickReturnToHomepage(){
        waitForVisibility(returnToHomepage);
        returnToHomepage.click();
        return new homepagePageObject(driver, wait);
    }
}
