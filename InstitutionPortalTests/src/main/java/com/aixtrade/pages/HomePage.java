package com.aixtrade.pages;

import com.aixtrade.waits.WebWaits;
import com.aixtrade.webControls.ClickControl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(css = "#mainContent > div > div > div > div > div > div > div > h1")
    private WebElement welcomeElement = null;
    @FindBy(css = "body > nav > ul > li > a")
    private WebElement signOut = null;
    @FindBy(id = "btnStartApplication")
    private WebElement applyMenu = null;
    @FindBy(css = "#portalMenuLarge > div > ul > li:nth-child(4) > a > span")
    private WebElement usersMenu = null;
    @FindBy(css = "#aix-main-div > div > nav > div > div > div:nth-child(3) > a")
    private WebElement privacyPolicyMenu = null;
    @FindBy(css = "#portalMenuLarge > div > ul > li:nth-child(2) > a > span")
    private WebElement tradeBlotterMenu = null;



    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean validateLogin(String message) {
        WebWaits.waitForTextToBePresent(welcomeElement, message);
        return welcomeElement.getText().toLowerCase().contains(message.toLowerCase());
    }

    public BasePage logOut() {
        WebWaits.waitForNoOfSeconds(2);
        ClickControl.click(signOut);
        return PageFactory.initElements(webDriver, BasePage.class);
    }

    public DirectionsPage clickToApply() {
        ClickControl.click(applyMenu);
        return PageFactory.initElements(webDriver, DirectionsPage.class);
    }

    public UsersPage goToUsersPage() {
        ClickControl.click(usersMenu);
        return PageFactory.initElements(webDriver, UsersPage.class);
    }

    public HelpPage goToHelpPage() {
        ClickControl.click(tradeBlotterMenu);
        return PageFactory.initElements(webDriver, HelpPage.class);
    }

    public PrivacyPolicyPage goToPrivacyPolicyPage() {
        ClickControl.click(privacyPolicyMenu);
        return PageFactory.initElements(webDriver, PrivacyPolicyPage.class);
    }

    public TradeBlotterPage goToTradeBlotterPage() {
        ClickControl.click(tradeBlotterMenu);
        return PageFactory.initElements(webDriver, TradeBlotterPage.class);
    }

    public OTCScreenPage goToOTCScreenPage() {
        ClickControl.click(tradeBlotterMenu);
        return PageFactory.initElements(webDriver, OTCScreenPage.class);
    }
}
