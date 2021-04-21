package com.aixtrade.webControls;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.aixtrade.browsers.WebDriverFactory;
import org.openqa.selenium.WebElement;


public class JavaScriptControl extends BaseControl {
    private static Logger logger = LogManager.getLogger("TestLogger");
    private static WebDriver driver = WebDriverFactory.getThreadedDriver();

    public static Object runJsScript(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript(script);
    }


    public static void scrollDownScript(long num){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+ num+ ")");
    }

    public static void scrollUpScript(long num){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+ num + ",0)");
    }

    public static void scrollToViewScript(WebElement Element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }
}
