package com.aixtrade.steps;

import com.aixtrade.pages.AuthorisedSignersPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AddControlPersonAndBeneficiarySteps {

    private WorldHelper helper;
    private AuthorisedSignersPage authorisedSignersPage;

    public AddControlPersonAndBeneficiarySteps(WorldHelper helper){
        this.helper = helper;
    }

    @Given("^I am on the Authorised Signer page for selected application$")
    public void iAmOnTheAuthorisedSignerPageForSelectedApplication() throws Throwable {
        String username = TestData.getValue("user email");
        String password = TestData.getValue("user password");
        authorisedSignersPage = helper
                .getBasePage()
                .loginWith(username, password)
                .clickToApply()
                .continueApplication()
                .tickCheckbox()
                .saveAndProceedToAppInfo()
                .goToAuthorisedSignersPage();
    }


    @When("^I select to edit an Authorised Signer$")
    public void iSelectToEditAnAuthorisedSigner() throws Throwable {
        authorisedSignersPage = helper.getAuthorisedSignersPage().clickEditSigner();
    }

    @When("^I enable the Authorised signer as a control person and beneficial owner$")
    public void iEnableTheAuthorisedSignerAsAControlPersonAndBeneficialOwner() throws Throwable {
        authorisedSignersPage.selectAuthorisedSignerRoles();
    }

    @Then("^I should able to see \"([^\"]*)\"$")
    public void iShouldAbleToSee(String updateSignerMessage) throws Throwable {
        updateSignerMessage =TestData.getValue(updateSignerMessage);
        assertThat(authorisedSignersPage.validateUpdateSigner(updateSignerMessage), is(true));
    }

    @When("^I disable the Authorised signer as a control person  and beneficial owner$")
    public void iDisableTheAuthorisedSignerAsAControlPersonAndBeneficialOwner() throws Throwable {
        authorisedSignersPage.disableAuthorisedSignerRoles();
    }



}
