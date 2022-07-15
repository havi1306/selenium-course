package com.sat.page.havidemoivivu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sat.page.havidemoivivu.common.NavigationPage;
import com.sat.utils.Utils;

import io.qameta.allure.Step;

public class ThongTinNguoiDat extends NavigationPage{

    // page factory
    
    @FindBy(xpath = "//button[@id='btn_complete']")
    private WebElement yeuCauDatPhongBtn;

    @FindBy(xpath = "//input[@id='customername']")
    private WebElement hoTenTxt;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement dienThoaiTxt;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailTxt;

    @FindBy(xpath = "//input[@id='registercustomerortherorder']")
    private WebElement xuatHoaDonChk;

    @FindBy(xpath = "//div[@id='registercustomerortherformhodon']")
    private WebElement thongTinXuatHoaDon;

    @Step
    public void clickYeuCauDatPhong(){

        //tils.explicitWaitVOEL("//button[@id='btn_complete']", 3);
        Utils.scrollToElement(yeuCauDatPhongBtn);
        yeuCauDatPhongBtn.click();
    }

    @Step
    public String getPlaceholderHoTenTxt(){

        return hoTenTxt.getAttribute("placeholder");
    }

    @Step
    public String getPlaceholderDienThoaiTxt(){

        return dienThoaiTxt.getAttribute("placeholder");
    }

    @Step
    public String getPlaceholdertEmailTxt(){

        return emailTxt.getAttribute("placeholder");
    }

    @Step
    public void clickXuatHoaDon(){

        xuatHoaDonChk.click();
    }

    @Step
    public Boolean isThongTinXuatHoaDon(){

        return thongTinXuatHoaDon.isDisplayed();
    }
}
