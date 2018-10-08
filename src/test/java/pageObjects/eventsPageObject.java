package pageObjects;

import base.log;
import base.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Random;

public class eventsPageObject extends pageObject {
    public eventsPageObject(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //Constants

    String baseUrl = "https://www.nutaku.net/events/";

    @FindBy(css = "a.grey-box")
    public WebElement viewAllGamesButton;

    @FindBy(css = ".events-list li")
    List <WebElement> events;

    //Page actions

    public browserGamesPageObject clickViewAllGames(){
        waitForVisibility(viewAllGamesButton);
        viewAllGamesButton.click();
        checkLinkAfterClick("/games");
        return new browserGamesPageObject(driver, wait);
    }

    public void checkRandomGameEvent(){
        int rand = new Random().nextInt(events.size());
        WebElement gameEvent =  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".events-list li:nth-child("+rand+") a"))));
        if (gameEvent.getAttribute("href").contains(gameEvent.findElement(By.cssSelector("img")).getAttribute("alt"))){
            log.debug("event image alt attribute matches href link href value");
        }else{
            log.info("event image alt attribute does not match link href value");
        }
    }
}