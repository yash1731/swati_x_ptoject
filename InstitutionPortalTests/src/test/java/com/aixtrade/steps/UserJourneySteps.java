package com.aixtrade.steps;

import com.aixtrade.pages.*;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class UserJourneySteps {

    private WorldHelper helper;
    private ApplicationInfoPage appInfoPage;
    private DirectionsPage directionsPage;
    private DisclosuresPage disclosuresPage;
    private AuthorisedSignersPage authorisedSignersPage;
    private FinancialInformationPage financialInformationPage;
    private LegalPage legalPage;
    private SubmitApplicationPage submitApplicationPage;
    private ECPStatusPage ecpStatusPage;
    private DocumentUploadPage documentUploadPage;


    public UserJourneySteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I select Apply button$")
    public void iSelectApplyButton() {
        directionsPage = helper
                .getLandingPage()
                .clickToApply();
    }

    @When("^I Continue Application$")
    public void iContinueApplication() {
        disclosuresPage = directionsPage.continueApplication();
    }

    @When("^I tick the Disclosures checkbox and proceed to the next page$")
    public void iTickTheDisclosuresCheckboxAndProceedToTheNextPage() {
        appInfoPage = disclosuresPage
                .tickCheckbox()
                .saveAndProceedToAppInfo();
    }

    @And("^I fill all required field on the application information page as below:$")
    public void iFillAllRequiredFieldOnTheApplicationInformationPageAsBelow(DataTable dataTable) {
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
        authorisedSignersPage = appInfoPage.fillApplicantInformation(name, address1, address2, city, state, postcode, country).fillCompanyInformation(website, type, date, regNo, ein, identifier, seedCXID, tradingExp).goToAuthorisedSignersPage();
    }

    @And("^I fill the details of the first authorised user on the Authorised Signers page as below:$")
    public void iFillTheDetailsOfTheFirstAuthorisedUserOnTheAuthorisedSignersPageAsBelow(DataTable dataTable) {
        List<List<String>> signersOption = dataTable.raw();
        String firstName = TestData.getValue(signersOption.get(1).get(1));
        String lastName = TestData.getValue(signersOption.get(2).get(1));
        String title = TestData.getValue(signersOption.get(3).get(1));
        String dob = TestData.getValue(signersOption.get(4).get(1));
        String email = TestData.getValue(signersOption.get(5).get(1));
        String contactNo = TestData.getValue(signersOption.get(6).get(1));
        String country = TestData.getValue(signersOption.get(7).get(1));
        String ssn = TestData.getValue(signersOption.get(8).get(1));
        String passportNo = TestData.getValue(signersOption.get(9).get(1));
        String expiry = TestData.getValue(signersOption.get(10).get(1));
        String issue = TestData.getValue(signersOption.get(11).get(1));
        String buildingNo = TestData.getValue(signersOption.get(12).get(1));
        String street = TestData.getValue(signersOption.get(13).get(1));
        String city = TestData.getValue(signersOption.get(14).get(1));
        String postcode = TestData.getValue(signersOption.get(15).get(1));
        authorisedSignersPage = helper.getAuthorisedSignersPage().fillFirstAuthorisedSignerDetails(firstName, lastName, title, dob, email, contactNo, ssn, passportNo, expiry, issue, buildingNo, street, city, country, postcode);
    }

    /*@And("^I fill the details of the second authorised user on the Authorised Signers page as below:$")
    public void iFillTheDetailsOfTheSecondAuthorisedUserOnTheAuthorisedSignersPageAsBelow(DataTable dataTable) {
        List<List<String>> signersOption2 = dataTable.raw();
        String firstName2 = TestData.getValue(signersOption2.get(1).get(1));
        String lastName2 = TestData.getValue(signersOption2.get(2).get(1));
        String title2 = TestData.getValue(signersOption2.get(3).get(1));
        String dob2 = TestData.getValue(signersOption2.get(4).get(1));
        String email2 = TestData.getValue(signersOption2.get(5).get(1));
        String contactNo2 = TestData.getValue(signersOption2.get(6).get(1));
        String country2 = TestData.getValue(signersOption2.get(7).get(1));
        String passportNo2 = TestData.getValue(signersOption2.get(8).get(1));
        String expiry2 = TestData.getValue(signersOption2.get(9).get(1));
        String issue2 = TestData.getValue(signersOption2.get(10).get(1));
        String buildingNo2 = TestData.getValue(signersOption2.get(11).get(1));
        String street2 = TestData.getValue(signersOption2.get(12).get(1));
        String city2 = TestData.getValue(signersOption2.get(13).get(1));
        String postcode2 = TestData.getValue(signersOption2.get(14).get(1));
        authorisedSignersPage.fillSecondAuthorisedSignerDetails(firstName2, lastName2, title2, email2, contactNo2, dob2, passportNo2, expiry2, issue2, buildingNo2, street2, city2, country2, postcode2);
    }*/

    @When("^I add the documents for the authorised signer$")
    public void iAddTheDocumentsForTheAuthorisedSigner() throws Throwable {
       financialInformationPage = authorisedSignersPage.uploadAuthorisedSignerDocuments().goFinancialInformationPage();
    }

    @And("^I select options on the financial Information page$")
    public void iSelectOptionsOnTheFinancialInformationPage() {
        legalPage = financialInformationPage.selectFinancialInformationDetails();
    }

    @And("^I select options on the Legal page and add a beneficiary as below:$")
    public void iSelectOptionsOnTheLegalPageAndAddABeneficiaryAsBelow(DataTable dataTable){
        List<List<String>> beneficiaryField = dataTable.raw();
        String dob = TestData.getValue(beneficiaryField.get(1).get(1));
        String address = TestData.getValue(beneficiaryField.get(2).get(1));
        String passportNo = TestData.getValue(beneficiaryField.get(3).get(1));
        ecpStatusPage = legalPage.selectLegalOptions().addBeneficiary(dob, address, passportNo).navigateToECPPage();
    }

    @And("^I select an ECP status option$")
    public void iSelectAnECPStatusOption() {
        documentUploadPage = ecpStatusPage.selectECPOptions();
    }

    @And("^I upload required documents$")
    public void iUploadRequiredDocuments() {
        submitApplicationPage = documentUploadPage.uploadDocument();
    }

    @And("^I submit my application$")
    public void iSubmitMyApplication() {
        submitApplicationPage.submitApplication();
    }

    @Then("^I should be able to get a \"([^\"]*)\" for submitting application$")
    public void iShouldBeAbleToGetAForSubmittingApplication(String message) {
        message = TestData.getValue(message);
        //assertThat(submitApplicationPage.validateApplicationSubmission(message), is(true));
    }
}
