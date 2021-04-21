package com.aixtrade.steps;

import com.aixtrade.pages.InstrumentsPage;
import com.aixtrade.pages.Popovers;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AddUpdateDeleteInstrumentsSteps {

    private WorldHelper helper;
    private InstrumentsPage instrumentsPage;
    private Popovers popovers;

    public AddUpdateDeleteInstrumentsSteps(WorldHelper helper) {
        this.helper = helper;
    }


    @Given("^I am on Instruments page$")
    public void iAmOnInstrumentsPage() throws Throwable {
        String username = TestData.getValue("admin email");
        String password = TestData.getValue("admin password");
        instrumentsPage = helper.getBasePage().loginWith(username, password).goToInstrumentsPage();
    }

    @Then("^I can view Instruments list$")
    public void iCanViewInstrumentsList() throws Throwable {
        Assert.assertNotNull(instrumentsPage.viewInstrumentsList());
        Assert.assertTrue(instrumentsPage.viewInstrumentsList());
    }

    @When("^I click on add Instruments tab$")
    public void iClickOnAddInstrumentsTab() throws Throwable {
       instrumentsPage.createAnInstrument();
    }

    @When("^I click on 'Add' button on Add Instruments page$")
    public void iClickOnAddButtonOnAddInstrumentsPage() throws Throwable {
        String addButton = TestData.getValue("add instrument");
      instrumentsPage.clickAddUpdateInstrumentButton(addButton);
    }

    @Then("^I can view validations for mandatory fields$")
    public void iCanViewValidationsForMandatoryFields() throws Throwable {
       String instrumentErrorMessage = TestData.getValue("instrument error");
        String symbol = TestData.getValue("instrument symbolValid");
        String securityType = TestData.getValue("instrument securityTypeValid");
        String baseCurrency = TestData.getValue("instrument baseCurrencyValid");
        String settlementCurrency = TestData.getValue("instrument settlementCurrencyValid");
        String settlementCurrencySign = TestData.getValue("instrument settlementCurrencySignValid");
        String instrumentNLU = TestData.getValue("instrument nluValid");
       Assert.assertFalse(instrumentsPage.viewInstrumentsValidation(instrumentErrorMessage,symbol,
               securityType,baseCurrency,settlementCurrency,settlementCurrencySign,instrumentNLU));
    }

    @When("^I enter all the fields to create Instrument$")
    public void iEnterAllTheFieldsToCreateInstrument(DataTable dataTable) throws Throwable {
        List<List<String>> fieldOption = dataTable.raw();
        String symbol = TestData.getValue(fieldOption.get(1).get(1));
        String description = TestData.getValue(fieldOption.get(2).get(1));
        String securityHeader = TestData.getValue("security header");
        String securityType = TestData.getValue(fieldOption.get(3).get(1));
        String baseCurrency = TestData.getValue(fieldOption.get(4).get(1));
        String assetHeader = TestData.getValue("asset header");
        String assetType = TestData.getValue(fieldOption.get(5).get(1));
        String settlementCurrencyHeader = TestData.getValue("settlementCurrency header");
        String settlementCurrency = TestData.getValue(fieldOption.get(6).get(1));
        String settlementCurrencySignHeader = TestData.getValue("settlementCurrencySign header");
        String settlementCurrencySign = TestData.getValue(fieldOption.get(7).get(1));
        String volumePrecision1 = TestData.getValue(fieldOption.get(8).get(1));
        String pricePrecision1 = TestData.getValue(fieldOption.get(9).get(1));
        String nluSynonyms = TestData.getValue(fieldOption.get(10).get(1));
        String addButton = TestData.getValue("add instrument");
        instrumentsPage = helper.getInstrumentsPage().fillInstrumentForm(symbol,description,
                securityHeader, securityType, baseCurrency,assetHeader,assetType,
                settlementCurrencyHeader,settlementCurrency,settlementCurrencySignHeader,
                settlementCurrencySign,volumePrecision1, pricePrecision1,nluSynonyms,addButton);

    }

    @When("^I filter \"([^\"]*)\" on View Instruments list$")
    public void iFilterOnViewInstrumentsList(String symbol) throws Throwable {
        symbol = TestData.getValue("instrument symbol");
         instrumentsPage.filterSymbol(symbol);
    }

    @When("^I click on edit an Instrument$")
    public void iClickOnEditAnInstrument() throws Throwable {
        instrumentsPage.clickEditButton();
    }

    @When("^I update the fields in the instruments form$")
    public void iUpdateTheFieldsInTheInstrumentsForm(DataTable dataTable) throws Throwable {
        List<List<String>> fieldOption = dataTable.raw();
        String volumePrecision2 = TestData.getValue(fieldOption.get(1).get(1));
        String pricePrecision2 = TestData.getValue(fieldOption.get(2).get(1));
        instrumentsPage = helper.getInstrumentsPage().fillBookPrecision(volumePrecision2,pricePrecision2);
    }


    @Then("^Volume and Price Precision validation is thrown$")
    public void volumeAndPricePrecisionValidationIsThrown() throws Throwable {
        String bookError = TestData.getValue("book precision");
     Assert.assertTrue(helper.getInstrumentsPage().validateBookPrecesinError(bookError));
    }

    @Then("^I update the fields in the instruments form with valid values$")
    public void iUpdateTheFieldsInTheInstrumentsFormWithValidValues(DataTable dataTable) throws Throwable {
        List<List<String>> fieldOption = dataTable.raw();
        String volumePrecision3 = TestData.getValue(fieldOption.get(1).get(1));
        String pricePrecision3 = TestData.getValue(fieldOption.get(2).get(1));
        instrumentsPage = helper.getInstrumentsPage().fillBookPrecision(volumePrecision3,pricePrecision3);
    }


    @Then("^I enable the instrument and test fields$")
    public void iEnableTheInstrumentAndTestFields() throws Throwable {
        instrumentsPage.enableTestField();
    }

    @Then("^I enter the mock fields$")
    public void iEnterTheMockFields(DataTable dataTable) throws Throwable {
        List<List<String>> fieldOption = dataTable.raw();
        String open = TestData.getValue(fieldOption.get(1).get(1));
        String low = TestData.getValue(fieldOption.get(2).get(1));
        String high = TestData.getValue(fieldOption.get(2).get(1));
        String source = TestData.getValue(fieldOption.get(2).get(1));
        String url = TestData.getValue(fieldOption.get(2).get(1));
        instrumentsPage = helper.getInstrumentsPage().fillMockDetails(open,low,high,source,url);


    }

    @Then("^I click on 'Update' button on Add Instruments page$")
    public void iClickOnUpdateButtonOnAddInstrumentsPage() throws Throwable {
        String updateButton = TestData.getValue("update instrument");
        instrumentsPage.clickAddUpdateInstrumentButton(updateButton);
    }

    @Then("^I can view \"([^\"]*)\" message$")
    public void iCanViewMessage(String message) throws Throwable {
       Assert.assertTrue(helper.getInstrumentsPage().validateInstrumentSavedDeleteMessage(message));
    }

    @When("^I click on Instruments tab$")
    public void iClickOnInstrumentsTab() throws Throwable {
       helper.getInstrumentsPage().viewAnInstrument();
    }

    @Then("^I click on Delete an Instrument button$")
    public void iClickOnDeleteAnInstrumentButton() throws Throwable {
        String delete = TestData.getValue("delete instrument");
       popovers = helper.getInstrumentsPage().clickDeleteButton(delete).completeAction();
    }

}
