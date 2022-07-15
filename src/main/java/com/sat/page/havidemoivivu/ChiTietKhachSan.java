package com.sat.page.havidemoivivu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sat.page.havidemoivivu.common.NavigationPage;
import com.sat.utils.Utils;

import io.qameta.allure.Step;

public class ChiTietKhachSan extends NavigationPage{

    // page factory
    
    @FindBy(xpath = "//button[@id='ComboPriceRequestCustomer']")
    private WebElement yeuCauDat1Btn;

    @FindBy(xpath = "//button[@id='datphongnay']")
    private WebElement datNgayBtn;

    @FindBy(xpath = "(//button[@class='btn btn-warning btn-action btn-block book-button ng-scope'])[1]")
    private WebElement yeuCauDat2Btn;

    @Step
    public void clickYeuCauDat1(){

        Utils.explicitWaitVOEL("//button[@id='ComboPriceRequestCustomer']", 3);
        Utils.scrollToElement(yeuCauDat1Btn);
        yeuCauDat1Btn.click();
    }

    @Step
    public void clickYeuCauDat2(){

        //Utils.explicitWaitVOEL("(//button[@class='btn btn-warning btn-action btn-block book-button ng-scope'])[1]", 3);
        Utils.scrollToElement(yeuCauDat2Btn);
        yeuCauDat2Btn.click();
    }

    @Step
    public void clickDatNgayBtn(){

        //Utils.explicitWaitVOEL("//button[@id='datphongnay']", 3);
        datNgayBtn.click();

    }
}   
