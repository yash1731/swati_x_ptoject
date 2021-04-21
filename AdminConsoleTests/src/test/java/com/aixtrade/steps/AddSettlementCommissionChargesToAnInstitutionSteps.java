package com.aixtrade.steps;

import com.aixtrade.pages.InstitutionsPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.When;

public class AddSettlementCommissionChargesToAnInstitutionSteps {

    private WorldHelper helper;
    private InstitutionsPage institutionsPage;

    public AddSettlementCommissionChargesToAnInstitutionSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I add settlement and commission charge for an institution$")
    public void iAddSettlementAndCommissionChargeForAnInstitution() throws Throwable {
        String settlementCharge = TestData.getValue("settlement charge");
        String commissionCharge = TestData.getValue("commission charge");
       institutionsPage = helper.getInstitutionsPage()
               .addChargestoAnInstitution(settlementCharge,commissionCharge);
    }
}
