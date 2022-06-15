package stepdefinitions;

import com.pages.MyStorePage;
import com.qa.factory.DriverFactory;
import com.qa.util.ElementUtil;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class ProdctSelectSteps {

    private MyStorePage myStorePage = new MyStorePage(DriverFactory.getDriver());
    ElementUtil util = new ElementUtil();

    @Given("User is on MyStore Page")
    public void user_is_on_MyStore_page() {

        DriverFactory.getDriver().get("http://automationpractice.com/index.php");
        String ExpectedPageTitle="My Store";
        String pageTitle = DriverFactory.getDriver().getTitle();
        System.out.println("Page Title is : " + pageTitle);
        Assert.assertEquals(pageTitle,ExpectedPageTitle);

    }

    @When("user click on Dresses Tab")
    public void user_click_on_dresses_tab() {
        myStorePage.clickDressesTab();
    }

    @When("select highest priced product and add to cart")
    public void select_highest_priced_product_and_add_to_cart() {
        Actions action = new Actions(DriverFactory.getDriver());
        List<WebElement> ProductImages = DriverFactory.getDriver().findElements(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img"));
        int ProductImagesCount = ProductImages.size();
        System.out.println("Total Products counts is : " + ProductImagesCount);
        List<WebElement> ProductPrice = DriverFactory.getDriver().findElements(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[1]/span[@class='price product-price']"));
        int ProductPriceCount = ProductPrice.size();
        //   System.out.println("Total Product prices are : " + ProductPriceCount);


        int highestPrice = 1;
        int k = 0;
        for (int i = 1; i <= ProductImagesCount; i++) {
            WebElement ProductImage = DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[" + i + "]/div/div[1]/div/a[1]/img"));
            action.moveToElement(ProductImage).build().perform();
            String price = DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[" + i + "]/div/div[1]/div/div[2]/span")).getText();
            int productPrice = Integer.parseInt(price.replaceAll("[^0-9]", "").toString());
          //     System.out.println("Products Price is : " + productPrice);
            if (highestPrice < productPrice) {
                highestPrice = productPrice;
                k = i;
            }

        }


        WebElement ProductImage = DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[" + k + "]/div/div[1]/div/a[1]/img"));
        action.moveToElement(ProductImage).build().perform();
        System.out.println("Product selected");
        String price = DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[" + k + "]/div/div[1]/div/div[2]/span")).getText();
        System.out.println("Product highest price is : " + price);
        DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]")).click();
       // System.out.println("Product added to Cart");

    }

    @Then("product should added to Cart and get Success Message")
    public void product_should_added_to_cart_and_get_success_message() throws InterruptedException {
        System.out.println("Expected Message: Product successfully added to your shopping cart");
            String ExpectedMessage = "Product successfully added to your shopping cart";
          Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();

      String successMessage = js.executeScript("return document.querySelector(\"div[class='layer_cart_product col-xs-12 col-md-6'] h2\").innerText").toString();

        System.out.println("Actual Message: "+successMessage);
      Thread.sleep(3000);

         Assert.assertEquals(successMessage,ExpectedMessage);


    }

}
