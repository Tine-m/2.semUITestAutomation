import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class GoogleDemoTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        //Load driver
        System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void googleSearch() {
        // Launch website
        driver.navigate().to("http://www.google.com/");
        WebElement element = driver.findElement(By.id("L2AGLb"));
        element.click();
        element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();

        assertEquals("Cheese! - Google-søgning", driver.getTitle());
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}