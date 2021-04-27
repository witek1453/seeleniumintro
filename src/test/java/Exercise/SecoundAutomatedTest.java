package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SecoundAutomatedTest {

        private WebDriver driver;

        @BeforeMethod
        public void beforeTest() {
            System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }

        @Test
        public void mySecoundTest(){
            driver.navigate().to("https://selenium.dev/");

            String pageTitle = driver.getTitle();

            assertTrue(pageTitle.equals("SeleniumHQ Browser Automation"));
        }

        @AfterMethod
        public void afterTest() {
            driver.close();
            driver.quit();
        }
    }
