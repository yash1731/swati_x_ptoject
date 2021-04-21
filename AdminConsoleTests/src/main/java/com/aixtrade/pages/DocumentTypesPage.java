package com.aixtrade.pages;

import com.aixtrade.waits.WebWaits;
import com.aixtrade.webControls.ButtonControl;
import com.aixtrade.webControls.DropDownControl;
import com.aixtrade.webControls.TextFieldsControl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DocumentTypesPage extends BasePage {

    @FindBy(id = "country")
    private WebElement country = null;
    @FindBy(id = "documentTypesTable")
    private WebElement documentTypesTable = null;
    @FindBy(id = "docTypeType")
    private WebElement docTypeCode = null;
    @FindBy(id = "docTypeDescription")
    private WebElement docTypeDescription = null;
    @FindBy(id = "btnCreateDocumentType")
    private WebElement btnCreateDocumentType = null;
    @FindBy(css = "#btnEdit1 > i")
    private WebElement editDocumentType = null;
    @FindBy(id = "btnUpdateDocumentType")
    private WebElement btnUpdateDocumentType = null;
    @FindBy(css = "#btnDelete1")
    private WebElement deleteDocumentType = null;
    @FindBy(id = "exportCountry")
    private WebElement exportCountry = null;
    @FindBy(id = "btnExport")
    private WebElement btnExport = null;
    protected String randomCode = "c" + randomNo + "t";


    public DocumentTypesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public DocumentTypesPage selectCountry(String aCountry){
        DropDownControl.selectDropDownByVisibleText(country, aCountry);
        return this;
    }

    public DocumentTypesPage fillAllFields( String description){
        TextFieldsControl.enterText(docTypeCode, randomCode);
        TextFieldsControl.enterText(docTypeDescription, description);
        return this;
    }

    public DocumentTypesPage clickAddNewButton(){
        ButtonControl.clickButton(btnCreateDocumentType);
        return this;
    }

    public boolean validateDocumentTypesExist() {
        WebWaits.waitForNoOfSeconds(1);
        List<WebElement> column = documentTypesTable.findElement(By.tagName("tr")).findElements(By.tagName("th"));
        for (int j = 0; j < column.size(); j++) {
            return value.add(column.get(j).getText());
        }
        return false;
    }

    public boolean validateDocumentCode() {
        WebWaits.waitForNoOfSeconds(1);
        WebElement dataElement = documentTypesTable.findElement(By.tagName("tbody")).findElements(By.tagName("tr")).get(0);
        WebElement columnElement = dataElement.findElements(By.tagName("td")).get(2);
        columnElement.getText().contains(randomCode);
            return true;

    }

    public boolean validateDocumentType(String value) {
        WebWaits.waitForNoOfSeconds(1);
        WebElement dataElement = documentTypesTable.findElement(By.tagName("tbody")).findElement(By.tagName("tr")).findElement(By.cssSelector("td:nth-child(4)"));
            if (!dataElement.getText().equalsIgnoreCase(value)) {
            return true;
        }
        return false;
    }

    public boolean validateCreateDocMessage(String message) {
        WebWaits.waitForNoOfSeconds(1);
        WebWaits.waitForElement(alert);
        return alert.getText().contains(message);
    }

    public DocumentTypesPage editDocumentType(){
        ButtonControl.clickButton(editDocumentType);
        return this;
    }

    public DocumentTypesPage clickUpdateButton(){
        WebWaits.waitForNoOfSeconds(1);
        ButtonControl.clickButton(btnUpdateDocumentType);
        return this;
    }

    public Popovers clickDeleteButton(){
        ButtonControl.clickButton(deleteDocumentType);
        return PageFactory.initElements(webDriver, Popovers.class);
    }

    public DocumentTypesPage selectExportCountry(String eCountry){
        WebWaits.waitForNoOfSeconds(2);
        DropDownControl.selectDropDownByVisibleText(exportCountry, eCountry);
        return this;
    }

    public Popovers copyExportCountry(){
        ButtonControl.clickButton(btnExport);
        return PageFactory.initElements(webDriver, Popovers.class);
    }
}
