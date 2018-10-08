package pageObjects;

import base.log;
import base.pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class landingPageObject extends pageObject{

    public landingPageObject(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //Constants

    public String baseUrl = "https://stage-frontend.nutaku.net/";

    @FindBy(css = ".mainbtn")
    public WebElement acceptButon;

    //Page actions

    public void goToLanding(){
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    public homepagePageObject goToNutaku(){
        waitForVisibility(acceptButon);
        if(acceptButon.getText().contains("I am over 18 years old")){
            log.debug("Age consent text is present");
        }
        acceptButon.click();
        checkLinkAfterClick(".net/home");
        return new homepagePageObject(driver, wait);
    }
}
