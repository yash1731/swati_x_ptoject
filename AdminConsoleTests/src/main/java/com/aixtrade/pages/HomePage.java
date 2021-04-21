package com.aixtrade.pages;

import com.aixtrade.waits.WebWaits;
import com.aixtrade.webControls.ClickControl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(css ="body > nav > a > span")
    private WebElement adminElement = null;
    @FindBy(css = "body > nav > ul > li > a")
    private WebElement signOut = null;
    @FindBy(css ="div > ul > li.nav-item:nth-child(2) > a")
    private WebElement invitationsElement = null;
    @FindBy(css ="div > ul > li.nav-item:nth-child(3) > a")
    private WebElement applicationsElement = null;
    @FindBy(css ="div > ul > li.nav-item:nth-child(4) > a")
    private WebElement institutionsElement = null;
    @FindBy(css ="div > ul > li.nav-item:nth-child(5) > a")
    private WebElement documentsTypeElement = null;
    @FindBy(css =".sidebar-sticky > ul > li.nav-item:nth-child(7) > a")
    private WebElement tradingActivityElement = null;
    @FindBy(css ="li.nav-item:nth-child(11) > a:nth-child(1)")
    private WebElement broadcastMessageElement = null;
    @FindBy(css ="li.nav-item:nth-child(13) > a:nth-child(1)")
    private WebElement platformControlElement = null;
    @FindBy(css =".sidebar-sticky > ul:nth-child(1) > li:nth-child(8) > a")
    private WebElement tradeBlotterElement = null;
    @FindBy(css ="li.nav-item:nth-child(12) > a:nth-child(1)")
    private WebElement instrumentsElement = null;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean validateLogin(String message) {
        return adminElement.getText().toLowerCase().contains(message.toLowerCase());
    }

    public BasePage logOut() {
        ClickControl.click(signOut);
        return PageFactory.initElements(webDriver, BasePage.class);
    }

    public InvitationsPage goToInvitationsPage() {
        ClickControl.click(invitationsElement);
        return PageFactory.initElements(webDriver, InvitationsPage.class);
    }

    public ApplicationsPage goToApplicationsPage() {
        ClickControl.click(applicationsElement);
        return PageFactory.initElements(webDriver, ApplicationsPage.class);
    }

    public InstitutionsPage goToInstitutionsPage() {
        ClickControl.click(institutionsElement);
        return PageFactory.initElements(webDriver, InstitutionsPage.class);
    }

    public DocumentTypesPage goToDocumentTypesPage() {
        ClickControl.click(documentsTypeElement);
        return PageFactory.initElements(webDriver, DocumentTypesPage.class);
    }

    public TradingActivityPage goToTradingActivityPage() {
        ClickControl.click(tradingActivityElement);
        return PageFactory.initElements(webDriver, TradingActivityPage.class);
    }

    public BroadcastMessagesPage goToBroadcastMessagePage() {
        ClickControl.click(broadcastMessageElement);
        return PageFactory.initElements(webDriver, BroadcastMessagesPage.class);
    }

    public PlatformControlPage goToPlatformControlPage() {
        ClickControl.click(platformControlElement);
        WebWaits.waitForNoOfSeconds(10);
        return PageFactory.initElements(webDriver, PlatformControlPage.class);
    }

    public TradeBlotterPage goToTradeBlotterPage() {
        ClickControl.click(tradeBlotterElement);
        return PageFactory.initElements(webDriver, TradeBlotterPage.class);
    }

    public InstrumentsPage goToInstrumentsPage() {
        ClickControl.click(instrumentsElement);
        return PageFactory.initElements(webDriver, InstrumentsPage.class);
    }
}
