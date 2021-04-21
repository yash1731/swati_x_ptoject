package com.aixtrade.pages;

import com.aixtrade.webControls.ClickControl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DisclosuresPage extends BasePage {

    @FindBy(id = "disclosureAccepted")
    private WebElement disclosureCheckbox = null;


    public DisclosuresPage(WebDriver webDriver) {
        super(webDriver);
    }

    public DisclosuresPage tickCheckbox() {
        ClickControl.click(disclosureCheckbox);
        return this;
    }

    public ApplicationInfoPage saveAndProceedToAppInfo() {
        ClickControl.click(saveAndProcced);
        return PageFactory.initElements(webDriver, ApplicationInfoPage.class);
    }
}
