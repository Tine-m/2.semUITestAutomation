import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Pacman {
    public static final long PAUSE = 1000;

    public static final Keys UP = Keys.ARROW_UP;
    public static final Keys DOWN = Keys.ARROW_DOWN;
    public static final Keys LEFT = Keys.ARROW_LEFT;
    public static final Keys RIGHT = Keys.ARROW_RIGHT;

    public static WebElement controls;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\webdriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://elgoog.im/pacman/");

        controls = driver.findElement(By.id("pcm-c"));
        //controls = driver.findElement(By.name("c"));

        move(LEFT, UP, LEFT, DOWN, LEFT, UP, LEFT, DOWN, RIGHT, UP, DOWN, LEFT, RIGHT);
    }

    private static void move(Keys... directions) {
        for (Keys direction : directions) {
            controls.sendKeys(direction);
            try {
                Thread.sleep(PAUSE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
