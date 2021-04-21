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

public class CloneDocumentTypeSteps {

    private WorldHelper helper;
    private DocumentTypesPage documentTypesPage;
    private Popovers popovers;

    public CloneDocumentTypeSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @And("^I have created a new document Type for a specified country$")
    public void iHaveCreatedANewDocumentTypeForASpecifiedCountry() {
        String country = TestData.getValue("preferred country");
        //String code = TestData.getValue("document code");
        String description = TestData.getValue("document description");
        documentTypesPage = helper.getDocumentTypesPage().selectCountry(country).fillAllFields(description).clickAddNewButton();
    }

    @When("^I select an \"([^\"]*)\" to copy document Type into$")
    public void iSelectAnToCopyDocumentTypeInto(String exportCountry) throws Throwable {
        exportCountry = TestData.getValue(exportCountry);
        documentTypesPage.selectExportCountry(exportCountry);
    }

    @When("^I click on the copy button$")
    public void iClickOnTheCopyButton() throws Throwable {
        popovers = documentTypesPage.copyExportCountry();
    }

    @When("^I confirm 'Copy Document Types'$")
    public void iConfirmCopyDocumentTypes() throws Throwable {
        popovers.completeAction();
    }

    @Then("^I should be able to see a success message - \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeASuccessMessage(String cloneMessage) throws Throwable {
        cloneMessage = TestData.getValue(cloneMessage);
        Assert.assertTrue(helper.getDocumentTypesPage().validateCreateDocMessage(cloneMessage));
    }

    @When("^I select to delete the document Type$")
    public void iSelectToDeleteTheDocumentType() {
        popovers = helper.getDocumentTypesPage().clickDeleteButton();
    }

    @Then("^I should be able to successfully delete document type$")
    public void iShouldBeAbleToSuccessfullyDeleteDocumentType() {
        popovers.completeAction();
    }

    @When("^I select the \"([^\"]*)\"$")
    public void iSelectThe(String exportCountry) throws Throwable {
        exportCountry = TestData.getValue(exportCountry);
        documentTypesPage = helper.getDocumentTypesPage().selectCountry(exportCountry);
    }

    @Then("^I should be able to see cloned documents displayed for the country as below:$")
    public void iShouldBeAbleToSeeClonedDocumentsDisplayedForTheCountryAsBelow(DataTable dataTable) throws Throwable {
        List<List<String>> fieldOption = dataTable.raw();
       // String updatedCode = TestData.getValue(fieldOption.get(1).get(1));
        String updatedDescription = TestData.getValue(fieldOption.get(1).get(1));
       // Assert.assertTrue(documentTypesPage.validateDocumentCode());
        Assert.assertTrue(documentTypesPage.validateDocumentType(updatedDescription));
    }

    @When("^I select to delete the document Type for the export country$")
    public void iSelectToDeleteTheDocumentTypeForTheExportCountry() {
        popovers = helper.getDocumentTypesPage().clickDeleteButton();
    }
}
