package com.sat.utils;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.sat.config.Constants;
import com.sat.driver.DriverManager;
import com.sat.driver.LaunchBrowser;
import com.sat.report.AllureManager;
import com.sat.report.ReportListener;
import com.sat.report.TestListener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;
import org.testng.annotations.Listeners;
import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//@Listeners({ExtentITestListenerClassAdapter.class, ReportListener.class})
@Listeners({TestListener.class})
public abstract class BaseTest {

    //protected static WebDriver driver;
    public static final Logger logger = LogManager.getLogger("SAT");

    // public static WebDriver getDriver() {
    //     return driver;
    // }

    // open
    @BeforeMethod
    @Parameters(value={"browser"})
    public void preCondition(@Optional(Constants.BROWSER_TYPE) String browser) {
        WebDriver driver = LaunchBrowser.getDriver(browser);
        DriverManager.setDriver(driver);
    }

    // close
    @AfterMethod
    public void postCondition(){
        // Quit the Browser
        DriverManager.quit();
    }
}