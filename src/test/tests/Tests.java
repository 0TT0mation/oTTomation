
import base.driverFactory;
import base.log;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import pageObjects.*;


public class Tests extends driverFactory {




    @Test
    public void SmokeTest() throws Exception{

        WebDriver driver = driverFactory.getDriver();
        WebDriverWait wait = driverFactory.getWait(driver);

        log.startLog();



        landingPageObject page = new landingPageObject(driver, wait);
        PageFactory.initElements(driver,page);
        page.goToLanding();
        page.goToNutaku();

        homepagePageObject homePage = new homepagePageObject(driver, wait);
        PageFactory.initElements(driver,homePage);
        homePage.createAccount();
        homePage.signOut();
        homePage.checkHeaderLinksNoAuth();
        homePage.Login();
        homePage.checkHeaderLinksAuth();
        homePage.checkSections();
        homePage.checkFooterLinks();
        homePage.viewMobileGamesPage();

        mobileGamesPageObject mobileGamesPage = new mobileGamesPageObject(driver, wait);
        PageFactory.initElements(driver,mobileGamesPage);
        mobileGamesPage.clickLogo();
        homePage.topGamesPage();

        browserGamesPageObject browserGamesPage = new browserGamesPageObject(driver, wait);
        PageFactory.initElements(driver,browserGamesPage);

        browserGamesPage.clickLogo();
        homePage.desktopGamesPage();

        desktopGamesPageObject desktopGamesPage = new desktopGamesPageObject(driver, wait);
        PageFactory.initElements(driver,desktopGamesPage);

        desktopGamesPage.clickLogo();
        homePage.eventsPage();

        eventsPageObject eventsPage = new eventsPageObject(driver, wait);
        PageFactory.initElements(driver,eventsPage);

        eventsPage.clickLogo();
        homePage.clickCommunityButton();

        communityPageObject communityPage = new communityPageObject(driver, wait);
        PageFactory.initElements(driver,communityPage);
        communityPage.isSearchavailable();
        communityPage.clickLogo();
        homePage.signOut();
        homePage.loginValidVerified();
        homePage.clickCommunityButton();
        communityPage.searchUserClickProfile();
        communityPage.clickUser();

        userProfilePageObject userProfilePage = new userProfilePageObject(driver, wait);
        PageFactory.initElements(driver,userProfilePage);
        userProfilePage.clickLogo();




        log.endLog();
    }

}
