package com.sat.havidemobantheme;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

//import com.sat.data.BookingDataFactory;
import com.sat.driver.DriverManager;
//import com.sat.models.Booking;
//import com.sat.page.havidemogondo.HomePage;
import com.sat.page.havidemobantheme.HomePage;   // class
//import com.sat.page.booking.DetailPage;
//import com.sat.page.booking.RoomPage;
import com.sat.utils.BaseTest;
import com.sat.utils.Utils;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC_08 extends BaseTest {

    // open browser

    @Test
    public void  verifyTC08() {

        HomePage homePage = new HomePage(); // object
        //Assertion softAssert = new SoftAssert();
        //WebDriver driver = DriverManager.getDriver();
        
        logger.info("1: Open homepage");
        homePage.openBrowser();

        logger.info("2: Click on 'Lốc lạnh xe Mercedes' product");
        homePage.clickMercedesProduct();
    
        logger.info("3: Add the product to cart ");
        homePage.clickAddToCart();

        logger.info("4: Click the 'X' button");
        homePage.clickProductRemove();

        logger.info(("Verify deleted products no longer appear on cart page"));
        Assert.assertEquals(homePage.getCartEmptyInfo(), "Chưa có sản phẩm nào trong giỏ hàng.");

        logger.info("5. Click on the 'Restore Item' hyperlink");
        homePage.clickRestoreItem();
        Utils.hardWait();

        logger.info(("Verify deleted product is restored"));
        String expectedResult = "Lốc lạnh (máy nén) xe Mercedes E CLass, GLK Class, SLK Class";
        Assert.assertTrue(homePage.getProductName().contains(expectedResult));
    }

    // close browser
}
