import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumIntroduction {

    private static Thread thread;

    public static void main(String [] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/SeleniumDriver/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        System.out.println(driver.getTitle());
        WebElement heading = driver.findElement(By.tagName("h1"));
        System.out.println(heading.getText());
         WebElement loginTab = driver.findElement(By.id("inputUsername"));
         loginTab.sendKeys("rahul");
         WebElement passwordTab = driver.findElement(By.name("inputPassword"));
         passwordTab.sendKeys("hello123");
         WebElement checkBox1 = driver.findElement(By.id("chkboxOne"));
         checkBox1.click();
         WebElement checkBox2 = driver.findElement(By.name("chkboxTwo"));
         checkBox2.click();
         driver.findElement(By.className("signInBtn")).click();

         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
         System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
         driver.findElement(By.linkText("Forgot your password?")).click();
         driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("naman");
         driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("jhon@rsa.com");
         driver.findElement(By.xpath("//form/input[3]")).sendKeys("9650817488");
         driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();

         System.out.println(driver.findElement(By.cssSelector("form p")).getText());
         Thread.sleep(2000);

         driver.findElement(By.className("go-to-login-btn")).click();
         driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
         driver.findElement(By.cssSelector("input[type*='Pass']")).sendKeys("rahulshettyacademy");
         checkBox1.click();
         checkBox2.click();
         driver.findElement(By.className("signInBtn")).click();

         System.out.println(driver.findElement(By.tagName("p")).getText());
         System.out.println(driver.findElement(By.cssSelector(".login-container > h2")).getText());
         System.out.println(driver.findElement(By.cssSelector(".login-container > h1")).getText());
         Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
         driver.findElement(By.cssSelector("button.logout-btn")).click();
         driver.quit();
      //System.out.println(loginTab.getText());

    }}

