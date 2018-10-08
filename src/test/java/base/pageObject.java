package base;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.homepagePageObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


public class pageObject{

    public WebDriver driver;
    public WebDriverWait wait;



    @FindBy(css = ".header a.logo")
    public WebElement logoLink;
    public String baseUrl;


    public pageObject(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }



    public void checkWebElement(WebElement element){
        if (element.isDisplayed() & element.isEnabled()){
            log.info(element.getTagName() + element + "is available");
        }else {
            log.info(element.getTagName() + element + "is not available");
        }
    }

    public void checkValidDateFormat(String time){
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddd:hh:mm:ss");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(time.trim());
            log.info("Valid time format");
        }catch (ParseException pe){
            log.info("Not a valid time format");
        }
    }

    public void waitForVisibility(WebElement element) throws Error{
        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
            Coordinates coordinates = ((Locatable)element).getCoordinates();
            coordinates.onPage();
            coordinates.inViewPort();
        }catch (WebDriverException wde){
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
        }
    }

    public void checkElementListVisibility(List<WebElement> list){
        for(int i=0; i<list.size();i++){
            if(list.get(i).isDisplayed()){
                log.debug("Element available " + list.get(i).getSize());
            }else{
                log.info("Element not available " + list.get(i).getSize());
            }
        }
    }

    public void checkLinkAfterClick(String url){
        if(driver.getCurrentUrl().contains(url)){
            log.debug("Url contains " + url);
        }else{
            log.info("Url does not contain " + url);
        }
    }

    public homepagePageObject clickLogo(){
        waitForVisibility(logoLink);
        logoLink.click();
        return new homepagePageObject(driver, wait);
    }

}
