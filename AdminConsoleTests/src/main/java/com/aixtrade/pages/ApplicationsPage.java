package com.aixtrade.pages;

import com.aixtrade.waits.WebWaits;
import com.aixtrade.webControls.BaseControl;
import com.aixtrade.webControls.ButtonControl;
import com.aixtrade.webControls.ClickControl;
import com.aixtrade.webControls.TextFieldsControl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ApplicationsPage extends BasePage {

    @FindBy(id = "applicationsTable")
    private WebElement applicationsTable = null;
    @FindBy(css = "tr:nth-child(1) > td:nth-child(2) > a")
    private WebElement viewApplication = null;
    @FindBy(id = "application-block")
    private WebElement applicationDetails = null;
    @FindBy(id = "documents")
    private WebElement documents = null;
    @FindBy(css = "#documents > ul > li:nth-child(2) > a")
    private WebElement viewDocuments = null;
    @FindBy(css = ".nav-tabs > li:nth-child(8) > a:nth-child(1)")
    private WebElement creditCheckReport = null;
    @FindBy(id = "creditReportData")
    private WebElement creditReportData = null;
    @FindBy(css = "#applicationsTable_filter > label > input")
    private WebElement searchApplication = null;
    @FindBy(css = "#applicationsTable_filter > label > input")
    private WebElement searchField = null;
    @FindBy(css = ".fa-thumbs-up")
    private WebElement thumbsUpButton = null;
    @FindBy(css = ".nav-tabs > li:nth-child(2) > a:nth-child(1)")
    private WebElement authorisedSignerMenu = null;
    @FindBy(id = "authorisedSigners")
    private WebElement authorisedTable = null;
    //@FindBy(css = "#amlResetBlock > span.btn:nth-child(1)")
    @FindBy(css = "td[id*='amlResetBlock']  > span:nth-child(1)")
    private WebElement viewAMLReport = null;
    @FindBy(css = "#amlReportData > span.json-string:nth-child(154)")
    private WebElement fullNameInAML = null;
    @FindBy(css = "#signerAmlReportModal > div > div > div > div > button:nth-child(2) > span:nth-child(1)")
    private WebElement closeAMLReport =  null;
    //@FindBy(css = "#kycResetBlock1952 > span.btn:nth-child(1)")
    @FindBy(css = "td[id*='kycResetBlock']  > span:nth-child(1)")
    private WebElement viewKYCReport = null;
    @FindBy(css = "#kycReportData > span.json-string:nth-child(42)")
    private WebElement fullNameInKYC = null;
    @FindBy(css = "#signerKycReportModal > div > div > div > div > button:nth-child(2) > span:nth-child(1)")
    private WebElement closeKYCReport = null;
    //@FindBy(css = "#amlResetBlock1952 > span.btn:nth-child(2)")
    @FindBy(css = "td[id*='amlResetBlock']  > span.btn:nth-child(2)")
    private WebElement resetAMLReport = null;
    //@FindBy(css = "#kycResetBlock1952 > span.btn:nth-child(2)")
    @FindBy(css = "td[id*='kycResetBlock']  > span.btn:nth-child(2)")
    private WebElement resetKYCReport = null;
    @FindBy(css = ".btn-toolbar > button.btn:nth-child(1)")
    private WebElement runAMLChecks = null;
    @FindBy(css = ".btn-toolbar > button.btn:nth-child(2)")
    private WebElement runKYCChecks = null;
    @FindBy(css = ".nav-tabs > li:nth-child(9) > a:nth-child(1)")
    private WebElement additionalDocsMenu = null;
    @FindBy(css = "div.btn")
    private WebElement additionalDocsButton = null;
    @FindBy(css = ".fileupload-start")
    private WebElement startUploadButton = null;


    public ApplicationsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean validateApplicationsExist() {
        WebWaits.waitForNoOfSeconds(1);
        List<WebElement> column = applicationsTable.findElement(By.tagName("tbody")).findElements(By.tagName("td"));
        for (int j = 0; j < column.size(); j++) {
            return value.add(column.get(j).getText());
        }
        return false;
    }

    public ApplicationsPage viewSelectedApplications() {
        WebWaits.waitForNoOfSeconds(1);
        viewApplication.click();
        return this;
    }

    public boolean validateAllApplicationPages() {
        WebWaits.waitForNoOfSeconds(1);
        List<WebElement> applicationList = applicationDetails.findElement(By.tagName("div")).findElements(By.tagName("li"));
        for (int i = 0; i < applicationList.size(); i++) {
            return value.add(applicationList.get(i).getText());
        }
        return false;
    }

    public ApplicationsPage selectDocumentPage() {
        WebWaits.waitForNoOfSeconds(1);
        for (WebElement tableListElement : applicationDetails.findElement(By.tagName("div")).findElements(By.tagName("li"))) {
            for (WebElement tableDataElement : tableListElement.findElements(By.tagName("a"))) {
                if (!tableDataElement.getText().equalsIgnoreCase("Documents")) continue;
                ClickControl.click(tableDataElement);
                break;
            }
        }
        return this;
    }

    public boolean validateRequiredDocumentLists() {
        List<WebElement> docList = documents.findElement(By.tagName("ul")).findElements(By.tagName("li"));
        for (int x = 0; x < docList.size(); x++) {
            return value.add(docList.get(x).getText());
        }
        return false;
    }

    public boolean validateViewDocumentButton() {
        ButtonControl.getButtonName(viewDocuments);
        return true;
    }

    public ApplicationsPage clickCreditCheckButton() {
        WebWaits.waitForNoOfSeconds(2);
        for(WebElement firstRow : applicationsTable.findElements(By.cssSelector("tbody > tr"))){
        for (WebElement dataElement : firstRow.findElements(By.tagName("td"))) {
            for (WebElement spanElement : dataElement.findElements(By.tagName("span"))) {
                for (WebElement buttonElement : spanElement.findElements(By.tagName("button"))) {
                    if (!buttonElement.getAttribute("onclick").contains("creditCheck")) continue;
                    ClickControl.click(buttonElement);
                    break;
                }
                }
            }
        }
        return this;
    }

    public boolean validateCreditCheckMessage(String message) {
        WebWaits.waitForElement(alert);
        //WebWaits.waitForNoOfSeconds(7);
        return alert.getText().contains(message);
    }

    public ApplicationsPage selectCreditCheckReportPage() {
        WebWaits.waitForNoOfSeconds(2);
        creditCheckReport.click();
        return this;
    }

    public boolean validateCreditRating() {
        WebWaits.waitForNoOfSeconds(1);
        for (WebElement spanElement : creditReportData.findElements(By.tagName("span"))) {
            if (!spanElement.getText().equalsIgnoreCase("CREDIT_RATING")) continue;
            return true;
        }
        return false;
    }

    public boolean validateCreditLimit() {
        WebWaits.waitForNoOfSeconds(1);
        for (WebElement spanElement : creditReportData.findElements(By.tagName("span"))) {
            if (!spanElement.getText().equalsIgnoreCase("CREDIT_LIMIT")) continue;
            return true;
        }
        return false;
    }

    public ApplicationsPage searchForApplication(String keyWord) {
        WebWaits.waitForNoOfSeconds(1);
        TextFieldsControl.enterText(searchApplication, keyWord);
        return this;
    }

    public boolean validateSubmittedApplications() {
        WebElement firstElement = applicationsTable.findElement(By.tagName("tbody")).findElements(By.tagName("tr")).get(0);
        for (WebElement dataElement : firstElement.findElements(By.tagName("td"))) {
            for (WebElement spanElement : dataElement.findElements(By.tagName("span"))) {
                if (!spanElement.getText().equalsIgnoreCase("SUBMITTED")) continue;
                return true;
            }
        }
        return false;
    }

    public CreditScoreCardModal clickCreditScoreCardButton() {
        WebElement firstRow = applicationsTable.findElements(By.cssSelector("tbody > tr")).get(0);
        for (WebElement dataElement : firstRow.findElements(By.tagName("td"))) {
            for (WebElement spanElement : dataElement.findElements(By.tagName("span"))) {
                for (WebElement buttonElement : spanElement.findElements(By.tagName("button"))) {
                    if (!buttonElement.getAttribute("onclick").contains("showCreditScore")) continue;
                    ClickControl.click(buttonElement);
                    break;
                }
            }
        }
        return PageFactory.initElements(webDriver, CreditScoreCardModal.class);
    }

    public Popovers clickRejectButton() {
        WebElement firstRow = applicationsTable.findElements(By.cssSelector("tbody > tr")).get(0);
        for (WebElement dataElement : firstRow.findElements(By.tagName("td"))) {
            for (WebElement spanElement : dataElement.findElements(By.tagName("span"))) {
                for (WebElement buttonElement : spanElement.findElements(By.tagName("button"))) {
                    if (!buttonElement.getAttribute("onclick").contains("rejectApplication")) continue;
                    ClickControl.click(buttonElement);
                    break;
                }
            }
        }
        return PageFactory.initElements(webDriver, Popovers.class);
    }

    public Popovers clickApproveButton() {
        WebElement firstRow = applicationsTable.findElements(By.cssSelector("tbody > tr")).get(0);
        for (WebElement dataElement : firstRow.findElements(By.tagName("td"))) {
            for (WebElement spanElement : dataElement.findElements(By.tagName("span"))) {
                for (WebElement buttonElement : spanElement.findElements(By.tagName("button"))) {
                    if (!buttonElement.getAttribute("onclick").contains("approveApplication")) continue;
                    ClickControl.click(buttonElement);
                    break;
                }
            }
        }
        return PageFactory.initElements(webDriver, Popovers.class);
    }

    public Popovers clickFTPSeedCXButton(String name) {
        WebElement firstRow = applicationsTable.findElements(By.cssSelector("tbody > tr")).get(0);
        for (WebElement dataElement : firstRow.findElements(By.tagName("td"))) {
            for (WebElement spanElement : dataElement.findElements(By.tagName("span"))) {
                for (WebElement buttonElement : spanElement.findElements(By.tagName("button"))) {
                    if (!buttonElement.getAttribute("aria-label").contains(name)) continue;
                    ClickControl.click(buttonElement);
                    break;
                }
            }
        }
        return PageFactory.initElements(webDriver, Popovers.class);
    }

    public boolean validateSeedCXValidationMessage(String seedCXMessage) {
        ButtonControl.clickButton(thumbsUpButton);
        WebWaits.waitForNoOfSeconds(2);
        return dangerAlert.getText().contains(seedCXMessage);
    }

    public ApplicationsPage selectAuthorisedSignerMenu() {
        ClickControl.click(authorisedSignerMenu);
        return this;
    }

    public boolean viewAllAuthorisedSigners() {
        WebWaits.waitForNoOfSeconds(1);
        List<WebElement> column = authorisedTable.findElements(By.tagName("td"));
        for (int j = 0; j < column.size(); j++) {
            return value.add(column.get(j).getText());
        }
        return false;
    }

    public void clickViewAMLReportButton() {
        ButtonControl.clickButton(viewAMLReport);
    }

    public boolean validateAMLReportForUser(String authSigner) {
        WebWaits.waitForNoOfSeconds(1);
        if(fullNameInAML.getText().contains(authSigner)){
            return true;
        }
        return false;
    }

    public void closeAMLReport() {
        ClickControl.click(closeAMLReport);
    }

    public void clickViewKYCReportButton() {
        ButtonControl.clickButton(viewKYCReport);
    }

    public boolean validateKYCReportForUser(String authSigner) {
        WebWaits.waitForNoOfSeconds(2);
        if(fullNameInKYC.getText().contains(authSigner)){
            return true;
        }
        return false;
    }

    public void closeKYCReport() {
        ClickControl.click(closeKYCReport);
    }

    public Popovers clickResetAMLReportButton() {
        ButtonControl.clickButton(resetAMLReport);
        Actions action = new Actions(webDriver);
        action.moveByOffset(100,100).perform();
        return PageFactory.initElements(webDriver, Popovers.class);
    }

    public boolean validateAMLKYCStatusMessage(String message) {
        WebWaits.waitForElement(alert);
        WebWaits.waitForNoOfSeconds(20);
        if(alert.getText().contains(message)){
            return true;
        }
        return false;
    }

    public Popovers clickResetKYCReportButton() {
        ButtonControl.clickButton(resetKYCReport);
        Actions action = new Actions(webDriver);
        action.moveByOffset(100,100).perform();
        return PageFactory.initElements(webDriver, Popovers.class);
    }

    public Popovers clickRunAMLChecksButton() {
        ButtonControl.clickButton(runAMLChecks);
        Actions action = new Actions(webDriver);
        action.moveByOffset(100,100).perform();
        return PageFactory.initElements(webDriver, Popovers.class);
    }

    public Popovers clickRunKYCCheckstButton() {
        ButtonControl.clickButton(runKYCChecks);
        Actions action = new Actions(webDriver);
        action.moveByOffset(100,100).perform();
        return PageFactory.initElements(webDriver, Popovers.class);
    }

    public ApplicationsPage clickAdditionalDocsTab() {
        ClickControl.click(additionalDocsMenu);
        return this;
    }

    public void verifyAdditionalDocsButton() {
        BaseControl.isElementDisplayed(additionalDocsButton);
        ClickControl.click(additionalDocsButton);
    }

    public void addDocuments() {
        TextFieldsControl.enterText(additionalDocsButton,"/Users/swati/Swati1.jpg");
    }

    public void clickStartUploadButton() {
        ClickControl.click(startUploadButton);
    }
}
