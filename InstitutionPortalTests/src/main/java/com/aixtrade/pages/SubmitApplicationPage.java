package com.aixtrade.pages;

import com.aixtrade.waits.WebWaits;
import com.aixtrade.webControls.ButtonControl;
import com.aixtrade.webControls.CheckBoxControl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubmitApplicationPage extends BasePage {

    @FindBy(id = "agreed")
    private WebElement agreeButton = null;
    @FindBy(css = "div.actions.clearfix > ul > li:nth-child(3) > a")
    private WebElement submitApplication = null;

    public SubmitApplicationPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SubmitApplicationPage submitApplication() {
        CheckBoxControl.tickCheckBox(agreeButton);
        ButtonControl.clickButton(submitApplication);
        WebWaits.waitForNoOfSeconds(2);
        return this;
    }

    public boolean validateApplicationSubmission(String message) {
        return alert.getText().contains(message);
    }
}
