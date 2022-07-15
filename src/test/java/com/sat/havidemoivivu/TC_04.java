package com.sat.havidemoivivu;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mongodb.util.Util;
import com.sat.page.havidemoivivu.ChiTietKhachSan;
import com.sat.page.havidemoivivu.DanhSachKhachSan;
import com.sat.page.havidemoivivu.ThongTinNguoiDat;
import com.sat.page.havidemoivivu.TrangChu;
import com.sat.utils.BaseTest;
import com.sat.utils.Utils;

public class TC_04 extends BaseTest {

    // Open Browser
    @Test
    public void verifyTC04(){

        TrangChu trangChu = new TrangChu();
        DanhSachKhachSan danhSachKhachSan = new DanhSachKhachSan();
        ChiTietKhachSan chiTietKhachSan = new ChiTietKhachSan();
        ThongTinNguoiDat thongTinNguoiDat = new ThongTinNguoiDat();
      
        logger.info("1: Mở trang chủ");   
        trangChu.openBrowser();
        
        logger.info("2: Chọn địa điểm (phú quốc)");
        trangChu.nhapTimKiem("Phú Quốc");
        Utils.hardWait();
        trangChu.clickDiaChiTK("Phú Quốc");
        Utils.hardWait();

        logger.info("3: Chọn ngày xuất phát là 1 tuần sau (duration 3 ngày)");

        // get curent date
        Date currDate = new Date();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        //LocalDateTime now = LocalDateTime.now(); 
        Calendar cal = Calendar.getInstance(); 
        cal.setTime(currDate);
        cal.add(Calendar.DATE, 7);
        Date currentDatePlus = cal.getTime();
        System.out.println(currentDatePlus);
        String datePlus =  Utils.subString(df.format(currentDatePlus), 2); // --> sau 1 tuan ??? month

        trangChu.selectDate("Th 08 2022", "23");
        Utils.hardWait();
        trangChu.selectDate("Th 08 2022", "26");
        Utils.hardWait(5000);
        trangChu.clickTim();

        logger.info("4: Chọn một khách sạn bất kỳ");
        danhSachKhachSan.chonKhachSan("1");

        logger.info("5: Chọn vào nút đặt phòng");
        Utils.switchTab(1);
        Utils.hardWait();
        chiTietKhachSan.clickDatNgayBtn();
        Utils.hardWait();
        chiTietKhachSan.clickYeuCauDat2();

        logger.info("6: Bấm vào thanh toán ngay");
        thongTinNguoiDat.clickYeuCauDatPhong();
        Utils.hardWait();

        logger.info("Xác minh: Hiện vui lòng nhập họ tên");
        Assert.assertEquals(thongTinNguoiDat.getPlaceholderHoTenTxt(), "Vui lòng nhập đầy đủ họ tên");
        logger.info("Xác minh: Hiện số điện thoại không đúng định dạng");
        Assert.assertEquals(thongTinNguoiDat.getPlaceholderDienThoaiTxt(), "Số di động không đúng định dạng");
        logger.info("Xác minh: Hiện email không đúng định dạng");
        Assert.assertEquals(thongTinNguoiDat.getPlaceholdertEmailTxt(), "Email không đúng định dạng");
    }

    // close browser
    
}
