package com.qa.util;

import com.qa.factory.DriverFactory;
import io.cucumber.java.an.E;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementUtil {
    DriverFactory driver = new DriverFactory();
    Actions action;


    public void performMouseHower(WebElement element, WebDriver driver){
        action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public void click(WebElement element){

        element.click();
    }

}
