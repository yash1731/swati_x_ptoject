package com.aixtrade.steps;

import com.aixtrade.pages.ApplicationsPage;
import com.aixtrade.support.WorldHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UploadDocumentsForAnApplicationSteps {

    private WorldHelper helper;
    private ApplicationsPage applicationsPage;

    public UploadDocumentsForAnApplicationSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I select the Additional Documents page$")
    public void iSelectTheAdditionalDocumentsPage() throws Throwable {
        applicationsPage = helper.getApplicationsPage().clickAdditionalDocsTab();
    }

    @Then("^I should be able to see 'Add Documents' button$")
    public void iShouldBeAbleToSeeAddDocumentsButton() throws Throwable {
        applicationsPage.verifyAdditionalDocsButton();
    }

    @When("^I select to add document$")
    public void iSelectToAddDocument() throws Throwable {
        applicationsPage.addDocuments();
    }

    @When("^I click on the 'Start Upload' button$")
    public void iClickOnTheStartUploadButton() throws Throwable {
        applicationsPage.clickStartUploadButton();
    }

    @Then("^I can successfully upload a document$")
    public void iCanSuccessfullyUploadADocument() throws Throwable {
    }

    @When("^I select to Add More Document$")
    public void iSelectToAddMoreDocument() throws Throwable {
    }

    @Then("^I should be able to see the 'Add Documents' button to enable me add more document$")
    public void iShouldBeAbleToSeeTheAddDocumentsButtonToEnableMeAddMoreDocument() throws Throwable {
    }

    @When("^I select to view document by clicking 'View Document' button$")
    public void iSelectToViewDocumentByClickingViewDocumentButton() throws Throwable {
    }

    @Then("^I can view selected document$")
    public void iCanViewSelectedDocument() throws Throwable {
    }

    @When("^I select to delete document$")
    public void iSelectToDeleteDocument() throws Throwable {
    }

    @Then("^I should be able to delete selected document$")
    public void iShouldBeAbleToDeleteSelectedDocument() throws Throwable {
    }

    @When("^I click on the 'Cancel Upload' button$")
    public void iClickOnTheCancelUploadButton() throws Throwable {
    }

    @Then("^document should not be uploaded$")
    public void documentShouldNotBeUploaded() throws Throwable {
    }
}
