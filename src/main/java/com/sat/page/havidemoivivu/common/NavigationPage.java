package com.sat.page.havidemoivivu.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sat.driver.DriverManager;
import com.sat.page.AbstractPageObject;
import com.sat.utils.Utils;

import io.qameta.allure.Step;

public class NavigationPage extends AbstractPageObject{
    
        
    @FindBy(xpath = "//th[@class=\"t-arrow t-next\"]")
    private WebElement arrowNext;

    // ..
    @Step
    public void selectDate1(String month_year, String select_day){


        while(true){

            Utils.explicitWaitVOEL("//div[@class='t-datepicker-day t-datepicker-days']", 3);
            List<WebElement> monthYear = DriverManager.getDriver().findElements(By.xpath("(//div[@class='t-datepicker-day t-datepicker-days']//th[@class='t-month'])[1]"));

            for(int i = 0; i < monthYear.size(); i++){

                //System.out.println(monthYear.get(i).getText());
                // select the month
                if(monthYear.get(i).getText().equals(month_year)){

                    // select the date
                    List <WebElement> days = DriverManager.getDriver().findElements(By.xpath("//div[@class='t-datepicker-day t-datepicker-days']//td"));
                    for (WebElement d : days) {
                        //System.out.println(d.getText());
                        if(d.getText().equals(select_day)){
                            d.click();
                            return;
                        }
                    }
                }

                Utils.hardWait();
                arrowNext.click();
            }

        }
       
    }

    //..
    @Step
    public void selectDate(String month_year, String select_day){

        int count = 0;
        while(count < 3){

            //Utils.explicitWaitVOEL("//div[@class='t-datepicker-day t-datepicker-days']", 3);
            List<WebElement> monthYears = DriverManager.getDriver().findElements(By.xpath("//div[@class='t-datepicker-day t-datepicker-days']//th[@class='t-month']"));

            for(int i = 0; i < monthYears.size(); i++){

                System.out.println(monthYears.get(i).getText());
                // select the month
                if(monthYears.get(i).getText().equals(month_year)){


                    WebElement monthContainer = DriverManager.getDriver().findElements(By.xpath("//table[@class='t-table-condensed']")).get(i);

                    // select the date
                    List <WebElement> days = monthContainer.findElements(By.xpath(".//td[not(contains(@class, 't-disabled'))]"));
                    

                    for (WebElement d : days) {
                        System.out.println(d.getText());
                        if(d.getText().equals(select_day)){
                            d.click();
                            return;
                        }
                    }
                }
            }
            Utils.hardWait(500);
            arrowNext.click();
            Utils.hardWait(500);
            arrowNext.click();
            count++;
        }      
    }
}
