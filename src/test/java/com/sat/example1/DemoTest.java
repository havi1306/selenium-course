package com.sat.example1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;

import com.sat.driver.DriverManager;
import com.sat.utils.BaseTest;

public class DemoTest {
    private static final Logger LOGGER = LogManager.getLogger();
    protected static WebDriver driver;
    private String driverPath;

    @BeforeMethod
    public void preCondition() {
        // Chromedriver path
        driverPath = System.getProperty("user.dir") + File.separator +
                    "src/main/resources/WebDrivers/chromedriver.exe";
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver(options);
        // Maximize the browser
        driver.manage().window().maximize();
    }

    @Test
    public void shouldValidateTitleTheInternet() {
        // Launch website
        driver.get("https://the-internet.herokuapp.com/");
        // Get page title
        String title = driver.getTitle();
        // Verify page title
        Assert.assertEquals(title, "The Internet");
        // Log the result
        LOGGER.info("Title found: " + title);
    }

    @AfterMethod
    public void postCondition(){
        // Quit the Browser
        driver.quit();
    }

}
