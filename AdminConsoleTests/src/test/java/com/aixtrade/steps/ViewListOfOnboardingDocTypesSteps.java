package com.aixtrade.steps;

import com.aixtrade.pages.DocumentTypesPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ViewListOfOnboardingDocTypesSteps {

    private WorldHelper helper;
    private DocumentTypesPage documentTypesPage;

    public ViewListOfOnboardingDocTypesSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I am on the Document Types page$")
    public void iAmOnTheDocumentTypesPage() throws Throwable {
        String username = TestData.getValue("admin email");
        String password = TestData.getValue("admin password");
        documentTypesPage = helper.getBasePage().loginWith(username, password).goToDocumentTypesPage();
    }

    @When("^I select a \"([^\"]*)\"$")
    public void iSelectA(String country) throws Throwable {
        country = TestData.getValue(country);
        documentTypesPage.selectCountry(country);
    }

    @Then("^I should be able to see all required document types for that country$")
    public void iShouldBeAbleToSeeAllRequiredDocumentTypesForThatCountry() {
        Assert.assertNotNull(documentTypesPage.validateDocumentTypesExist());
        Assert.assertTrue(documentTypesPage.validateDocumentTypesExist());
    }
}
