package com.aixtrade.pages;

import com.aixtrade.waits.WebWaits;
import com.aixtrade.webControls.ButtonControl;
import com.aixtrade.webControls.ClickControl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Calendar;
import java.util.List;

public class TradeBlotterPage extends BasePage {

    @FindBy(css = "#fromDate .fa")
    private WebElement fromDate = null;
    @FindBy(css =".timepicker-hour")
    private WebElement timePicker = null;
    @FindBy(css = "tr:nth-child(3) > .hour:nth-child(2)")
    private WebElement chooseFromTime = null;
    @FindBy(id="tradeBlotterForm")
    private WebElement tradeBlotterForm = null;
    @FindBy(id="tradeBlotterTable")
    private WebElement tradeBlotterTable = null;
    @FindBy(id="btnSearchTrades")
    private WebElement searchButton = null;

    public TradeBlotterPage(WebDriver webDriver) {
        super(webDriver);
    }

    public TradeBlotterPage clickFromDate() {
        ClickControl.click(fromDate);
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

    public TradeBlotterPage selectDate() {
        ClickControl.click(timePicker);
        WebWaits.waitForNoOfSeconds(1);
        ClickControl.click(chooseFromTime);
        return this;
    }

    public TradeBlotterPage clickInstrumentsDropdown() {
        WebElement institution = tradeBlotterForm.findElement(By.xpath("div[1]/div[3]/div/button"));
        ClickControl.click(institution);
        return this;
    }

    public TradeBlotterPage selectFromDropDown(String value) {
        WebWaits.waitForNoOfSeconds(1);
        try {
            List<WebElement> list = webDriver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']//li//a//span"));
            for (WebElement option : list) {
                if (option.getAttribute("innerHTML").equalsIgnoreCase(value)) {
                    ClickControl.click(option);
                }
            }
        }catch(org.openqa.selenium.StaleElementReferenceException ex) {
        }
        return this;
    }

    public boolean validateInstrumentinList(String instrument) {
        WebElement table = tradeBlotterTable.findElements(By.cssSelector("tbody > tr")).get(0);
        WebElement firstRow = table.findElements(By.tagName("td")).get(10);
        firstRow.getText().equalsIgnoreCase(instrument);
        return true;

    }

    public boolean validateTradeList() {
        WebWaits.waitForNoOfSeconds(2);
        List<WebElement> column = tradeBlotterTable.findElement(By.tagName("tr")).findElements(By.tagName("th"));
        for (int j = 0; j < column.size(); j++) {
            return value.add(column.get(j).getText());
        }
        return false;
    }

    public void clickSearchButton() {
        ButtonControl.clickButton(searchButton);
    }

    public TradeBlotterPage clickSidesDropdown() {
        WebElement sides = tradeBlotterForm.findElement(By.xpath("div[2]/div[3]/div/button"));
        ClickControl.click(sides);
        return this;
    }

    public boolean validateSide(String sell) {
        WebWaits.waitForNoOfSeconds(1);
        WebElement table = tradeBlotterTable.findElements(By.cssSelector("tbody > tr")).get(0);
        WebElement firstRow = table.findElements(By.tagName("td")).get(3);
        firstRow.getText().equalsIgnoreCase(sell);
        return true;
    }

    public TradeBlotterPage deselectSide() {
        WebElement sides = tradeBlotterForm.findElement(By.xpath("div[2]/div[3]/div/div/div[2]/div/button[2]"));
        ClickControl.click(sides);
        return this;
    }

    public TradeBlotterPage clickInstitutionDropdown() {
        WebElement institution = tradeBlotterForm.findElement(By.xpath("div[2]/div[1]/div/button"));
        ClickControl.click(institution);
        return this;
    }

    public TradeBlotterPage clickUsersDropdown() {
        WebWaits.waitForNoOfSeconds(1);
        try {
            WebElement users = tradeBlotterForm.findElement(By.xpath("div[2]/div[2]/div/button"));
            ClickControl.click(users);
        }catch(org.openqa.selenium.StaleElementReferenceException ex) {
            }
        return this;
    }

    public TradeBlotterPage selectUsersDropdown(String user) {
        //WebWaits.waitForNoOfSeconds(5);
        try {
            List<WebElement> list = webDriver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']//li//a//span"));
            for(WebElement option : list){
                if(option.getAttribute("innerHTML").contains(user)){
                    ClickControl.click(option);
                }
            }
//            WebElement users = webDriver.findElement(By.cssSelector("div.show:nth-child(1) > div:nth-child(3) > div:nth-child(3) > ul > li"));
//            for (WebElement linkElement : users.findElements(By.tagName("a"))) {
//                for (WebElement spanElement : linkElement.findElements(By.tagName("span"))) {
//                    if (!spanElement.getText().equalsIgnoreCase(user)) continue;
//                    WebWaits.waitForNoOfSeconds(5);
//                    ClickControl.click(spanElement);
//                    TextFieldsControl.enterText(spanElement,"Keys.ENTER");
//                    break;
//                }
//            }
        }catch(org.openqa.selenium.StaleElementReferenceException ex) {
        }
        return this;
    }

    public boolean validateInstitutioninList(String institution1) {
        WebWaits.waitForNoOfSeconds(1);
        for(WebElement rows : tradeBlotterTable.findElements(By.cssSelector("tbody > tr"))){
            WebElement institutionColumn = rows.findElements(By.tagName("td")).get(6);
            institutionColumn.getText().equalsIgnoreCase(institution1);
            break;
        }
        return true;
    }

    public boolean validateUsersinList(String user1) {
        WebWaits.waitForNoOfSeconds(1);
        for(WebElement rows : tradeBlotterTable.findElements(By.cssSelector("tbody > tr"))){
            WebElement institutionColumn = rows.findElements(By.tagName("td")).get(7);
            institutionColumn.getText().equalsIgnoreCase(user1);
            break;
        }
        return true;
    }

    public boolean validateCounterPartyUsersinList(String user1) {
        WebWaits.waitForNoOfSeconds(1);
        for(WebElement rows : tradeBlotterTable.findElements(By.cssSelector("tbody > tr"))){
            WebElement institutionColumn = rows.findElements(By.tagName("td")).get(8);
            institutionColumn.getText().equalsIgnoreCase(user1);
            break;
        }
        return true;
    }

}
