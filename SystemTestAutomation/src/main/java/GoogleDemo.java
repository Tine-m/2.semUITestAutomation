import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GoogleDemo {
    //Forår 2012 Test
    public static void main(String[] args) throws InterruptedException {
        //Load driver
        System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         // Launch website
        driver.navigate().to("http://www.google.com/");
        WebElement element = driver.findElement(By.id("L2AGLb"));

        element.click();
        element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();
        System.out.println("Page title is: " + driver.getTitle());

        //driver.quit();
    }
}
