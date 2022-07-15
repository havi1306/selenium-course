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

public class TC_05 extends BaseTest {

    // open browser

    @Test
    public void  verifyTC05() {

        HomePage homePage = new HomePage(); // object

        logger.info("1: Open homepage"); 
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://demo.gondolatest.com/");

        logger.info("2: Add 2 products");    
        homePage.clickAddTwoProductsToCart();;
        Utils.hardWait(2000);

        logger.info("3: Click to cart icon");
        homePage.clickToCart();
        Utils.hardWait(2000);

        logger.info("Verify the total price displays correctly");
        Assert.assertEquals(homePage.getTotalPriceActrual(), homePage.priceTwoProducts());
        Utils.hardWait(2000);   

    }

    // close browser
}
