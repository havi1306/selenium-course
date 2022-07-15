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

public class DanhSachKhachSan extends NavigationPage {
    
    // Page Factory

    @Step
    public void chonKhachSan(String number){
        

        String dynamicLocator = "(//div[@class='center']//p[@class='name limit-length'])[" + number +"]";
        Utils.explicitWaitVOEL("(//div[@class='center']//p[@class='name limit-length'])[" + number +"]", 3);
        WebElement khachSan = DriverManager.getDriver().findElement(By.xpath(dynamicLocator));

        khachSan.click();
    }
    
}
