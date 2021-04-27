package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ActionTest {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl/test/hover_mouse.html");
        driver.manage().window().maximize();
    }

    @Test
    public void actionTest() throws InterruptedException {

        WebElement smileyIcon = driver.findElement(By.id("smiley"));
        WebElement smileyIcon2 = driver.findElement(By.id("smiley2"));

        Actions action = new Actions(driver);
        action.moveToElement(smileyIcon).build().perform();
        sleep();

        Actions secondAction = new Actions(driver);
        action.moveToElement(smileyIcon2).build().perform();
        sleep();

    }

    private void sleep() throws InterruptedException {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



        @AfterMethod
        public void afterTest () {
            driver.close();
            driver.quit();
        }
    }

