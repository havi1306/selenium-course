package com.sat.page;

import com.sat.driver.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormAuthenticationPage extends AbstractPageObject { // inherit

    //*********Web Elements by using Page Factory*********
    @FindBy(id = "username")
    private WebElement usernameEle;

    @FindBy(id = "password")
    private WebElement passwordEle;

    @FindBy(css = ".radius")
    WebElement submitButton;

    @FindBy(id = "invalidusername")
    private WebElement invalidUsernameEle;

    @FindBy(xpath = "//h2[contains(text(),'Secure Area')]")
    WebElement secureAreaEle;

    //*********Page Methods*********
    public Boolean isUsernameEleDisplay() {
        return usernameEle.isDisplayed();
    }

    public Boolean isInvalidUsernameEleDisplay() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOfAllElements(invalidUsernameEle));
        return invalidUsernameEle.isDisplayed();
    }

    public void login(String username, String password) {
        usernameEle.sendKeys(username);
        passwordEle.sendKeys(password);
        submitButton.click();
    }

    public Boolean isSecureAreaEleDisplay() {
        return secureAreaEle.isDisplayed();
    }

}
