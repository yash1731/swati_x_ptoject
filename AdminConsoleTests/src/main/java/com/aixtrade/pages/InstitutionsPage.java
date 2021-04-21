package com.aixtrade.pages;

import com.aixtrade.waits.WebWaits;
import com.aixtrade.webControls.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InstitutionsPage extends BasePage {

    @FindBy(id = "institutionsTable")
    private WebElement institutionsTable = null;
    @FindBy(css = "tr.odd:nth-child(1) > td:nth-child(9) > button:nth-child(1)")
    private WebElement viewUsers = null;
    @FindBy(id = "userList")
    private WebElement usersTable = null;
    @FindBy(css = "thead > tr > th:nth-child(1)")
    private WebElement sortByNumber = null;
    @FindBy(css = "input.form-control")
    private WebElement searchInstitution = null;
    @FindBy(css = "tr:nth-child(1) > td:nth-child(2) > button:nth-child(1)")
    private WebElement viewUserPrefInfoButton = null;
    @FindBy(css = "tr.bg-secondary:nth-child(1) > td:nth-child(2)")
    private WebElement receiveLTCSecurity = null;
    @FindBy(css = "tr.bg-secondary:nth-child(5) > td:nth-child(2)")
    private WebElement receivePAXSecurity = null;
    @FindBy(css = "#institutionsTable > tbody > tr:nth-child(1) > td:nth-child(1) > button")
    private WebElement institutionInfoButton = null;
    @FindBy(id="btnClearInstitution")
    private WebElement clearButton = null;
    @FindBy(id="chatbotName")
    private WebElement chatbotName = null;
    @FindBy(id="chatbotToken")
    private WebElement chatbotToken = null;
    @FindBy(id="btnUpdateInstitution")
    private WebElement updateInstitutionButton = null;
    @FindBy(css = "#usersTable > tbody > tr:nth-child(1) > td:nth-child(6)")
    private WebElement phoneNo = null;
    @FindBy(css = "#usersTable_filter > label > input")
    private WebElement searchingUser = null;
    @FindBy(css = "button[id*='btnEdit']")
    private WebElement editUsersButton = null;
    @FindBy(id="phone")
    private WebElement phoneUpdate = null;
    @FindBy(css = ".material-switch-control-indicator")
    private WebElement balanceCheck = null;
    @FindBy(css = ".fa-check")
    private WebElement balanceCheckSignal = null;
    @FindBy(id = "btnUpdateUser")
    private WebElement updateUser = null;
    @FindBy(css = "div.col-lg-4:nth-child(3) > div:nth-child(2) > div:nth-child(2) > label:nth-child(1) > span:nth-child(2)")
    private WebElement userAsAdmin = null;
    @FindBy(css = "div.col-lg-4:nth-child(3) > div:nth-child(3) > div:nth-child(2) > label:nth-child(1) > span:nth-child(2)")
    private WebElement userAsTrader = null;
    @FindBy(css = "div.col-lg-4:nth-child(3) > div:nth-child(4) > div:nth-child(2) > label:nth-child(1) > span:nth-child(2)")
    private WebElement userAsMarketMaker = null;
    @FindBy(css = "#userForm > div.form-group:nth-child(13) > div.col-sm-3:nth-child(2)")
    private WebElement channelPref = null;
    @FindBy(css = "div.tabulator-row:nth-child(1) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)")
    private WebElement receiveFirstSecurity = null;
    @FindBy(css = "input[value*='60'][data-scope*='adausd']")
    private WebElement quoteExpiry = null;
    @FindBy(css = "input[value*='1'][data-scope*='adausd']")
    private WebElement maxVolume = null;
    @FindBy(css = "input[id*='pt'][data-scope*='adausd']")
    private WebElement minVolume = null;
    @FindBy(id = "institutionForm")
    private  WebElement institutionForm = null;
    @FindBy(linkText = "Institutions")
    private WebElement institutionLink = null;
    @FindBy(css = "#channelDiv_T > div:nth-child(2) > label:nth-child(1) > span:nth-child(2)")
    private WebElement telegramIdField = null;
    @FindBy(css = "#channelDiv_F > div:nth-child(2) > label:nth-child(1) > span:nth-child(2)")
    private WebElement fixIdField = null;
    @FindBy(id = "fixSessionCode")
    private WebElement fixCodeField = null;
    @FindBy(css= "td.text-center:nth-child(10) > button:nth-child(1)")
    private WebElement clearingPartnersButton = null;
    @FindBy(id = "userEditTitle")
    private WebElement clearingPartnersHeader = null;
    @FindBy(id = "secretCO")
    private WebElement copperSecret = null;
    @FindBy(id = "apiKeyCO")
    private WebElement copperKey = null;
    @FindBy(id = "btnCreateClearingPartner")
    private WebElement saveClearingPartners = null;
    @FindBy(id = "mapInstrumentsTab")
    private WebElement instrumentsTab = null;
    @FindBy(id = "mapInstrumentsForm")
    private WebElement instrumentsForm = null;
    @FindBy(css = "div.tabulator-cell:nth-child(1)")
    private WebElement baseSecurityInList = null;
    @FindBy(css = "label.custom-control:nth-child(1) > span:nth-child(2)")
    private WebElement enableSettlementPartner = null;
    @FindBy(id = "btnSaveMappings")
    private WebElement saveInstrument = null;
    @FindBy(css = "div.tabulator-cell:nth-child(2)")
    private WebElement enabledSecurityUserPref = null;
    @FindBy(id = "clearingPartnerInstitutionIdZH")
    private WebElement clearSeedCXId = null;
    @FindBy(id= "clearingPartnersTab")
    private WebElement clearingPartnersTab = null;
    @FindBy(id="SETTLEMENT_CHARGE_BPS")
    private WebElement settlementCharges = null;
    @FindBy(id = "COMMISSION_CHARGE_BPS")
    private WebElement commissionCharges = null;
    @FindBy(css = "#channelDiv_F > div:nth-child(2) > label:nth-child(1) > span:nth-child(2)")
    private WebElement fixChannel = null;
    @FindBy(css = "#userForm > div:nth-child(2) > div.d-flex.justify-content-between.flex-wrap.flex-md-nowrap.align-items-center.pt-1.pb-2.pr-1.mb-3.border-bottom > button")
    private WebElement channelToolTip = null;
    @FindBy(id = "channelCombinationInfoModalLongTitle")
    private WebElement channelHeader = null;
    @FindBy(css = "#channelCombinationInfoModal > div > div > div.modal-body")
    private WebElement channelText = null;
    @FindBy(css = "#channelCombinationInfoModal > div > div > div.modal-header > button")
    private WebElement closeChannelTooltipButton = null;
    @FindBy(css = "#channelDiv_P > div.col-sm-2.col-form-label > label > span")
    private WebElement portalChannel = null;
    @FindBy(css = "#channelDiv_T > div.col-sm-2.col-form-label > label > span")
    private WebElement telegramChannel = null;
    @FindBy(css = "#channelDiv_S > div.col-sm-2.col-form-label > label > span")
    private WebElement symphonyChannel = null;
    @FindBy(css = ".cp-check-BTCUSD > span:nth-child(2)")
    private WebElement disableBTCUSD = null;
    @FindBy(css = ".cp-check-BTCEUR > span:nth-child(2)")
    private WebElement disableBTCEUR = null;
    @FindBy(css = ".cp-check-BTCGBP > span:nth-child(2)")
    private WebElement disableBTCGBP = null;
    @FindBy(css = ".cp-check-BTCUSDT > span:nth-child(2)")
    private WebElement disableBTCUSDT = null;

    public InstitutionsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean validateApplicationsExist() {
        WebWaits.waitForNoOfSeconds(10);
        List<WebElement> column = institutionsTable.findElements(By.tagName("td"));
        for (int j = 0; j < column.size(); j++) {
            return value.add(column.get(j).getText());
        }
        return false;
    }

    public InstitutionsPage viewUsersWithinAnInstitution(){
        //ClickControl.click(sortByNumber);
        ButtonControl.clickButton(viewUsers);
        System.out.println("Click");
        return this;
    }

    public boolean validateUsersExist() {
        WebWaits.waitForNoOfSeconds(7);
        List<WebElement> column = usersTable.findElement(By.tagName("tr")).findElements(By.tagName("th"));
        for (int x = 0; x < column.size(); x++) {
            return value.add(column.get(x).getText());
        }
        return false;
    }

    public InstitutionsPage searchAnInstituton(String institution) {
        WebWaits.waitForNoOfSeconds(2);
        TextFieldsControl.enterText(searchInstitution, institution);
        return this;
    }

    public InstitutionsPage clickUsersButton() {
        ButtonControl.clickButton(viewUsers);
        return this;
    }

    public InstitutionsPage clickUserPrefInfoButton() {
        ButtonControl.clickButton(viewUserPrefInfoButton);
        return this;
    }


    public boolean validateLTCSecurity(String ltc) {
        WebWaits.waitForNoOfSeconds(5);
        if(receiveLTCSecurity.getText().contains(ltc)){
            return true;
        }
        return false;
    }

    public boolean validatePAXSecurity(String pax) {
        if(receivePAXSecurity.getText().contains(pax)){
            return true;
        }
        return false;
    }

    public InstitutionsPage clickInstitutionInfoButton() {
        WebWaits.waitForNoOfSeconds(1);
        ButtonControl.clickButton(institutionInfoButton);
        return this;
    }

    public InstitutionsPage clickClearButton() {
        ButtonControl.clickButton(clearButton);
        return this;
    }

    public void enterChatBotNameAndToken(String chatBotName, String chatBotToken) {
        TextFieldsControl.enterText(chatbotName,chatBotName);
        TextFieldsControl.enterText(chatbotToken,chatBotToken);
    }

    public void clickUpdateInstitutionButton() {
        ButtonControl.clickButton(updateInstitutionButton);
    }

    public boolean validateInstitutionUpdated(String institutionUpdateMessage) {
        WebWaits.waitForNoOfSeconds(1);
        WebWaits.waitForElement(alert);
        return alert.getText().contains(institutionUpdateMessage);
    }

    public boolean verifyPhoneNumber(String phoneNumber) {
        WebWaits.waitForNoOfSeconds(1);
        if(phoneNo.getText().contains(phoneNumber)){
            return true;
        }
        return false;
    }

    public InstitutionsPage searchUser(String email) {
        WebWaits.waitForNoOfSeconds(1);
        TextFieldsControl.enterText(searchingUser,email);
        return this;
    }

    public InstitutionsPage clickEditUsers() {
        ClickControl.click(editUsersButton);
        return this;
    }

    public InstitutionsPage enterPhoneNumber(String phoneNo) {
        TextFieldsControl.enterText(phoneUpdate, phoneNo);
        return this;

    }

    public InstitutionsPage disableBalanceCheck() {
        ClickControl.click(balanceCheck);
        return this;
    }

    public boolean verifyBalanceCheckEnabled() {
        WebWaits.waitForNoOfSeconds(5);
        BaseControl.isElementDisplayed(balanceCheckSignal);
        return true;
    }

    public boolean valiadteUsersUpdateMessage(String message) {
        WebWaits.waitForNoOfSeconds(5);
        return alert.getText().contains(message);
    }

    public InstitutionsPage clickUpdateUserButton() {
        ButtonControl.clickButton(updateUser);
        return this;
    }

    public InstitutionsPage enableUserAsAdmin() {
        WebWaits.waitForNoOfSeconds(1);
        //JavaScriptControl.scrollToViewScript(userAsAdmin);
        ClickControl.click(userAsAdmin);
        return this;
    }

    public void enableUserAsTrader() {
        JavaScriptControl.scrollToViewScript(userAsTrader);
        ClickControl.click(userAsTrader);
    }

    public InstitutionsPage enableUserAsMM() {
        WebWaits.waitForNoOfSeconds(1);
        JavaScriptControl.scrollToViewScript(userAsMarketMaker);
        ClickControl.click(userAsMarketMaker);
        return this;
    }

    public InstitutionsPage setPreferedChannel(String preChannel, String channel) {
          for (WebElement divElement : channelPref.findElements(By.tagName("div"))) {
            for(WebElement buttonElement : divElement.findElements(By.tagName("button"))) {
                if (!buttonElement.getAttribute("title").contains(preChannel)) continue;
                ClickControl.click(buttonElement);
                break;
            }
        }

        List<WebElement> list = webDriver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']//li//a//span"));
        for(WebElement option : list){
            if(option.getAttribute("innerHTML").contains(channel)){
                ClickControl.click(option);
            }
        }
        return this;
    }

    public InstitutionsPage receiveSecurity() {
        WebWaits.waitForNoOfSeconds(1);
        JavaScriptControl.scrollToViewScript(receiveFirstSecurity);
        ClickControl.click(receiveFirstSecurity);
        return this;
    }

    public boolean validateQuoteExpiry() {
        WebWaits.waitForNoOfSeconds(1);
        return quoteExpiry.getAttribute("value").contains("60");
    }

    public boolean validateMaxVolume() {
        WebWaits.waitForNoOfSeconds(2);
        return maxVolume.getAttribute("value").contains("1");
    }

    public boolean validateMinVolume() {
        WebWaits.waitForNoOfSeconds(2);
        return minVolume.getAttribute("id").contains("pt");
    }

    public void isSecurityDisabled() {
        BaseControl.isElementDisplayed(quoteExpiry);
        BaseControl.isElementDisplayed(maxVolume);
        BaseControl.isElementDisplayed(minVolume);
    }

    private InstitutionsPage clickChannelsDropdown(String value){
        WebWaits.waitForNoOfSeconds(2);
        WebElement channelElement = institutionForm.findElement(By.cssSelector("div.form-group:nth-child(4) > div:nth-child(2) > div.dropdown:nth-child(1)"));
            for(WebElement buttonElement : channelElement.findElements(By.tagName("button"))) {
                if (!buttonElement.getAttribute("title").contains(value)) continue;
                ClickControl.click(buttonElement);
                break;
            }
            return this;
    }

    private  InstitutionsPage clickSelectDeselectAllOptions(String value){
        WebElement channelElement = institutionForm.findElement(By.cssSelector("div.form-group:nth-child(4) > div:nth-child(2) > div.dropdown:nth-child(1) > div:nth-child(3)"));
        for(WebElement actionElement : channelElement.findElements(By.tagName("div"))) {
                for (WebElement buttonElement : actionElement.findElements(By.tagName("button"))) {
                    if (!buttonElement.getText().contains(value)) continue;
                    ClickControl.click(buttonElement);
                    break;
            }
        }
        return this;
    }

    public InstitutionsPage clickToEnableAllChannels(String selectAllChannels) {
        WebWaits.waitForNoOfSeconds(2);
        this.clickChannelsDropdown("Please select allowed Channels");
        this.clickSelectDeselectAllOptions(selectAllChannels);
        return  this;
    }

    public InstitutionsPage clickToDisableAllChannels(String deselectAllChannels) {
        this.clickChannelsDropdown("5 Channels selected");
        this.clickSelectDeselectAllOptions(deselectAllChannels);
        return this;
    }

    private  InstitutionsPage selectDropDownOptions(String value){
        List<WebElement> list = webDriver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']//li//a//span"));
        for(WebElement option : list){
            if(option.getAttribute("innerHTML").contains(value)){
                ClickControl.click(option);
            }
        }
        return this;
    }

    public InstitutionsPage clickToEnableTelegramFIX(String telegram, String fix) {
        WebWaits.waitForNoOfSeconds(1);
        this.clickChannelsDropdown("Please select allowed Channels");
        this.selectDropDownOptions(telegram);
        this.clickUpdateInstitutionButton();
        this.clickChannelsDropdown("Telegram");
        WebWaits.waitForNoOfSeconds(2);
        this.selectDropDownOptions(fix);
        return this;
    }

    public boolean verifyTelegramFixFieldsEnabled() {
        BaseControl.isElementDisplayed(telegramIdField);
        BaseControl.isElementDisplayed(fixIdField);
        return  true;
    }

    public InstitutionsPage goBackToInstitutionPage() {
        ClickControl.click(institutionLink);
        WebWaits.waitForNoOfSeconds(2);
        return this;
    }

    public InstitutionsPage enterFixSessionCode(String fixCode) {
        ClickControl.click(balanceCheck);
        TextFieldsControl.enterText(fixCodeField,fixCode);
        return  this;
    }

    public boolean validateFixCodeInList(String fixCode) {
        WebElement rowElement = institutionsTable.findElement(By.cssSelector("tbody:nth-child(2)")).findElements(By.tagName("tr")).get(0);
        for(WebElement columnElement : rowElement.findElements(By.tagName("td"))){
            if(columnElement.getText().contains(fixCode)){
                return true;
            }
        }
        return  false;
    }

    public InstitutionsPage clickClearingPartnersButton() {
        WebWaits.waitForNoOfSeconds(1);
        ButtonControl.clickButton(clearingPartnersButton);
        return this;
    }

    public boolean clearingPartnersTab(String header) {
        WebWaits.waitForNoOfSeconds(3);
        if(clearingPartnersHeader.getText().contains(header)){
        return true;
        }
        return false;
    }

    public InstitutionsPage enterClearingPartnersKeyAndSecret(String key, String secret) {
        TextFieldsControl.enterText(copperKey,key);
        TextFieldsControl.enterText(copperSecret,key);
        return this;
    }

    public InstitutionsPage clickSaveXlearingPartnersButton() {
        ButtonControl.clickButton(saveClearingPartners);
        return this;
    }

    public boolean validateCopperError(String error) {
        WebWaits.waitForElement(dangerAlert);
        return dangerAlert.getText().contains(error);
    }

    public InstitutionsPage clickInstrumentsTab() {
        ButtonControl.clickButton(instrumentsTab);
        return this;
    }

    public InstitutionsPage chooseBaseCurrencies(String base) {
        WebWaits.waitForNoOfSeconds(5);
        try {
            WebElement baseCurrency = instrumentsForm.findElement(By.cssSelector("div:nth-child(1) > div:nth-child(2) > div:nth-child(1)"));
            for (WebElement button : baseCurrency.findElements(By.tagName("button"))) {
                if (button.getAttribute("data-id").contains("baseCurrencies")) {
                    ClickControl.click(button);
                    selectDropDownOptions(base);
                }
            }
        }catch(org.openqa.selenium.StaleElementReferenceException ex){
        }
        return this;
    }

    public InstitutionsPage chooseQuoteCurrencies(String quote) {
        WebElement baseCurrency = instrumentsForm.findElement(By.cssSelector("div:nth-child(2) > div:nth-child(2) > div:nth-child(1)"));
        for(WebElement button : baseCurrency.findElements(By.tagName("button"))){
            if(button.getAttribute("data-id").contains("quoteCurrencies")){
                ClickControl.click(button);
                selectDropDownOptions(quote);
                            }
        }
        return this;
    }

    public void verifyInstrumentsInClearingPartnerList() {
        BaseControl.isElementDisplayed(baseSecurityInList);
    }

    public void enableInstrumentsToBeInSeedCX() {
        //ClickControl.click(enableSettlementPartner);
        ClickControl.click(disableBTCUSD);
        ClickControl.click(disableBTCEUR);
        ClickControl.click(disableBTCGBP);
        ClickControl.click(disableBTCUSDT);
    }

    public InstitutionsPage clickSaveInstrumentsButton() {
        ClickControl.click(saveInstrument);
        return this;
    }

    public boolean validateClearingPartnerUpdatedMessage(String message) {
        WebWaits.waitForElement(alert);
        return alert.getText().contains(message);
    }

    public boolean validateInstrumentInUserPref() {
        WebWaits.waitForNoOfSeconds(30);
        JavaScriptControl.scrollToViewScript(enabledSecurityUserPref);
        //JavaScriptControl.scrollDownScript();
       // WebWaits.waitForNoOfSeconds(15);
        if(enabledSecurityUserPref.isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean validateInstrumentIsNotInUserPref() {
        JavaScriptControl.scrollToViewScript(userAsMarketMaker);
        JavaScriptControl.scrollDownScript();
        WebWaits.waitForNoOfSeconds(15);
       BaseControl.isElementNotDisplayedAndPresent(enabledSecurityUserPref);
        return true;
    }

    public InstitutionsPage clearClearingPartnerSeedCXId() {
        clearSeedCXId.clear();
        return this;
    }

    public boolean validateClearingCredentialsSavedMessage(String message) {
        WebWaits.waitForNoOfSeconds(5);
        return alert.getText().contains(message);
    }

    public boolean instrumentTabDisplay() {
        BaseControl.isElementNotDisplayedAndPresent(instrumentsTab);
        return true;
    }

    public InstitutionsPage enterClearingPartnerSeedCXId(String id) {
        TextFieldsControl.enterText(clearSeedCXId,id);
        return this;
    }

    public void clickClearingPartnersTab() {
        ClickControl.click(clearingPartnersTab);
    }

    public boolean validateInstrumentAssociatedMessage(String message) {
        WebWaits.waitForNoOfSeconds(5);
        return dangerAlert.getText().contains(message);
    }

    public InstitutionsPage addChargestoAnInstitution(String settlementCharge, String commissionCharge) {
        WebWaits.waitForNoOfSeconds(2);
        TextFieldsControl.enterText(settlementCharges,settlementCharge);
        TextFieldsControl.enterText(commissionCharges,commissionCharge);
        return this;
    }

    public InstitutionsPage clickToDisableTelegranFixChannels(String deselectAllChannels) {
        this.clickChannelsDropdown("Telegram, Fix");
        this.clickSelectDeselectAllOptions(deselectAllChannels);
        return this;
    }

    public InstitutionsPage setPreferredChannelForUser() {
        ButtonControl.clickButton(fixChannel);
        return this;
    }

    public InstitutionsPage clickValidCombinationToolTip() {
        ClickControl.click(channelToolTip);
        return this;
    }

    public boolean verifyChannelHeaderText(String header, String text) {
        if(channelHeader.getText().contains(header) &&
        channelText.getText().contains(text)){
            return true;
        }
        return false;
    }

    public InstitutionsPage closeChannelTooltipButton() {
        ButtonControl.clickButton(closeChannelTooltipButton);
        return this;
    }

    public InstitutionsPage enableValidCombinationOfChannel() {
        WebWaits.waitForNoOfSeconds(2);
        ClickControl.click(telegramChannel);
        ClickControl.click(portalChannel);
        return this;
    }

    public InstitutionsPage enableSymphonyAsChannel() {
        ClickControl.click(symphonyChannel);
        return this;
    }

    public InstitutionsPage disabledValidChannels() {
        BaseControl.isElementDisabled(telegramChannel);
        BaseControl.isElementDisabled(portalChannel);
        return this;
    }

    public InstitutionsPage enablePortalChannel() {
        ClickControl.click(portalChannel);
        return this;
    }

    public boolean valiadteMMOTCMessage(String message) {
        WebWaits.waitForNoOfSeconds(2);
        return infoAlert.getText().contains(message);
    }

    public InstitutionsPage validateCantDisabledPartnerMessage(String message) {
        WebWaits.waitForNoOfSeconds(1);
        if(dangerAlert.getText().contains(message)){

        }
        return this;
    }

    public InstitutionsPage disableInstrumentsToBeInSeedCX() {
        ClickControl.click(disableBTCUSD);
        ClickControl.click(disableBTCEUR);
        ClickControl.click(disableBTCGBP);
        ClickControl.click(disableBTCUSDT);
        return this;
    }
}
