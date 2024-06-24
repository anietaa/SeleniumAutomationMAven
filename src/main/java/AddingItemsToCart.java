import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddingItemsToCart {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        //decalring array
        String [] itemsNeeded = {"Cucumber","Brocolli"};
        //int j=0;
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
       List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
       for(int i =0;i<products.size();i++){
           String[] name = products.get(i).getText().split("-");
           String formattedName = name[0].trim();
           //check whether itemsNeeded we extracted is present in array or not
           //Convert array into arraylist for easy search
           List<String> itemsNeededList = Arrays.asList(itemsNeeded);


           if(itemsNeededList.contains(formattedName)){


               driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

               }

           }

           driver.findElement(By.cssSelector("img[alt='Cart']")).click();
           driver.findElement(By.xpath("//div[@class='cart-preview active']//div[@class='action-block']")).click();
           driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
           driver.findElement(By.className("promoBtn")).click();
           Thread.sleep(5000);
           String st=driver.findElement(By.cssSelector("span.promoInfo")).getText();
           Assert.assertEquals(st,"Code applied ..!");



       }
    }

