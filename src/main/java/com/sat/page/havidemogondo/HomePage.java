package com.sat.page.havidemogondo;

import com.sat.page.havidemogondo.common.NavigationPage;

import com.sat.driver.DriverManager;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;
import io.qameta.allure.Stories;
import lombok.val;

public class HomePage extends NavigationPage {
    
    // Page Factory
    @FindBy(xpath = "//*[@id='__layout']/div/div/main/div[2]/section/div[1]/button")
    private WebElement addToCart1;

    @FindBy(xpath = "//*[@id='__layout']/div/div/main/div[2]/section/div[2]/button")
    private WebElement addToCart2;

    @FindBy(xpath = "//*[@id='__layout']/div/div/main/div[2]/section/div[3]/button")
    private WebElement addToCart3;

    @FindBy(xpath = "//*[@id='__layout']/div/div/div[1]/nav/div/a[2]/div/div")
    private WebElement cart;

    @FindBy(xpath = "//*[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//*[@id='__layout']/div/div/div[2]/div/div[3]/div/button")
    private WebElement payWithCreditCard;

    @FindBy(xpath = "//*[@id='__layout']/div/div/div[2]/div/h2")
    private WebElement successTxt; 

    @FindBy(xpath = "(//div[@class=\"cartitems\"])[1]//strong")
    private WebElement priceProduct1;

    @FindBy(xpath = "(//div[@class=\"cartitems\"])[2]//strong")
    private WebElement priceProduct2;

    @FindBy(xpath = "//*[@id='__layout']/div/div/div[2]/div/div[3]/h3")
    private WebElement totalPrice;


    @Step
    public void clickAddToCart() {
        // Locator normal
        // WebElement addToCart1 = DriverManager.getDriver().findElement(By.xpath("//*[@id='__layout']/div/div/main/div[2]/section/div[1]/button"));
        addToCart1.click();
    }

    @Step
    public void clickAddTwoProductsToCart(){
        addToCart1.click();
        addToCart2.click();
    }

    @Step
    public void clickMultipleProductsToCart() {
        // Locator normal
        // WebElement addToCart1 = DriverManager.getDriver().findElement(By.xpath("//*[@id='__layout']/div/div/main/div[2]/section/div[1]/button"));
        addToCart1.click();
        addToCart2.click();
        addToCart3.click();
    }

    @Step
    public void clickMultipleProductsToCart2() {
        int number = 3;

        for (int i = 0; i < number; i++) {
            ///System.out.println(i);
            // Dynamic Locator
            String dynamicLocator = "//*[@id='__layout']/div/div/main/div[2]/section/div[" + i + "]/button";
            WebElement addToCart = DriverManager.getDriver().findElement(By.xpath(dynamicLocator));
            addToCart.click();
        }
    }

    @Step
    public void switchToFrameByIndex (int inx){
        DriverManager.getDriver().switchTo().frame(0);
    }

    @Step
    public void switchBackToDefaultFrame (){
        DriverManager.getDriver().switchTo().defaultContent();
    }

    
    @Step
    public void enterCardNumber (String cardNumberTxt){

            //DriverManager.getDriver().switchTo().frame(0);

            String locatorCardNumber = "//*[@id='root']/form/div/div[2]/span[1]/span[2]/div/div[2]/span/input";
            WebElement cardNumberInput = DriverManager.getDriver().findElement(By.xpath(locatorCardNumber));

            cardNumberInput.sendKeys(cardNumberTxt);

            //DriverManager.getDriver().switchTo().defaultContent();
    }

    @Step
    public void enterExpirationDate (String dateTxt){

            //DriverManager.getDriver().switchTo().frame(0);

            String locatorCartExpirationDate = "//*[@id='root']/form/div/div[2]/span[2]/span/span/input";
            WebElement cartExpirationDateInput = DriverManager.getDriver().findElement(By.xpath(locatorCartExpirationDate));

            cartExpirationDateInput.sendKeys(dateTxt);

            //DriverManager.getDriver().switchTo().defaultContent();
    }

    @Step
    public void enterCVCCode (String CVCTxt){

        //DriverManager.getDriver().switchTo().frame(0);

        String locatorCVCCode = "//*[@id='root']/form/div/div[2]/span[3]/span/span/input";
        WebElement cvcCodeInput = DriverManager.getDriver().findElement(By.xpath(locatorCVCCode));

        cvcCodeInput.sendKeys(CVCTxt);

        //DriverManager.getDriver().switchTo().defaultContent();
    }

    @Step
    public void enterZipCode (String zipTxt){

        //DriverManager.getDriver().switchTo().frame(0);

        String locatorZipcode = "//*[@id='root']/form/div/div[2]/span[4]/span/span/input";
        WebElement zipcodeInput = DriverManager.getDriver().findElement(By.xpath(locatorZipcode));

        zipcodeInput.sendKeys(zipTxt);

        //DriverManager.getDriver().switchTo().defaultContent();
    }

    @Step
    public int getCartNumber() {

        String text = cart.getText(); //'1'

        int textInt = Integer.valueOf(text); //1


        //return cart.getText(); // tra ve text
        return textInt;
    }

    @Step
    public void clickToCart(){

        cart.click();
    }

    @Step
    public void enterEmail(String emailTxt) {

        email.sendKeys(emailTxt);
    }

    @Step
    public String getEmail(){

        return email.getAttribute("placeholder");
    }

    @Step
    public void clickPayWithCreditCard(){

        payWithCreditCard.click();
    }

    @Step 
    public String getSuccessTxt (){

        return successTxt.getText();
    }

    @Step
    public String priceTwoProducts (){

        String price1 = priceProduct1.getText();
        float price1Float = Float.parseFloat(price1);

        String price2 = priceProduct2.getText();
        float price2Float = Float.parseFloat(price2);

        String totalPrice =  String.format("%.2f", (price1Float + price2Float));
        
        return "Total: $" + totalPrice ;
    }

    @Step
    public String getTotalPriceActrual(){

        return totalPrice.getText();
    }

    
}
