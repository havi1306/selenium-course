package com.sat.page.booking;

import com.sat.driver.DriverManager;
import com.sat.enums.RoomType;
import com.sat.page.booking.common.NavigationPage;

import org.openqa.selenium.By;
import io.qameta.allure.Step;

public class RoomPage extends NavigationPage {

    @Step
    public void selectRoomType(RoomType room) {
        DriverManager.getDriver().findElement(By.xpath("//h6[text()='" + room + "']")).click();
    }
}
