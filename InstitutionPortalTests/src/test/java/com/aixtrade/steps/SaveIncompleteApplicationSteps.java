package com.aixtrade.steps;

import com.aixtrade.pages.ApplicationInfoPage;
import com.aixtrade.pages.AuthorisedSignersPage;
import com.aixtrade.pages.BasePage;
import com.aixtrade.pages.HomePage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SaveIncompleteApplicationSteps {

    private WorldHelper helper;
    private BasePage basePage;
    private HomePage landingPage;
    private ApplicationInfoPage appInfoPage;
    private AuthorisedSignersPage authorisedSignersPage;

    public SaveIncompleteApplicationSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I logged in to the application with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iLoggedInToTheApplicationWithAnd(String user5, String password5) {
        user5 = TestData.getValue(user5);
        password5 = TestData.getValue(password5);
        landingPage = helper.getBasePage().loginWith(user5, password5);
                //.closeCookiePolicy();
    }

    @When("^I proceed to the Application Information page$")
    public void iProceedToTheApplicationInformationPage() {
        appInfoPage = landingPage
                .clickToApply()
                .continueApplication()
                .tickCheckbox()
                .saveAndProceedToAppInfo();
    }

    @And("^I fill and save my details on the Application Information page as below:$")
    public void iFillAndSaveMyDetailsOnTheApplicationInformationPageAsBelow(DataTable dataTable) {
        List<List<String>> fieldOption = dataTable.raw();
        String name = TestData.getValue(fieldOption.get(1).get(1));
        String address1 = TestData.getValue(fieldOption.get(2).get(1));
        String address2 = TestData.getValue(fieldOption.get(3).get(1));
        String city = TestData.getValue(fieldOption.get(4).get(1));
        String state = TestData.getValue(fieldOption.get(5).get(1));
        String postcode = TestData.getValue(fieldOption.get(6).get(1));
        String country = TestData.getValue(fieldOption.get(7).get(1));
        String website = TestData.getValue(fieldOption.get(8).get(1));
        String type = TestData.getValue(fieldOption.get(9).get(1));
        String date = TestData.getValue(fieldOption.get(10).get(1));
        String regNo = TestData.getValue(fieldOption.get(11).get(1));
        String ein = TestData.getValue(fieldOption.get(12).get(1));
        String identifier = TestData.getValue(fieldOption.get(13).get(1));
        String seedCXID = TestData.getValue(fieldOption.get(14).get(1));
        String tradingExp = TestData.getValue(fieldOption.get(15).get(1));
        authorisedSignersPage = appInfoPage
                .fillApplicantInformation(name, address1, address2, city, state, postcode, country)
                .fillCompanyInformation(website, type, date, regNo, ein, identifier, seedCXID, tradingExp)
                .goToAuthorisedSignersPage();
    }

    @When("^I log out of the Application$")
    public void iLogOutOfTheApplication() throws Throwable {
        basePage = helper.getLandingPage().logOut();
    }

    @And("^I log into the application \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iLogIntoTheApplicationAnd(String user5, String password5) {
        user5 = TestData.getValue(user5);
        password5 = TestData.getValue(password5);
        landingPage = helper.getBasePage().loginWith(user5, password5);

    }

    @And("^navigate to the application information page$")
    public void navigateToTheApplicationInformationPage() {
        appInfoPage = landingPage
                .clickToApply()
                .continueApplication()
                .tickCheckbox()
                .saveAndProceedToAppInfo();
    }

    @Then("^I should be able to see all my saved details populate on this page as below:$")
    public void iShouldBeAbleToSeeAllMySavedDetailsPopulateOnThisPageAsBelow(DataTable dataTable) {
        List<List<String>> fieldOption = dataTable.raw();
        String name = TestData.getValue(fieldOption.get(1).get(1));
        String regNo = TestData.getValue(fieldOption.get(2).get(1));
        String ein = TestData.getValue(fieldOption.get(3).get(1));
        assertTrue(name, appInfoPage.validateApplicantName());
        assertTrue(regNo, appInfoPage.validateApplicantRegNo());
        assertTrue(ein, appInfoPage.validateApplicantEIN());
    }
}
