package com.aixtrade.pages;

import com.aixtrade.waits.WebWaits;
import com.aixtrade.webControls.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LegalPage extends BasePage {

    @FindBy(id = "legalCEA2")
    private WebElement statutoryQualification = null;
    @FindBy(id = "legalAIX2")
    private WebElement employeeOfAIX = null;
    @FindBy(id = "legalSeedCX2")
    private WebElement employeeOfSeedSEF = null;
    @FindBy(id = "legalDoddFrank2")
    private WebElement applicantofDoddFrank = null;
    @FindBy(id = "legalCapacityCP")
    private WebElement legalCapacityCP = null;
    @FindBy(id = "btnAddBeneficiary")
    private WebElement addBeneficiary = null;
    @FindBy(id = "legalCapacityCPO")
    private WebElement legalCapacityCPO = null;
    @FindBy(id = "invitationsTable")
    private WebElement invitationsTable = null;
    @FindBy(css = "body > div.col-xs-11.col-sm-4.alert.alert-info.animated.fadeInDown")
    protected WebElement alert = null;


    public LegalPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AddUpdateBeneficiaryModal selectLegalOptions() {
        WebWaits.waitForNoOfSeconds(2);
        RadioControl.clickButton(statutoryQualification);
        RadioControl.clickButton(employeeOfAIX);
        RadioControl.clickButton(employeeOfSeedSEF);
        RadioControl.clickButton(applicantofDoddFrank);
        ClickControl.click(legalCapacityCPO);
        CheckBoxControl.tickCheckBox(legalCapacityCP);
        ButtonControl.clickButton(addBeneficiary);
        return PageFactory.initElements(webDriver, AddUpdateBeneficiaryModal.class);
    }

    public AddUpdateBeneficiaryModal selectToEditBeneficiary() {
        WebWaits.waitForNoOfSeconds(1);
        WebElement firstRow = invitationsTable.findElements(By.cssSelector("tbody > tr")).get(0);
        for (WebElement dataElement : firstRow.findElements(By.tagName("td"))) {
            for (WebElement buttonElement : dataElement.findElements(By.tagName("button"))) {
                if (!buttonElement.getAttribute("id").contains("btnEditBeneficiary")) continue;
                ButtonControl.clickButton(buttonElement);
                break;
            }
        }
        return PageFactory.initElements(webDriver, AddUpdateBeneficiaryModal.class);
    }

    public ECPStatusPage navigateToECPPage() {
        ButtonControl.clickButton(saveAndProcced);
        return PageFactory.initElements(webDriver, ECPStatusPage.class);
    }

    public boolean validateAddedBeneficiary() {
        WebWaits.waitForNoOfSeconds(2);
        for (WebElement tableRowElement : invitationsTable.findElements(By.tagName("tr"))) {
            for (WebElement tableDataElement : tableRowElement.findElements(By.tagName("th"))) {
                if (!tableDataElement.getText().equalsIgnoreCase("name")) continue;
                return true;
            }
        }
        return false;
    }

    public AlertsAndPopovers clickDeleteBenButton() {
        WebWaits.waitForNoOfSeconds(1);
        WebElement firstRow = invitationsTable.findElements(By.cssSelector("tbody > tr")).get(0);
        for (WebElement dataElement : firstRow.findElements(By.tagName("td"))) {
            for (WebElement buttonElement : dataElement.findElements(By.tagName("button"))) {
                if (!buttonElement.getAttribute("id").contains("btnRemoveBeneficiary")) continue;
                ButtonControl.clickButton(buttonElement);
                break;
            }
        }
        return PageFactory.initElements(webDriver, AlertsAndPopovers.class);
    }

    public boolean validateAlert(String message) {
        WebWaits.waitForNoOfSeconds(1);
        return alert.getText().contains(message);
    }

    public boolean validateUpdatedAddress(String updatedAddress) {
        WebElement firstRow = invitationsTable.findElements(By.cssSelector("tbody > tr")).get(0);
        for (WebElement dataElement : firstRow.findElements(By.tagName("td"))) {
            if (!dataElement.getText().contains(updatedAddress)) continue;
            return true;
        }
        return false;
    }

    public boolean validateUpdatedPassportNo(String updatedPassportNo) {
        WebElement firstRow = invitationsTable.findElements(By.cssSelector("tbody > tr")).get(0);
        for (WebElement dataElement : firstRow.findElements(By.tagName("td"))) {
            if (!dataElement.getText().equalsIgnoreCase(updatedPassportNo)) continue;
            return true;
        }
        return false;
    }
}
