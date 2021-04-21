package com.aixtrade.steps;

import com.aixtrade.pages.InstitutionsPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ViewPhoneNumberOfUserSteps {

    private WorldHelper helper;
    private InstitutionsPage institutionsPage;

    public ViewPhoneNumberOfUserSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I search for \"([^\"]*)\" in Users$")
    public void iSearchForInUsers(String email) throws Throwable {
        institutionsPage = helper.getInstitutionsPage().searchUser(email);
    }


    @Then("^Verify the phone number of a user is present$")
    public void verifyThePhoneNumberOfAUserIsPresent() throws Throwable {
        String phoneNumber = TestData.getValue("user phoneNumber");
        Assert.assertFalse(helper.getInstitutionsPage().verifyPhoneNumber(phoneNumber));
    }

    @Then("^I Click on 'Edit' users button$")
    public void iClickOnEditUsersButton() throws Throwable {
        institutionsPage = helper.getInstitutionsPage().clickEditUsers();
    }

    @When("^I update the phone Number of the user$")
    public void iUpdateThePhoneNumberOfTheUser() throws Throwable {
        String phoneNo = TestData.getValue("user phoneNumber");
        institutionsPage.enterPhoneNumber(phoneNo).clickUpdateUserButton();
    }

    @Then("^Verify user validation Message \"([^\"]*)\"$")
    public void verifyUserValidationMessage(String message) throws Throwable {
       Assert.assertTrue(institutionsPage.valiadteUsersUpdateMessage(message));
    }



}
