package com.aixtrade.steps;

import com.aixtrade.pages.DocumentTypesPage;
import com.aixtrade.pages.Popovers;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

public class CreateNewDocumentTypeSteps {

    private WorldHelper helper;
    private DocumentTypesPage documentTypesPage;
    private Popovers popovers;

    public CreateNewDocumentTypeSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I select country and add the values to the fields as below:$")
    public void iSelectCountryAndAddTheValuesToTheFieldsAsBelow(DataTable dataTable) {
        List<List<String>> fieldOption = dataTable.raw();
        String country = TestData.getValue(fieldOption.get(1).get(1));
        //String code = TestData.getValue(fieldOption.get(2).get(1));
        String description = TestData.getValue(fieldOption.get(3).get(1));
        documentTypesPage = helper.getDocumentTypesPage().selectCountry(country).fillAllFields(description);
    }

    @When("^I click the Add New button$")
    public void iClickTheAddNewButton() throws Throwable {
        documentTypesPage.clickAddNewButton();
    }

    @Then("^I should be able to add new document Type on the Document Type table as below:$")
    public void iShouldBeAbleToAddNewDocumentTypeOnTheDocumentTypeTableAsBelow(DataTable dataTable) {
        List<List<String>> fieldOption = dataTable.raw();
        //String code = TestData.getValue(fieldOption.get(1).get(1));
        String description = TestData.getValue(fieldOption.get(1).get(1));
        Assert.assertNotNull(documentTypesPage.validateDocumentCode());
        Assert.assertTrue(documentTypesPage.validateDocumentCode());
        Assert.assertTrue(documentTypesPage.validateDocumentType(description));
    }

    @Then("^I should be able to see a \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeA(String createMessage) throws Throwable {
        createMessage = TestData.getValue(createMessage);
        Assert.assertTrue(documentTypesPage.validateCreateDocMessage(createMessage));
    }

    @When("^I edit the document$")
    public void iEditTheDocument() {
        documentTypesPage.editDocumentType();
    }

    @And("^I make changes to the below:$")
    public void iMakeChangesToTheBelow(DataTable dataTable) {
        List<List<String>> fieldOption = dataTable.raw();
        //String code = TestData.getValue(fieldOption.get(1).get(1));
        String description = TestData.getValue(fieldOption.get(1).get(1));
        documentTypesPage.fillAllFields(description);
    }

    @When("^I click on the update button$")
    public void iClickOnTheUpdateButton() throws Throwable {
        documentTypesPage.clickUpdateButton();
    }

    @Then("^document type is updated with the changes made as below:$")
    public void documentTypeIsUpdatedWithTheChangesMadeAsBelow(DataTable dataTable) {
        List<List<String>> fieldOption = dataTable.raw();
        //String updatedCode = TestData.getValue(fieldOption.get(1).get(1));
        String updatedDescription = TestData.getValue(fieldOption.get(1).get(1));
        //Assert.assertTrue(documentTypesPage.validateDocumentType(updatedCode));
        Assert.assertTrue(documentTypesPage.validateDocumentType(updatedDescription));

    }

    @Then("^I should be able to see an \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeAn(String updateMessage) throws Throwable {
        updateMessage = TestData.getValue(updateMessage);
        Assert.assertTrue(documentTypesPage.validateCreateDocMessage(updateMessage));
    }

    @When("^I select to delete document Type$")
    public void iSelectToDeleteDocumentType() {
        popovers = documentTypesPage.clickDeleteButton();
    }

    @When("^I confirm deletion$")
    public void iConfirmDeletion() throws Throwable {
        popovers.completeAction();
    }

    @Then("^I should be able to delete document type successfully with a \"([^\"]*)\" displayed$")
    public void iShouldBeAbleToDeleteDocumentTypeSuccessfullyWithADisplayed(String deleteMessage) throws Throwable {
        deleteMessage = TestData.getValue(deleteMessage);
        Assert.assertTrue(documentTypesPage.validateCreateDocMessage(deleteMessage));
    }
}
