package com.sat.page.havidemoivivu;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sat.driver.DriverManager;
import com.sat.page.havidemoivivu.common.NavigationPage;
import com.sat.utils.Utils;

import io.qameta.allure.Step;

public class TrangDangKy extends NavigationPage {

    //Page Factory
    
    @FindBy(xpath = "//div//input[@name='EmailDK']")
    private WebElement emailDKTxt;

    @FindBy(xpath = "//div//input[@name='PasswordDK']")
    private WebElement passwordDKTxt;

    @FindBy(xpath = "//button[contains(@class,'btn btn-login') and text()='Đăng ký']")
    private WebElement dangKyBtn;

    @FindBy(xpath = "//div//input[@name='RePasswordDK']")
    private WebElement rePasswordDKTxt;

    @FindBy(xpath = "(//div[@class='form-group v-margin-bottom-5']/small[@class='text-danger errorMsg'])[2]")
    private WebElement errorMsg;

    @Step
    public void clickDangKyBtn(){

        Utils.explicitWaitVOEL("//button[contains(@class,'btn btn-login') and text()='Đăng ký']", 3);
        dangKyBtn.click();
    }

    @Step
    public Boolean isEmailReuired(){

        // WebElement nameEle = DriverManager.getDriver().findElement(By.xpath("//input[@name='EmailDK']"));
        // String atr = nameEle.getAttribute("required");
        WebElement nameTextbox = DriverManager.getDriver().findElement(By.xpath("//input[@name='EmailDK' and @required]"));

        return nameTextbox.isDisplayed();
    }

    @Step
    public void nhapEmailDK(String email){

        Utils.explicitWaitVOEL("//div//input[@name='EmailDK']", 3);

        emailDKTxt.clear();
        emailDKTxt.sendKeys(email);
    }

    @Step
    public String getErrorMsg(){

        return errorMsg.getText();
    }

    @Step
    public void nhapPasswordDK(String password){

        Utils.explicitWaitVOEL("//div//input[@name='PasswordDK']", 3);

        passwordDKTxt.clear();
        passwordDKTxt.sendKeys(password);
    }

    @Step
    public void nhapRePasswordDK(String password){

        Utils.explicitWaitVOEL("//div//input[@name='RePasswordDK']", 3);

        rePasswordDKTxt.clear();
        rePasswordDKTxt.sendKeys(password);
    }
    
    @Step
    public Boolean isPasswordReuired(){

        WebElement nameTextbox = DriverManager.getDriver().findElement(By.xpath("//input[@name='PasswordDK' and @required]"));

        return nameTextbox.isDisplayed();
    }  
    
    @Step
    public String getPasswordMes(){

        String passwordMessage = Utils.getHtml5ValidationMessage(DriverManager.getDriver().findElement(By.xpath("//div//input[@name='PasswordDK']")));

        return passwordMessage;
    }
}
