package com.sat.havidemoivivu;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sat.page.havidemoivivu.ChiTietKhachSan;
import com.sat.page.havidemoivivu.DanhSachKhachSan;
import com.sat.page.havidemoivivu.ThongTinNguoiDat;
import com.sat.page.havidemoivivu.TrangChu;
import com.sat.page.havidemoivivu.TrangDangNhap;
import com.sat.utils.BaseTest;
import com.sat.utils.Utils;

public class TC_05 extends BaseTest{

    // Open Browser
    @Test
    public void verifyTC05(){

        TrangChu trangChu = new TrangChu();
        TrangDangNhap trangDangNhap = new TrangDangNhap();
        DanhSachKhachSan danhSachKhachSan = new DanhSachKhachSan();
        ChiTietKhachSan chiTietKhachSan = new ChiTietKhachSan();
        ThongTinNguoiDat thongTinNguoiDat = new ThongTinNguoiDat();

        logger.info("1: Mở trang chủ (đã đăng nhập)");   
        trangChu.openBrowser();
        trangChu.clickTaiKhoanIcon();
        trangChu.clickDangNhapBtn();
        trangDangNhap.nhapEmailPhoneDN("qwerty@gmail.com");
        trangDangNhap.nhapPasswordDN("12345678");
        trangDangNhap.clickDangNhap();

        logger.info("2: Chọn địa điểm (phú quốc)");
        trangChu.nhapTimKiem("Phú Quốc");
        trangChu.clickDiaChiTK("Phú Quốc");
        trangChu.clickTim();

        logger.info("3: Chọn một khách sạn bất kỳ");
        danhSachKhachSan.chonKhachSan("1");
        Utils.hardWait();

        logger.info("4: Chọn vào nút đặt phòng");
        Utils.switchTab(1);
        Utils.hardWait();
        chiTietKhachSan.clickDatNgayBtn();
        Utils.hardWait();
        chiTietKhachSan.clickYeuCauDat2();

        logger.info("5: Chọn vào nút đặt phòng");
        thongTinNguoiDat.clickXuatHoaDon();
        Utils.hardWait();

        logger.info("Xác minh: Thông tin xuất hóa đơn hiển thị");
        Assert.assertTrue(thongTinNguoiDat.isThongTinXuatHoaDon());
    }

    // close browser
    
}
