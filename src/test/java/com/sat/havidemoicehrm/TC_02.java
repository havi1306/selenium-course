package com.sat.havidemoicehrm;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.sat.page.haviicehrm.LoginPage;
import com.sat.utils.BaseTest;
import com.sat.utils.Utils;

public class TC_02 extends BaseTest{
    
    // open browser

    @Test(dataProvider = "DemoLogins")
    public void verifyTC02(String userName, String password) {

        LoginPage loginPage = new LoginPage();

        logger.info("1: Mở trang chủ");
        loginPage.openBrowser();
        Utils.hardWait();

        logger.info("2. Đăng nhập với tài khoàn Admin");
        logger.info("3. Đăng nhập với tài khoàn Manager ");
        logger.info("4. Đăng nhập với tài khoàn User");
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
        loginPage.clickLogIn();
        Utils.hardWait();

        logger.info("Xác minh đăng nhập thành công");
        Assert.assertEquals(loginPage.getTitle(), "ICE Hrm"); 
    }

    @DataProvider(name="DemoLogins")
    public Object[][] TestDataFeed(){
        
        // Create object array with 2 rows and 2 column- first parameter is row and second is 
        //column

        Object [][] loginsData=new Object[3][2];

        loginsData[0][0] = "admin";
        loginsData[0][1] = "admin";
        loginsData[1][0] = "manager";
        loginsData[1][1] = "demouserpwd";
        loginsData[2][0] = "user1";
        loginsData[2][1] = "demouserpwd";

        return loginsData;
    }

    // close browser
}
