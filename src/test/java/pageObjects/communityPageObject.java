package pageObjects;


import base.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class communityPageObject extends pageObject {

    public communityPageObject(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String baseUrl = "https://stage-frontend.nutaku.net/search/";

    @FindBy(css = "#username")
    public WebElement userNameSearchInput;

    @FindBy(css = "#search")
    public WebElement searchButton;

    @FindBy(css = ".new-memeber li")
    public WebElement userProfileLink;

    @FindBy(css = "#form")
    public WebElement searchForm;


    public void searchUserClickProfile(){
        waitForVisibility(userNameSearchInput);
        userNameSearchInput.sendKeys("selenium");
        waitForVisibility(searchButton);
        searchButton.click();
    }

    public userProfilePageObject clickUser(){
        waitForVisibility(userProfileLink);
        userProfileLink.click();
        return new userProfilePageObject(driver, wait);
    }
    public boolean isSearchavailable(){
        if (searchForm.findElement(By.cssSelector(".notice-verify-email")).isDisplayed()){
            return true;
        }else{
            return false;
        }
    }
}
