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

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TC_02 extends BaseTest {

    // open browser

    @Test
    public void  verifyTC02() {

        HomePage homePage = new HomePage(); // object
        Assertion softAssert = new SoftAssert();
        
        logger.info("1: Open homepage");
        homePage.openBrowser();

        logger.info("2: Go to Login page");
        homePage.clickLoginLink();

        logger.info("3: Click 'Dang Nhap' button");
        homePage.clickLoginBtn();
        Utils.hardWait(2000);

        logger.info("Verify error message displays");
        Assert.assertTrue(homePage.getErrorMessage().contains("Yêu cầu tên tài khoản."));

        logger.info("4: Enter valid username");
        homePage.enterUsernameLoginForm("qwerty@gmail.com");
        Utils.hardWait(2000);

        logger.info("5: Click 'Dang Nhap' button");
        homePage.clickLoginBtn();
        Utils.hardWait(2000);

        logger.info("Verify error message displays");
        Assert.assertTrue(homePage.getErrorMessage().contains("Mục nhập mật khẩu trống."));

        logger.info("6: Enter username");
        homePage.enterUsernameLoginForm("qwertygmail@.com");
        Utils.hardWait(2000);

        logger.info("6: Enter password");
        homePage.enterPasswordLoginForm("1234567890");
        Utils.hardWait(2000);

        logger.info("7: Click 'Dang ky' button");
        homePage.clickLoginBtn();
        Utils.hardWait(2000);

        logger.info("Verify error message displays");
        String expectedResult = "tên đăng nhập qwertygmail@.com chưa được đăng ký trên trang web này. Nếu bạn không chắc chắn về tên người dùng của mình, hãy thử địa chỉ email của bạn.";
        Assert.assertTrue(homePage.getErrorMessage().contains(expectedResult));

        // logger.info("8: Enter valid username");
        // homePage.enterUsernameLoginForm("havi@gmail.com");
        // Utils.hardWait(2000);

        // logger.info("9: Enter valid password");
        // homePage.enterPasswordLoginForm("HaVi@@1234567890");
        // Utils.hardWait(2000);

        // logger.info("10: Click 'Dang ky' button");
        // homePage.clickregisterBtn();
        // Utils.hardWait(2000);

        // logger.info("Verify welcome message displays");
        // Assert.assertTrue(homePage.getWelcomeMessage().contains("havi@gmail.com"));

    }

    // close browser
}
