package com.sat.havidemogondo;

import org.testng.annotations.Test;

//import com.sat.data.BookingDataFactory;
import com.sat.driver.DriverManager;
//import com.sat.models.Booking;
import com.sat.page.havidemogondo.HomePage;  // class

//import com.sat.page.booking.DetailPage;
//import com.sat.page.booking.RoomPage;
import com.sat.utils.BaseTest;

import com.sat.utils.Utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TC_04 extends BaseTest {

    // open browser

    @Test
    public void  verifyTC04() {
        logger.info("1: Open homepage"); 
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://demo.gondolatest.com/");

        logger.info("2: Add products");
        HomePage homePage = new HomePage(); // object
        homePage.clickAddToCart();

        logger.info("3: Click to cart icon");
        homePage.clickToCart();

        Utils.hardWait(2000);

        logger.info("4: Enter email address");
        homePage.enterEmail("a@gmail.com");
        Utils.hardWait(2000);

        logger.info("5: Enter cart number");
        homePage.switchToFrameByIndex(0);
        homePage.enterCardNumber("4242 4242 4242 4242");
        Utils.hardWait(2000);

        logger.info("6: Enter cart expiration date");
        homePage.enterExpirationDate("0622");
        Utils.hardWait(2000);

        logger.info("5: Enter CVC code");
        homePage.enterCVCCode("111");
        Utils.hardWait(2000);

        logger.info("5: Enter Zip code");
        homePage.enterZipCode("55000");
        Utils.hardWait(2000);
        homePage.switchBackToDefaultFrame();

        logger.info("6. Click on 'Pay with credit card' button");
        homePage.clickPayWithCreditCard();
        Utils.hardWait(2000);

        logger.info("Verify payment is completed successfully");
        Assert.assertEquals(homePage.getSuccessTxt(), "Success!");
        Utils.hardWait(2000);

    }

    // close browser
}
