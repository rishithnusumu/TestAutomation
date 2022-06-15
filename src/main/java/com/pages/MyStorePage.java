package com.pages;

import com.qa.factory.DriverFactory;
import com.qa.util.ElementUtil;
import io.cucumber.java.an.E;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class MyStorePage {

    private WebDriver driver;
    ElementUtil util = new ElementUtil();

        private By dressesTab = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/a");
        private By product = By.xpath("//*[@id=\"homefeatured\"]/li[3]/div/div[1]/div/a[1]/img");


   //  image = By.xpath("//*[@id=\"homefeatured\"]/li[3]/div/div[1]/div/a[1]/img");
        private By addToCardBtn = By.xpath("//*[@id=\\\"homefeatured\\\"]/li[3]/div/div[2]/div[2]/a[1]/span");

     public MyStorePage(WebDriver driver){
        this.driver =  driver;
     }

     public String getHomePageTitle(){
       return driver.getTitle();
     }
    public void addProductToCart(){


        Actions action = new Actions(DriverFactory.getDriver());
        WebElement image = DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img"));
        action.moveToElement(image).build().perform();
    }

    public void clickOnAddToCart(){

         DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]")).click();
    }

    public void clickDressesTab(){
         DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
    }


}
