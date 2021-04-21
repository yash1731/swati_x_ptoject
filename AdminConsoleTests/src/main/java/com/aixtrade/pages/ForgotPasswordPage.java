package com.aixtrade.pages;

import com.aixtrade.webControls.ClickControl;
import com.aixtrade.webControls.TextFieldsControl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameElement = null;
    @FindBy(css = "#kc-form-buttons > input")
    private WebElement submitButton = null;
    @FindBy(css = ".message-text")
    private WebElement resetPasswordMessage = null;

    public ForgotPasswordPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ForgotPasswordPage submitPasswordReset(String email) {
        TextFieldsControl.enterText(usernameElement, email);
        ClickControl.click(submitButton);
        return this;
    }

    public boolean validateResetPasswordMessage(String successMessage) {
        return resetPasswordMessage.getText().contains(successMessage);
    }
}
