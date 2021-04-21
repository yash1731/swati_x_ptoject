package com.aixtrade.pages;

import com.aixtrade.waits.WebWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrivacyPolicyPage extends BasePage {

    @FindBy(id = "privacy-policy-block")
    private WebElement privacyPolicy = null;


    public PrivacyPolicyPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean validatePrivacyPolicyPage(String privacyPolicyPage) {
        WebWaits.waitForNoOfSeconds(1);
        for (WebElement divElement : privacyPolicy.findElements(By.tagName("div"))) {
            for (WebElement div2Element : divElement.findElements(By.tagName("div"))) {
                for (WebElement h4Element : div2Element.findElements(By.tagName("h4"))) {
                    if (!h4Element.getText().equalsIgnoreCase(privacyPolicyPage)) continue;
                    return true;
                }
            }
        }
        return false;
    }
}
