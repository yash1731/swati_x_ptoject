package com.aixtrade.pages;

import com.aixtrade.waits.WebWaits;
import com.aixtrade.webControls.ClickControl;
import com.aixtrade.webControls.JavaScriptControl;
import com.aixtrade.webControls.TextFieldsControl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InstrumentsPage extends BasePage{

    @FindBy(id = "instrumentsTable")
    private WebElement instrumentsTable = null;
    @FindBy(id = "addEditInstrumentTab")
    private WebElement addInstrumentsTab = null;
    @FindBy(id = "addEditInstrument")
    private  WebElement addEditInstrumentButton = null;
    @FindBy(css = "div.mb-2:nth-child(1) > div:nth-child(3)")
    private WebElement symbolValidation = null;
    @FindBy(css = "div.form-group:nth-child(3) > div:nth-child(3)")
    private WebElement securityTypeValidation = null;
    @FindBy(css = "div.row:nth-child(8) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3)")
    private WebElement baseCurrencyValidation = null;
    @FindBy(css = "div.row:nth-child(9) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3)")
    private WebElement settlementCurrencyValidation = null;
    @FindBy(css = "div.row:nth-child(9) > div:nth-child(1) > div:nth-child(3) > div:nth-child(3)")
    private WebElement settlementCurrencySignValidation = null;
    @FindBy(css = "div.row:nth-child(11) > div:nth-child(1) > div:nth-child(3) > div:nth-child(3)")
    private WebElement instrumentNLUValidation = null;
    @FindBy(id="symbol")
    private WebElement symbolField = null;
    @FindBy(id = "description")
    private WebElement descriptionField = null;
    @FindBy(id = "instrumentForm")
    private WebElement instrumentForm = null;
    @FindBy(id = "baseCurrencyCurrency")
    private WebElement baseCurrencyField = null;
    @FindBy(id = "bookVolumePrecision")
    private WebElement volumePrecision = null;
    @FindBy(id = "bookPricePrecision")
    private WebElement pricePrecision = null;
    @FindBy(css = ".select2-search__field")
    private WebElement nluSynonymsField = null;
    @FindBy(css = "div.row:nth-child(7) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > button:nth-child(2)")
    private  WebElement assetType = null;
    @FindBy(css = ".settlement-currency > div:nth-child(1) > button:nth-child(2)")
    private WebElement settlementCurrency = null;
    @FindBy(css = ".settlement-currencySign > div:nth-child(1) > button:nth-child(2)")
    private WebElement settlementCurrencySign = null;
    @FindBy(css=".tabulator-col:nth-child(2) .form-control")
    private WebElement filterBySymbol = null;
    @FindBy(css = ".fa-edit")
    private WebElement editButton = null;
    @FindBy(id = "instrumentListTab")
    private WebElement viewInstrumentsTab = null;
    @FindBy(css = "div.row:nth-child(7) > div:nth-child(2) > label:nth-child(1) > span:nth-child(2)")
    private WebElement enableTest = null;
    @FindBy(id = "mockOpen")
    private WebElement mockOpen = null;
    @FindBy(id = "mockLow")
    private WebElement mockLow = null;
    @FindBy(id = "mockHigh")
    private WebElement mockHigh = null;
    @FindBy(id = "mockSource")
    private WebElement mockSource = null;
    @FindBy(id = "mockSourceUrl")
    private WebElement mockURL = null;
    @FindBy(xpath = "//button[starts-with(@id,'btnDeleteInstrument')]")
    private WebElement deleteInstrument = null;


    public InstrumentsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean viewInstrumentsList() {
        WebWaits.waitForNoOfSeconds(1);
        List<WebElement> column = instrumentsTable.findElements(By.cssSelector("div.tabulator-col > div > div"));
        for (int j = 0; j < column.size(); j++) {
            return value.add(column.get(j).getText());
        }
        return false;
    }

    public void createAnInstrument() {
        ClickControl.click(addInstrumentsTab);
    }

    public void viewAnInstrument() {
        WebWaits.waitForNoOfSeconds(3);
        JavaScriptControl.scrollUpScript();
        ClickControl.click(viewInstrumentsTab);
    }

    public InstrumentsPage clickAddUpdateInstrumentButton(String value) {
        WebElement addUpdateButton = addEditInstrumentButton.findElement(By.cssSelector("div:nth-child(1) > div:nth-child(2)"));
        for(WebElement button : addUpdateButton.findElements(By.tagName("button"))){
            if(!button.getText().contains(value)) continue;
            ClickControl.click(button);
            WebWaits.waitForNoOfSeconds(2);
            break;
        }
        return this;
    }

    public boolean viewInstrumentsValidation(String instrumentErrorMessage, String symbol,
                                             String securityType,
                                             String baseCurrency, String settlementCurrency,
                                             String settlementCurrencySign, String instrumentNLU) {
        WebWaits.waitForNoOfSeconds(2);
        if((dangerAlert.getText().contains(instrumentErrorMessage))
                && (symbolValidation.getText().contains(symbol))
        && (securityTypeValidation.getText().contains(securityType))
                && (baseCurrencyValidation.getText().contains(baseCurrency))
        && (settlementCurrencyValidation.getText().contains(settlementCurrency))
                && (settlementCurrencySignValidation.getText().contains(settlementCurrencySign))
        && (instrumentNLUValidation.getText().contains(instrumentNLU))) {
            return true;
        }
        return false;
    }

    private  void selectDropDownOption(String value) {
        List<WebElement> list = webDriver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']//li//a//span"));
        for (WebElement option : list) {
            if (option.getAttribute("innerHTML").contains(value)) {
                ClickControl.click(option);
            }
        }
    }

    private InstrumentsPage selectSecurityType(String value1){
        WebElement divElement = instrumentForm.findElement(By.cssSelector("div.form-group:nth-child(3) > div > div"));
        for(WebElement buttonElement : divElement.findElements(By.tagName("button"))){
                        if (!buttonElement.getAttribute("title").contains(value1)) continue;
                        ClickControl.click(buttonElement);
                        break;
        }
        return this;
    }


    private InstrumentsPage selectAssetType(String value1){
        ClickControl.click(assetType);
        return this;
    }

    private InstrumentsPage selectSettlementCurrency(String value1){
        ClickControl.click(settlementCurrency);
        return this;
    }

    private InstrumentsPage selectSettlementCurrencySign(String value1)  {
        ClickControl.click(settlementCurrencySign);
        return this;
    }

    public InstrumentsPage selectSecurityTypeOption(String value1,String value2){
        WebWaits.waitForNoOfSeconds(1);
        this.selectSecurityType(value1);
        this.selectDropDownOption(value2);
        return this;
    }

    public InstrumentsPage selectAssetTypeOption(String value1,String value2){
        this.selectAssetType(value1);
        this.selectDropDownOption(value2);
        return this;
    }

    public InstrumentsPage selectSettlementCurrencyOption(String value1,String value2){
        this.selectSettlementCurrency(value1);
        this.selectDropDownOption(value2);
        return this;
    }

    public InstrumentsPage selectSettlementCurrencySignOption(String value1,String value2)  {
        this.selectSettlementCurrencySign(value1);
        this.selectDropDownOption(value2);
        return this;
    }

    public InstrumentsPage fillInstrumentForm(String symbol, String description, String securityTypeHeader,
                                              String securityType, String baseCurrency, String assetTypeHeader,
                                              String assetType,String settlementCurrencyHeader,
                                              String settlementCurrency, String settlementCurrencySignHeader,
                                              String settlementCurrencySign,
                                              String volumePrecision1, String pricePrecision1,
                                              String nluSynonyms, String addButton)  {
        TextFieldsControl.enterText(symbolField,symbol);
        TextFieldsControl.enterText(descriptionField,description);
        this.selectSecurityTypeOption(securityTypeHeader,securityType);
        TextFieldsControl.enterText(baseCurrencyField,baseCurrency);
        JavaScriptControl.scrollDownScript();
        this.selectAssetTypeOption(assetTypeHeader,assetType);
        this.selectSettlementCurrencyOption(settlementCurrencyHeader,settlementCurrency);
        this.selectSettlementCurrencySignOption(settlementCurrencySignHeader,settlementCurrencySign);
        TextFieldsControl.enterText(volumePrecision,volumePrecision1);
        TextFieldsControl.enterText(pricePrecision,pricePrecision1);
        TextFieldsControl.enterText(nluSynonymsField,nluSynonyms);
        TextFieldsControl.enterText(nluSynonymsField,String.valueOf(Keys.ARROW_DOWN));
        TextFieldsControl.enterText(nluSynonymsField,String.valueOf(Keys.ENTER));
        JavaScriptControl.scrollToViewScript(addInstrumentsTab);
        this.clickAddUpdateInstrumentButton(addButton);
        return this;
    }

    public void filterSymbol(String symbol) {
        TextFieldsControl.enterText(filterBySymbol,symbol);
    }

    public void clickEditButton() {
        WebWaits.waitForNoOfSeconds(2);
        ClickControl.click(editButton);

    }

    public InstrumentsPage fillBookPrecision(String volumePrecision2, String pricePrecision2) {
        JavaScriptControl.scrollDownScript();
        TextFieldsControl.enterText(volumePrecision,volumePrecision2);
        TextFieldsControl.enterText(pricePrecision,pricePrecision2);
        WebWaits.waitForNoOfSeconds(2);
        JavaScriptControl.scrollToViewScript(addInstrumentsTab);
        return this;
    }

    public boolean validateBookPrecesinError(String bookError) {
        WebWaits.waitForNoOfSeconds(3);
       WebWaits.waitForElement(dangerAlert);
        return dangerAlert.getText().contains(bookError);
    }

    public void enableTestField() {
        JavaScriptControl.scrollToViewScript(addInstrumentsTab);
        ClickControl.click(enableTest);
        WebWaits.waitForNoOfSeconds(1);
        JavaScriptControl.scrollDownScript();
    }

    public InstrumentsPage fillMockDetails(String open, String low, String high, String source, String url) {
        TextFieldsControl.enterText(mockOpen,open);
        TextFieldsControl.enterText(mockLow,low);
        TextFieldsControl.enterText(mockHigh,high);
        TextFieldsControl.enterText(mockSource,source);
        TextFieldsControl.enterText(mockURL,url);
        JavaScriptControl.scrollToViewScript(addInstrumentsTab);
        return this;
    }

    public boolean validateInstrumentSavedDeleteMessage(String message) {
        WebWaits.waitForElement(alert);
        return  alert.getText().contains(message);
    }

    public Popovers clickDeleteButton(String value) {
        WebWaits.waitForNoOfSeconds(3);
       ClickControl.click(deleteInstrument);
        return PageFactory.initElements(webDriver, Popovers.class);
    }
}
