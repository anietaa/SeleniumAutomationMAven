
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;


import static dev.failsafe.internal.util.Assert.*;

public class StaticDropDown {

    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //dropdown with select tag
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByValue("INR");
        driver.findElement(By.id("divpaxinfo")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        int i =1;
        while(i<5){
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }

        driver.findElement(By.id("btnclosepaxoption")).click();

        //dynamic dropdown
        // //a[@value='GWL']  //a[@value='CCU']

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='GWL']")).click();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        //driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        //driver.findElement(By.xpath("(//a[@value='JSA'])[1]")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value='JSA']")).click();
        //driver.findElement(By.className(".ui-state-highlight"));


        //driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
        //driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover"));

        //Handelling Autosuggestive dropdowns
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for(WebElement option :options){
            if(option.getText().equalsIgnoreCase("India"))
            {
                option.click();
                break;
            }


        }
        System.out.println(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).isSelected());
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        //Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
        Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).isSelected());







    }
}
