package com.aixtrade.support;

import com.aixtrade.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.aixtrade.browsers.WebDriverFactory;

public class WorldHelper {

    private WebDriver driver = WebDriverFactory.getThreadedDriver();
    private static BasePage basePage = null;
    private static HomePage landingPage = null;
    private static ForgotPasswordPage forgotPasswordPage = null;
    private static ApplicationInfoPage applicationInfoPage = null;
    private static AuthorisedSignersPage authorisedSignersPage = null;
    private static DirectionsPage directionsPage = null;
    private static DisclosuresPage disclosuresPage = null;
    private static UsersPage usersPage = null;
    private static AddUpdateBeneficiaryModal addBeneficiaryModal = null;
    private static DocumentUploadPage documentUploadPage = null;
    private static ECPStatusPage ecpStatusPage = null;
    private static FinancialInformationPage financialInformationPage = null;
    private static LegalPage legalPage = null;
    private static SubmitApplicationPage submitApplicationPage = null;
    private static TradeBlotterPage tradeBlotterPage = null;
    private static OTCScreenPage otcScreenPage = null;



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

    public ApplicationInfoPage getApplicationInfoPage(){
        if(applicationInfoPage != null) return applicationInfoPage;
        return PageFactory.initElements(driver, ApplicationInfoPage.class);
    }

    public AuthorisedSignersPage getAuthorisedSignersPage(){
        if(authorisedSignersPage != null) return authorisedSignersPage;
        return PageFactory.initElements(driver, AuthorisedSignersPage.class);
    }

    public DirectionsPage getDirectionsPage(){
        if(directionsPage != null) return directionsPage;
        return PageFactory.initElements(driver, DirectionsPage.class);
    }

    public DisclosuresPage getDisclosuresPage(){
        if(disclosuresPage != null) return disclosuresPage;
        return PageFactory.initElements(driver, DisclosuresPage.class);
    }

    public UsersPage getUsersPage(){
        if(usersPage != null) return usersPage;
        return PageFactory.initElements(driver, UsersPage.class);
    }

    public AddUpdateBeneficiaryModal getAddBeneficiaryModal(){
        if(addBeneficiaryModal != null) return addBeneficiaryModal;
        return PageFactory.initElements(driver, AddUpdateBeneficiaryModal.class);
    }

    public SubmitApplicationPage getSubmitApplicationPage(){
        if(submitApplicationPage != null) return submitApplicationPage;
        return PageFactory.initElements(driver, SubmitApplicationPage.class);
    }


    public DocumentUploadPage getDocumentUploadPage(){
        if(documentUploadPage != null) return documentUploadPage;
        return PageFactory.initElements(driver, DocumentUploadPage.class);
    }

    public ECPStatusPage getECPStatusPage(){
        if(ecpStatusPage != null) return ecpStatusPage;
        return PageFactory.initElements(driver, ECPStatusPage.class);
    }

    public FinancialInformationPage getFinancialInformationPage(){
        if(financialInformationPage != null) return financialInformationPage;
        return PageFactory.initElements(driver, FinancialInformationPage.class);
    }

    public LegalPage getLegalPage(){
        if(legalPage != null) return legalPage;
        return PageFactory.initElements(driver, LegalPage.class);
    }

    public TradeBlotterPage getTradeBlotterPage(){
        if(tradeBlotterPage != null) return tradeBlotterPage;
        return PageFactory.initElements(driver, TradeBlotterPage.class);
    }

    public OTCScreenPage getOTCScreenPage(){
        if(otcScreenPage != null) return otcScreenPage;
        return PageFactory.initElements(driver, OTCScreenPage.class);
    }
}
