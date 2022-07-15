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

public class TC_05 extends BaseTest {

    // open browser

    @Test
    public void  verifyTC05() {

        HomePage homePage = new HomePage(); // object
        //Assertion softAssert = new SoftAssert();
        //WebDriver driver = DriverManager.getDriver();
        
        logger.info("1: Open homepage");
        homePage.openBrowser();
        Utils.hardWait(5000);

        logger.info("2: Go to Login page");
        homePage.clickLoginLink();
    
        logger.info("3: Sign in the account");
        homePage.enterUsernameLoginForm("havi1306@gmail.com");
        homePage.enterPasswordLoginForm("HaVi@@1234567890");
        homePage.clickLoginBtn();
        Utils.hardWait(2000);

        logger.info("4: Open a new tab");
        homePage.openNewTab();
        homePage.openBrowser();
        Utils.hardWait(2000);

        logger.info("5: Close old tab");
        homePage.switchTab(0);
        homePage.closeTab();
        homePage.switchTab(0);
        Utils.hardWait(2000);

        logger.info("7: Click 'Dang Nhap' button");
        homePage.clickLoginLink();

        logger.info("Verrify the user goes to the account management page ");
        Assert.assertEquals(homePage.getTitle(), "Tài khoản | Hà Thành Auto");
    }

    // close browser
}
