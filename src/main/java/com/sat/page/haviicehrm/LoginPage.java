package com.sat.page.haviicehrm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.sat.driver.DriverManager;
import com.sat.page.haviicehrm.common.NavigationPage;
import com.sat.config.Constants;

import io.qameta.allure.Step;

public class LoginPage extends NavigationPage {
    
    WebDriver driver = DriverManager.getDriver();

     // Page Factory

     @FindBy(xpath = "//div//input[@id='username']")
     WebElement userNameTxt;

     @FindBy(xpath = "//div//input[@id='password']")
     WebElement passWordTxt;

     @FindBy(xpath = "//button[text()='Log in ']")
     WebElement logInBtn;

    @Step
    public void openBrowser(){
        
        driver.get(Constants.Url_Base8);;
    }

    @Step
    public boolean isRegisterBtnPresent() {
        List<WebElement> buttons = driver.findElements(By.xpath("//*[contains(text(),'Register')]"));
        if (buttons.size() > 0 && buttons.get(0).isDisplayed())
        {
            return false;
        }
        return true;
    } 

    @Test
    public void enterUserName(String userName){

        userNameTxt.clear();
        userNameTxt.sendKeys(userName);
    }

    @Test
    public void enterPassword(String passwword){

        passWordTxt.clear();
        passWordTxt.sendKeys(passwword);
    }

    @Test
    public void clickLogIn(){

        logInBtn.click();
    }

    @Test
    public String getTitle(){

        return DriverManager.getDriver().getTitle();
    }
}