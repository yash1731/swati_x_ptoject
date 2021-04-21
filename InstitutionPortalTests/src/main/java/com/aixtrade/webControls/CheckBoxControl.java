package com.aixtrade.webControls;

import com.aixtrade.waits.WebWaits;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;


public class CheckBoxControl extends BaseControl {

    private static Logger logger = LogManager.getLogger("TestLogger");


    public static void tickCheckBox(WebElement element) {
        for (int count = 0; count <= time; count++) {
            try {
                if (!isElementDisplayed(element) && !isElementEnabled(element)) continue;
                if (!isElementSelected(element)) {
                    element.click();
                    logger.info("Element is clicked");
                    return;
                }
                logger.warn("Unable to click on the element");
                return;
            } catch (Exception e) {
                WebWaits.waitForNoOfSeconds(1);
            }
        }
    }

    public static void untickCheckBox(WebElement element) {
        for (int count = 0; count <= time; count++) {
            try {
                if (!isElementDisplayed(element) && !isElementEnabled(element)) continue;
                if (isElementSelected(element)) {
                    element.click();
                    logger.info("Checkbox is unticked");
                    return;
                }
                logger.warn("Unable to click on the element");
                return;
            } catch (Exception e) {
                WebWaits.waitForNoOfSeconds(1);
            }
        }
    }
}
