import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SeliniumTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");

        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
                Actions action = new Actions(driver);
        List<WebElement> ProductImages = driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img"));
        int ProductImagesCount = ProductImages.size();
        System.out.println("Total Product counts is : " + ProductImagesCount);
        List<WebElement> ProductPrice = driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[1]/span[@class='price product-price']"));
        int ProductPriceCount = ProductPrice.size();
        System.out.println("Total Product prices are : " + ProductPriceCount);



            int highestPrice = 1;
            int k=0;
            for(int i=1;i<=ProductImagesCount;i++){
                WebElement ProductImage = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li["+i+"]/div/div[1]/div/a[1]/img"));
               action.moveToElement(ProductImage).build().perform();
                String price = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li["+i+"]/div/div[1]/div/div[2]/span")).getText();
                int productPrice = Integer.parseInt(price.replaceAll("[^0-9]","").toString());
                System.out.println("Product Price is : " + productPrice);
                if(highestPrice < productPrice){
                    highestPrice = productPrice;
                     k = i;
                }

            }
        System.out.println("Highest Product price is : " + highestPrice);
        System.out.println("K value is : " + k);

      //  action.moveToElement(ProductImage).build().perform();

      //        Actions action = new Actions(driver);

                WebElement ProductImage = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li["+k+"]/div/div[1]/div/a[1]/img"));
                action.moveToElement(ProductImage).build().perform();
                System.out.println("Product selected");
                String price = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/div[2]/span")).getText();
                System.out.println("Product price is : "+ price);
                 driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]")).click();
                 System.out.println("Product added to Cart");



    }
}
