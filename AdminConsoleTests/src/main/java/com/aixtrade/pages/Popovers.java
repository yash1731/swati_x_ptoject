package com.aixtrade.pages;

import com.aixtrade.waits.WebWaits;
import com.aixtrade.webControls.ButtonControl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Popovers extends BasePage {

    @FindBy(className = "popover-body")
    private WebElement popover = null;

    public Popovers(WebDriver webDriver) {
        super(webDriver);
    }

    public Popovers completeAction() {
        WebWaits.waitForNoOfSeconds(3);
        try {
            for (WebElement divElement : popover.findElements(By.tagName("div"))) {
                for (WebElement div2Element : divElement.findElements(By.tagName("div"))) {
                    for (WebElement inputElement : div2Element.findElements(By.tagName("a"))) {
                        if (!inputElement.getText().equalsIgnoreCase("Yes")) continue;
                        ButtonControl.clickButton(inputElement);
                        break;
                    }
                }
            }
        }catch (org.openqa.selenium.StaleElementReferenceException ex){

        }
        return this;
    }

}
