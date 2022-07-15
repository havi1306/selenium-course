package com.sat.page.havidemoivivu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Wait;

import com.sat.driver.DriverManager;
import com.sat.page.havidemoivivu.common.NavigationPage;
import com.sat.utils.Utils;

import io.qameta.allure.Step;

public class TrangChu extends NavigationPage {
    
    // Page Factory

    @FindBy(xpath = "//ul[@class='dropdown-menu member-dropdown-menu user-menu-list']//btn[@class='btn btn-action btn-login-header']")
    private WebElement dangNhapBtn;

    @FindBy(xpath = "//a[@class='dropdown-toggle']//div[@class='img-wrapper']")
    private WebElement taiKhoanIcon;

    @FindBy(xpath = "(//span[@class='register-link'])[1]")
    private WebElement dangKyLink;

    @FindBy(xpath = "//li[@id='UserLogin']//span[@class='username-header']")
    private WebElement userDangNhap;

    @FindBy(xpath = "//div[@class='v_field__content']//p[@class='v_field__text ng-binding']")
    private WebElement datPhonglstv;

    @FindBy(xpath = "//div[contains(@class,'room-popover__item')]/div[contains(.,'Phòng')]/../div[2]//i[@class='fa fa-plus']/..")
    private WebElement tangSoPhongBtn;

    @FindBy(xpath = "//div[contains(@class,'room-popover__item')]/div[contains(.,'Người lớn')]/../div[2]//i[@class='fa fa-plus']/..")
    private WebElement tangSoNguoiLonBtn;

    @FindBy(xpath = "//div[contains(@class,'room-popover__item')]/div[contains(.,'Trẻ em')]/../div[2]//i[@class='fa fa-plus']/..")
    private WebElement tangSoTreEmBtn;

    @FindBy(xpath = "(//div[@class='quantity ng-binding'])[1]")
    private WebElement soPhong;

    @FindBy(xpath = "(//div[@class='quantity ng-binding'])[2]")
    private WebElement soNguoiLon;

    @FindBy(xpath = "(//div[@class='quantity ng-binding'])[3]")
    private WebElement soTreEm;

    @FindBy(xpath = "//div//input[@id='searchText']")
    private WebElement timKiemTxt;

    @FindBy(xpath = "//button[contains(@class, 'search-form-button btn')]")
    private WebElement timBtn;

    WebDriver driver = DriverManager.getDriver();

    @Step
    public void openBrowser(){
        
        driver.get("https://www.ivivu.com/");
    }

    @Step
    public void clickDangNhapBtn(){

        Utils.explicitWaitVOEL("//ul[@class='dropdown-menu member-dropdown-menu user-menu-list']//btn[@class='btn btn-action btn-login-header']", 3);
        dangNhapBtn.click();
    }

    @Step
    public void clickDangKyLink(){

        Utils.explicitWaitVOEL("(//span[@class='register-link'])[1]", 3);
        dangKyLink.click();
    }

    @Step
    public void clickTaiKhoanIcon(){

        Utils.explicitWaitVOEL("//a[@class='dropdown-toggle']//div[@class='img-wrapper']", 3);
        taiKhoanIcon.click();

    }

    @Step
    public String getUserDangNhap(){

        Utils.explicitWaitVOEL("//li[@id='UserLogin']//span[@class='username-header']", 3);
        return userDangNhap.getText();
    }

    @Step
    public void clickDatPhong(){

        Utils.explicitWaitVOEL("//div[@class='v_field__content']//p[@class='v_field__text ng-binding']", 3);
        datPhonglstv.click();
    }

    @Step
    public void tangSoPhong(int number){

        Utils.explicitWaitVOEL("(//i[@class='fa fa-plus'])[1]", 3);
        for (int i = 0; i <= number; i++){
            tangSoPhongBtn.click();
        }
    }

    @Step
    public String getSoPhong(){

        Utils.explicitWaitVOEL("(//div[@class='quantity ng-binding'])[1]", 3);
        return soPhong.getText();
    }

    @Step
    public void tangSoNguoiLon(int number){

        Utils.explicitWaitVOEL("(//i[@class='fa fa-plus'])[2]", 3);
        for (int i = 0; i <= number; i++){
            tangSoNguoiLonBtn.click();
        }
    }

    @Step
    public String getSoNguoiLon(){

        Utils.explicitWaitVOEL("(//div[@class='quantity ng-binding'])[2]", 3);
        return soNguoiLon.getText();
    }

    @Step
    public void tangSoTreEm(int number){

        Utils.explicitWaitVOEL("(//i[@class='fa fa-plus'])[3]", 3);
        for (int i = 0; i <= number; i++){
            tangSoTreEmBtn.click();
        }
    }

    @Step
    public String getSoTreEm(){

        Utils.explicitWaitVOEL("(//div[@class='quantity ng-binding'])[3]", 3);
        return soTreEm.getText();
    }

    @Step
    public void nhapTimKiem(String timKiem){

        //Utils.explicitWaitVOEL("//div//input[@id='searchText']", 3);
        timKiemTxt.clear();
        timKiemTxt.sendKeys(timKiem);
    }

    @Step
    public void clickDiaChiTK(String diaChi){

        String dynamicDiaChi = "(//strong[@class='tt-highlight' and contains(text(), '" + diaChi + "')])[1]";
        //Utils.explicitWaitVOEL("(//strong[@class='tt-highlight' and contains(text(), '" + diaChi + "')])[1]", 3);
        WebElement clickDiaChi = DriverManager.getDriver().findElement(By.xpath(dynamicDiaChi));
        clickDiaChi.click();
    }


    @Step
    public void clickTim(){

        //Utils.explicitWaitVOEL("//button[contains(@class, 'search-form-button btn')]", 3);
        timBtn.click();
    }
    
}
