package com.aixtrade.pages;

import com.aixtrade.waits.WebWaits;
import com.aixtrade.webControls.ButtonControl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvitationEmailModal extends BasePage {

    @FindBy(css ="div.modal-body > p:nth-child(3)")
    private WebElement modalBody = null;
    @FindBy(css ="div.modal-body > p:nth-child(4)")
    private WebElement loginText = null;
    @FindBy(css ="div.modal-body > p:nth-child(5) > b:nth-child(1)")
    private WebElement emailAddress = null;
    @FindBy(className ="modal-content")
    private WebElement modalContent = null;

    public InvitationEmailModal(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean validateModalBody(String message) {
        WebWaits.waitForNoOfSeconds(1);
        return modalBody.getText().contains(message);
    }

    public boolean validateLoginText(String text) {
        WebWaits.waitForElement(loginText);
        return loginText.getText().contains(text);
    }

    public boolean validateEmailAddress(String email) {
        WebWaits.waitForElement(emailAddress);
        return emailAddress.getText().contains(email);
    }

    public InvitationsPage closeModal(){
        for (WebElement divElement : modalContent.findElements(By.tagName("div"))) {
            for (WebElement buttonElement : divElement.findElements(By.tagName("button"))) {
                if (!buttonElement.getText().equalsIgnoreCase("Close")) continue;
                ButtonControl.clickButton(buttonElement);
                break;
            }
        }
        return PageFactory.initElements(webDriver,InvitationsPage.class);
    }
}
