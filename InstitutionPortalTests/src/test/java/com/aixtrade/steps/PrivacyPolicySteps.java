package com.aixtrade.steps;

import com.aixtrade.pages.PrivacyPolicyPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PrivacyPolicySteps {

    private WorldHelper helper;
    private PrivacyPolicyPage privacyPolicyPage;

    public PrivacyPolicySteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I have selected to view Privacy Policy page$")
    public void iHaveSelectedToViewPrivacyPolicyPage() {
        String username = TestData.getValue("user email");
        String password = TestData.getValue("user password");
        privacyPolicyPage = helper.getBasePage()
                .loginWith(username, password)
                .closeCookiePolicy()
                .goToPrivacyPolicyPage();
    }

    @Then("^I should be able to see the \"([^\"]*)\" page$")
    public void iShouldBeAbleToSeeThePage(String privacyPolicy) {
        privacyPolicyPage.validatePrivacyPolicyPage(privacyPolicy);
        assertThat(privacyPolicyPage.validatePrivacyPolicyPage(privacyPolicy), is(true));
    }
}
