package com.sat.havidemoivivu;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sat.page.havidemoivivu.TrangChu;
import com.sat.page.havidemoivivu.TrangDangNhap;
import com.sat.utils.BaseTest;
import com.sat.utils.Utils;

public class TC_02 extends BaseTest{

    // Open Browser
    @Test
    public void verifyTC02(){

        TrangChu trangChu = new TrangChu();
        TrangDangNhap trangDangNhap = new TrangDangNhap();

        logger.info("1: Mở trang chủ");   
        trangChu.openBrowser();
        
        logger.info("2: Nhan vao 'Tai Khoan'");
        trangChu.clickTaiKhoanIcon();

        logger.info("3: Nhan vao nut 'Dang Nhap'");
        trangChu.clickDangNhapBtn();

        logger.info("4: Điền tài khoản (đã tồn tại trên hệ thống)");
        trangDangNhap.nhapEmailPhoneDN("qwerty@gmail.com");

        logger.info("5: Điền mật khẩu (đã tồn tại trên hệ thống)");
        trangDangNhap.nhapPasswordDN("12345678");

        logger.info("6: Nhấp nút đăng nhập");
        trangDangNhap.clickDangNhap();
        Utils.hardWait();

        logger.info("Xác minh đăng nhập thành công");
        Assert.assertEquals(trangChu.getUserDangNhap(), "qwerty@gmail.com");

    }

    // close browser
    
}
