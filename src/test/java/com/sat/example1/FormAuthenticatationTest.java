package com.sat.example1;

import com.sat.driver.DriverManager;
import com.sat.page.FormAuthenticationPage;
import com.sat.utils.BaseTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class FormAuthenticatationTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger();
    protected FormAuthenticationPage formAuthenticationPage;

    @Test
    public void visibilityTest() {
        WebDriver driver = DriverManager.getDriver();
        // Launch website
        driver.get("https://the-internet.herokuapp.com/");
        formAuthenticationPage = new FormAuthenticationPage();
        formAuthenticationPage.clickLink("Form Authentication");
        Boolean display = formAuthenticationPage.isUsernameEleDisplay();
        LOGGER.info("Username displayed: " + display);
        Assert.assertFalse(display);

        Boolean display2 = formAuthenticationPage.isInvalidUsernameEleDisplay();
        LOGGER.info("Invalid sername displayed: " + display2);
        Assert.assertTrue(display2);
    }

    @Test
    public void softAssert() {
        WebDriver driver = DriverManager.getDriver();
        SoftAssert softAssert = new SoftAssert();
        // Launch website
        driver.get("https://the-internet.herokuapp.com/");
        formAuthenticationPage = new FormAuthenticationPage();
        formAuthenticationPage.clickLink("Form Authentication");
        Boolean display = formAuthenticationPage.isUsernameEleDisplay();
        LOGGER.info("Username displayed: " + display);
        softAssert.assertTrue(display);

        Boolean display2 = formAuthenticationPage.isInvalidUsernameEleDisplay();
        LOGGER.info("Invalid sername displayed: " + display2);
        softAssert.assertTrue(display2);
    }

}
