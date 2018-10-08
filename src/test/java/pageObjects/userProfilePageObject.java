package pageObjects;

import base.pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class userProfilePageObject extends pageObject {
    public userProfilePageObject(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String baseUrl="https://stage-frontend.nutaku.net/members/profile/1001369/";  /////FIX



}
