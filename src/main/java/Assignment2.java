import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.name("name")).sendKeys("Harsh");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("er.anitapal@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("Test@123");
        driver.findElement(By.id("exampleCheck1")).click();

        WebElement staticDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(0);
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys("05/14/1998");
        driver.findElement(By.cssSelector("input[value='Submit']")).click();
        WebElement successMessage = driver.findElement(By.cssSelector(".alert-success"));
        System.out.println(successMessage.getText());




    }
}
