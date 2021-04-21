package com.aixtrade.pages;

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

import java.util.List;

public class InvitationsPage extends BasePage {

    @FindBy(id = "institutionName")
    private WebElement institutionName = null;
    @FindBy(id = "contactFirstName")
    private WebElement contactFirstName = null;
    @FindBy(id = "contactLastName")
    private WebElement contactLastName = null;
    @FindBy(id = "contactEmail")
    private WebElement contactEmail = null;
    @FindBy(id = "btnCreateInvitation")
    private WebElement sendInvite = null;
    @FindBy(id = "btnPreviewInvitation")
    private WebElement previewInvitation = null;
    @FindBy(css = "body > div.col-xs-11.col-sm-4.alert.alert-success")
    private WebElement alert = null;
    @FindBy(id = "invitationsTable")
    private WebElement invitationsTable = null;
    @FindBy(css = "#invitationsTable_length > label > select")
    private WebElement invitationEntries = null;

    public InvitationsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public InvitationEmailModal previewInvite() {
        ButtonControl.clickButton(previewInvitation);
        return PageFactory.initElements(webDriver, InvitationEmailModal.class);
    }

    public InvitationEmailModal previewExistingInvitation() {
        WebWaits.waitForNoOfSeconds(1);
        WebElement firstRow = invitationsTable.findElements(By.cssSelector("tbody > tr")).get(0);
        for (WebElement dataElement : firstRow.findElements(By.tagName("td"))) {
            for (WebElement buttonElement : dataElement.findElements(By.tagName("button"))) {
                if (!buttonElement.getAttribute("id").contains("btnPreview")) continue;
                ButtonControl.clickButton(buttonElement);
                break;
            }
        }
        return PageFactory.initElements(webDriver, InvitationEmailModal.class);
    }

    public InvitationsPage fillInstitutionInformation(String institution, String firstName, String lastName, String emailAddress) {
        WebWaits.waitForNoOfSeconds(2);
        TextFieldsControl.enterText(institutionName, institution);
        TextFieldsControl.enterText(contactFirstName, firstName);
        TextFieldsControl.enterText(contactLastName, lastName);
        TextFieldsControl.enterText(contactEmail, emailAddress);
        return this;
    }

    public InvitationsPage resendInvite() {
        WebWaits.waitForNoOfSeconds(1);
        WebElement firstRow = invitationsTable.findElements(By.cssSelector("tbody > tr")).get(0);
        for (WebElement dataElement : firstRow.findElements(By.tagName("td"))) {
            for (WebElement buttonElement : dataElement.findElements(By.tagName("button"))) {
                if (!buttonElement.getText().equalsIgnoreCase("Resend")) continue;
                ClickControl.click(buttonElement);
                break;
            }
        }
        return this;
    }

    public boolean validateResentInvite(String message) {
        WebWaits.waitForElement(alert);
        return alert.getText().contains(message);
    }

    public InvitationsPage validateResendingAnInvite() {
        for (WebElement tableRowElement : invitationsTable.findElement(By.tagName("tbody")).findElements(By.tagName("tr"))) {
            for (WebElement tableDataElement : tableRowElement.findElements(By.tagName("td"))) {
                if (!tableDataElement.getAttribute("id").equalsIgnoreCase("btnResend454")) continue;
                ButtonControl.clickButton(tableDataElement);
                break;
            }
        }
        return this;
    }

    public boolean viewListOfInvitations() {
        WebWaits.waitForNoOfSeconds(1);
        List<WebElement> column = invitationsTable.findElement(By.tagName("tr")).findElements(By.tagName("th"));
        for (int j = 0; j < column.size(); j++) {
            return value.add(column.get(j).getText());
        }
        return false;
    }

    public InvitationsPage filterInvitationsEntries() {
        DropDownControl.selectDropDownByVisibleText(invitationEntries, "All");
        WebWaits.waitForNoOfSeconds(1);
        DropDownControl.selectDropDownByVisibleText(invitationEntries, "25");
        return this;
    }
}
