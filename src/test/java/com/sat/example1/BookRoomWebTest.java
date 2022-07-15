package com.sat.example1;

import org.testng.annotations.Test;

import com.sat.data.BookingDataFactory;
import com.sat.driver.DriverManager;
import com.sat.models.Booking;
import com.sat.page.booking.AccountPage;
import com.sat.page.booking.DetailPage;
import com.sat.page.booking.RoomPage;
import com.sat.utils.BaseTest;

import org.testng.Assert;

public class BookRoomWebTest extends BaseTest {

    // open browser

    

    @Test
    public void bookARoom() {
        Booking bookingInformation = new BookingDataFactory().createBookingData();

        AccountPage accountPage = new AccountPage();
        accountPage.openHomepage();
        accountPage.fillEmail(bookingInformation.getEmail());
        accountPage.fillPassword(bookingInformation.getPassword());
        accountPage.selectCountry(bookingInformation.getCountry());
        accountPage.selectBudget(bookingInformation.getDailyBudget());
        accountPage.clickNewsletter();
        accountPage.next();

        RoomPage roomPage = new RoomPage();
        roomPage.selectRoomType(bookingInformation.getRoomType());
        roomPage.next();

        DetailPage detailPage = new DetailPage();
        detailPage.fillRoomDescription(bookingInformation.getRoomDescription());
        detailPage.finish();

        Assert.assertEquals(detailPage.getAlertMessage(), "Your reservation has been made and we will contact you shortly");
                
    }


    // close browser
}
