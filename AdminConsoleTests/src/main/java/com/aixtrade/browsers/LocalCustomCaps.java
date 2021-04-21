package com.aixtrade.browsers;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class LocalCustomCaps {
    private static String filePath = File.separator;


    public static WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(firefoxBinary);
        options.setCapability("marionette", true);
        options.addArguments("--headless");
        options.setAcceptInsecureCerts(true);
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        return new FirefoxDriver(options);
    }



    public static WebDriver getIeDriver(){
        WebDriverManager.iedriver().setup();
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.introduceFlakinessByIgnoringSecurityDomains();
        options.destructivelyEnsureCleanSession();
        options.ignoreZoomSettings();
        options.takeFullPageScreenshot();
        return new InternetExplorerDriver(options);
    }


    public static WebDriver getChromeDriver()  {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--start-maximized");
        options.addArguments("--enable-javascript");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--fast-start");

        final String headless = System.getProperty("headless");
        if (Boolean.TRUE.toString().equals(headless) ) {
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--allow-insecure-localhost");
            options.addArguments("window-size=1920,1080");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            System.setProperty("webdriver.chrome.whitelistedIps", "");
        }
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        return driver;
    }


    public static WebDriver getPhantonJsDriver()  {
        WebDriverManager.phantomjs().setup();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        return new PhantomJSDriver(caps);
    }

    public static WebDriver getHtmlChromeUnitDriver(String browserName){
        WebDriver driver = null;
        if(browserName.toLowerCase().contains("chrome")){
            driver = new HtmlUnitDriver(BrowserVersion.CHROME);
        }else if(browserName.toLowerCase().contains("firefox")) {
            driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_60);
        }else if(browserName.toLowerCase().contains("ie")) {
            driver = new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER);
        }else if(browserName.toLowerCase().contains("edge")) {
            driver = new HtmlUnitDriver(BrowserVersion.EDGE);
        }
        ((HtmlUnitDriver)driver).setJavascriptEnabled(true);
        return driver;
    }

    public static WebDriver getEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        DesiredCapabilities caps = DesiredCapabilities.edge();
        caps.setJavascriptEnabled(true);
        caps.setPlatform(Platform.WIN10);
        options.merge(caps);
        return new EdgeDriver(options);
    }

    public static WebDriver getSafariDriver()  {
        SafariOptions options = new SafariOptions();
        options.setCapability(CapabilityType.PLATFORM_NAME, Platform.MAC);
        DesiredCapabilities caps = DesiredCapabilities.safari();
        caps.setJavascriptEnabled(true);
        caps.setPlatform(Platform.MAC);
        caps.setAcceptInsecureCerts(true);
        options.merge(caps);
        return new SafariDriver(options);
    }
}
