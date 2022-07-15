package com.sat.page;

import com.sat.driver.DriverManager;
import com.sat.utils.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class AbstractPageObject {

    //public WebDriver driver;

    //*********Constructor*********
    protected AbstractPageObject() {
        //this.driver = DriverManager.getDriver();
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void clickLink(String text){
        WebElement element = DriverManager.getDriver().findElement(By.xpath("//li/a[text()='"+ text +"']"));
        element.click();
    }
}
