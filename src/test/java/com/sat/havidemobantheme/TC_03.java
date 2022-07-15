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

public class TC_03 extends BaseTest {

    // open browser

    @Test
    public void  verifyTC03() {

        HomePage homePage = new HomePage(); // object
        Assertion softAssert = new SoftAssert();
        //WebDriver driver = DriverManager.getDriver();
        
        logger.info("1: Open homepage");
        homePage.openBrowser();
        Utils.hardWait(2000);

        logger.info("2: Search with a product");
        homePage.enterSearch("Lốc lạnh xe Mercedes");
        Utils.hardWait(2000);
        
        logger.info("3: Add the product to cart ");
        homePage.clickAddToCart();
        Utils.hardWait(2000);

        logger.info("4: Click on the 'Tien Hanh Thanh Toan' button");
        homePage.clickConductPayment();
        Utils.hardWait(2000);

        logger.info("Verify URL");
        // String url = driver.getCurrentUrl();
        Assert.assertEquals(homePage.getTitle(),"Thanh toán | Hà Thành Auto");

    }

    // close browser
}
