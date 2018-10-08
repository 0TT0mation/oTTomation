package pageObjects;


import base.pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class supportConfirmPageObject extends pageObject {
    public supportConfirmPageObject(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public  String baseUrl = "https://stage-frontend.nutaku.net/support/general-inquiries/confirm/";


    @FindBy(css = ".item .mainbtn")
    public WebElement sendButtonConfirm;

    public supportCompletePageObject clickConfirm(){
        waitForVisibility(sendButtonConfirm);
        sendButtonConfirm.click();
        checkLinkAfterClick("/support/general-inquiries/complete/");
        return new supportCompletePageObject(driver, wait);
    }
}
