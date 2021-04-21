package com.aixtrade.steps;

import com.aixtrade.pages.OTCScreenPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OTCScreenRestrictQuantityTo8Decimals {

    private WorldHelper helper;
    private OTCScreenPage otcScreenPage;

    public OTCScreenRestrictQuantityTo8Decimals(WorldHelper helper) {
        this.helper = helper;
    }


    @When("^I add 'Quantity' more than (\\d+) decimal places in OTC Screen to request for price$")
    public void iAddQuantityMoreThanDecimalPlacesInOTCScreenToRequestForPrice(int quantity) throws Throwable {
        String quantity2 = TestData.getValue("otc quantity2");
        helper.getOTCScreenPage().enterQuantity(quantity2);
    }

    @Then("^I should receive error notification on OTC Screen \"([^\"]*)\"$")
    public void iShouldReceiveErrorNotificationOnOTCScreen(String message) throws Throwable {
       helper.getOTCScreenPage().validateQuantityRestrictionError(message);
    }
}
