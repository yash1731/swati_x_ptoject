package com.aixtrade.pages;

import com.aixtrade.waits.WebWaits;
import com.aixtrade.webControls.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AuthorisedSignersPage extends BasePage {

    @FindBy(id = "title")
    private WebElement signerTitle = null;
    @FindBy(id = "email")
    private WebElement signerEmail = null;
    @FindBy(id = "contactNumber")
    private WebElement contactNumber = null;
    @FindBy(id = "btnAddAuthorisedSigner")
    private WebElement addAuthorisedSigner = null;
    @FindBy(id = "firstName")
    private WebElement firstName = null;
    @FindBy(id = "lastName")
    private WebElement lastName = null;
    @FindBy(id = "passport")
    private WebElement signerPassportNo = null;
    @FindBy(id = "passportExpiryDate")
    private WebElement signerPassportExpDate = null;
    @FindBy(id = "passportIssueDate")
    private WebElement signerPassportIssueDate = null;
    @FindBy(id = "building")
    private WebElement signerBuilding = null;
    @FindBy(id = "street")
    private WebElement signerStreet = null;
    @FindBy(id = "authorisedSignerForm")
    private WebElement authorisedSignerForm = null;
    @FindBy(id = "authorised-signers-list-block")
    private WebElement authorisedSignersTable = null;
    @FindBy(id = "signup-form")
    private WebElement signupform = null;
    @FindBy(id="btnUpdateAuthorisedSigner")
    private WebElement updateSigner = null;
    @FindBy(css="body > div.col-xs-11.col-sm-4.alert.alert-info.animated.fadeInDown")
    private WebElement upadtedSignerMessage = null;


    public AuthorisedSignersPage(WebDriver webDriver) {
        super(webDriver);
    }

    private void enterCity(String city) {
        for (WebElement divElement : authorisedSignerForm.findElements(By.tagName("div"))) {
            for (WebElement div2Element : divElement.findElements(By.tagName("div"))) {
                for (WebElement inputElement : div2Element.findElements(By.tagName("input"))) {
                    if (!inputElement.getAttribute("id").toLowerCase().contains("city")) continue;
                    TextFieldsControl.enterText(inputElement, city);
                    break;
                }
            }
        }
    }

    private void enterCountry(String country) {
        for (WebElement divElement : authorisedSignerForm.findElements(By.tagName("div"))) {
            for (WebElement div2Element : divElement.findElements(By.tagName("div"))) {
                for (WebElement inputElement : div2Element.findElements(By.tagName("div"))) {
                    for (WebElement selectElement : inputElement.findElements(By.tagName("select"))) {
                        if (!selectElement.getAttribute("id").equalsIgnoreCase("country")) continue;
                        DropDownControl.selectDropDownByVisibleText(selectElement, country);
                        break;
                    }
                }
            }
        }
    }

    private void enterPostCode(String postcode) {
        for (WebElement divElement : authorisedSignerForm.findElements(By.tagName("div"))) {
            for (WebElement div2Element : divElement.findElements(By.tagName("div"))) {
                for (WebElement div3Element : div2Element.findElements(By.tagName("div"))) {
                    for (WebElement inputElement : div3Element.findElements(By.tagName("input"))) {
                        if (!inputElement.getAttribute("id").contains("postCode")) continue;
                        TextFieldsControl.enterText(inputElement, postcode);
                        break;
                    }
                }
            }
        }
    }

    public AuthorisedSignersPage fillFirstAuthorisedSignerDetails(String fName, String lName, String title, String dob, String email, String contactNo, String signerSSN, String passportNo,
                                                                  String passportExpiry, String passportIssue, String building, String street, String city, String country, String postcode) {
        WebWaits.waitForNoOfSeconds(1);
        TextFieldsControl.enterText(firstName, fName);
        TextFieldsControl.enterText(lastName, lName);
        TextFieldsControl.enterText(signerTitle, title);
        TextFieldsControl.enterText(dateOfBirth, dob);
        TextFieldsControl.enterText(signerEmail, email);
        TextFieldsControl.enterText(contactNumber, contactNo);
        this.enterCountry(country);
        TextFieldsControl.enterText(ssn, signerSSN);
        TextFieldsControl.enterText(signerPassportNo, passportNo);
        TextFieldsControl.enterText(signerPassportExpDate, passportExpiry);
        TextFieldsControl.enterText(signerPassportIssueDate, passportIssue);
        TextFieldsControl.enterText(signerBuilding, building);
        TextFieldsControl.enterText(signerStreet, street);
        this.enterCity(city);
        this.enterPostCode(postcode);
        ClickControl.click(addAuthorisedSigner);
        return this;
    }


    public AuthorisedSignersPage fillSecondAuthorisedSignerDetails(String fName2, String lName2, String title2, String dob2, String email2, String contactNo2, String passportNo2,
                                                                   String passportExpiry2, String passportIssue2, String building2, String street2, String city2, String country2, String postcode2) {
        TextFieldsControl.enterText(firstName, fName2);
        TextFieldsControl.enterText(lastName, lName2);
        TextFieldsControl.enterText(signerTitle, title2);
        TextFieldsControl.enterText(dateOfBirth, dob2);
        TextFieldsControl.enterText(signerEmail, email2);
        TextFieldsControl.enterText(contactNumber, contactNo2);
        this.enterCountry(country2);
        TextFieldsControl.enterText(signerPassportNo, passportNo2);
        TextFieldsControl.enterText(signerPassportExpDate, passportExpiry2);
        TextFieldsControl.enterText(signerPassportIssueDate, passportIssue2);
        TextFieldsControl.enterText(signerBuilding, building2);
        TextFieldsControl.enterText(signerStreet, street2);
        this.enterCity(city2);
        this.enterPostCode(postcode2);
        ClickControl.click(addAuthorisedSigner);
        return PageFactory.initElements(webDriver, AuthorisedSignersPage.class);
    }

    public FinancialInformationPage goFinancialInformationPage() {
        ClickControl.click(saveAndProcced);
        return PageFactory.initElements(webDriver, FinancialInformationPage.class);
    }

    public AlertsAndPopovers clickDeleteAuthButton() {
        WebWaits.waitForNoOfSeconds(2);
        for(WebElement firstRow : authorisedSignersTable.findElements(By.cssSelector(".table"))){
            for(WebElement dataElement : firstRow.findElements(By.tagName("div"))){
                if (!dataElement.getAttribute("id").contains("accordion")) continue;
                for(WebElement insideRow : dataElement.findElements(By.tagName("div"))){
                    for (WebElement buttonElement : insideRow.findElements(By.tagName("button"))) {
                        if (!buttonElement.getText().contains("Delete Signer")) continue;
                        ButtonControl.clickButton(buttonElement);
                        break;
                    }
                }
            }
        }
        return PageFactory.initElements(webDriver, AlertsAndPopovers.class);
    }

    public ApplicationInfoPage goBackToAppInfoPage(){
        ButtonControl.clickButton(previousPage);
        return PageFactory.initElements(webDriver, ApplicationInfoPage.class);
    }

    public boolean validateAuthorisedSignersPage(String authSigners) {
        for (WebElement divElement : signupform.findElements(By.tagName("div"))) {
            for (WebElement fieldElement : divElement.findElements(By.tagName("fieldset"))) {
                for (WebElement hElement : fieldElement.findElements(By.tagName("h2"))) {
                    if (!hElement.getText().contains(authSigners)) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public AuthorisedSignersPage clickEditSigner() {
        WebWaits.waitForNoOfSeconds(2);
        for(WebElement firstRow : authorisedSignersTable.findElements(By.cssSelector(".table"))){
            for(WebElement dataElement : firstRow.findElements(By.tagName("div"))){
                if (!dataElement.getAttribute("id").contains("accordion")) continue;
                for(WebElement insideRow : dataElement.findElements(By.tagName("div"))){
                    for (WebElement buttonElement : insideRow.findElements(By.tagName("button"))) {
                        if (!buttonElement.getText().contains("Edit Signer")) continue;
                        ButtonControl.clickButton(buttonElement);
                        break;
                    }
                }
            }
        }
        return PageFactory.initElements(webDriver, AuthorisedSignersPage.class);
    }

    private void editControlPerson(){
        WebWaits.waitForNoOfSeconds(1);
        for (WebElement divElement : authorisedSignerForm.findElements(By.tagName("div"))) {
            for (WebElement div2Element : divElement.findElements(By.tagName("div"))) {
                if (!div2Element.getText().contains("Control Person")) continue;
                for (WebElement inputElement : div2Element.findElements(By.tagName("div"))) {
                    for(WebElement labelElement : inputElement.findElements(By.tagName("label"))) {
                        for (WebElement spanElement : labelElement.findElements(By.tagName("span")))
                            RadioControl.clickButton(spanElement);
                        break;
                    }
                }
            }
        }
    }

    private void editBeneficialOwner(){
        for (WebElement divElement : authorisedSignerForm.findElements(By.tagName("div"))) {
            for (WebElement div2Element : divElement.findElements(By.tagName("div"))) {
                for (WebElement inputElement : div2Element.findElements(By.tagName("div"))) {
                    for(WebElement labelElement : inputElement.findElements(By.cssSelector("label > input"))) {
                        if (!labelElement.getAttribute("id").toLowerCase().contains("beneficialOwner")) continue;
                        for (WebElement spanElement : labelElement.findElements(By.tagName("span")))
                            RadioControl.clickButton(spanElement);
                        break;
                    }
                }
            }
        }
    }

    public void selectAuthorisedSignerRoles() {
       this.editControlPerson();
       this.editBeneficialOwner();
       ButtonControl.clickButton(updateSigner);
    }

    public void disableAuthorisedSignerRoles() {
        this.editControlPerson();
        this.editBeneficialOwner();
        ButtonControl.clickButton(updateSigner);
    }

    public boolean validateUpdateSigner(String message){
        WebWaits.waitForNoOfSeconds(1);
        return upadtedSignerMessage.getText().contains(message);
    }

    public AuthorisedSignersPage uploadAuthorisedSignerDocuments() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("for(var i=0;i<7000; i++){if(document.getElementById('inputFileSpan-p' + i)){document.getElementById('inputFileSpan-p' + i).innerHTML = 'PASSPORT.png';}}");
        javascriptExecutor.executeScript("for(var i=0;i<3000; i++){if(document.getElementById('inputFileSpan-d' + i)){document.getElementById('inputFileSpan-d' + i).innerHTML = 'Address_Proof.png';}}");
        return PageFactory.initElements(webDriver, AuthorisedSignersPage.class); }
}
