package com.aixtrade.pages;

import com.aixtrade.waits.WebWaits;
import com.aixtrade.webControls.ButtonControl;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentUploadPage extends BasePage {

    @FindBy(id = "inputFileSpanaoi")
    private WebElement sartOfIncorp = null;
    @FindBy(id = "inputFileSpancgs")
    private WebElement certOfGoodStand = null;
    @FindBy(id = "inputFileSpancbl")
    private WebElement corpBylaws = null;
    @FindBy(id = "inputFileSpanefq")
    private WebElement ecpFinQual = null;
    @FindBy(id = "inputFileSpanids")
    private WebElement idDoc = null;


    public DocumentUploadPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SubmitApplicationPage uploadDocument(){
        WebWaits.waitForNoOfSeconds(1);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("document.getElementById('inputFileSpanaoi').innerHTML='TESTAOI'");
        javascriptExecutor.executeScript("document.getElementById('inputFileSpancgs').innerHTML='TESTCGS'");
        javascriptExecutor.executeScript("document.getElementById('inputFileSpancbl').innerHTML='TESTCBL'");
        javascriptExecutor.executeScript("document.getElementById('inputFileSpanefq').innerHTML='TESTEFQ'");
        javascriptExecutor.executeScript("document.getElementById('inputFileSpanids').innerHTML='TESTIDS'");
        ButtonControl.clickButton(saveAndProcced);
        WebWaits.waitForNoOfSeconds(5);
        return PageFactory.initElements(webDriver, SubmitApplicationPage.class);
    }
}
