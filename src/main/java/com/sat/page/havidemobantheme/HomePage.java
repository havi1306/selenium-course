package com.sat.page.havidemobantheme;

import com.sat.page.havidemogondo.common.NavigationPage;
import com.sat.utils.Utils;
import com.google.gson.annotations.Until;
import com.google.inject.Key;
import com.mongodb.util.Util;
import com.sat.driver.DriverManager;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;
import io.qameta.allure.Stories;
import javafx.scene.control.Tab;
import lombok.val;

public class HomePage extends NavigationPage {
    
    // Page Factory
    @FindBy(xpath = "//div//a[@class='pos-login']")
    private WebElement registerLink;

    @FindBy(xpath = "//div//button[@name='register']")
    private WebElement registerBtn;

    @FindBy(xpath = "//div//input[@id='reg_email']")
    private WebElement emailRegTb;

    @FindBy(xpath = "//div//input[@id='reg_password']")
    private WebElement passwordRegTb;

    @FindBy(xpath = "//div//a[@class='pos-login']")
    private WebElement logInLink;

    @FindBy(xpath = "//form[@class='woocommerce-form woocommerce-form-login login']//input[@id='username']")
    private WebElement usernameLoginTb;

    @FindBy(xpath = "//form[@class='woocommerce-form woocommerce-form-login login']//input[@id='password']")
    private WebElement passwordLoginTb;

    @FindBy(xpath = "//div//button[@name='login']")
    private WebElement logInbtn;

    @FindBy(xpath = "//div//ul[@class='woocommerce-error']")
    private WebElement errorMessageTxt;

    @FindBy(xpath = "//div[@class='woocommerce-MyAccount-content']//p[1]")
    private WebElement welcomeMessageTxt;

    @FindBy(xpath = "(//div//input[@class='form-control js-typeahead tt-input' and @id='s'])[1]")
    private WebElement searchTb;

    @FindBy(xpath = "//div//button[@name='add-to-cart']")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//div//a[@href='https://bantheme.xyz/hathanhauto/thanh-toan/']")
    private WebElement conductPaymentBtn;

    @FindBy(xpath = "//div//li//a[@href='https://bantheme.xyz/hathanhauto/tai-khoan/edit-account/']")
    private WebElement accountHyperlink;

    @FindBy(xpath = "(//div//a[contains(@href,'https://bantheme.xyz/hathanhauto/tai-khoan/customer-logout')])[1]")
    private WebElement exitHyperlink;

    @FindBy(xpath = "//div//td[@class='product-name']")
    private WebElement productName;

    @FindBy(xpath = "//div//a[@class='remove']")
    private WebElement productRemove;

    @FindBy(xpath = "//div//p[@class='cart-empty woocommerce-info']")
    private WebElement cartEmptyInfo;

    @FindBy(xpath = "//div//button[@class='plus']")
    private WebElement plusBtn;

    @FindBy(xpath = "//div//button[@name='update_cart']")
    private WebElement updateCart;

    @FindBy(xpath = "//div//td[@class='product-price']//bdi")
    private WebElement unitPrice;

    @FindBy(xpath = "//div//input[@id='quantity_62af25785ebcd']")
    private WebElement numberProduct;

    @FindBy(xpath = "//div//td//strong//span[@class='woocommerce-Price-amount amount']")
    private WebElement totalPrice;

    @FindBy(xpath = "(//div//a[text()='Lốc lạnh (máy nén) xe Mercedes E CLass, GLK Class, SLK Class'])[1]")
    private WebElement mercedesProduct;
    
    @FindBy(xpath = "//div//a[@class='restore-item']")
    private WebElement restoreItem;

    @Step
    public void openBrowser(){
        
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://bantheme.xyz/hathanhauto/");
    }

    @Step
    public void clickregisterLink() {
        // Locator normal
        // WebElement addToCart1 = DriverManager.getDriver().findElement(By.xpath("//*[@id='__layout']/div/div/main/div[2]/section/div[1]/button"));
        registerLink.click();
    }

    @Step
    public void clickregisterBtn() {
        
        registerBtn.click();
    }

    @Step
    public void enterEmailRegForm(String emailReg) {

        emailRegTb.clear();
        emailRegTb.sendKeys(emailReg);
    }

    @Step
    public void enterPassRegForm(String passReg) {

        passwordRegTb.clear();
        emailRegTb.sendKeys(passReg);
    }

    @Step
    public void enterUsernameLoginForm(String username){

        usernameLoginTb.clear();
        usernameLoginTb.sendKeys(username);
    }

    @Step
    public void enterPasswordLoginForm(String password){

        passwordLoginTb.clear();
        passwordLoginTb.sendKeys(password);
    }

    @Step
    public void clickLoginLink(){

        logInLink.click();
    }

    @Step
    public void clickLoginBtn(){

        logInbtn.click();
    }

    @Step
    public String getErrorMessage(){

        return errorMessageTxt.getText();
    }

    @Step
    public String getCartEmptyInfo(){

        Utils.explicitWaitVOEL("//div//p[@class='cart-empty woocommerce-info']", 3);
        return cartEmptyInfo.getText();
    }

    @Step
    public String getWelcomeMessage(){

        return welcomeMessageTxt.getText();
    }

    @Step
    public void enterSearch(String search){

        Utils.explicitWaitVOEL("(//div//input[@class='form-control js-typeahead tt-input' and @id='s'])[1]", 3);
        searchTb.clear();
        searchTb.sendKeys(search);

        DriverManager.getDriver().findElement(By.xpath("(//div//input[@class='form-control js-typeahead tt-input' and @id='s'])[1]")).sendKeys(Keys.ENTER);
    }

    @Step
    public void clickAddToCart(){
        
        Utils.explicitWaitVOEL("//div//button[@name='add-to-cart']", 3);
        addToCartBtn.click();
    }

    @Step
    public void clickConductPayment(){

        conductPaymentBtn.click();
    } 

    @Step   
    public void clickProductRemove(){

        Utils.explicitWaitVOEL("//div//a[@class='remove']", 3);
        Utils.scrollToElement(productRemove);
        productRemove.click();
    }


    @Step
    public String getTitle(){

        return DriverManager.getDriver().getTitle();
    } 

    @Step
    public void clickAccountHyperlink(){

        accountHyperlink.click();
    }

    @Step
    public void clickExitHyperlink(){

        exitHyperlink.click();
    }

    @Step
    public void back(){

        DriverManager.getDriver().navigate().back();
    }

    @Step
    public void openNewTab(){

        JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getDriver();
        jse.executeScript("window.open()");
        Utils.hardWait(500);
        ArrayList<String> tabs = new ArrayList<String>(DriverManager.getDriver().getWindowHandles());
        DriverManager.getDriver().switchTo().window(tabs.get(1));

    }

    @Step
    public void switchTab(int index){
        
        ArrayList<String> tabs = new ArrayList<String>(DriverManager.getDriver().getWindowHandles());
        DriverManager.getDriver().switchTo().window(tabs.get(index));
    }

    @Step
    public void closeTab(){

        DriverManager.getDriver().close();
    }

    @Step
    public String getProductName(){

        Utils.explicitWaitVOEL("//div//td[@class='product-name']", 3);
        return productName.getText();
    }
    
    @Step
    public void increaseProduct(int number) {

        Utils.explicitWaitVOEL("//div//button[@class='plus']", 3);
        for(int i = 1; i < number; i++){
            plusBtn.click();
        }
    }

    @Step
    public void clickUpdateCart(){

        Utils.explicitWaitVOEL("//div//button[@name='update_cart']", 3);
        updateCart.click();
    }

    @Step
    public String totalPrice(int number){

        String unit = unitPrice.getText();
        String removeLastCharUnit = Utils.removeLastChar(unit); // 12,500,000
        removeLastCharUnit = removeLastCharUnit.replace(",", ""); // 12500000

        float unitFloat = Float.parseFloat(removeLastCharUnit);

        //String number = numberProduct.getAttribute("value");
        //int numberInt = Integer.parseInt(number);

        float total = (unitFloat * number);
        BigDecimal totalBD = new BigDecimal(total);
        String totalPrice = totalBD.toString();

        return totalPrice;
    }

    @Step
    public String getTotalPrice(){

        Utils.explicitWaitVOEL("//div//td//strong//span[@class='woocommerce-Price-amount amount']", 3);
        String total = totalPrice.getText();
        String newTotalPrice = Utils.removeLastChar(total).replace(",", "");
        return newTotalPrice;
    }

    @Step
    public void clickMercedesProduct(){

        Utils.explicitWaitVOEL("(//div//a[text()='Lốc lạnh (máy nén) xe Mercedes E CLass, GLK Class, SLK Class'])[1]", 3);
        mercedesProduct.click();
    }

    @Step
    public void clickRestoreItem(){

        Utils.explicitWaitVOEL("//div//a[@class='restore-item']", 3);
        restoreItem.click();
    }
}
