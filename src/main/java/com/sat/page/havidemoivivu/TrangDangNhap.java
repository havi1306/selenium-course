package com.sat.page.havidemoivivu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sat.page.havidemoivivu.common.NavigationPage;
import com.sat.utils.Utils;

import io.qameta.allure.Step;

public class TrangDangNhap extends NavigationPage{

    // page factory
    
    @FindBy(xpath = "//div//input[@name='EmailPhoneDN']")
    private WebElement emailPhoneDNTxt;

    @FindBy(xpath = "//div//input[@name='PasswordDN']")
    private WebElement passwordDNTxt;

    @FindBy(xpath = "//button[contains(@class,'btn btn-login') and text()='Đăng nhập']")
    private WebElement dangNhapBtn;

    @Step
    public void nhapEmailPhoneDN(String emailPhoneDN){

        Utils.explicitWaitVOEL("//div//input[@name='EmailPhoneDN']", 3);
        emailPhoneDNTxt.clear();
        emailPhoneDNTxt.sendKeys(emailPhoneDN);
    }

    @Step
    public void nhapPasswordDN(String passwordDN){

        Utils.explicitWaitVOEL("//div//input[@name='PasswordDN']", 3);
        passwordDNTxt.clear();
        passwordDNTxt.sendKeys(passwordDN);
    }

    @Step
    public void clickDangNhap(){

        Utils.explicitWaitVOEL("//button[contains(@class,'btn btn-login') and text()='Đăng nhập']", 3);
        dangNhapBtn.click();
    }

}
