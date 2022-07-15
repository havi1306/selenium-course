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

public class TC_01 extends BaseTest {

    // open browser

    @Test
    public void  verifyTC01() {
        // 1. Open homepage 
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://demo.gondolatest.com/");

        // 2. Add a single product
        HomePage homePage = new HomePage(); // object
        homePage.clickAddToCart();


        // 3. Verify 1 product in cart
        Assert.assertEquals(homePage.getCartNumber(), 2, "mot khac hai , vui long kiem tra lai code");

    }

    // close browser
}
