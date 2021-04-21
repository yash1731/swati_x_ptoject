package com.aixtrade.pages;

import com.aixtrade.webControls.ClickControl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DirectionsPage extends BasePage {


    public DirectionsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public DisclosuresPage continueApplication() {
        ClickControl.click(saveAndProcced);
        return PageFactory.initElements(webDriver, DisclosuresPage.class);
    }
}
