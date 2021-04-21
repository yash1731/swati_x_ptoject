package com.aixtrade.pages;

import com.aixtrade.waits.WebWaits;
import com.aixtrade.webControls.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PlatformControlPage extends BasePage {

    @FindBy(id="btnPlatformSwitch")
    private WebElement applyButton = null;
    @FindBy(css=".platform-action-invalid")
    private WebElement stateReason = null;
    @FindBy(css=".reason1-invalid")
    private WebElement stateTextReason = null;
    @FindBy(css="#platformCollapse > div > div > div")
    private WebElement platformCollapse = null;
    @FindBy(css="#instrumentsCollapse > div > div")
    private WebElement instrumentCollapse = null;
    @FindBy(id="reason1")
    private WebElement platformReason = null;
    @FindBy(id="platforms-suspended")
    private WebElement platformSuspend = null;
    @FindBy(id="instruments-suspended")
    private WebElement instrumentsSuspend = null;
    @FindBy(id="institutions-suspended")
    private WebElement institutionsSuspend = null;
    @FindBy(id="users-suspended")
    private WebElement usersSuspend = null;
    @FindBy(id="platforms-trading_halted")
    private WebElement platformTradingHalt = null;
    @FindBy(id="instruments-trading_halted")
    private WebElement instrumentsTradingHalted = null;
    @FindBy(id="institutions-trading_halted")
    private WebElement institutionsTradingHalted = null;
    @FindBy(id="users-trading_halted")
    private WebElement usersTradingHalted = null;
    @FindBy(id="platforms-settlement_halted")
    private WebElement platformSettlementHalt = null;
    @FindBy(id="instruments-settlement_halted")
    private WebElement instrumentsSettlementHalt = null;
    @FindBy(id="institutions-settlement_halted")
    private WebElement institutionsSettlementHalt = null;
    @FindBy(id="users-settlement_halted")
    private WebElement usersSettlementHalt = null;
    @FindBy(id="platforms-active")
    private WebElement platformContinueTrading = null;
    @FindBy(id="instruments-active")
    private WebElement instrumentsContinueTrading = null;
    @FindBy(id="institutions-active")
    private WebElement institutionsContinueTrading = null;
    @FindBy(id="users-active")
    private WebElement usersContinueTrading = null;
    //@FindBy(id="btnInstrumentsCollapse")
    @FindBy(id = "btnInstrumentsCollapse")
    private WebElement instrumentsLink = null;
    @FindBy(id="btnInstrumentSwitch")
    private WebElement applyInstrumentStateButton = null;
    @FindBy(css=".instrument-invalid")
    private WebElement instrumentReqText = null;
    @FindBy(css=".instrument-action-invalid")
    private WebElement stateReqText = null;
    @FindBy(css=".reason2-invalid")
    private WebElement stateReasonReqText = null;
    @FindBy(id="reason2")
    private WebElement instrumentReasonField = null;
    @FindBy(css=".show > .inner > .dropdown-menu > li:nth-child(2) .text")
    private WebElement settlementState = null;
    @FindBy(css=".show > .inner > .dropdown-menu > li:nth-child(3) .text")
    private WebElement tradingHalt = null;
    @FindBy(css=".show > .inner > .dropdown-menu > li:nth-child(4) .text")
    private WebElement suspendState = null;
    @FindBy(css="#instruments-suspended > a:nth-child(1)")
    private WebElement suspendedLink = null;
    @FindBy(css=".btn-outline-info")
    private WebElement changeState = null;
    @FindBy(css=".show > .inner > .dropdown-menu > li:nth-child(1) .text")
    private WebElement continueState = null;
    @FindBy(id="btnInstitutionsCollapse")
    private WebElement institutionsLink = null;
    @FindBy(id="btnInstitutionSwitch")
    private WebElement applyInstitutionState = null;
    @FindBy(id="institutionsCollapse")
    private WebElement institutionCollapse = null;
    @FindBy(css=".institutions-invalid")
    private WebElement institutionReqText = null;
    @FindBy(css=".institutions-action-invalid")
    private WebElement institutionStateReqText = null;
    @FindBy(css=".reason3-invalid")
    private WebElement institutionStateReasonReqText = null;
    @FindBy(id="reason3")
    private WebElement institutionReason = null;
    @FindBy(css="#institutions-suspended > a:nth-child(1)")
    private WebElement institutionSuspendedLink = null;
    @FindBy(css="#users-suspended > a:nth-child(1)")
    private WebElement usesrSuspendedLink = null;
    @FindBy(id="historyTab")
    private WebElement historyTab = null;
    @FindBy(id="statesTable")
    private WebElement statesTable = null;
    @FindBy(id="btnUsersCollapse")
    private WebElement usersLink = null;
    @FindBy(id="btnUserSwitch")
    private WebElement applyUserStateButton = null;
    @FindBy(id="usersCollapse")
    private WebElement userCollapse = null;
    @FindBy(css="div.invalid-feedback:nth-child(3)")
    private WebElement usersReqText = null;
    @FindBy(css=".users-action-invalid")
    private WebElement usersStateReqText = null;
    @FindBy(css=".reason4-invalid")
    private WebElement usersStateReasonReqText = null;
    @FindBy(id="reason4")
    private WebElement usersReason = null;


    public PlatformControlPage(WebDriver webDriver) {
        super(webDriver);
    }

    public Popovers clickApplyButton() {
        WebWaits.waitForNoOfSeconds(5);
        ButtonControl.clickButton(applyButton);
        Actions action = new Actions(webDriver);
        action.moveByOffset(100,100).perform();
        return PageFactory.initElements(webDriver, Popovers.class);
    }

    public boolean validateStateErrorMessage(String state) {
        if(stateReason.getText().contains(state)) {
            return true;
        }
        return false;
    }

    public boolean validateStateReasonErrorMessage(String stateReason) {
        if(stateTextReason.getText().contains(stateReason)) {
            return true;
        }
        return false;
    }

    public PlatformControlPage clickState(String value){
        for(WebElement div1Element : platformCollapse.findElements(By.tagName("div"))){
            for(WebElement buttonElement : div1Element.findElements(By.tagName("button"))){
                if(!buttonElement.getAttribute("title").equalsIgnoreCase(value)) continue;
                ClickControl.click(buttonElement);
            }
        }
        return this;
    }

    public PlatformControlPage selectState(String value) {
        WebWaits.waitForNoOfSeconds(1);
        List<WebElement> list = webDriver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']//li//a//span"));
        for(WebElement option : list){
            if(option.getAttribute("innerHTML").contains(value)){
                ClickControl.click(option);
                break;
            }
        }
        return this;
    }

    public PlatformControlPage enterPlatoformStateReason(String enterReason) {
        WebWaits.waitForNoOfSeconds(1);
        TextFieldsControl.enterText(platformReason,enterReason);
        return this;
    }

    public boolean validateMessage(String message) {
        WebWaits.waitForNoOfSeconds(2);
        WebWaits.waitForElement(alert);
        return alert.getText().contains(message);
    }

    public boolean validateSuspendedChart() {
      platformSuspend.getText().contains("Y");
      return true;
    }

    public boolean instrumentSuspended() {
        BaseControl.isElementNotDisplayedAndPresent(instrumentsSuspend);
        return true;
    }

    public boolean institutionsSuspended() {
        BaseControl.isElementNotDisplayedAndPresent(institutionsSuspend);
        return true;
    }

    public boolean usersSuspended() {
        BaseControl.isElementNotDisplayedAndPresent(usersSuspend);
        return true;
    }

    public boolean validateTradingHaltChart() {
        platformTradingHalt.getText().contains("Y");
        return true;
    }

    public boolean instrumentTradingHalt() {
        BaseControl.isElementNotDisplayedAndPresent(instrumentsTradingHalted);
        return true;
    }

    public boolean institutionsTradingHalt() {
        BaseControl.isElementNotDisplayedAndPresent(institutionsTradingHalted);
        return true;
    }

    public boolean usersTradingHalt() {
        BaseControl.isElementNotDisplayedAndPresent(usersTradingHalted);
        return true;
    }

    public boolean validateSettlementHaltChart() {
        platformSettlementHalt.getText().contains("Y");
        return true;
    }

    public boolean instrumentSettlementHalt() {
        BaseControl.isElementNotDisplayedAndPresent(instrumentsSettlementHalt);
        return true;
    }

    public boolean institutionsSettlementHalt() {
        BaseControl.isElementNotDisplayedAndPresent(institutionsSettlementHalt);
        return true;
    }

    public boolean usersSettlementHalt() {
        BaseControl.isElementNotDisplayedAndPresent(usersSettlementHalt);
        return true;
    }

    public boolean validateContinueTradingChart() {
        platformContinueTrading.getText().contains("Y");
        return true;
    }

    public boolean instrumentContinueTrading() {
        BaseControl.isElementDisplayed(instrumentsContinueTrading);
        return true;
    }

    public boolean institutionsContinueTrading() {
        BaseControl.isElementDisplayed(institutionsContinueTrading);
        return true;
    }

    public boolean usersContinueTrading() {
        BaseControl.isElementDisplayed(usersContinueTrading);
        return true;
    }

    public PlatformControlPage selectInstrumentsLink() {
        WebWaits.waitForNoOfSeconds(10);
        ClickControl.click(instrumentsLink);
        return this;
    }

    public PlatformControlPage clickInstrumentDropdown(String value) {
        for(WebElement div1Element : instrumentCollapse.findElements(By.tagName("div"))) {
            for (WebElement div2Element : div1Element.findElements(By.tagName("div"))) {
                for (WebElement buttonElement : div2Element.findElements(By.tagName("button"))) {
                    if (!buttonElement.getAttribute("title").equalsIgnoreCase(value)) continue;
                    ClickControl.click(buttonElement);
                    break;
                }
            }
        }
        return this;
    }

    public Popovers clickApplyInstrumentStateButton() {
        ButtonControl.clickButton(applyInstrumentStateButton);
        Actions action = new Actions(webDriver);
        action.moveByOffset(5,5).perform();
        return PageFactory.initElements(webDriver, Popovers.class);
    }

    public boolean validateInstrumentErrorMessage(String instrumentRequired, String stateRequired, String stateReasonRequired) {
        WebWaits.waitForNoOfSeconds(1);
        instrumentReqText.getText().contains(instrumentRequired);
        stateReqText.getText().contains(stateRequired);
        stateReasonReqText.getText().contains(stateReasonRequired);
        return true;
    }

    public PlatformControlPage clickInstrumentStateDropdown() {
        WebElement buttonElement = instrumentCollapse.findElement(By.xpath("div[2]/div[1]/button"));
        ClickControl.click(buttonElement);
        return this;
    }

    public PlatformControlPage enterInstrumentStateReason(String reason) {
        TextFieldsControl.enterText(instrumentReasonField,reason);
        return this;
    }

    public void selectTradeHalt() {
        ClickControl.click(tradingHalt);
    }

    public void selectSuspended() {
        ClickControl.click(suspendState);
    }

    public void clickSuspendedLink() {
        ClickControl.click(suspendedLink);
    }

    public void changeState() {
        ClickControl.click(changeState);
    }

    public void selectContinueTrade() {
        ClickControl.click(continueState);
    }

    //Institutions control
    public PlatformControlPage selectInstitutionsLink() {
        WebWaits.waitForNoOfSeconds(15);
        ClickControl.click(institutionsLink);
        return this;
    }

    public Popovers clickApplyInstitutionStateButton() {
        ButtonControl.clickButton(applyInstitutionState);
        Actions action = new Actions(webDriver);
        action.moveByOffset(10,10).perform();
        return PageFactory.initElements(webDriver, Popovers.class);
    }


    public PlatformControlPage clickInstitutions(String value) {
        WebElement institutionElement = institutionCollapse.findElement(By.cssSelector("div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)"));
                for (WebElement buttonElement : institutionElement.findElements(By.tagName("button"))) {
                    if (!buttonElement.getAttribute("title").equalsIgnoreCase(value)) continue;
                    WebWaits.waitForNoOfSeconds(1);
                    ClickControl.click(buttonElement);
                    break;
        }
        return this;
    }

    public PlatformControlPage clickInstitutionStateDropdown() {
        WebElement institutionState = institutionCollapse.findElement(By.xpath("div/div[1]/div[2]/div[1]/button"));
        ClickControl.click(institutionState);
        return this;
    }

    public boolean validateInstitutionErrorMessage(String institutionRequired, String stateRequired, String stateReasonRequired) {
        WebWaits.waitForNoOfSeconds(1);
        institutionReqText.getText().contains(institutionRequired);
        institutionStateReqText.getText().contains(stateRequired);
        institutionStateReasonReqText.getText().contains(stateReasonRequired);
        return true;
    }

    public void enterInstitutionReason(String reason) {
        TextFieldsControl.enterText(institutionReason,reason);
    }

    public void clickInstitutionSuspendedLink() {
        ClickControl.click(institutionSuspendedLink);
    }


    //Platform History
    public PlatformControlPage clickHistoryTab() {
        WebWaits.waitForNoOfSeconds(7);
        ClickControl.click(historyTab);
        return this;
    }

    public boolean viewListOfPlatformStates() {
        WebWaits.waitForNoOfSeconds(5);
        List<WebElement> column = statesTable.findElement(By.tagName("tr")).findElements(By.tagName("th"));
        for (int j = 0; j < column.size(); j++) {
            return value.add(column.get(j).getText());
        }
        return false;
    }

    //Users Control

    public PlatformControlPage selectUserLink() {
        ClickControl.click(usersLink);
        return this;
    }

    public Popovers clickApplyUsersStateButton() {
        ButtonControl.clickButton(applyUserStateButton);
        Actions action = new Actions(webDriver);
        action.moveByOffset(5,5).perform();
        return PageFactory.initElements(webDriver, Popovers.class);
    }

    public PlatformControlPage clickInstitutionForUser(String institutionTitle) {
        WebElement div1Element = userCollapse.findElement(By.cssSelector("div:nth-child(1) > div:nth-child(1) > div:nth-child(1)"));
            for (WebElement div2Element : div1Element.findElements(By.tagName("div"))) {
                for (WebElement buttonElement : div2Element.findElements(By.tagName("button"))) {
                    if (!buttonElement.getAttribute("title").equalsIgnoreCase(institutionTitle)) continue;
                    ClickControl.click(buttonElement);
                    break;
            }
        }
        return this;
    }

    public PlatformControlPage clickUsersDropdown() {
        WebWaits.waitForNoOfSeconds(1);
        WebElement usersDropdown = userCollapse.findElement(By.xpath("div/div[1]/div[2]/div/button"));
        ClickControl.click(usersDropdown);
        return this;
    }

    public boolean validateUsersErrorMessage(String userRequired, String stateRequired, String stateReasonRequired) {
        WebWaits.waitForNoOfSeconds(1);
        usersReqText.getText().contains(userRequired);
        usersStateReqText.getText().contains(stateRequired);
        usersStateReasonReqText.getText().contains(stateReasonRequired);
        return true;
    }

    public void selectInstitutionToChooseUser(String institution1) {
        WebElement institutionDropdown = userCollapse.findElement(By.cssSelector("div > div > div > div > div:nth-child(3) > div:nth-child(2)"));
        for(WebElement ulElement : institutionDropdown.findElements(By.tagName("ul"))){
            for(WebElement liElement : ulElement.findElements(By.cssSelector("li > a"))){
                for(WebElement spanElement : liElement.findElements(By.tagName("span"))){
                    if (!spanElement.getText().equalsIgnoreCase(institution1)) continue;
                    ClickControl.click(spanElement);
                    break;
                }

            }
        }
    }

    public void enterUsersControlReason(String reason) {
        TextFieldsControl.enterText(usersReason,reason);
    }

    public PlatformControlPage selectSettlementState() {
        ClickControl.click(settlementState);
        return this;
    }

    public PlatformControlPage selectUsersStateDropdown() {
        WebElement institutionState = userCollapse.findElement(By.xpath("div/div[2]/div[2]/div[1]/button"));
        ClickControl.click(institutionState);
        return this;
    }

    public void clickUsersSuspendedLink() {
        ClickControl.click(usesrSuspendedLink);
    }
}

