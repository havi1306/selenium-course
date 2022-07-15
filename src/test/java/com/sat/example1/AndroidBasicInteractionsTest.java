package com.sat.example1;


import org.testng.annotations.Test;
import io.qameta.allure.Feature;
import io.qameta.allure.Description;
import com.sat.utils.BaseTest;

import java.io.IOException;


import com.sat.driver.DriverManager;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AndroidBasicInteractionsTest extends BaseTest {
    private AndroidDriver delegate = null;
    private final String SEARCH_ACTIVITY = ".app.SearchInvoke";
    private final String ALERT_DIALOG_ACTIVITY = ".app.AlertDialogSamples";
    private final String PACKAGE = "io.appium.android.apis";

    private final String PHONE_ACTIVITY = ".DialtactsActivity";
    private final String PHONE_PACKAGE = "com.google.android.dialer";

    private final String MESSAGE_ACTIVITY = "com.google.android.apps.messaging.ui.ConversationListActivity";
    private final String MESSAGE_PACKAGE = "com.google.android.apps.messaging";

    private final String SAUCELABAPP_ACTIVITY = "com.swaglabsmobileapp.MainActivity";
    private final String SAUCELABAPP_PACKAGE = "com.swaglabsmobileapp";

    // @Test
    // public void testSendKeys() {
    //     delegate = (AndroidDriver) DriverManager.getDriver().getDelegate();
    //     delegate.startActivity(new Activity(PACKAGE, SEARCH_ACTIVITY));
    //     AndroidElement searchBoxEl = (AndroidElement) delegate.findElementById("txt_query_prefill");
    //     searchBoxEl.sendKeys("Hello world!");
    //     AndroidElement onSearchRequestedBtn = (AndroidElement) delegate.findElementById("btn_start_search");
    //     onSearchRequestedBtn.click();
    //     AndroidElement searchText = (AndroidElement) new WebDriverWait(delegate, 30)
    //             .until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/search_src_text")));
    //     String searchTextValue = searchText.getText();
    //     Assert.assertEquals(searchTextValue, "Hello world!");

    //     delegate.startActivity(new Activity(PHONE_PACKAGE, PHONE_ACTIVITY));

    //     AndroidElement phoneButton = (AndroidElement) delegate.findElementById("com.google.android.dialer:id/floating_action_button");
    //     phoneButton.click();

    //     AndroidElement numerOne = (AndroidElement) delegate.findElementById("com.google.android.dialer:id/one");
    //     numerOne.click();
    //     numerOne.click();

    //     AndroidElement numberThree = (AndroidElement) delegate.findElementById("com.google.android.dialer:id/three");
    //     numberThree.click();

    //     AndroidElement sendSMS = (AndroidElement) delegate.findElementByXPath("//android.widget.TextView[@content-desc='Send SMS']");
    //     sendSMS.click();

    // }

    @Test
    public void testFingerAndOTP() throws IOException {
        delegate = (AndroidDriver) DriverManager.getDriver();
        
        // Login Test App with finger print
        AndroidElement loginWithBiometric = (AndroidElement) delegate.findElementByXPath("//android.view.ViewGroup[@content-desc='test-biometry']");
        loginWithBiometric.click();
        Runtime.getRuntime().exec("adb -e emu finger touch 1");

        // Check out an order
        AndroidElement addToCartBtn = (AndroidElement) delegate.findElementByXPath("(//android.view.ViewGroup[@content-desc='test-ADD TO CART'])[2]");
        addToCartBtn.click();

        AndroidElement cartBtn = (AndroidElement) delegate.findElementByXPath("//android.view.ViewGroup[@content-desc='test-Cart']");
        cartBtn.click();

        AndroidElement checkOutBtn = (AndroidElement) delegate.findElementByXPath("//android.view.ViewGroup[@content-desc='test-CHECKOUT']");
        checkOutBtn.click();

        AndroidElement firstName = (AndroidElement) delegate.findElementByXPath("//android.widget.EditText[@content-desc='test-First Name']");
        firstName.sendKeys("Mai!");
        
        AndroidElement lastName = (AndroidElement) delegate.findElementByXPath("//android.widget.EditText[@content-desc='test-Last Name']");
        lastName.sendKeys("Nguyen");

        // Launch message app
        Activity activity = new Activity(MESSAGE_PACKAGE, MESSAGE_ACTIVITY);
        //activity.setStopApp(false);
        delegate.startActivity(activity);
        
        AndroidElement clickMessage = (AndroidElement) delegate.findElementByXPath("//*[@resource-id='android:id/list']");
        clickMessage.click();

        // Get OTP
        AndroidElement getMessage = (AndroidElement) delegate.findElementByXPath("//*[@resource-id='com.google.android.apps.messaging:id/message_text']");
        String OTP = getMessage.getText().split("Ma OTP cua ban la ")[1];

        // Re launch test app
        activity = new Activity(SAUCELABAPP_PACKAGE, SAUCELABAPP_ACTIVITY); 
        activity.setStopApp(false);
        delegate.startActivity(activity);

        // Enter OTP & checkout
        AndroidElement zipCode = (AndroidElement) delegate.findElementByXPath("//android.widget.EditText[@content-desc='test-Zip/Postal Code']");
        zipCode.sendKeys(OTP);

        AndroidElement continueBtn = (AndroidElement) delegate.findElementByXPath("//android.view.ViewGroup[@content-desc='test-CONTINUE']");
        continueBtn.click();

        String price = delegate.findElementByXPath("//android.view.ViewGroup[@content-desc='test-Price']/android.widget.TextView").getText();
        System.out.println("Price is: " + price);

        String text = "FINISH";
        delegate.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\""+text+"\"))");
        AndroidElement finishBtn = (AndroidElement) delegate.findElementByXPath("//android.view.ViewGroup[@content-desc='test-FINISH']");
        finishBtn.click();

        String checkoutComplete = delegate.findElementByXPath("//android.widget.ScrollView[@content-desc='test-CHECKOUT: COMPLETE!']/android.view.ViewGroup/android.widget.TextView[1]").getText();
        Assert.assertEquals(checkoutComplete, "THANK YOU FOR YOU ORDER");

    }


    // @Test
    // public void testOpensAlert() {
    //     delegate = (AndroidDriver) DriverManager.getDriver().getDelegate();
    //     // Open the "Alert Dialog" activity of the android app
    //     delegate.startActivity(new Activity(PACKAGE, ALERT_DIALOG_ACTIVITY));

    //     // Click button that opens a dialog
    //     AndroidElement openDialogButton = (AndroidElement) delegate.findElementById("io.appium.android.apis:id/two_buttons");
    //     openDialogButton.click();

    //     // Check that the dialog is there
    //     AndroidElement alertElement = (AndroidElement) delegate.findElementById("android:id/alertTitle");
    //     String alertText = alertElement.getText();
    //     Assert.assertEquals(alertText, "Lorem ipsum dolor sit aie consectetur adipiscing\nPlloaso mako nuto siwuf cakso dodtos anr koop.");
    //     AndroidElement closeDialogButton = (AndroidElement) delegate.findElementById("android:id/button1");

    //     // Close the dialog
    //     closeDialogButton.click();
    // }
}

