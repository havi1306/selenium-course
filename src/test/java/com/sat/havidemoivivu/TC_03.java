package com.sat.havidemoivivu;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sat.page.havidemoivivu.TrangChu;
import com.sat.utils.BaseTest;
import com.sat.utils.Utils;

public class TC_03 extends BaseTest {

    // Open Browser
    @Test
    public void verifyTC03(){

        TrangChu trangChu = new TrangChu();
      
        logger.info("1: Mở trang chủ");   
        trangChu.openBrowser();
        
        logger.info("2: Click vào dấu cộng ( + ) tối đa phòng");
        trangChu.clickDatPhong();
        trangChu.tangSoPhong(10);
        Utils.hardWait();

        logger.info("Verify: Số lần chọn phòng không lớn hơn 9");
        Assert.assertTrue(Utils.compare(trangChu.getSoPhong(), "9"));

        logger.info("3: Click vào dấu cộng ( + ) tối đa người lớn");
        trangChu.tangSoNguoiLon(31);

        logger.info("Verify: Số lần chọn người không lớn hơn 30");
        Assert.assertTrue(Utils.compare(trangChu.getSoPhong(), "30"));

        logger.info("3: Click vào dấu cộng ( + ) tối đa trẻ em");
        trangChu.tangSoTreEm(13);

        logger.info("Verify: Số trẻ em không được lớn hơn 12");
        Assert.assertTrue(Utils.compare(trangChu.getSoPhong(), "12"));

    }

    // close browser
    
}
