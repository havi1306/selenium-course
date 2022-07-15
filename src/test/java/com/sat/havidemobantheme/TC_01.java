package com.sat.havidemobantheme;

import org.testng.annotations.Test;

//import com.sat.data.BookingDataFactory;
import com.sat.driver.DriverManager;
//import com.sat.models.Booking;
//import com.sat.page.havidemogondo.HomePage;
import com.sat.page.havidemobantheme.HomePage;   // class
//import com.sat.page.booking.DetailPage;
//import com.sat.page.booking.RoomPage;
import com.sat.utils.BaseTest;
import com.sat.utils.Utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TC_01 extends BaseTest {

    // open browser

    @Test
    public void  verifyTC01() {

        HomePage homePage = new HomePage(); // object
        
        logger.info("1: Open homepage");
        homePage.openBrowser();

        logger.info("2: Go to Register page");
        homePage.clickregisterLink();

        logger.info("3: Click 'Dang ky' button");
        homePage.clickregisterBtn();
        Utils.hardWait(2000);

        logger.info("Verify error message displays");
        Assert.assertTrue(homePage.getErrorMessage().contains("Vui lòng cung cấp địa chỉ email hợp lệ."));

        logger.info("4: Enter invalid email");
        homePage.enterEmailRegForm("123@456");
        Utils.hardWait(2000);

        logger.info("5: Click 'Dang ky' button");
        homePage.clickregisterBtn();
        Utils.hardWait(2000);

        logger.info("Verify error message displays");
        Assert.assertTrue(homePage.getErrorMessage().contains("Vui lòng cung cấp địa chỉ email hợp lệ."));

        logger.info("6: Enter valid email");
        homePage.enterEmailRegForm("qwerty@gmail.com");
        Utils.hardWait(2000);

        logger.info("7: Click 'Dang ky' button");
        homePage.clickregisterBtn();
        Utils.hardWait(2000);

        logger.info("Verify error message displays");
        Assert.assertTrue(homePage.getErrorMessage().contains("Vui lòng nhập mật khẩu tài khoản."));

    }

    // close browser
}
