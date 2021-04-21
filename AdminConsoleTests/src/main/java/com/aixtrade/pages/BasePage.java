package com.aixtrade.pages;

import com.aixtrade.waits.WebWaits;
import com.aixtrade.webControls.ClickControl;
import com.aixtrade.webControls.TextFieldsControl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class BasePage {

    protected WebDriver webDriver;

    @FindBy(id = "username")
    private WebElement usernameElement = null;
    @FindBy(id = "password")
    private WebElement passwordElement = null;
    @FindBy(css = "#kc-form-login > input.submit")
    private WebElement loginButton = null;
    @FindBy(id = "kc-form-options")
    private WebElement loginScreen = null;
    @FindBy(css = "#kc-form-options > div:nth-child(1) > span:nth-child(1) > a:nth-child(1)")
    private WebElement forgotPassword = null;
    protected List<String> value = new ArrayList<String>();
    @FindBy(css = "body > div.col-xs-11.col-sm-4.alert.alert-success")
    protected WebElement alert = null;
    @FindBy(css = "body > div.col-xs-11.col-sm-4.alert.alert-danger.animated.fadeInDown")
    protected WebElement dangerAlert = null;
    @FindBy(css = "body > div.col-xs-11.col-sm-4.alert.alert-info.animated.fadeInDown")
    protected WebElement infoAlert = null;
    private Random random = new Random();
    protected String randomNo = Integer.toString(random.nextInt(100) + 1);
    //Get the current date and time
    protected Calendar calendar = Calendar.getInstance();
    protected SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    protected SimpleDateFormat formatter1 = new SimpleDateFormat("dd");
    protected SimpleDateFormat formatter2 = new SimpleDateFormat("HH");
    protected String getCurrentDate = formatter.format(calendar.getTime());



    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public HomePage loginWith(String username, String password) {
        TextFieldsControl.enterText(usernameElement, username);
        TextFieldsControl.enterText(passwordElement, password);
        ClickControl.click(loginButton);
        return PageFactory.initElements(webDriver, HomePage.class);
    }

    public boolean validateLogout() {
        WebWaits.waitForNoOfSeconds(1);
        return loginButton.getAttribute("value").toLowerCase().contains("login".toLowerCase());
    }

    public ForgotPasswordPage goToForgotPasswordPage() {
        try {
            WebWaits.waitForNoOfSeconds(2);
            /*for (WebElement buttonElement : loginScreen.findElements(By.tagName("div"))) {
                for (WebElement spanElement : buttonElement.findElements(By.cssSelector("span:nth-child(1) > a:nth-child(1)"))) {
                    if (!spanElement.getText().toLowerCase().contains("Forgotten your password?")) continue;
                    ClickControl.click(spanElement);
                    break;
                }
            }*/
            ClickControl.click(forgotPassword);
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
        }
        return PageFactory.initElements(webDriver, ForgotPasswordPage.class);
    }

}
