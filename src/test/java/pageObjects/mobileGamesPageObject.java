package pageObjects;

import base.pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mobileGamesPageObject extends pageObject {
    public mobileGamesPageObject(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //Constants

    String baseUrl = "https://www.nutaku.net/games/mobile/";

    @FindBy(css = "")
    public WebElement element;

    //Page actions

}
