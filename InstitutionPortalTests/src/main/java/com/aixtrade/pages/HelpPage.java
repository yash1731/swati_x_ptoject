package com.aixtrade.pages;

import com.aixtrade.waits.WebWaits;
import com.aixtrade.webControls.ButtonControl;
import com.aixtrade.webControls.TextFieldsControl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HelpPage extends BasePage {

    @FindBy(id = "emailSubject")
    private WebElement emailSubject = null;
    @FindBy(id = "emailMessage")
    private WebElement emailMessage = null;
    @FindBy(id = "supportEmailForm")
    private WebElement supportEmailForm = null;


    public HelpPage(WebDriver webDriver) {
        super(webDriver);
    }

    public HelpPage enterSubjectAndMessage(String subject, String email){
        TextFieldsControl.enterText(emailSubject, subject);
        TextFieldsControl.enterText(emailMessage, email);
        return this;
    }

    public HelpPage sendMessage() {
        scrollToBottomOfPage();
        for (WebElement divElement : supportEmailForm.findElements(By.tagName("div"))) {
            for (WebElement div2Element : divElement.findElements(By.tagName("div"))) {
                for (WebElement buttonElement : div2Element.findElements(By.tagName("button"))) {
                    if (!buttonElement.getText().equalsIgnoreCase("Send Message")) continue;
                    ButtonControl.clickButton(buttonElement);
                    break;
                }
            }
        }
        return this;
    }

    public boolean validateSentMessage(String message) {
        WebWaits.waitForElement(alert);
        return alert.getText().contains(message);
    }
}
