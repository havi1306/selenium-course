package com.sat.havidemoivivu;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sat.page.havidemoivivu.TrangChu;
import com.sat.page.havidemoivivu.TrangDangKy;
import com.sat.utils.BaseTest;
import com.sat.utils.Utils;

public class TC_01 extends BaseTest{
    
    // open browser

    @Test
    public void verifyTC01() {

        TrangChu trangChu = new TrangChu();
        TrangDangKy trangDangKy = new TrangDangKy();

        logger.info("1: Mo trang ivivu");
        trangChu.openBrowser();

        logger.info("2: Vao trang Dang Ky");
        trangChu.clickTaiKhoanIcon();
        trangChu.clickDangKyLink();

        logger.info("3: Nhan vao nut Dang Ky");
        trangDangKy.clickDangKyBtn();
        Utils.hardWait();

        logger.info("Verify: Email field là bắt buộc");
        Assert.assertTrue(trangDangKy.isEmailReuired());

        logger.info("4: Nhap email (eg: qwerty@gmail.com)");
        trangDangKy.nhapEmailDK("qwerty@gmail.com");

        logger.info("5: Bam vao nut 'Dang Ky'");
        trangDangKy.clickDangKyBtn();
        Utils.hardWait();

        logger.info("Verify: Email field là bắt buộc");
        Assert.assertTrue(trangDangKy.isPasswordReuired());

        logger.info("6: Nhap password (eg: 123)");
        trangDangKy.nhapPasswordDK("123");

        logger.info("7: Bam vao nut 'Dang Ky'");
        trangDangKy.clickDangKyBtn();
        Utils.hardWait();

        logger.info("Verify: Mật khẩu tối thiểu 6 ký tự");
        Assert.assertEquals(trangDangKy.getPasswordMes(), "Mật khẩu tối thiểu 6 ký tự");

        logger.info("8: Nhap password (eg: 12345678)");
        trangDangKy.nhapPasswordDK("12345678");

        logger.info("9: Nhap re_password (eg: 12345678)");
        trangDangKy.nhapRePasswordDK("12345678");

        logger.info("9: Bam vao nut 'Dang Ky'");
        trangDangKy.clickDangKyBtn();
        Utils.hardWait();

        logger.info("Verify: Bạn phải đồng ý với điều khoản của iVIVU !");
        Assert.assertEquals(trangDangKy.getErrorMsg(), "Bạn phải đồng ý với điều khoản của iVIVU !");

    }

    // close browser
}
