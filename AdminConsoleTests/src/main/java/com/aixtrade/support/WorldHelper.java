package com.aixtrade.support;


import com.aixtrade.QuoteSchemaModel.HttpVerbs;
import com.aixtrade.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.aixtrade.browsers.WebDriverFactory;

public class WorldHelper {

    private WebDriver driver = WebDriverFactory.getThreadedDriver();
    private static BasePage basePage = null;
    private static HomePage landingPage = null;
    private static ForgotPasswordPage forgotPasswordPage = null;
    private static InvitationsPage invitationsPage = null;
    private static ApplicationsPage applicationsPage = null;
    private static DocumentTypesPage documentTypesPage = null;
    private static InstitutionsPage institutionsPage = null;
    private static Popovers popovers = null;
    private static CreditScoreCardModal creditScoreCardModal = null;
    private static TradingActivityPage getTradingActivityPage = null;
    private static BroadcastMessagesPage getBroadcastMessagesPage = null;
    private static PlatformControlPage getPlatformControlPage = null;
    private static TradeBlotterPage getTradeBlotterPage = null;
    private static InstrumentsPage getInstrumentsPage = null;

    private static HttpVerbs verbs;


    public BasePage getBasePage(){
        if(basePage != null) return basePage;
        return PageFactory.initElements(driver, BasePage.class);
    }

    public HomePage getLandingPage(){
        if(landingPage != null) return landingPage;
        return PageFactory.initElements(driver, HomePage.class);
    }

    public ForgotPasswordPage getForgotPasswordPage(){
        if(forgotPasswordPage != null) return forgotPasswordPage;
        return PageFactory.initElements(driver, ForgotPasswordPage.class);
    }

    public ApplicationsPage getApplicationsPage(){
        if(applicationsPage != null) return applicationsPage;
        return PageFactory.initElements(driver, ApplicationsPage.class);
    }

    public InvitationsPage getInvitationsPage(){
        if(invitationsPage != null) return invitationsPage;
        return PageFactory.initElements(driver, InvitationsPage.class);
    }

    public InstitutionsPage getInstitutionsPage(){
        if(institutionsPage != null) return institutionsPage;
        return PageFactory.initElements(driver, InstitutionsPage.class);
    }

    public DocumentTypesPage getDocumentTypesPage(){
        if(documentTypesPage != null) return documentTypesPage;
        return PageFactory.initElements(driver, DocumentTypesPage.class);
    }

    public Popovers getPopovers(){
        if(popovers != null) return popovers;
        return PageFactory.initElements(driver, Popovers.class);
    }

    public CreditScoreCardModal getCreditScoreCardModal(){
        if(creditScoreCardModal != null) return creditScoreCardModal;
        return PageFactory.initElements(driver, CreditScoreCardModal.class);
    }

    public TradingActivityPage getTradingActivityPage(){
        if(getTradingActivityPage != null) return getTradingActivityPage;
        return PageFactory.initElements(driver, TradingActivityPage.class);
    }


    public BroadcastMessagesPage getBroadcastMessagesPage(){
        if(getBroadcastMessagesPage != null) return getBroadcastMessagesPage;
        return PageFactory.initElements(driver, BroadcastMessagesPage.class);
    }

    public PlatformControlPage getPlatformControlPage(){
        if(getPlatformControlPage != null) return getPlatformControlPage;
        return PageFactory.initElements(driver, PlatformControlPage.class);
    }

    public TradeBlotterPage getTradeBlotterPage(){
        if(getTradeBlotterPage != null) return getTradeBlotterPage;
        return PageFactory.initElements(driver, TradeBlotterPage.class);
    }

    public InstrumentsPage getInstrumentsPage(){
        if(getInstrumentsPage != null) return getInstrumentsPage;
        return PageFactory.initElements(driver, InstrumentsPage.class);
    }

    public HttpVerbs verbs() {
        if (verbs != null) return verbs;
        verbs = new HttpVerbs();
        return verbs();
    }
}
