package com.aixtrade.pages;

import com.aixtrade.waits.WebWaits;
import com.aixtrade.webControls.ClickControl;
import com.aixtrade.webControls.TextFieldsControl;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class BasePage {

    protected WebDriver webDriver;

    @FindBy(id = "username")
    private WebElement usernameElement = null;
    @FindBy(id = "password")
    private WebElement passwordElement = null;
    @FindBy(css = "#kc-form-login > input.submit")
    private WebElement loginButton = null;
    @FindBy(css = "#kc-form-options > div > span > a")
    private WebElement forgotPassword = null;
    @FindBy(css = "div.actions.clearfix > ul > li:nth-child(2) > a")
    protected WebElement saveAndProcced = null;
    @FindBy(css = "div.actions.clearfix > ul > li:nth-child(1) > a")
    protected WebElement previousPage = null;
    @FindBy(id = "dob")
    protected WebElement dateOfBirth = null;
    @FindBy(id = "ssn")
    protected WebElement ssn = null;
    @FindBy(id = "oCity")
    protected WebElement applicantCity = null;
    @FindBy(id = "oCountry")
    protected WebElement applicantCountry = null;
    @FindBy(id = "oPostCode")
    protected WebElement applicantPostCode = null;
    private Random random = new Random();
    protected String randomNo = Integer.toString(random.nextInt(100) + 1);
    @FindBy(css = "body > div.col-xs-11.col-sm-4.alert.alert-success.animated.fadeInDown")
    protected WebElement alert = null;
    @FindBy(css = "body > div.col-xs-11.col-sm-4.alert.alert-danger.animated.fadeInDown")
    protected WebElement dangerAlert = null;
    @FindBy(css = "body > div.col-xs-11.col-sm-4.alert.alert-info.animated.fadeInDown")
    protected WebElement infoAlert = null;
    //Get the current date and time
    protected Calendar calendar = Calendar.getInstance();
    protected SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    protected SimpleDateFormat formatter1 = new SimpleDateFormat("dd");
    protected SimpleDateFormat formatter2 = new SimpleDateFormat("HH");
    @FindBy(css = "body > div.cc-window.cc-banner.cc-type-info.cc-theme-block.cc-bottom.cc-color-override-530831885 > div > a")
    protected WebElement cookieAcceptButton = null;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public HomePage loginWith(String username, String password) {
        TextFieldsControl.enterText(usernameElement, username);
        TextFieldsControl.enterText(passwordElement, password);
        ClickControl.click(loginButton);
        return PageFactory.initElements(webDriver, HomePage.class);
    }

    public HomePage closeCookiePolicy() {
        ClickControl.click(cookieAcceptButton);
        return PageFactory.initElements(webDriver, HomePage.class);
    }

    public boolean validateLogout() {
        return loginButton.getAttribute("value").toLowerCase().contains("login".toLowerCase());
    }

    public ForgotPasswordPage goToForgotPasswordPage() {
        try {
           /* for (WebElement buttonElement : loginScreen.findElements(By.tagName("div"))) {
                for (WebElement spanElement : buttonElement.findElements(By.tagName("span"))) {
                    if (!spanElement.getText().toLowerCase().contains("forgot password?")) continue;
                    ClickControl.click(spanElement);
                    break;
                }
            }*/
            WebWaits.waitForNoOfSeconds(2);
            ClickControl.click(forgotPassword);

        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
        }
        return PageFactory.initElements(webDriver, ForgotPasswordPage.class);
    }

    public void scrollToBottomOfPage() {
        ((JavascriptExecutor) webDriver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
