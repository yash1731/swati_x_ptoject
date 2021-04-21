package com.aixtrade.pages;

import com.aixtrade.webControls.ButtonControl;
import com.aixtrade.webControls.CheckBoxControl;
import com.aixtrade.webControls.ClickControl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ECPStatusPage extends BasePage {

    @FindBy(id = "ecpINSC")
    private WebElement ecp = null;
    @FindBy(id = "ecpFIUK")
    private WebElement ecpFI = null;

    public ECPStatusPage(WebDriver webDriver) {
        super(webDriver);
    }

    public DocumentUploadPage selectECPOptions() {
        CheckBoxControl.tickCheckBox(ecpFI);
        ClickControl.click(ecp);
        ButtonControl.clickButton(saveAndProcced);
        return PageFactory.initElements(webDriver, DocumentUploadPage.class);
    }
}
