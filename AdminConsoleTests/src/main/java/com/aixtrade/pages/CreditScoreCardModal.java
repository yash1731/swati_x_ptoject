package com.aixtrade.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreditScoreCardModal extends BasePage {

    @FindBy(id = "creditScoreModalLongTitle")
    private WebElement creditScoreTitle = null;
    @FindBy(className = "modal-body")
    private WebElement modalBody = null;

    public CreditScoreCardModal(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean validateCreditScoreTitle() {
        return creditScoreTitle.getText().equalsIgnoreCase("Credit Score");
    }

    public boolean validateCreditScoreCardDetails(String value) {
        for (WebElement firstElement : modalBody.findElement(By.tagName("div")).findElements(By.tagName("div"))) {
            for (WebElement dataElement : firstElement.findElements(By.tagName("div"))) {
                for (WebElement spanElement : dataElement.findElements(By.tagName("h6"))) {
                    if (!spanElement.getText().equalsIgnoreCase(value)) continue;
                    return true;
                }
            }
        }
        return false;
    }
}
