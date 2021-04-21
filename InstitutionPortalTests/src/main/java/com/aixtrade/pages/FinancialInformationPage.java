package com.aixtrade.pages;

import com.aixtrade.waits.WebWaits;
import com.aixtrade.webControls.ClickControl;
import com.aixtrade.webControls.RadioControl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinancialInformationPage extends BasePage {

    @FindBy(id = "bankruptcy2")
    private WebElement bankruptcy = null;
    @FindBy(id = "annualIncome2")
    private WebElement annualIncome = null;
    @FindBy(id = "netAssets2")
    private WebElement netAssets = null;

    public FinancialInformationPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LegalPage selectFinancialInformationDetails() {
        WebWaits.waitForNoOfSeconds(1);
        RadioControl.clickButton(bankruptcy);
        RadioControl.clickButton(annualIncome);
        RadioControl.clickButton(netAssets);
        ClickControl.click(saveAndProcced);
        return PageFactory.initElements(webDriver, LegalPage.class);
    }
}
