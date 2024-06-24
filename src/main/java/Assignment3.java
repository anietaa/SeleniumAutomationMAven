import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import java.util.Arrays;
import java.util.List;


public class Assignment3 {
    public static void main(String[] args) {
        String[] itemsNeeded = {"iphone X", "Blackberry", "Samsung Note 8"};
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.xpath("(//label[@class='customradio'])[2]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-dialog")));
        driver.findElement(By.cssSelector("button[id='okayBtn']")).click();
        WebElement testDropDown = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select dropdown = new Select(testDropDown);
        dropdown.selectByValue("teach");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
        wait.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/angularpractice/shop"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-title")));


        System.out.println(driver.getCurrentUrl());
        addItemsToCart(driver, itemsNeeded);

        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();


    }

    public static void addItemsToCart(WebDriver driver, String[] itemsNeeded) {
        List<WebElement> products = driver.findElements(By.xpath("//h4[@class='card-title']"));
        List<String> itemsNeededList = Arrays.asList(itemsNeeded);
        for (int i = 0; i < products.size(); i++) {
            String pName = products.get(i).getText();
            String fPName= pName.trim();



            if(itemsNeededList.contains(fPName)) {
                driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
//                System.out.println(Arrays.toString(itemsNeeded));
            }


        }

    }
}





















