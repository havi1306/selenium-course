package com.sat.utils;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;


import com.sat.driver.DriverManager;

public class Utils {
    public static void hardWait(int timeout){
        try {
            Thread.sleep(timeout);
        } catch (Exception e) {
            // pass
        }
    }

    public static void hardWait(){
        hardWait(3000);
    }

    public static void scrollToElement(WebElement webElement) {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
        hardWait(500);
    }

    public static void newTab() {
        JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getDriver();
        jse.executeScript("window.open()");
        hardWait(500);

        ArrayList<String> tabs = new ArrayList<String>(DriverManager.getDriver().getWindowHandles());
        DriverManager.getDriver().switchTo().window(tabs.get(1));
    }



    public static void hover(WebElement webElement) {
        Actions action = new Actions(DriverManager.getDriver());

        action.moveToElement(webElement);
        action.build().perform();
        hardWait(500);
    }

    public static void acceptAlert() {
        
        DriverManager.getDriver().switchTo().alert().accept();
    }

    public static void explicitWaitVOEL(String xpath, int timeout) {
        
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        
    }

    public static String removeLastChar(String s) {  

    //returns the string after removing the last character  
    return s.substring(0, s.length() - 1);  
    }

    public static String subString(String s, int i) {  

        //returns the string after removing the last character  
        return s.length() > i ? s.substring(s.length() - i) : s;  
        }
    
    public static String getHtml5ValidationMessage(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
        }

    public static Boolean compare (String a , String b){
        
        Integer number1 = Integer.parseInt(a);
        Integer number2 = Integer.parseInt(b);

        if(number1 <= number2){
            return true;
        }
        return false;
    }

    public static void switchTab(int index){
        
        ArrayList<String> tabs = new ArrayList<String>(DriverManager.getDriver().getWindowHandles());
        DriverManager.getDriver().switchTo().window(tabs.get(index));
    }      
}

