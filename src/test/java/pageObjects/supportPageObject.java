package pageObjects;

import base.pageObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class supportPageObject extends pageObject {

    public supportPageObject(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String baseUrl = "https://stage-frontend.nutaku.net/support/general-inquiries/";
    public String randomName = RandomStringUtils.randomAlphanumeric(19);
    public String randomEmail = RandomStringUtils.randomAlphanumeric(30) + "@mailinator.com" ;
    public String randomSubject = RandomStringUtils.randomAlphanumeric(30);
    public String randomBodyMessage = RandomStringUtils.randomAlphanumeric(900);


    @FindBy(css = "#name")
    public WebElement nameInput;

    @FindBy(css = "#email")
    public WebElement emailInput;

    @FindBy(css = "#email2")
    public WebElement emailInputConfirm;

    @FindBy(css = ".item.distance #subject")
    public WebElement subjectDropdown;

    @FindBy(css = ".item.distance #subject option[value=\"other\"]")
    public WebElement otterSubject;

    @FindBy(css = "#input-appended #subject")
    public WebElement otterSubjectInput;

    @FindBy(css = "#message")
    public WebElement messageBodyTextarea;

    @FindBy(css = "form .mainbtn")
    public WebElement formSendButton;


    public supportConfirmPageObject createTicket(){
        waitForVisibility(nameInput);
        nameInput.sendKeys(randomName);
        waitForVisibility(emailInput);
        emailInput.sendKeys(randomEmail);
        waitForVisibility(emailInputConfirm);
        emailInputConfirm.sendKeys(randomEmail);
        waitForVisibility(subjectDropdown);
        subjectDropdown.click();
        waitForVisibility(otterSubject);
        otterSubject.click();
        waitForVisibility(otterSubjectInput);
        otterSubjectInput.sendKeys(randomSubject);
        waitForVisibility(messageBodyTextarea);
        messageBodyTextarea.sendKeys(randomBodyMessage);
        waitForVisibility(formSendButton);
        formSendButton.click();
        checkLinkAfterClick("support/general-inquiries/confirm/");
        return new supportConfirmPageObject(driver, wait);
    }

}
