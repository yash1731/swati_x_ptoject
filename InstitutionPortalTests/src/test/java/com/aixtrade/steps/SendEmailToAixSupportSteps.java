package com.aixtrade.steps;

import com.aixtrade.pages.HelpPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;


public class SendEmailToAixSupportSteps {

    private WorldHelper helper;
    private HelpPage helpPage;

    public SendEmailToAixSupportSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I have selected the Help menu$")
    public void iHaveSelectedTheHelpMenu() {
        String username = TestData.getValue("user email");
        String password = TestData.getValue("user password");
        helpPage = helper.getBasePage()
                .loginWith(username, password)
                .goToHelpPage();
    }

    @When("^I enter the details below:$")
    public void iEnterTheDetailsBelow(DataTable dataTable) {
        List<List<String>> emailField = dataTable.raw();
        String subject = TestData.getValue(emailField.get(1).get(1));
        String message = TestData.getValue(emailField.get(2).get(1));
        helpPage.enterSubjectAndMessage(subject, message).sendMessage();
    }

    @Then("^I should be able to see a \"([^\"]*)\" for email successfully sent$")
    public void iShouldBeAbleToSeeAForEmailSuccessfullySent(String message) throws Throwable {
//        message = TestData.getValue(message);
//        assertThat(helpPage.validateSentMessage(message), is(true));
    }
}
