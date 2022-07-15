package com.sat.example1;

import com.sat.driver.DriverManager;
import com.sat.page.WelcomePage;
import com.sat.utils.BaseTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class WelcomeTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger();
    protected WelcomePage welcomePage;

    @Test
    public void shouldValidateTitleTheInternet() {
        WebDriver driver = DriverManager.getDriver();
        // Launch website
        driver.get("https://the-internet.herokuapp.com/");
        welcomePage = new WelcomePage();
        String title = welcomePage.getTitle();
        Assert.assertEquals(title, "The Internet");
        LOGGER.info("Title found: " + title);
    }

}
