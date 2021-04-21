package com.aixtrade.pages;

import com.aixtrade.waits.WebWaits;
import com.aixtrade.webControls.ButtonControl;
import com.aixtrade.webControls.ClickControl;
import com.aixtrade.webControls.TextFieldsControl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BroadcastMessagesPage extends BasePage {

    @FindBy(id = "broadcastForm")
    private WebElement broadcastForm = null;
    @FindBy(id = "broadcastMessage")
    private WebElement textMessage = null;
    @FindBy(id = "btnSendBroadcastMessage")
    private WebElement sendMessage = null;
    @FindBy(id = "messagesTable")
    private WebElement messagesTable = null;
    @FindBy(id = "recipientsUsersInfoTable")
    private WebElement recepientUsersTable = null;
    @FindBy(css = ".float-left")
    private WebElement closeInfoButton = null;
    @FindBy(css = "#messagesTable_filter > label > input")
    private WebElement searchMessage = null;
    @FindBy(css = "th.dt-body-nowrap:nth-child(2)")
    private WebElement dateSent = null;
    @FindBy(id = "bs-select-2-9")
    private WebElement selectBroadcastUser2 = null;
    @FindBy(css = "div.col-sm-4:nth-child(2) > div:nth-child(1) > button:nth-child(2)")
    private WebElement usersDropOption = null;


    public BroadcastMessagesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public BroadcastMessagesPage clickInstitution(String value) {
        WebWaits.waitForNoOfSeconds(15);
        for(WebElement div1Element : broadcastForm.findElements(By.tagName("div"))){
            for(WebElement div2Element : div1Element.findElements(By.tagName("div"))){
                for(WebElement div3Element : div2Element.findElements(By.tagName("div"))){
                    for(WebElement buttonElement : div3Element.findElements(By.tagName("button"))){
                        if(!buttonElement.getAttribute("title").contains(value)) continue;
                        ClickControl.click(buttonElement);
                    }
                }
            }
        }
        return this;
    }


       public BroadcastMessagesPage selectAnInstitution(String value){
        try {
            List<WebElement> list = webDriver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']//li//a//span"));
            for (WebElement option : list) {
                if (option.getAttribute("innerHTML").contains(value)) {
                    ClickControl.click(option);
                    break;
                }
            }
        }catch(org.openqa.selenium.StaleElementReferenceException ex){
        }
           return this;
    }

    public BroadcastMessagesPage enterTextToBroadcast(String institutionMessage) {
        TextFieldsControl.enterText(textMessage,institutionMessage);
        return this;
    }

    public void clickSendMessageButton() {
        ButtonControl.clickButton(sendMessage);
    }

    public boolean validateBroadcastMessageHistory() {
        WebWaits.waitForNoOfSeconds(1);
        List<WebElement> column = messagesTable.findElement(By.tagName("tbody")).findElements(By.tagName("td"));
        for (int j = 0; j < column.size(); j++) {
            return value.add(column.get(j).getText());
        }
        return false;
    }

    public void broadcastInfoDetails() {
        try {
            WebElement bodyElement = messagesTable.findElements(By.cssSelector("tbody > tr")).get(0);
                for (WebElement tdElement : bodyElement.findElements(By.tagName("td"))) {
                    for (WebElement buttonElement : tdElement.findElements(By.tagName("button"))) {
                        if (!buttonElement.getAttribute("onclick").contains("showRecipientInfo")) continue;
                        ClickControl.click(buttonElement);
                        break;
                    }
                }
        }catch(org.openqa.selenium.StaleElementReferenceException ex){
        }
    }

    public boolean validateSelectedInstitution(String broadcastInstitution) {
        WebElement rowElement = messagesTable.findElements(By.cssSelector("tbody > tr")).get(0);
        for(WebElement institutionColumn : rowElement.findElements(By.tagName("td"))){
            if(!institutionColumn.getText().equalsIgnoreCase(broadcastInstitution)) continue;
            return true;
        }
        return false;
    }

    public BroadcastMessagesPage closeInfoDetails() {
        WebWaits.waitForNoOfSeconds(1);
        ClickControl.click(closeInfoButton);
        return this;
    }

    public BroadcastMessagesPage searchMessage(String institutionMessage) {
        ClickControl.click(dateSent);
        TextFieldsControl.enterText(searchMessage,institutionMessage);
        return this;
    }

    public boolean validateBroadcastMessage(String broadcastMessage) {
        WebWaits.waitForElement(alert);
        return alert.getText().contains(broadcastMessage);
    }

    public BroadcastMessagesPage clickUsers() {
        WebWaits.waitForNoOfSeconds(3);
        WebElement usersElement = broadcastForm.findElement(By.cssSelector(".bs-placeholder .filter-option-inner-inner"));
        ClickControl.click(usersElement);
        return this;
    }

    public BroadcastMessagesPage selectUser(String user) {
        try {
            List<WebElement> list = webDriver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']//li//a//span"));
            for (WebElement option : list) {
                if (option.getAttribute("innerHTML").contains(user)) {
                    ClickControl.click(option);
                }
            }
        }catch(org.openqa.selenium.StaleElementReferenceException ex){
        }
        return this;
    }

    public boolean validateSelectedUserOfAnInstitution(String broadcastUser) {
        WebElement rowElement = recepientUsersTable.findElements(By.cssSelector("tbody > tr")).get(0);
        for(WebElement institutionColumn : rowElement.findElements(By.tagName("td"))){
            if(!institutionColumn.getText().equalsIgnoreCase(broadcastUser)) continue;
            return true;
        }
        return false;
    }

}

