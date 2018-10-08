package pageObjects;

import base.log;
import base.pageObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class homepagePageObject extends pageObject {

    public homepagePageObject(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //Const

    public String baseUrl = "https://stage-frontend.nutaku.net/home/";
    public String email = "totaltest@mailinator.com";
    public String validEmail = "totaltester@mailinator.com";
    public String password = "selenium";
    public String newUsername = RandomStringUtils.randomAlphanumeric(25) ;
    public String newEmail = newUsername + "@mailinator.com";

    //Page elements

    @FindBy(css = "a.avatar")
    public WebElement profileMenuArrow;

    @FindBy(css = "a.signOut")
    public WebElement signOutButton;

    @FindBy(css = ".mobile a.more")
    public WebElement mobileGames;

    @FindBy(css = ".download a.more")
    public WebElement desktopGames;

    @FindBy(css = ".browser a.more")
    public WebElement browserGames;

    @FindBy(css = ".browser a.more")
    public WebElement eventsButton;

    @FindBy(css = "#page .header a.login")
    public WebElement loginButton;

    @FindBy(css = "#LoginForm #mailAddress")
    public WebElement loginEmailInput;

    @FindBy(css = "#LoginForm input[name='password']")
    public WebElement loginPasswordInput;

    @FindBy(css = "#LoginForm #create-account")
    public WebElement loginButtonForm;

    @FindBy(css = ".singup-area .signup")
    public WebElement createAccount;

    @FindBy(css = "#singupForm ul li:first-child input")
    public WebElement createAccountEmailInput;

    @FindBy(css = "#singupForm ul li:nth-child(2) input")
    public WebElement createAccountUserInput;

    @FindBy(css = "#singupForm ul li:nth-child(3) input")
    public WebElement createAccountPasswordInput;

    @FindBy(css = "#create-account")
    public WebElement createFreeAccountButton;

    @FindBy(css = ".header .layout")
    public WebElement verifyEmailButton;

    @FindBy(css = ".avatar img")
    public WebElement profileAvatar;

    @FindBy(css = ".menu-login-member a[rel=\"nofollow\"]")
    public WebElement communityPageButton;

    @FindBy(css = "a[href=\"/support/general-inquiries/\"]")
    public WebElement footerSupportFormButton;

    @FindBy(css = ".header a.submenu-member[href=\"/games/\"]")
    public WebElement gamesDropdownButtonNoAuth;

    @FindBy(css = ".header a.submenu-member[href=\"/events/\"]")
    public WebElement gameEventsHeaderButtonNoAuth;

    @FindBy(css = ".menu-login a[href=\"/support/\"]")
    public WebElement supportHeaderButtonNoAuth;

    @FindBy(css = "#header .language-top")
    public WebElement languagePicker;

    @FindBy(css = ".menu-login-member [href=\"/games/\"] span")
    public WebElement gamesDropdownButtonAuth;

    @FindBy(css = ".header a[href=\"/events/\"]")
    public WebElement gameEventsHeaderButtonAuth;

    @FindBy(css = ".menu-login-member a[href=\"/support/\"]")
    public WebElement supportHeaderButtonAuth;

    @FindBy(css = ".footer-links .footer-layout ul")
    public List<WebElement> footerLinksLists;

    @FindBy(css = ".bx-viewport, .top-ranking.browser, .top-ranking.mobile, .top-ranking.download, .recommended.top, .games, .new-games, .recommended.bottom-rec, .coming-soon, .events-banners, .follow-us, .right-side .side-banners:first-child, .right-side .side-banners:nth-child(2)")
    public List<WebElement> homeContentElements;

    @FindBy(css = "#buy-gold")
    public WebElement getMoreGold;

    //Page actions
    public void Login(){
        loginButton.click();
        waitForVisibility(loginEmailInput);
        loginEmailInput.sendKeys(email);
        loginPasswordInput.sendKeys(password);
        waitForVisibility(loginButtonForm);
        loginButtonForm.click();
        waitForVisibility(profileAvatar);
        if(profileAvatar.isDisplayed() &&  driver.getCurrentUrl().contains("/home")){
            log.info("create account is functional and verify account ribbon is present");
        }else{
            log.info("create account not functional or verify account ribbon not present");
        }
    }

    public void createAccount(){
        waitForVisibility(createAccount);
        createAccount.click();
        waitForVisibility(createAccountEmailInput);
        createAccountEmailInput.sendKeys(newEmail);
        waitForVisibility(createAccountUserInput);
        createAccountUserInput.sendKeys(newUsername);
        waitForVisibility(createAccountPasswordInput);
        createAccountPasswordInput.sendKeys(password);
        createFreeAccountButton.click();
        waitForVisibility(verifyEmailButton);
        if(verifyEmailButton.isDisplayed() &&  driver.getCurrentUrl().contains("/home")){
            log.debug("create account is functional and verify account ribbon is present");
        }else{
            log.info("create account not functional or verify account ribbon not present");
        }
    }

    public void signOut(){
        waitForVisibility(profileMenuArrow);
        profileMenuArrow.click();
        waitForVisibility(signOutButton);
        signOutButton.click();
        waitForVisibility(loginButton);
        if (loginButton.isDisplayed()){
            log.debug("login button available");
        }else {
            log.info("login button not displayed.");
        }
    }

    public void checkSections(){
        checkElementListVisibility(homeContentElements);
    }

    public void loginValidVerified(){
        loginButton.click();
        waitForVisibility(loginEmailInput);
        loginEmailInput.sendKeys(validEmail);
        loginPasswordInput.sendKeys(password);
        waitForVisibility(loginButtonForm);
        loginButtonForm.click();
    }

    public void checkFooterLinks(){
        if (footerLinksLists.size()==4){
            for(int i=0; i<footerLinksLists.size(); i++){
                List<WebElement> links =  wait.until(ExpectedConditions.visibilityOfAllElements(footerLinksLists.get(i).findElements(By.cssSelector("li:not(:first-child)"))));
                for (int j=0; j<links.size(); j++) {
                    WebElement link = wait.until(ExpectedConditions.elementToBeClickable(links.get(j).findElement(By.cssSelector("a"))));
                    String href = link.getAttribute("href");
                    if (href.equals(driver.getCurrentUrl())){
                        link.click();
                        log.info("Link " + href +" is ok"+"\n");
                    }else if(link.getAttribute("target").equals("_blank")){
                        String home = driver.getWindowHandle();
                        link.click();
                        if(driver.getCurrentUrl().contains(href)){
                            log.info("Link " + href +" is ok"+"\n");
                        }
                        driver.switchTo().window(home);
                    }else{
                        link.click();
                        if(driver.getCurrentUrl().contains(href)){
                            log.info("Link " + href +" is ok"+"\n");
                            driver.navigate().back();
                        }
                    }
                    links = wait.until(ExpectedConditions.visibilityOfAllElements(footerLinksLists.get(i).findElements(By.cssSelector("li:not(:first-child)"))));
                }
            }
        }else{
            log.info("the footer does not contain 4 link lists");
        }
    }


    public void checkHeaderLinksNoAuth(){
        waitForVisibility(logoLink);
        checkWebElement(logoLink);
        waitForVisibility(gameEventsHeaderButtonNoAuth);
        checkWebElement(gameEventsHeaderButtonNoAuth);
        waitForVisibility(gamesDropdownButtonNoAuth);
        checkWebElement(gamesDropdownButtonNoAuth);
        waitForVisibility(createAccount);
        checkWebElement(createAccount);
        waitForVisibility(loginButton);
        checkWebElement(loginButton);
        waitForVisibility(languagePicker);
        checkWebElement(languagePicker);
        waitForVisibility(supportHeaderButtonNoAuth);
        checkWebElement(supportHeaderButtonNoAuth);
    }

    public void checkHeaderLinksAuth(){
        waitForVisibility(logoLink);
        checkWebElement(logoLink);
        waitForVisibility(gamesDropdownButtonAuth);
        checkWebElement(gamesDropdownButtonAuth);
        waitForVisibility(gameEventsHeaderButtonAuth);
        checkWebElement(gameEventsHeaderButtonAuth);
        waitForVisibility(communityPageButton);
        checkWebElement(communityPageButton);
        waitForVisibility(supportHeaderButtonAuth);
        checkWebElement(supportHeaderButtonAuth);
        waitForVisibility(languagePicker);
        checkWebElement(languagePicker);
    }

    public communityPageObject clickCommunityButton(){
        waitForVisibility(communityPageButton);
        communityPageButton.click();
        return new communityPageObject(driver, wait);
    }


    public supportPageObject clickCreateTicket(){
        waitForVisibility(footerSupportFormButton);
        footerSupportFormButton.click();
        checkLinkAfterClick("/support/general-inquiries");
        return new supportPageObject(driver, wait);
    }

    public mobileGamesPageObject viewMobileGamesPage(){
        waitForVisibility(mobileGames);
        mobileGames.click();
        checkLinkAfterClick("/games/mobile");
        return new mobileGamesPageObject(driver, wait);
    }

    public desktopGamesPageObject desktopGamesPage(){
        waitForVisibility(desktopGames);
        desktopGames.click();
        checkLinkAfterClick("/games/download/");
        return new desktopGamesPageObject(driver, wait);
    }

    public browserGamesPageObject topGamesPage(){
        waitForVisibility(browserGames);
        browserGames.click();
        checkLinkAfterClick("/games");
        return new browserGamesPageObject(driver, wait);
    }

    public eventsPageObject eventsPage(){
        waitForVisibility(eventsButton);
        eventsButton.click();
        checkLinkAfterClick("/events");
        return new eventsPageObject(driver, wait);
    }

    public goldStorePageObject clickGetMoreGold(){
        waitForVisibility(getMoreGold);
        getMoreGold.click();
        return new goldStorePageObject (driver, wait);
    }
}