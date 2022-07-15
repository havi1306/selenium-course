package com.sat.havidemoicehrm;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sat.page.haviicehrm.LoginPage;
import com.sat.utils.BaseTest;
import com.sat.utils.Utils;

public class TC_01 extends BaseTest{
    
    // open browser

    @Test
    public void verifyTC01() {

        LoginPage loginPage = new LoginPage();

        logger.info("1: Mở trang chủ");
        loginPage.openBrowser();
        Utils.hardWait();

        logger.info("Verify: Không có button đăng ký");
        logger.info("=================" + loginPage.isRegisterBtnPresent());
        Assert.assertTrue(loginPage.isRegisterBtnPresent());

    }

    // close browser
}
