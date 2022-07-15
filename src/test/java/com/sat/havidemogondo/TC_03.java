package com.sat.havidemogondo;

import org.testng.annotations.Test;

//import com.sat.data.BookingDataFactory;
import com.sat.driver.DriverManager;
//import com.sat.models.Booking;
import com.sat.page.havidemogondo.HomePage;  // class
//import com.sat.page.booking.DetailPage;
//import com.sat.page.booking.RoomPage;
import com.sat.utils.BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TC_03 extends BaseTest {

    // open browser

    @Test
    public void  verifyTC03() {
        // 1. Open homepage 
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://demo.gondolatest.com/");

        // 2. Add 3 products
        HomePage homePage = new HomePage(); // object
        for(int i = 0 ; i < 3; i++) {
            homePage.clickAddToCart();
        }

        // 3. Verify 3 product in cart
        Assert.assertEquals(homePage.getCartNumber(), 3);

    }

    // close browser
}
