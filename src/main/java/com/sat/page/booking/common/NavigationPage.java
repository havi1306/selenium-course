package com.sat.page.booking.common;

import com.sat.config.Constants;
import com.sat.driver.DriverManager;
import com.sat.page.AbstractPageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;

public class NavigationPage extends AbstractPageObject {

    @FindBy(name = "next")
    private WebElement next;

    @FindBy(name = "previous")
    private WebElement previous;

    @FindBy(name = "finish")
    private WebElement finish;

    @Step
    public void next() {
        next.click();
    }

    @Step
    public void previous() {
        previous.click();
    }

    @Step
    public void finish() {
        finish.click();
    }
    
    @Step
    public void openHomepage() {
        DriverManager.getDriver().get(Constants.Url_Base);
    }

}
