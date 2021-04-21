package com.aixtrade.pages;

import com.aixtrade.utilities.TestData;
import com.aixtrade.waits.WebWaits;
import com.aixtrade.webControls.ButtonControl;
import com.aixtrade.webControls.ClickControl;
import com.aixtrade.webControls.DropDownControl;
import com.aixtrade.webControls.TextFieldsControl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationInfoPage extends BasePage {

    @FindBy(id = "legalName")
    private WebElement applicantName = null;
    @FindBy(id = "oAddressLine1")
    private WebElement addressLine1 = null;
    @FindBy(id = "oAddressLine2")
    private WebElement addressLine2 = null;
    @FindBy(id = "oState")
    private WebElement applicantState = null;
    @FindBy(id = "businessWebsite")
    private WebElement businessWebsite = null;
    @FindBy(id = "organisationType")
    private WebElement organisationType = null;
    @FindBy(id = "dateEstablished")
    private WebElement dateEstablished = null;
    @FindBy(id = "regNo")
    private WebElement compRegistrationNo = null;
    @FindBy(id = "ein")
    private WebElement ein = null;
    @FindBy(id = "legalEntityIdentifier")
    private WebElement legalEntityIdentifier = null;
    @FindBy(id = "seedCXParticipantId")
    private WebElement seedCXParticipantId = null;
    @FindBy(id = "experienceLevel")
    private WebElement experienceLevel = null;
    @FindBy(id = "btnToggleSeedCX")
    private WebElement btnToggleSeedCX = null;
    @FindBy(id = "applicationInformationForm")
    private WebElement applicationInformationForm = null;


    public ApplicationInfoPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ApplicationInfoPage fillApplicantInformation(String name, String address1, String address2, String city, String state, String postcode, String country) {
        TextFieldsControl.enterText(applicantName, name);
        TextFieldsControl.enterText(addressLine1, address1);
        TextFieldsControl.enterText(addressLine2, address2);
        TextFieldsControl.enterText(applicantCity, city);
        TextFieldsControl.enterText(applicantState, state);
        TextFieldsControl.enterText(applicantPostCode, postcode);
        DropDownControl.selectDropDownByVisibleText(applicantCountry, country);
        return this;
    }

    public ApplicationInfoPage fillCompanyInformation(String website, String orgType, String dateEst, String compRegNo, String einEIN, String entityIdentifier, String seedCX, String tradeExp) {
        TextFieldsControl.enterText(businessWebsite, website);
        DropDownControl.selectDropDownByVisibleText(organisationType, orgType);
        dateEstablished.sendKeys(dateEst);
        TextFieldsControl.enterText(compRegistrationNo, compRegNo);
        TextFieldsControl.enterText(ein, einEIN);
        TextFieldsControl.enterText(legalEntityIdentifier, entityIdentifier);
        this.enterSeedCXParticipantId(seedCX);
        DropDownControl.selectDropDownByVisibleText(experienceLevel, tradeExp);
        return this;
    }


    public AuthorisedSignersPage goToAuthorisedSignersPage() {
        ClickControl.click(saveAndProcced);
        return PageFactory.initElements(webDriver, AuthorisedSignersPage.class);
    }

    public boolean validateApplicantName() {
        WebWaits.waitForNoOfSeconds(1);
        String legalName = TestData.getValue("application2 name");
        return applicantName.getAttribute("value").contains(legalName);
    }

    public boolean validateApplicantRegNo() {
        WebWaits.waitForNoOfSeconds(1);
        String regNo = TestData.getValue("company regNumber");
        return compRegistrationNo.getAttribute("value").contains(regNo);
    }

    public boolean validateApplicantEIN() {
        WebWaits.waitForNoOfSeconds(1);
        String ni = TestData.getValue("company EIN");
        return ein.getAttribute("value").contains(ni);
    }

    public ApplicationInfoPage disableOrEnableSeedCXParticipantId() {
        scrollToBottomOfPage();
        ButtonControl.clickButton(btnToggleSeedCX);
        return this;
    }

    public ApplicationInfoPage enterSeedCXParticipantId(String seedCX) {
        TextFieldsControl.enterText(seedCXParticipantId, seedCX);
        return this;
    }

    public boolean validateSeedCXIDErrorMessage(String errorMessage) {
        scrollToBottomOfPage();
        for (WebElement divElement : applicationInformationForm.findElements(By.tagName("div"))) {
            for (WebElement div2Element : divElement.findElements(By.tagName("div"))) {
                for (WebElement div3Element : div2Element.findElements(By.tagName("div"))) {
                    if (!div3Element.getText().contains(errorMessage)) continue;
                    return true;
                }
            }
        }
        return false;
    }
}
