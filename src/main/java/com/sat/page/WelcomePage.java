package com.sat.page;

import com.sat.driver.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage extends AbstractPageObject {
    WebDriver driver = DriverManager.getDriver();

    //*********Web Elements by using Page Factory*********
    @FindBy(xpath = "//h1")
    private WebElement titleWelcomePage;

    @FindBy(xpath = "//h2")
    private WebElement subTitleWelcomePage;

    //*********Page Methods*********
    public String getTitle() {
        return driver.getTitle();
    }

    public String getTextTitleWelcome() {
        return titleWelcomePage.getText();
    }

    public String getTextSubTitleAvailable() {
        return subTitleWelcomePage.getText();
    }
}
