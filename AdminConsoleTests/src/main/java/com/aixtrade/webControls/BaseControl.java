package com.aixtrade.webControls;

import com.aixtrade.waits.WebWaits;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import com.aixtrade.utilities.EnvConfig;


public abstract class BaseControl {

    protected static int time = Integer.parseInt(EnvConfig.getValue("default.timer"));
    private static Logger logger = LogManager.getLogger("TestLogger");



    public static boolean isElementDisplayed(WebElement element){
        for(int i = 0; i < time; i++){
            if(element.isDisplayed()){
                logger.info("Element is displayed");
                return true;
            }else {
                WebWaits.waitForNoOfSeconds(1);
            }
        }
        return false;
    }

    protected static boolean isElementSelected(WebElement element){
        for(int i = 0; i < time; i++){
            if(element.isSelected()){
                boolean status = element.isSelected();
                logger.info("The element selected status is "+status);
                return true;
            }else {
                WebWaits.waitForNoOfSeconds(1);
            }
        }
        return false;
    }

    public static boolean isElementEnabled(WebElement element){
        for(int i = 0; i < time; i++){
            if(element.isEnabled()){
                logger.info("The element enabled status is "+element.isEnabled());
                return true;
            }else {
                WebWaits.waitForNoOfSeconds(1);
            }
        }
        return false;
    }

    public static boolean isElementDisabled(WebElement element){
        for(int i = 0; i < time; i++){
            if(element.isEnabled()){
                logger.info("The element enabled status is "+element.isEnabled());
                return false;
            }else {
                WebWaits.waitForNoOfSeconds(1);
            }
        }
        return true;
    }

    public static Boolean isElementNotDisplayedAndPresent(WebElement element) {
        try {
            element.isDisplayed();
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }
}
