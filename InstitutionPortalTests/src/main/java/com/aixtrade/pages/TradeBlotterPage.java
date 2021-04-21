package com.aixtrade.pages;

import com.aixtrade.waits.WebWaits;
import com.aixtrade.webControls.ButtonControl;
import com.aixtrade.webControls.ClickControl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TradeBlotterPage extends BasePage {

    @FindBy(css = "#tradeBlotterForm > div:nth-child(2) > div:nth-child(1) > div > button > div > div > div")
    private WebElement usersDropdown = null;
    @FindBy(id = "btnSearchTrades")
    private WebElement searchButton = null;
    @FindBy(css ="#fromDate > div > div")
    private WebElement fromDate = null;
    @FindBy(id = "tradeBlotterTable")
    private WebElement tradeTable = null;
    private List<String> value = new ArrayList<String>();
    @FindBy(css ="#toDate > div > div")
    private WebElement toDate = null;
    @FindBy(css = "#tradeBlotterForm > div:nth-child(2) > div:nth-child(3) > div > button > div > div > div")
    private WebElement instrument = null;
    @FindBy(css = "#tradeBlotterForm > div:nth-child(2) > div:nth-child(2) > div > button > div > div > div")
    private WebElement sides = null;
    @FindBy(css = "#tradeBlotterForm > div:nth-child(2) > div:nth-child(2) > div > div > div.bs-actionsbox > div > button.actions-btn.bs-deselect-all.btn.btn-light")
    private WebElement deselectSides = null;
    @FindBy(css = "body > div.cc-window.cc-banner.cc-type-info.cc-theme-block.cc-bottom.cc-color-override-530831885 > div > a")
    private WebElement policy = null;


    public TradeBlotterPage(WebDriver webDriver) {
        super(webDriver);
    }

    public TradeBlotterPage selectUser(String user) {
        ClickControl.click(usersDropdown);
        List<WebElement> list = webDriver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']//li//a//span"));
        for (WebElement option : list) {
            if (option.getAttribute("innerHTML").contains(user)) {
                ClickControl.click(option);
            }
        }
        return this;
    }

    public void clickSearchButton() {
        ClickControl.click(searchButton);
    }

    public TradeBlotterPage fromDate(){
        WebWaits.waitForNoOfSeconds(1);
        ButtonControl.clickButton(fromDate);
        return this;
    }

    public TradeBlotterPage selectDate() {
        WebElement datePickWiget = webDriver.findElement(By.xpath("//div[@id='fromDate']/div/div/div/div/table/tbody"));
        List<WebElement> dateColumn = datePickWiget.findElements(By.tagName("td"));
        calendar.add(Calendar.DAY_OF_MONTH, -2);
        for(WebElement getDate : dateColumn){
            String newDate = formatter1.format(calendar.getTime());
            if(!getDate.getText().equals(newDate)) continue;
            JavascriptExecutor executor = (JavascriptExecutor)webDriver;
            executor.executeScript("arguments[0].click();", getDate);
            break;
        }
        return this;
    }

    public boolean validateTraderInList(String user) {
        WebWaits.waitForNoOfSeconds(1);
        try {
            WebElement dataElement = tradeTable.findElements(By.cssSelector("tbody > tr")).get(0);
            WebElement rowElement = dataElement.findElements(By.tagName("td")).get(6);
            rowElement.getText().contains(user);
        } catch(org.openqa.selenium.StaleElementReferenceException ex){

        }
        return true;
    }

    public boolean validateTradeBlotterList() {
        WebWaits.waitForNoOfSeconds(1);
        List<WebElement> column = tradeTable.findElement(By.tagName("tr")).findElements(By.tagName("th"));
        for (int j = 0; j < column.size(); j++) {
            return value.add(column.get(j).getText());
        }
        return false;
    }

    public TradeBlotterPage toDate() {
        ButtonControl.clickButton(toDate);
        return this;
    }

    public TradeBlotterPage selectInstrument() {
        ClickControl.click(instrument);
        return this;
    }

    public TradeBlotterPage chooseInstrument(String security) {
        List<WebElement> list = webDriver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']//li//a//span"));
        for (WebElement option : list) {
            if (option.getAttribute("innerHTML").contains(security)) {
                ClickControl.click(option);
            }
        }
        return this;
    }

    public boolean validateSecurityInList(String security) {
        WebWaits.waitForNoOfSeconds(1);
        try {
            WebElement dataElement = tradeTable.findElements(By.cssSelector("tbody > tr")).get(0);
            WebElement rowElement = dataElement.findElements(By.tagName("td")).get(8);
            rowElement.getText().contains(security);
        } catch(org.openqa.selenium.StaleElementReferenceException ex){

        }
        return true;
    }

    public TradeBlotterPage clickSide(){
        ClickControl.click(sides);
        return  this;
    }
    public TradeBlotterPage selectSide(String side) {
        List<WebElement> list = webDriver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']//li//a//span"));
        for (WebElement option : list) {
            if (option.getAttribute("innerHTML").contains(side)) {
                ClickControl.click(option);
            }
        }
        return this;
    }

    public boolean validateSideIntheList(String side) {
        WebWaits.waitForNoOfSeconds(1);
        try {
            WebElement dataElement = tradeTable.findElements(By.cssSelector("tbody > tr")).get(0);
            WebElement rowElement = dataElement.findElements(By.tagName("td")).get(4);
            rowElement.getText().contains(side);
        } catch(org.openqa.selenium.StaleElementReferenceException ex){

        }
        return true;
    }

    public TradeBlotterPage deselectSide() {
        ButtonControl.clickButton(deselectSides);
        return this;
    }

    public TradeBlotterPage clickPolicy() {
        ClickControl.click(policy);
        return this;
    }
}
