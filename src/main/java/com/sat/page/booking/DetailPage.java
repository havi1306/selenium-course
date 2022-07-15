package com.sat.page.booking;

import com.sat.driver.DriverManager;
import com.sat.page.booking.common.NavigationPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;

public class DetailPage extends NavigationPage {

    @FindBy(id = "description")
    private WebElement roomDescription;

    @FindBy(css = "#message > p")
    private WebElement message;

    @Step
    public void fillRoomDescription(String description) {
        new Actions(DriverManager.getDriver()).sendKeys(roomDescription, description);
    }

    @Step
    public String getAlertMessage() {
        return message.getText();
    }
}
