package com.aixtrade.pages;

import com.aixtrade.waits.WebWaits;
import com.aixtrade.webControls.BaseControl;
import com.aixtrade.webControls.ClickControl;
import com.aixtrade.webControls.RadioControl;
import com.aixtrade.webControls.TextFieldsControl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OTCScreenPage extends BasePage {

    @FindBy(css = "#otcBody > div > div:nth-child(1) > div.col-sm-10.input-group > div.dropdown.bootstrap-select.otc-control.otc-control-left.w-50 > button")
    private WebElement selectBaseCurrency = null;
    @FindBy(css = "#otcBody > div > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > button")
    private WebElement selectQuoteCurrency = null;
    @FindBy(id = "quantity")
    private WebElement otcQuantity = null;
    @FindBy(id = "btnSubmitQuoteRequest")
    private WebElement requestQuoteButton = null;
    @FindBy(id = "btnCancelQuoteRequest")
    private WebElement cancelQuoteButton = null;
    @FindBy(id = "divBidAwaitingPrice")
    private WebElement sellSide = null;
    @FindBy(id = "divOfferAwaitingPrice")
    private WebElement buySide = null;
    @FindBy(css = "#otcBody > div > div:nth-child(3) > div:nth-child(5) > label > span")
    private WebElement showPartialButton = null;


    public OTCScreenPage(WebDriver webDriver) {
        super(webDriver);
    }

    //Quote Request

    public void selectDropDownOptions(String value){
        List<WebElement> list = webDriver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']//li//a//span"));
        for (WebElement option : list) {
            if (option.getAttribute("innerHTML").contains(value)) {
                ClickControl.click(option);
                TextFieldsControl.enterText(option, "Keys.ENTER");
            }
        }
    }

    public OTCScreenPage selectBaseCurrency(String baseCurrency) {
        ClickControl.click(selectBaseCurrency);
        selectDropDownOptions(baseCurrency);
        return this;
    }

    public OTCScreenPage selectQuoteCurrency(String quoteCurrency) {
        ClickControl.click(selectQuoteCurrency);
        selectDropDownOptions(quoteCurrency);
        return this;
    }

    public OTCScreenPage enterQuantity(String quantity) {
        TextFieldsControl.enterText(otcQuantity,quantity);
        return this;
    }

    public OTCScreenPage clickRequestQuoteButton() {
        ClickControl.click(requestQuoteButton);
        return this;
    }

    //Cancel Quote Request

    public AlertsAndPopovers clickCancelQuoteButton() {
        ClickControl.click(cancelQuoteButton);
        return PageFactory.initElements(webDriver, AlertsAndPopovers.class);
    }

    public boolean validateOTCNotify(String message) {
        WebWaits.waitForNoOfSeconds(2);
        return infoAlert.getText().contains(message);
    }

    //Insufficient funds

    public boolean validateOTCErrorNotify(String message) {
        WebWaits.waitForNoOfSeconds(2);
        return dangerAlert.getText().contains(message);
    }

    //Displayed BUY and SELL buttons with Awaiting Price

    public OTCScreenPage showBUYAndSELLButtons(String text) {
        BaseControl.isElementDisplayed(sellSide);
        sellSide.getText().contains(text);
        BaseControl.isElementDisplayed(buySide);
        buySide.getText().contains(text);
        return this;
    }

    //Show Partials

    public OTCScreenPage verifyPartialsButton() {
        WebWaits.waitForNoOfSeconds(2);
        BaseControl.isElementDisabled(showPartialButton);
        return this;
    }

    public OTCScreenPage enableShowPartials() {
        RadioControl.clickButton(showPartialButton);
        return this;
    }

    //Quantity Restriction to 8 decimal places

    public boolean validateQuantityRestrictionError(String message) {
        WebWaits.waitForNoOfSeconds(2);
        return dangerAlert.getText().contains(message);
    }
}
