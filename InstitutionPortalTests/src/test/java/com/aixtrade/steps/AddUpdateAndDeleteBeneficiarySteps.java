package com.aixtrade.steps;

import com.aixtrade.pages.*;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AddUpdateAndDeleteBeneficiarySteps {

    private WorldHelper helper;
    private LegalPage legalPage;
    private AlertsAndPopovers alertsAndPopovers;

    public AddUpdateAndDeleteBeneficiarySteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I am on the legal page$")
    public void iAmOnTheLegalPage() {
        String username = TestData.getValue("tester3 email");
        String password = TestData.getValue("user password");
        legalPage = helper
                .getBasePage()
                .loginWith(username, password)
                .closeCookiePolicy()
                .clickToApply()
                .continueApplication()
                .tickCheckbox()
                .saveAndProceedToAppInfo()
                .goToAuthorisedSignersPage().goFinancialInformationPage()
                .selectFinancialInformationDetails();
    }

    @And("^I add a beneficiary as below:$")
    public void iAddABeneficiaryAsBelow(DataTable dataTable) {
        List<List<String>> beneficiaryField = dataTable.raw();
        String dob = TestData.getValue(beneficiaryField.get(1).get(1));
        String address = TestData.getValue(beneficiaryField.get(2).get(1));
        String passportNo = TestData.getValue(beneficiaryField.get(3).get(1));
        legalPage.selectLegalOptions().addBeneficiary(dob, address, passportNo);
    }

    @Then("^I should see beneficiary added$")
    public void iShouldSeeBeneficiaryAdded() {
        Assert.assertNotNull(legalPage.validateAddedBeneficiary());
        Assert.assertTrue(legalPage.validateAddedBeneficiary());
    }

    @And("^I should be able to see a \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeA(String addBenMessage) {
        addBenMessage = TestData.getValue(addBenMessage);
        assertThat(legalPage.validateAlert(addBenMessage), is(true));
    }

    @When("^I update beneficiary as below:$")
    public void iUpdateBeneficiaryAsBelow(DataTable dataTable) {
        List<List<String>> beneficiaryField = dataTable.raw();
        String dob = TestData.getValue(beneficiaryField.get(1).get(1));
        String address = TestData.getValue(beneficiaryField.get(2).get(1));
        String passportNo = TestData.getValue(beneficiaryField.get(3).get(1));
        legalPage.selectToEditBeneficiary().updateBeneficiary(dob, address, passportNo);
    }

    @Then("^I should see beneficiary's details updated as below:$")
    public void iShouldSeeBeneficiarySDetailsUpdatedAsBelow(DataTable dataTable) {
        List<List<String>> beneficiaryField = dataTable.raw();
        String updatedAddress = TestData.getValue(beneficiaryField.get(1).get(1));
        String updatedPassportNo = TestData.getValue(beneficiaryField.get(2).get(1));
        legalPage.validateUpdatedAddress(updatedAddress);
        legalPage.validateUpdatedPassportNo(updatedPassportNo);
    }

    @And("^I should be able to see an \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeAn(String updateBenMessage) {
        updateBenMessage = TestData.getValue(updateBenMessage);
        assertThat(legalPage.validateAlert(updateBenMessage), is(true));
    }

    @When("^I select to delete beneficiary$")
    public void iSelectToDeleteBeneficiary() {
        alertsAndPopovers = legalPage
                .clickDeleteBenButton()
                .completeDelete();
    }

    @Then("^I should be able to see beneficiary details deleted$")
    public void iShouldBeAbleToSeeBeneficiaryDetailsDeleted() {
        Assert.assertTrue(helper
                .getAddBeneficiaryModal()
                .validateDeletedBeneficiary());
    }
}
