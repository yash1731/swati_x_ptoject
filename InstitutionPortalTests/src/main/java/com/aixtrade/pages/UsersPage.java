package com.aixtrade.pages;

import com.aixtrade.waits.WebWaits;
import com.aixtrade.webControls.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class UsersPage extends BasePage {

    @FindBy(id = "usersTable")
    private WebElement usersTable = null;
    private List<String> value = new ArrayList<String>();
    @FindBy(css = "#userForm > div:nth-child(3) > div:nth-child(2) > div.col-sm-2.col-form-label > label > span")
    private WebElement admin = null;
    @FindBy(css = "#userForm > div:nth-child(3) > div:nth-child(4) > div.col-sm-2.col-form-label > label > span")
    private WebElement marketMaster = null;
    @FindBy(css = "#userForm > div:nth-child(3) > div:nth-child(3) > div.col-sm-2.col-form-label > label > span")
    private WebElement trader = null;
    @FindBy(id = "lastName")
    private WebElement lastName = null;
    @FindBy(id = "email")
    private WebElement email = null;
    @FindBy(id = "channelId_T")
    private WebElement telegramId = null;
    @FindBy(id = "symphonyId")
    private WebElement symphonyId = null;
    @FindBy(id = "fixId")
    private WebElement fixId = null;
    @FindBy(id = "btnCreateUser")
    private WebElement createUserButton = null;
    @FindBy(id = "userForm")
    private WebElement userForm = null;
    private String randomEmail = "tester"+randomNo+"@aixtrade.com";
    private String randomName = "tester"+randomNo;
    @FindBy(css = "#usersTable_filter > label > input")
    private WebElement searchField = null;
    @FindBy(id = "btnUpdateUser")
    private WebElement updateUser = null;
    @FindBy(css = "#usersTable_length > label > select")
    private WebElement userEntries = null;
    @FindBy(id = "addEditUserTab")
    private WebElement addEditUserTab = null;
    @FindBy(css = "#userPrefsSection > div")
    private WebElement userPreferences = null;
    @FindBy(css = "#userForm > div.form-group:nth-child(13) > div.col-sm-3:nth-child(2)")
    private WebElement preferredChannel = null;
    @FindBy(css = "div.tabulator-row:nth-child(1) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)")
    private WebElement btcSecurity = null;
    @FindBy(id = "pt_1176")
    private WebElement quoteExpiry = null;
    @FindBy(id = "pt_1177")
    private WebElement minPriceBTC = null;
    @FindBy(id = "pt_1179")
    private WebElement maxPriceBTC = null;
    @FindBy(css = "#securityPreferencesTable > div.tabulator-tableHolder > div > div:nth-child(2) > div:nth-child(1) > label > span")
    private WebElement ethSecurity = null;
    @FindBy(id = "pt_1303")
    private WebElement quoteExpiryETH = null;
    @FindBy(id = "pt_1308")
    private WebElement minPriceETH = null;
    @FindBy(id = "pt_1312")
    private WebElement maxPriceETH = null;
    @FindBy(css  = "#channelDiv_T > div.col-sm-2.col-form-label > label > span")
    private WebElement enableTelegramChannel = null;
    @FindBy(css = "#channelDiv_P > div.col-sm-2.col-form-label > label > span")
    private WebElement enablePortalChannel = null;
    @FindBy(css = "#userForm > div:nth-child(2) > div.d-flex.justify-content-between.flex-wrap.flex-md-nowrap.align-items-center.pt-1.pb-2.pr-1.mb-3.border-bottom > button")
    private WebElement channeltip = null;
    @FindBy(id = "channelCombinationInfoModalLongTitle")
    private WebElement channelComboHeader = null;
    @FindBy(css = "#channelCombinationInfoModal > div > div > div.modal-body")
    private WebElement channelComboText = null;
    @FindBy(css = "#channelCombinationInfoModal > div > div > div.modal-header > button")
    private WebElement closeChannelCombo = null;
    @FindBy(css = "#channelDiv_S > div.col-sm-2.col-form-label > label > span")
    private WebElement enableSymphony = null;


    public UsersPage(WebDriver webDriver) {
        super(webDriver);
    }

    public Boolean viewListOfUsers() {
        WebWaits.waitForNoOfSeconds(1);
        List<WebElement> column = usersTable.findElement(By.tagName("tr")).findElements(By.tagName("th"));
        for (int j = 0; j < column.size(); j++) {
            return value.add(column.get(j).getText());
        }
        return false;
    }

    public UsersPage selectToAddOrEditUser(){
        ClickControl.click(addEditUserTab);
        return this;
    }

    private void enterFirstName() {
        WebWaits.waitForNoOfSeconds(1);
        for (WebElement divElement : userForm.findElements(By.tagName("div"))) {
            for (WebElement div2Element : divElement.findElements(By.tagName("div"))) {
                for (WebElement inputElement : div2Element.findElements(By.tagName("input"))) {
                    if (!inputElement.getAttribute("id").contains("firstName")) continue;
                    TextFieldsControl.enterText(inputElement, randomName);
                    break;
                }
            }
        }
    }

    public UsersPage addNewUser(String lName, String telegram, String symphony) {
        this.enterFirstName();
        TextFieldsControl.enterText(lastName, lName);
        TextFieldsControl.enterText(email, randomEmail);
        TextFieldsControl.enterText(telegramId, telegram);
        TextFieldsControl.enterText(symphonyId, symphony);
        ButtonControl.clickButton(createUserButton);
        WebWaits.waitForNoOfSeconds(1);
        return this;
    }

    public boolean validateUser(String message) {
        WebWaits.waitForElement(alert);
        return alert.getText().contains(message);
    }

    public boolean validateNewUser() {
        for (WebElement tableRowElement : usersTable.findElements(By.tagName("tr"))) {
            for (WebElement tableDataElement : tableRowElement.findElements(By.tagName("td"))) {
                if (!tableDataElement.getText().equalsIgnoreCase(randomEmail)) continue;
                return true;
            }
        }
        return false;
    }

    private void clickDeleteButton() {
        WebWaits.waitForNoOfSeconds(1);
        for (WebElement rowElement : usersTable.findElements(By.tagName("tr"))) {
            for (WebElement dataElement : rowElement.findElements(By.tagName("td"))) {
                for (WebElement buttonElement : dataElement.findElements(By.tagName("button"))) {
                    if (!buttonElement.getAttribute("id").contains("btnDelete")) continue;
                    ButtonControl.clickButton(buttonElement);
                    break;
                }
            }
        }
    }

    private void editUser() {
        //#btnEdit6 > i
        WebWaits.waitForNoOfSeconds(1);
        for (WebElement rowElement : usersTable.findElements(By.tagName("tr"))) {
            for (WebElement dataElement : rowElement.findElements(By.tagName("td"))) {
                for (WebElement buttonElement : dataElement.findElements(By.tagName("button"))) {
                    if (!buttonElement.getAttribute("id").contains("btnEdit")) continue;
                    ButtonControl.clickButton(buttonElement);
                    break;
                }
            }
        }
    }

    public AlertsAndPopovers deleteNewUser() {
        WebWaits.waitForNoOfSeconds(5);
        TextFieldsControl.enterText(searchField, randomName);
        this.clickDeleteButton();
        return PageFactory.initElements(webDriver, AlertsAndPopovers.class);
    }

    public boolean validateUpdatedUser(String message) {
        WebWaits.waitForElement(alert);
        //WebWaits.waitForNoOfSeconds(2);
        return alert.getText().contains(message);
    }

    public UsersPage markUserAsApersonnel(String searchText) {
        WebWaits.waitForNoOfSeconds(5);
        TextFieldsControl.enterText(searchField, searchText);
        this.editUser();
        return this;
    }

    public UsersPage markUserAsAdmin() {
        //this.markUserAsApersonnel("tester13");
        JavaScriptControl.scrollToViewScript(admin);
        RadioControl.clickButton(admin);
        ButtonControl.clickButton(updateUser);
        WebWaits.waitForNoOfSeconds(5);
        return this;
    }

    public UsersPage markUserAsMarketMaker() {
        //this.markUserAsApersonnel("tester13");
        JavaScriptControl.scrollToViewScript(marketMaster);
        RadioControl.clickButton(marketMaster);
        WebWaits.waitForNoOfSeconds(5);
        ButtonControl.clickButton(updateUser);
        return this;
    }

    public UsersPage markUserAsTrader() {
        //this.markUserAsApersonnel("tester13");
        RadioControl.clickButton(trader);
        WebWaits.waitForNoOfSeconds(2);
        RadioControl.clickButton(enableTelegramChannel);
        TextFieldsControl.enterText(telegramId,"998997995");
        ButtonControl.clickButton(updateUser);
        return this;
    }

    public UsersPage filterUsersEntries(){
        DropDownControl.selectDropDownByVisibleText(userEntries, "All");
        WebWaits.waitForNoOfSeconds(1);
        DropDownControl.selectDropDownByVisibleText(userEntries, "10");
        return this;
    }

    public boolean verifyUserPreferences() {
        WebWaits.waitForElement(userPreferences);
        return userPreferences.getText().contains("User Preferences");
    }

    public UsersPage selectPreferredChannel(String preChannel, String channel) {
        //DropDownControl.selectDropDownByVisibleText(preferredChannel,"Symphony");
        for (WebElement divElement : preferredChannel.findElements(By.tagName("div"))) {
            for(WebElement buttonElement : divElement.findElements(By.tagName("button"))) {
                if (!buttonElement.getAttribute("title").contains(preChannel)) continue;
                JavaScriptControl.scrollToViewScript(buttonElement);
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

        ButtonControl.clickButton(updateUser);
        return PageFactory.initElements(webDriver, UsersPage.class);
    }

    public UsersPage selectPreferredChannelToDefault() {
        JavaScriptControl.scrollToViewScript(lastName);
//        for (WebElement divElement : preferredChannel.findElements(By.tagName("div"))) {
//            for(WebElement buttonElement : divElement.findElements(By.tagName("button"))) {
//                if (!buttonElement.getAttribute("title").contains(preChannel)) continue;
//                ClickControl.click(buttonElement);
//                break;
//            }
//        }
//        List<WebElement> list = webDriver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']//li//a//span"));
//        for(WebElement option : list){
//            if(option.getAttribute("innerHTML").contains(channel)){
//                ClickControl.click(option);
//            }
//        }
        RadioControl.clickButton(enableTelegramChannel);
        ButtonControl.clickButton(updateUser);
        return PageFactory.initElements(webDriver, UsersPage.class);
    }

    //user preference

    public boolean validateUserPreferenceMessage(String message) {
        // WebWaits.waitForElement(alert);
        WebWaits.waitForNoOfSeconds(5);
        //System.out.println(alert.getText());
        return alert.getText().contains(message);
    }

    public UsersPage enableReceiveSecurityBTC() {
        WebWaits.waitForNoOfSeconds(5);
        JavaScriptControl.scrollToViewScript(btcSecurity);
        ClickControl.click(btcSecurity);
        /*JavaScriptControl.scrollDownScript(2500);
        CheckBoxControl.tickCheckBox(btcSecurity);*/
        return this;
    }

    public boolean validateBTCQuoteExpiry() {
        WebWaits.waitForNoOfSeconds(2);
        return quoteExpiry.getAttribute("value").contains("60");
    }

    /*public boolean validateBTCMinPrice() {
        WebWaits.waitForNoOfSeconds(2);
        return minPriceBTC.getAttribute("data-evt").contains("5000");
    }*/

   /* public boolean validateBTCMaxPrice() {
        WebWaits.waitForNoOfSeconds(2);
        return maxPriceBTC.getAttribute("value").contains("999999");
    }*/

    public UsersPage enterQuoteExpiryBTC() {
        WebWaits.waitForNoOfSeconds(1);
        TextFieldsControl.enterText(quoteExpiry,"45");
        ClickControl.enter(quoteExpiry);
        return this;
    }

    public UsersPage enterMinPriceBTC() {
        WebWaits.waitForNoOfSeconds(1);
        TextFieldsControl.enterText(minPriceBTC,"500");
        return this;
    }

    public UsersPage enterMaxPriceBTC() {
        WebWaits.waitForNoOfSeconds(1);
        TextFieldsControl.enterText(maxPriceBTC,"10000");
        ClickControl.enter(maxPriceBTC);
        return this;
    }

    public UsersPage enableReceiveSecurityETH() {
        WebWaits.waitForNoOfSeconds(1);
        JavaScriptControl.scrollDownScript(3500);
        CheckBoxControl.tickCheckBox(ethSecurity);
        return this;
    }

    public boolean validateETHQuoteExpiry() {
        WebWaits.waitForNoOfSeconds(1);
        return quoteExpiryETH.getAttribute("value").contains("60");
    }

    /*public boolean validateETHMinPrice() {
        WebWaits.waitForNoOfSeconds(1);
        return minPriceETH.getAttribute("data-evt").contains("500");
    }

    public boolean validateETHMaxPrice() {
        WebWaits.waitForNoOfSeconds(1);
        return maxPriceETH.getAttribute("value").contains("999");}*/

    public UsersPage enterQuoteExpiryETH() {
        WebWaits.waitForNoOfSeconds(1);
        TextFieldsControl.enterText(quoteExpiryETH,"55");
        return this;
    }

    public UsersPage enterMinPriceETH() {
        WebWaits.waitForNoOfSeconds(2);
        TextFieldsControl.enterText(minPriceETH,"10");
        return this;
    }

    public UsersPage enterMaxPriceETH() {
        WebWaits.waitForNoOfSeconds(2);
        TextFieldsControl.enterText(maxPriceETH,"9999");
        ClickControl.enter(maxPriceETH);
        return this;
    }

    public UsersPage enterInvalidQuoteExpiryBTC() {
        WebWaits.waitForNoOfSeconds(1);
        TextFieldsControl.enterText(quoteExpiry,"25");
        return this;}

    public boolean validateQuoteExpiryMessage(String expiryMessage) {
        WebWaits.waitForElement(dangerAlert);
        return dangerAlert.getText().contains(expiryMessage);
    }

    public UsersPage enterInvalidQuoteExpiryETH() {
        WebWaits.waitForNoOfSeconds(1);
        TextFieldsControl.enterText(quoteExpiryETH,"25");
        return this;
    }

    /*public UsersPage enterInvalidMinPriceBTC() {
        WebWaits.waitForNoOfSeconds(1);
        TextFieldsControl.enterText(minPriceBTC,"7001");
        ClickControl.enter(minPriceBTC);
        return this;
    }

    public UsersPage enterInvalidMaxPriceBTC() {
        WebWaits.waitForNoOfSeconds(1);
        TextFieldsControl.enterText(maxPriceBTC,"6999");
        ClickControl.enter(maxPriceBTC);
        return this;
    }

    public UsersPage enterInvalidMinPriceETH() {
        WebWaits.waitForNoOfSeconds(1);
        TextFieldsControl.enterText(minPriceETH,"11");
        ClickControl.enter(minPriceETH);
        return this;
    }

    public UsersPage enterInvalidMaxPriceETH() {
        WebWaits.waitForNoOfSeconds(1);
        TextFieldsControl.enterText(maxPriceETH,"100");
        ClickControl.enter(maxPriceETH);
        return this;
    }*/

    public UsersPage disableBTCSecurity() {
        WebWaits.waitForNoOfSeconds(1);
        JavaScriptControl.scrollDownScript(3200);
        CheckBoxControl.untickCheckBox(btcSecurity);
        WebWaits.waitForNoOfSeconds(1);
        return this;
    }

    public UsersPage disableETHSecurity() {
        WebWaits.waitForNoOfSeconds(1);
        JavaScriptControl.scrollDownScript(4200);
        CheckBoxControl.untickCheckBox(ethSecurity);
        WebWaits.waitForNoOfSeconds(1);
        return this;
    }

    public boolean isBTCFieldEnabled() {
        BaseControl.isElementNotDisplayedAndPresent(quoteExpiry);
        BaseControl.isElementNotDisplayedAndPresent(minPriceBTC);
        BaseControl.isElementNotDisplayedAndPresent(maxPriceBTC);
        return true;
    }

    public boolean isETHFieldEnabled() {
        BaseControl.isElementNotDisplayedAndPresent(quoteExpiryETH);
        BaseControl.isElementNotDisplayedAndPresent(minPriceETH);
        BaseControl.isElementNotDisplayedAndPresent(maxPriceETH);
        return true;
    }

    public UsersPage clickTelegramToolTip() {
        WebElement telegramTooltip = userForm.findElement(By.cssSelector("div:nth-child(9) > div:nth-child(3) > button"));
        ClickControl.click(telegramTooltip);
        return this;
    }

    public boolean verifyTelegramTooltip(String message) {
        WebElement tooltipMessage = webDriver.findElement(By.cssSelector("#telegramInfoModal > div:nth-child(1) > div:nth-child(1) > div:nth-child(2)"));
        if(tooltipMessage.getText().contains(message)){
            return true;
        }
        return false;
    }

    public void closeToolTip() {
        WebElement closeButton = webDriver.findElement(By.cssSelector("#telegramInfoModal > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > button"));
        ClickControl.click(closeButton);
    }

    public void scrollUp() {
        JavaScriptControl.scrollUpScript(3000);
    }

    public UsersPage enterChannelsId(String telegram) {
        RadioControl.clickButton(enableTelegramChannel);
        TextFieldsControl.enterText(telegramId,telegram);
        //TextFieldsControl.enterText(symphonyId,symphony);
        //TextFieldsControl.enterText(fixId,fix);
        ClickControl.click(updateUser);
        return this;
    }

    public boolean validateDuplicationText(String message) {
        WebWaits.waitForNoOfSeconds(2);
        return dangerAlert.getText().contains(message);
    }

    public UsersPage disableMMAndAdminChannel() {
        RadioControl.clickButton(marketMaster);
        RadioControl.clickButton(admin);
        return  this;
    }

    public UsersPage editUserAsTraderToUseOTCScreen() {
        RadioControl.clickButton(trader);
        WebWaits.waitForNoOfSeconds(2);
        ClickControl.click(enableTelegramChannel);
        ClickControl.click(enablePortalChannel);
        ButtonControl.clickButton(updateUser);
        return this;
    }

    public UsersPage clickChannelsTooltip() {
        ClickControl.click((channeltip));
        return this;
    }

    public boolean validateChannelCombination(String header, String text) {
        if((channelComboHeader.getText().contains(header)) &&
                channelComboText.getText().contains(text)){
            return true;
        }
        return false;
    }

    public UsersPage closeChannelComboModal() {
        ClickControl.click(closeChannelCombo);
        return this;
    }

    public UsersPage notValidComboChannels() {
        ClickControl.click(enableSymphony);
        return this;
    }

    public UsersPage channelTelegramPortalNotEnabled() {
        BaseControl.isElementDisabled(enableTelegramChannel);
        BaseControl.isElementDisabled(enablePortalChannel);
        return this;
    }

    public UsersPage clickUpdatingUser() {
        ButtonControl.clickButton(updateUser);
        return this;
    }

    public UsersPage editUserAsMMToUseOTCScreen() {
        RadioControl.clickButton(marketMaster);
        WebWaits.waitForNoOfSeconds(2);
        ClickControl.click(enablePortalChannel);
        return this;
    }

    public boolean validateOTCChannelForMM(String message) {
        if(infoAlert.getText().contains(message)){
            return true;
        }
        return false;
    }
}
