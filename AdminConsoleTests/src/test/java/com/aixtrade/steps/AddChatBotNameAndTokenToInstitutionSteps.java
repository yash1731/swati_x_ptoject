package com.aixtrade.steps;

import com.aixtrade.pages.InstitutionsPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class AddChatBotNameAndTokenToInstitutionSteps {

    private WorldHelper helper;
    private InstitutionsPage institutionsPage;

    public AddChatBotNameAndTokenToInstitutionSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I search for \"([^\"]*)\" in Institutions for balance check$")
    public void iSearchForInInstitutionsForBalanceCheck(String balance) throws Throwable {
        institutionsPage = helper.getInstitutionsPage().searchAnInstituton(balance);
    }


    @When("^I click on the 'Institution Info' button$")
    public void iClickOnTheInstitutionInfoButton() throws Throwable {
       institutionsPage = helper.getInstitutionsPage().clickInstitutionInfoButton();
    }

    @Then("^I clear the ChatBot details of an institution$")
    public void iClearTheChatBotDetailsOfAnInstitution() throws Throwable {
      institutionsPage.clickClearButton();
    }

    @When("^I add the ChatBot name and token to an Institution$")
    public void iAddTheChatBotNameAndTokenToAnInstitution() throws Throwable {
        String ChatBotName = TestData.getValue("chatBot name");
        String ChatBotToken = TestData.getValue("chatBot token");
        institutionsPage.enterChatBotNameAndToken(ChatBotName,ChatBotToken);
    }

    @When("^I click on 'Update' institution button$")
    public void iClickOnUpdateInstitutionButton() throws Throwable {
       institutionsPage.clickUpdateInstitutionButton();
    }

    @Then("^I can see Institution updated success message$")
    public void iCanSeeInstitutionUpdatedSuccessMessage() throws Throwable {
      String institutionUpdateMessage = TestData.getValue("institutionUpdate message");
        Assert.assertTrue(institutionsPage.validateInstitutionUpdated(institutionUpdateMessage));
    }

}
