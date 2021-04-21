package com.aixtrade.pages;

import com.aixtrade.waits.WebWaits;
import com.aixtrade.webControls.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class TradingActivityPage extends BasePage {


    @FindBy(id = "activitiesForm")
    private WebElement activityForm = null;
    @FindBy(css =".timepicker-hour")
    private WebElement timePicker = null;
    @FindBy(css =".timepicker-minute")
    private WebElement minutePicker = null;
    @FindBy(css =".timepicker-second")
    private WebElement secondPicker = null;
    @FindBy(css ="#fromDate > div > div")
    private WebElement fromDate = null;
    @FindBy(css ="tr:nth-child(1) > .hour:nth-child(1)")
    private WebElement selectTime = null;
    @FindBy(css ="tr:nth-child(2) > .minute:nth-child(3)")
    private WebElement selectFromMinute = null;
    @FindBy(css ="tr:nth-child(1) > .second:nth-child(4)")
    private WebElement selectFromSecond = null;
    @FindBy(css ="tr:nth-child(6) > .hour:nth-child(4)")
    private WebElement selectEndTime = null;
    @FindBy(id ="btnSearchActivities")
    private WebElement searchButton = null;
    @FindBy(id = "activitiesTable")
    private WebElement activitiesTable = null;
    @FindBy(css = ".table .prev > .fa")
    private WebElement previousMonth = null;
    @FindBy(css ="#toDate > div > div")
    private WebElement toDate = null;
    @FindBy(css = "tr:nth-child(4) > .day:nth-child(2)")
    private WebElement selectedFromDate = null;
    @FindBy(css = "tr:nth-child(4) > .day:nth-child(3)")
    private WebElement selectedTillDate = null;
    @FindBy(id = "activityInfoContent")
    private WebElement activityInfoContent = null;
    @FindBy(css = ".float-left")
    private  WebElement closeDetailsButton = null;
    public  String eventDescription;
    //@FindBy(css = "button[type='button'][data-id='user']")
    //div.form-group:nth-child(2) > div:nth-child(2) > div:nth-child(1) > button:nth-child(2)
    //@FindBy(css="div.form-group:nth-child(2) > div:nth-child(2) > div:nth-child(1) > button:nth-child(2)")
    @FindBy(xpath = "/html/body/div[2]/div/main/div/div[2]/form/div[2]/div[2]/div/button")
    private WebElement selectUser = null;
    @FindBy(id = "btnSaveFilter")
    private WebElement saveButton = null;
    @FindBy(id = "btnClearFilter")
    private WebElement clearButton = null;
    @FindBy(css = ".material-switch-control-indicator")
    private WebElement testData = null;
    @FindBy(css=".fa-calendar-check-o")
    private WebElement fromCheckButton = null;
    @FindBy(css = ".dataTables_empty")
    private WebElement noDisplay = null;


    public TradingActivityPage(WebDriver webDriver) {
        super(webDriver);
    }


    public TradingActivityPage fromDate(){
        WebWaits.waitForNoOfSeconds(1);
        /*for(WebElement fromDatePicker : activityForm.findElements(By.tagName("div"))){
            for(WebElement divElement : fromDatePicker.findElements(By.tagName("div"))){
                for(WebElement buttonElement : divElement.findElements(By.tagName("div"))){
                    if (!buttonElement.getAttribute("id").contains("fromDate")) continue;
                    for(WebElement div2Element : buttonElement.findElements(By.tagName("div"))){
                        for(WebElement fromDateButtonElement : div2Element.findElements(By.tagName("div"))){
                            if (!fromDateButtonElement.getAttribute("class").contains("input-group-text")) continue;
                            ButtonControl.clickButton(fromDateButtonElement);
                            break;
                        }
                    }
                }
            }
        }*/

        ButtonControl.clickButton(fromDate);
        return this;
    }

  //  public TradingActivityPage fromTimePicker(){

//    private TradingActivityPage fromDate(){
//        WebWaits.waitForNoOfSeconds(1);
//        for(WebElement fromDatePicker : activityForm.findElements(By.tagName("div"))){
//            for(WebElement divElement : fromDatePicker.findElements(By.tagName("div"))){
//                for(WebElement buttonElement : divElement.findElements(By.tagName("div"))){
//                    if (!buttonElement.getAttribute("id").contains("fromDate")) continue;
//                    for(WebElement div2Element : buttonElement.findElements(By.tagName("div"))){
//                        for(WebElement fromDateButtonElement : div2Element.findElements(By.tagName("div"))){
//                            if (!fromDateButtonElement.getAttribute("class").contains("input-group-text")) continue;
//                            ButtonControl.clickButton(fromDateButtonElement);
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        return this;
//    }

    public TradingActivityPage fromTimePicker(){
        ButtonControl.clickButton(fromDate);
        WebWaits.waitForNoOfSeconds(1);
        ClickControl.click(selectedFromDate);
        ClickControl.click(timePicker);
        ClickControl.click(selectTime);
        return this;
    }

    public TradingActivityPage toDate(){
        WebWaits.waitForNoOfSeconds(1);
        try{
        /*for(WebElement toDatePicker : activityForm.findElements(By.tagName("div"))){
            for(WebElement divElement : toDatePicker.findElements(By.tagName("div"))){
                for(WebElement buttonElement : divElement.findElements(By.tagName("div"))){
                    if (!buttonElement.getAttribute("id").contains("toDate")) continue;
                    for(WebElement div2Element : buttonElement.findElements(By.tagName("div"))){
                        for(WebElement toDateButtonElement : div2Element.findElements(By.tagName("div"))){
                            if (!toDateButtonElement.getAttribute("class").contains("input-group-text")) continue;
                            ButtonControl.clickButton(toDateButtonElement);
                            break;
                        }
                    }
                }
            }
        }*/
            ButtonControl.clickButton(toDate);
        }catch(org.openqa.selenium.StaleElementReferenceException ex) {
        }
        return this;
    }

    private TradingActivityPage toTimePicker(){
        ButtonControl.clickButton(toDate);
        ClickControl.click(timePicker);
        ClickControl.click(selectEndTime);
        return this;
    }


    public TradingActivityPage eventsSelector(String value){
        WebWaits.waitForNoOfSeconds(2);
        for(WebElement divElement : activityForm.findElements(By.cssSelector("div.col-sm-4:nth-child(3)"))){
            for(WebElement div2Element : divElement.findElements(By.tagName("div"))){
                for(WebElement buttonElement : div2Element.findElements(By.tagName("button"))){
                    if(!buttonElement.getAttribute("title").equalsIgnoreCase(value)) continue;
                    ClickControl.click(buttonElement);
                    break;
                }
            }
        }
        return this;
    }


    public TradingActivityPage selectAllEvents(String value){
        WebWaits.waitForNoOfSeconds(1);
        for(WebElement divElement : activityForm.findElements(By.cssSelector("div.col-sm-4:nth-child(3)"))){
            for(WebElement div2Element : divElement.findElements(By.tagName("div"))){
                for(WebElement div3Element : div2Element.findElements(By.cssSelector("div:nth-child(3) > div:nth-child(2)"))){
                    for(WebElement selectElement : div3Element.findElements(By.tagName("div"))){
                       for(WebElement buttonElement : selectElement.findElements(By.tagName("button"))) {
                           if (!buttonElement.getText().equalsIgnoreCase(value)) continue;
                           ClickControl.click(buttonElement);
                           break;
                       }
                    }
                }
            }
        }
        return this;
    }

    public TradingActivityPage selectEvent(String value){
        WebWaits.waitForNoOfSeconds(1);
        /*for(WebElement divElement : activityForm.findElements(By.cssSelector("div.col-sm-4:nth-child(3)"))){
            for(WebElement div2Element : divElement.findElements(By.tagName("div"))){
                for(WebElement div3Element : div2Element.findElements(By.cssSelector("div:nth-child(3) > div:nth-child(3) >ul:nth-child(1)"))) {
                    for(WebElement liElement : div3Element.findElements(By.tagName("li"))){
                        for(WebElement aElement : liElement.findElements(By.tagName("a"))){
                            for(WebElement spanElement : aElement.findElements(By.tagName("span"))){
                                if(!spanElement.getText().equalsIgnoreCase(value)) continue;
                                ClickControl.click(spanElement);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return this;*/
        try {
            List<WebElement> list = webDriver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']//li//a//span"));
            for (WebElement option : list) {
                if (option.getAttribute("innerHTML").equalsIgnoreCase(value)) {
                    ClickControl.click(option);
                }
            }
        }catch(org.openqa.selenium.StaleElementReferenceException ex){
        }
        return this;
    }

    public TradingActivityPage selectInstitution(String value){
        for(WebElement divElement : activityForm.findElements(By.cssSelector("div.form-group:nth-child(2)"))){
            for(WebElement div2Element : divElement.findElements(By.tagName("div"))) {
                for (WebElement div3Element : div2Element.findElements(By.tagName("div"))) {
                    for(WebElement buttonElement : div3Element.findElements(By.tagName("button"))){
                        if (!buttonElement.getAttribute("title").contains(value)) continue;
                        ClickControl.click(buttonElement);
                        break;
                    }
                }
            }
        }
        return this;
    }

    private TradingActivityPage selectInstitutionOptions(String value1) {
        //this.selectInstitution(value1);
        try {
            List<WebElement> list = webDriver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']//li//a//span"));
            for (WebElement option : list) {
                if (option.getAttribute("innerHTML").contains(value1)) {
                    ClickControl.click(option);
                }
            }
        }catch(org.openqa.selenium.StaleElementReferenceException ex) {
        }
        return this;
    }


    private TradingActivityPage institutionSearchBox(String value){
            for(WebElement divElement : activityForm.findElements(By.cssSelector("div.form-group:nth-child(2)"))){
                for(WebElement div2Element : divElement.findElements(By.tagName("div"))){
                    for(WebElement div3Element : div2Element.findElements(By.tagName("div"))){
                        for(WebElement div4Element : div3Element.findElements(By.tagName("div"))){
                            for(WebElement searchElement : div4Element.findElements(By.cssSelector("div.bs-searchbox"))) {
                                for (WebElement inputElement : searchElement.findElements(By.tagName("input"))) {
                                    if (!inputElement.getAttribute("aria-label").contains("Search")) continue;
                                    WebWaits.waitForElement(inputElement);
                                    TextFieldsControl.enterText(inputElement, value);
                                    TextFieldsControl.enterText(inputElement, String.valueOf(Keys.ENTER));
                                    //ClickControl.click(inputElement);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            return this;
        }


        private TradingActivityPage selectUsers(){
       /* WebElement userElement = activityForm.findElement(By.xpath("div[2]/div[2]/div"));
                    for(WebElement buttonElement : userElement.findElements(By.tagName("button"))){
                        if (!buttonElement.getAttribute("title").contains("Please select a User")) continue;
                        ClickControl.click(buttonElement);
                        break;div.form-group:nth-child(2) > div:nth-child(2) > div:nth-child(1) > button:nth-child(2)
                        /html/body/div[1]/div/main/div/div[2]/form/div[2]/div[2]/div/button  div.form-group:nth-child(2) > div:nth-child(2) > div:nth-child(1) > button:nth-child(2)
        }*/
            WebWaits.waitForNoOfSeconds(2);
            ClickControl.click(selectUser);
          return this;
    }

    private TradingActivityPage usersSearchBox(String value){
        this.selectUsers();
        List<WebElement> list = webDriver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']//li//a//span"));
        for(WebElement option : list){
            if(option.getAttribute("innerHTML").contains(value)){
                ClickControl.click(option);
            }
        }

        /*for(WebElement divElement : activityForm.findElements(By.cssSelector("div.form-group:nth-child(2)"))){
            for(WebElement div2Element : divElement.findElements(By.tagName("div"))){
                for(WebElement div3Element : div2Element.findElements(By.tagName("div"))){
                    for(WebElement div4Element : div3Element.findElements(By.tagName("div"))){
                        for(WebElement searchElement : div4Element.findElements(By.cssSelector("div.bs-searchbox"))){
                            for(WebElement inputElement :searchElement.findElements(By.tagName("input"))){
                                if (!inputElement.getAttribute("aria-label").contains("Search")) continue;
                                TextFieldsControl.enterText(inputElement,value);
                                TextFieldsControl.enterText(inputElement, String.valueOf(Keys.ENTER));
                                break;
                            }
                        }
                    }
                }
            }
        }*/
        return this;
    }

    public TradingActivityPage selectDateTimeAndEvents() {
        this.fromTimePicker();
        this.toTimePicker();
        return this;
    }

    public TradingActivityPage selectEvents(String value, String value2) {
        this.eventsSelector(value);
        this.selectAllEvents(value2);
        return this;
    }


    public TradingActivityPage fillTradingActivitySearchInfo(String selectInstitution,String institution1) {
        this.selectInstitution(selectInstitution);
        this.institutionSearchBox(institution1);
        //this.usersSearchBox(user1);
        return this;
    }

    public void clickSearchButton() {
        ClickControl.click(searchButton);
    }

    public boolean validateSelectedUser(String user) {
        WebWaits.waitForNoOfSeconds(1);
        for (WebElement dataElement : activityForm.findElement(By.cssSelector("div.form-group:nth-child(3)")).findElement(By.tagName("div")).findElement(By.tagName("span")).findElement(By.tagName("ul")).findElements(By.tagName("li"))) {
            if (!dataElement.getAttribute("title").contains(user)) continue;
            return true;
        }
        return false;
    }

    public boolean validateSelectedUserinList() {
        WebWaits.waitForNoOfSeconds(2);
        try {
            List<WebElement> column = activitiesTable.findElement(By.tagName("tbody")).findElements(By.tagName("td"));
            for (int j = 0; j < column.size(); j++) {
                return value.add(column.get(j).getText());
            }
        } catch(org.openqa.selenium.StaleElementReferenceException ex){

        }
        return false;
    }

    public boolean validateSelectedInstitution(String institution) {
        WebWaits.waitForNoOfSeconds(1);
        for (WebElement dataElement : activityForm.findElement(By.cssSelector("div.form-group:nth-child(2)")).findElement(By.tagName("div")).findElement(By.tagName("div")).findElements(By.tagName("button"))) {
            if (!dataElement.getAttribute("title").contains(institution)) continue;
            return true;
        }
        return false;
    }


    public boolean validatedSelectedUser(String selectedUser) {
        WebWaits.waitForNoOfSeconds(1);
        try {
           WebElement dataElement = activitiesTable.findElements(By.cssSelector("tbody > tr")).get(0);
                WebElement rowElement = dataElement.findElements(By.tagName("td")).get(4);
                    rowElement.getText().contains(selectedUser);
        } catch(org.openqa.selenium.StaleElementReferenceException ex){

        }
        return true;
    }

    public TradingActivityPage clickPreviousMonth() {
        ClickControl.click(previousMonth);
        return this;
    }

    public TradingActivityPage selectFromDate() {
        ClickControl.click(selectedFromDate);
        return this;
    }

    public TradingActivityPage selectFromTime() {
        ClickControl.click(timePicker);
        ClickControl.click(selectTime);
        ClickControl.click(minutePicker);
        ClickControl.click(selectFromMinute);
        ClickControl.click(secondPicker);
        ClickControl.click(selectFromSecond);
        return this;
    }

    public TradingActivityPage selectTillDate() {
        ClickControl.click(selectedTillDate);
        return this;
    }

    public TradingActivityPage selectTillTime() {
        ClickControl.click(timePicker);
        ClickControl.click(selectEndTime);
        ClickControl.click(minutePicker);
        ClickControl.click(selectFromMinute);
        ClickControl.click(secondPicker);
        ClickControl.click(selectFromSecond);
        return this;
    }

    public boolean validatedCurrentFromDate() {
        WebWaits.waitForNoOfSeconds(1);
        WebElement currentDate = webDriver.findElement(By.cssSelector(".today"));
        if(!currentDate.getText().contains(getCurrentDate)){
            return true;
        }
        return false;
    }

    public boolean validatedDefaultedTime() {
        calendar.add(Calendar.HOUR_OF_DAY, -1);
        if(!timePicker.getText().contains(getCurrentDate)){
            return true;
        }
        return false;
    }

    public boolean validatedCurrentTime() {
        if(!timePicker.getText().contains(getCurrentDate)){
            return true;
        }
        return false;
    }


    public TradingActivityPage viewUtteranceDirection(String value) {
        WebWaits.waitForNoOfSeconds(5);
        WebElement directionUtterance = activitiesTable.findElement(By.tagName("tbody")).findElements(By.tagName("tr")).get(0);
        for(WebElement direction : directionUtterance.findElements(By.tagName("td"))){
            eventDescription = direction.getText();
            if(!eventDescription.contains(value)) continue;
        }
        return this;
    }

    public TradingActivityPage getUtteranceDescription() {
        WebElement directionUtterance = activitiesTable.findElement(By.tagName("tbody")).findElements(By.tagName("tr")).get(0);
        for(WebElement description : directionUtterance.findElements(By.tagName("td"))){
            eventDescription = description.getText();
        }
        return this;
    }

    public TradingActivityPage clickViewDetailsButton() {
        try {
            WebWaits.waitForNoOfSeconds(1);
            WebElement directionUtterance = activitiesTable.findElement(By.tagName("tbody")).findElements(By.tagName("tr")).get(0);
            for (WebElement column : directionUtterance.findElements(By.tagName("td"))) {
                for (WebElement infoButton : column.findElements(By.tagName("button"))) {
                    if (!infoButton.getAttribute("onclick").contains("showActivityInfo")) continue;
                    ClickControl.click(infoButton);
                }
            }
        }catch(org.openqa.selenium.StaleElementReferenceException ex){

        }
        return this;
    }

    public TradingActivityPage viewDetails() {
        WebWaits.waitForNoOfSeconds(2);
        for(WebElement spanElement : activityInfoContent.findElements(By.tagName("span"))){
            if(!spanElement.getText().contains(eventDescription));
            System.out.println(eventDescription);
        }
        return this;
    }

    public boolean validateSymbol(String value) {
        for(WebElement spanElement : activityInfoContent.findElements(By.tagName("span"))){
            if(!spanElement.getText().contains(value));
            return true;
        }
        return false;
    }

    public TradingActivityPage clickCloseDetailsButton() {
        WebWaits.waitForNoOfSeconds(1);
        ClickControl.click(closeDetailsButton);
        return this;
    }

    public boolean viewOrderEventsInList(String orderEvents) {
        WebWaits.waitForNoOfSeconds(4);
        WebElement event = activitiesTable.findElement(By.tagName("tbody")).findElements(By.tagName("tr")).get(0);
        WebElement eventName = event.findElements(By.tagName("td")).get(4);
            eventName.getText().equalsIgnoreCase(orderEvents);
        return true;
    }

    private String eventTypeName;

    public TradingActivityPage getEventType() {
        WebWaits.waitForNoOfSeconds(1);
        WebElement event = activitiesTable.findElement(By.tagName("tbody")).findElements(By.tagName("tr")).get(0);
        WebElement eventType = event.findElements(By.tagName("td")).get(7);
        eventTypeName = eventType.getText();
        return this;
    }

    public TradingActivityPage getEventDescription() {
            WebElement firstRowElement = activitiesTable.findElement(By.tagName("tbody")).findElements(By.tagName("tr")).get(0);
            for (WebElement column : firstRowElement.findElements(By.tagName("td"))) {
                for (WebElement spanElement : column.findElements(By.tagName("span"))) {
                    eventDescription = spanElement.getText();
                }
            }

        return this;
    }

    public TradingActivityPage getEventDetails(String name) {
        WebWaits.waitForNoOfSeconds(5);
        //if(noDisplay.getText().contains("No Activities to display")){
        if((BaseControl.isElementNotDisplayedAndPresent(noDisplay)) ||
                (BaseControl.isElementDisplayed(noDisplay))){
            System.out.println("No Activities to display");
        }else if(activitiesTable.getAttribute("id").contains("activitiesTable")){
            this.viewOrderEventsInList(name);
            this.getEventType();
            this.getEventDescription();
            this.clickViewDetailsButton();
            this.clickCloseDetailsButton();
        }
        return this;
    }

    public TradingActivityPage viewEventNameInDetails() {
        WebWaits.waitForNoOfSeconds(5);
        for(WebElement spanElement : activityInfoContent.findElements(By.tagName("span"))){
            if(!spanElement.getText().equalsIgnoreCase(eventTypeName));
            System.out.println(eventTypeName);
        }
        return this;
    }

    private TradingActivityPage securitiesList(String value){
        WebWaits.waitForNoOfSeconds(1);
        WebElement findInstruments = activityForm.findElement(By.cssSelector("div.form-group:nth-child(2) > div.col-sm-2:nth-child(3)"));
                for (WebElement div3Element : findInstruments.findElements(By.tagName("div"))) {
                    for(WebElement buttonElement : div3Element.findElements(By.tagName("button"))){
                        if (!buttonElement.getAttribute("title").contains(value)) continue;
                        ClickControl.click(buttonElement);
                        break;
            }
        }
        return this;
    }
    public TradingActivityPage selectSecurity(String value) {
        WebWaits.waitForNoOfSeconds(1);
        this.securitiesList("Instrument");
        List<WebElement> list = webDriver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']//li//a//span"));
        for(WebElement option : list){
            if(option.getAttribute("innerHTML").contains(value)){
                ClickControl.click(option);
            }
        }
        this.securitiesList(value);
        return this;
    }

    public TradingActivityPage fillTradingActivitySearchByMultipleInstitutions(String selectInstitution, String institution1, String institution2) {
        /*ButtonControl.clickButton(fromDate);
        WebWaits.waitForNoOfSeconds(1);
        ClickControl.click(timePicker);
        ClickControl.click(selectTime);*/
        //ButtonControl.clickButton(toDate);
        this.selectInstitution(selectInstitution);
        this.selectInstitutionOptions(institution1);
        this.selectInstitutionOptions(institution2);
        return this;
    }

    public boolean validateInstitutions(String institution1, String institution2) {
        WebWaits.waitForNoOfSeconds(2);
        WebElement institutionsColumn = activitiesTable.findElement(By.tagName("tbody")).findElements(By.tagName("tr")).get(0);
        WebElement institutionColumn = institutionsColumn.findElements(By.tagName("td")).get(4);
                if ((institutionColumn.getText().contains(institution1)) || (institutionColumn.getText().contains(institution2))) {
                    WebWaits.waitForNoOfSeconds(1);
                }
        return true;
    }

    public TradingActivityPage clickSaveFiltersButton() {
        ButtonControl.clickButton(saveButton);
        return this;
    }

    public boolean validateSavedClearSearchMessage(String saveClearMessage) {
        WebWaits.waitForElement(alert);
        WebWaits.waitForNoOfSeconds(1);
        return alert.getText().contains(saveClearMessage);
    }

    public void clickClearFiltersButton() {
        ButtonControl.clickButton(clearButton);
    }

    public TradingActivityPage excudeTestData() {
        ClickControl.click(testData);
        return this;
    }

    public boolean verifyTestExcludeMessage(String message) {
        WebWaits.waitForNoOfSeconds(2);
        return dangerAlert.getText().contains(message);
    }

    public TradingActivityPage getTimeForUtterances() {
        ClickControl.click(fromCheckButton);
        ClickControl.click(minutePicker);
        Random random = new Random();
        String randomNo = Integer.toString(random.nextInt(4) + 1);
        WebElement datePickWiget = webDriver.findElement(By.xpath("//div[@id='fromDate']/div/div/div[2]/div[3]/table/tr[1]/td[" + randomNo + "]"));
        datePickWiget.click();
        return this;
    }

    public TradingActivityPage getTimeForOrderEvents() {
        ClickControl.click(timePicker);
        WebElement datePickWiget = webDriver.findElement(By.xpath("//div[@id='fromDate']/div/div/div[2]/div[2]/table"));
        List<WebElement> dateColumn = datePickWiget.findElements(By.tagName("td"));
        calendar.add(Calendar.HOUR_OF_DAY, -3);
        for(WebElement getDate : dateColumn){
            String newDate = formatter2.format(calendar.getTime());
            if(getDate.getText().equals(newDate)) {
                JavascriptExecutor executor = (JavascriptExecutor) webDriver;
                executor.executeScript("arguments[0].click();", getDate);
                break;
            }
        }
        return this;
    }

    public TradingActivityPage clickDirection(String direction) {
        WebElement findInstruments = activityForm.findElement(By.cssSelector("div.form-group:nth-child(2) > div.col-sm-2:nth-child(4)"));
        for (WebElement div3Element : findInstruments.findElements(By.tagName("div"))) {
            for(WebElement buttonElement : div3Element.findElements(By.tagName("button"))){
                if (!buttonElement.getAttribute("title").contains(direction)) continue;
                ClickControl.click(buttonElement);
                break;
            }
        }
        return this;
    }

    public TradingActivityPage selectDirection(String inbound) {
        List<WebElement> list = webDriver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']//li//a//span"));
        for(WebElement option : list){
            if(option.getAttribute("innerHTML").contains(inbound)){
                ClickControl.click(option);
            }
        }
        return this;
    }

    public boolean verifyDirectionInTradingActivityList(String inbound) {
        WebWaits.waitForNoOfSeconds(2);
        try {
            WebElement institutionsColumn = activitiesTable.findElement(By.tagName("tbody" )).findElements(By.tagName("tr" )).get(0);
            WebElement directionColumn = institutionsColumn.findElements(By.tagName("td" )).get(8);
            if ((directionColumn.getText().contains(inbound))) {
                return true;
            }
        }catch(org.openqa.selenium.StaleElementReferenceException ex){

        }
        return false;
    }

    public TradingActivityPage getTimeForFIXOrders() {
        WebElement datePickWiget = webDriver.findElement(By.xpath("//div[@id='fromDate']/div/div/div/div/table/tbody"));
        List<WebElement> dateColumn = datePickWiget.findElements(By.tagName("td"));
        calendar.add(Calendar.DAY_OF_MONTH, -2);
        WebWaits.waitForNoOfSeconds(3);
        for(WebElement getDate : dateColumn){
            String newDate = formatter1.format(calendar.getTime());
            if(getDate.getText().equals(newDate)) {
                JavascriptExecutor executor = (JavascriptExecutor) webDriver;
                WebWaits.waitForNoOfSeconds(1);
                executor.executeScript("arguments[0].click();", getDate);
                break;
            }
        }
        return this;
    }

    public TradingActivityPage getTimeForSettlement() {
        WebElement datePickWiget = webDriver.findElement(By.xpath("//div[@id='fromDate']/div/div/div/div/table/tbody"));
        List<WebElement> dateColumn = datePickWiget.findElements(By.tagName("td"));
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        WebWaits.waitForNoOfSeconds(5);
        for(WebElement getDate : dateColumn){
            String newDate = formatter1.format(calendar.getTime());
            if(!getDate.getText().equals(newDate)) continue;
            JavascriptExecutor executor = (JavascriptExecutor)webDriver;
            executor.executeScript("arguments[0].click();", getDate);
            break;
        }
        return this;
    }

    public TradingActivityPage getTimeForSecuritySearch() {
        WebElement datePickWiget = webDriver.findElement(By.xpath("//div[@id='fromDate']/div/div/div/div/table/tbody"));
        List<WebElement> dateColumn = datePickWiget.findElements(By.tagName("td"));
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        for(WebElement getDate : dateColumn){
            String newDate = formatter1.format(calendar.getTime());
            if(getDate.getText().equals(newDate)) {
                JavascriptExecutor executor = (JavascriptExecutor) webDriver;
                WebWaits.waitForNoOfSeconds(1);
                executor.executeScript("arguments[0].click();", getDate);
                break;
            }
        }
        return this;
    }

    public TradingActivityPage getTimeForRESTPriceTaker() {
        WebElement datePickWiget = webDriver.findElement(By.xpath("//div[@id='fromDate']/div/div/div/div/table/tbody"));
        List<WebElement> dateColumn = datePickWiget.findElements(By.tagName("td"));
        calendar.add(Calendar.DAY_OF_MONTH, -5);
        for(WebElement getDate : dateColumn) {
            String newDate = formatter1.format(calendar.getTime());
            if (getDate.getText().equals(newDate)) {
            JavascriptExecutor executor = (JavascriptExecutor) webDriver;
                WebWaits.waitForNoOfSeconds(1);
            executor.executeScript("arguments[0].click();", getDate);
            break;
        }
        }
        return this;
    }

    public TradingActivityPage getTimeForFIXPriceMaker() {
        WebWaits.waitForNoOfSeconds(1);
        WebElement datePickWiget = webDriver.findElement(By.xpath("//div[@id='fromDate']/div/div/div/div/table/tbody"));
        List<WebElement> dateColumn = datePickWiget.findElements(By.tagName("td"));
        calendar.add(Calendar.DAY_OF_MONTH, -2);
        WebWaits.waitForNoOfSeconds(2);
        for(WebElement getDate : dateColumn){
            String newDate = formatter1.format(calendar.getTime());
            if(getDate.getText().equals(newDate)) {
                JavascriptExecutor executor = (JavascriptExecutor) webDriver;
                WebWaits.waitForNoOfSeconds(1);
                executor.executeScript("arguments[0].click();", getDate);
                break;
            }
        }
        return this;
    }

    public TradingActivityPage getTimeForRestPriceMaker() {
        WebWaits.waitForNoOfSeconds(1);
        WebElement datePickWiget = webDriver.findElement(By.xpath("//div[@id='fromDate']/div/div/div/div/table/tbody"));
        List<WebElement> dateColumn = datePickWiget.findElements(By.tagName("td"));
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        WebWaits.waitForNoOfSeconds(2);
        for(WebElement getDate : dateColumn){
            String newDate = formatter1.format(calendar.getTime());
            if(getDate.getText().equals(newDate)) {
                JavascriptExecutor executor = (JavascriptExecutor) webDriver;
                WebWaits.waitForNoOfSeconds(1);
                executor.executeScript("arguments[0].click();", getDate);
                break;
            }
        }
        return this;
    }

    public boolean verifyAddMoreInstitutionMessage(String message) {
        WebWaits.waitForNoOfSeconds(1);
        return dangerAlert.getText().contains(message);
    }
}
