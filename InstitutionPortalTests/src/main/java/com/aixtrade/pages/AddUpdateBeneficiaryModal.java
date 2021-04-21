package com.aixtrade.pages;

import com.aixtrade.waits.WebWaits;
import com.aixtrade.webControls.BaseControl;
import com.aixtrade.webControls.ClickControl;
import com.aixtrade.webControls.TextFieldsControl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUpdateBeneficiaryModal extends BasePage {


    @FindBy(id = "addBeneficiaryModal")
    private WebElement beneficiaryModal = null;
    @FindBy(id = "fullName")
    private WebElement fullName = null;
    @FindBy(id = "beneficiaryForm")
    private WebElement beneficiaryForm = null;
    private String randomBeneficiary = "Beneficiary User " + randomNo;
    @FindBy(css = "#invitationsTable > tbody > tr:nth-child(1) > td:nth-child(2)")
    private WebElement beneficiary = null;
    @FindBy(id = "editBeneficiaryForm")
    private WebElement editBeneficiaryForm = null;
    @FindBy(id = "updateBeneficiaryModal")
    private WebElement updateBeneficiaryModal = null;


    public AddUpdateBeneficiaryModal(WebDriver webDriver) {
        super(webDriver);
    }

    private void enterDOB(String dob) {
        for (WebElement divElement : beneficiaryForm.findElements(By.tagName("div"))) {
            for (WebElement div2Element : divElement.findElements(By.tagName("div"))) {
                for (WebElement inputElement : div2Element.findElements(By.tagName("input"))) {
                    if (!inputElement.getAttribute("id").toLowerCase().contains("dob")) continue;
                    TextFieldsControl.enterText(inputElement, dob);
                    ClickControl.enter(inputElement);
                    break;
                }
            }
        }
    }

    private void enterAddress(String address) {
        for (WebElement divElement : beneficiaryForm.findElements(By.tagName("div"))) {
            for (WebElement div2Element : divElement.findElements(By.tagName("div"))) {
                for (WebElement inputElement : div2Element.findElements(By.tagName("input"))) {
                    if (!inputElement.getAttribute("id").toLowerCase().contains("address")) continue;
                    TextFieldsControl.enterText(inputElement, address);
                    break;
                }
            }
        }
    }

    private void enterPassportNo(String passportNo) {
        WebWaits.waitForNoOfSeconds(1);
        for (WebElement divElement : beneficiaryForm.findElements(By.tagName("div"))) {
            for (WebElement div2Element : divElement.findElements(By.tagName("div"))) {
                for (WebElement inputElement : div2Element.findElements(By.tagName("input"))) {
                    if (!inputElement.getAttribute("id").toLowerCase().contains("ssn")) continue;
                    TextFieldsControl.enterText(inputElement, passportNo);
                    break;
                }
            }
        }
    }




    private void submitBeneficiaryForm(){
        WebWaits.waitForNoOfSeconds(1);
        for(WebElement divElement : beneficiaryModal.findElements(By.tagName("div"))){
            for(WebElement div2Element : divElement.findElements(By.tagName("div"))){
                for(WebElement div3Element : div2Element.findElements(By.tagName("div"))){
                    for(WebElement buttonElement : div3Element.findElements(By.tagName("button")) ){
                        if(!buttonElement.getText().contains("Submit")) continue;
                        ClickControl.click(buttonElement);
                    }
                }
            }
        }

    }

    public LegalPage addBeneficiary(String dob, String address, String passportNo) {
        TextFieldsControl.enterText(fullName, randomBeneficiary);
        this.enterDOB(dob);
        this.enterAddress(address);
        this.enterPassportNo(passportNo);
        this.submitBeneficiaryForm();
        return PageFactory.initElements(webDriver, LegalPage.class);
    }

    private void updateDOB(String dob) {
        for (WebElement divElement : editBeneficiaryForm.findElements(By.tagName("div"))) {
            for (WebElement div2Element : divElement.findElements(By.tagName("div"))) {
                for (WebElement inputElement : div2Element.findElements(By.tagName("input"))) {
                    if (!inputElement.getAttribute("id").equalsIgnoreCase("dob")) continue;
                    TextFieldsControl.enterText(inputElement, dob);
                    break;
                }
            }
        }
    }

    private void updateAddress(String address) {
        for (WebElement divElement : editBeneficiaryForm.findElements(By.tagName("div"))) {
            for (WebElement div2Element : divElement.findElements(By.tagName("div"))) {
                for (WebElement inputElement : div2Element.findElements(By.tagName("input"))) {
                    if (!inputElement.getAttribute("id").equalsIgnoreCase("address")) continue;
                    TextFieldsControl.enterText(inputElement, address);
                    break;
                }
            }
        }
    }

    private void updatePassportNo(String passportNo) {
        WebWaits.waitForNoOfSeconds(1);
        for (WebElement divElement : editBeneficiaryForm.findElements(By.tagName("div"))) {
            for (WebElement div2Element : divElement.findElements(By.tagName("div"))) {
                for (WebElement inputElement : div2Element.findElements(By.tagName("input"))) {
                    if (!inputElement.getAttribute("id").equalsIgnoreCase("ssn")) continue;
                    TextFieldsControl.enterText(inputElement, passportNo);
                    break;
                }
            }
        }
    }

    public String getBeneficiaryNumber() {
        return randomBeneficiary;
    }

    private void submitUpdatedForm() {
        for (WebElement divElement : updateBeneficiaryModal.findElements(By.tagName("div"))) {
            for (WebElement div2Element : divElement.findElements(By.tagName("div"))) {
                for (WebElement div3Element : div2Element.findElements(By.tagName("div"))) {
                    for (WebElement buttonElement : div3Element.findElements(By.tagName("button"))) {
                        if (!buttonElement.getText().equalsIgnoreCase("Submit")) continue;
                        ClickControl.click(buttonElement);
                        break;
                    }
                }
            }
        }
    }

    public LegalPage updateBeneficiary(String dob, String address, String passportNo) {
        this.updateDOB(dob);
        this.updateAddress(address);
        this.updatePassportNo(passportNo);
        this.submitUpdatedForm();
        return PageFactory.initElements(webDriver, LegalPage.class);
    }

    public boolean validateDeletedBeneficiary() {
        BaseControl.isElementNotDisplayedAndPresent(beneficiary);
        return true;
    }
}
