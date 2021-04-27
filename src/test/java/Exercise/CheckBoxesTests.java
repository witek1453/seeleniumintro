package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CheckBoxesTests{
        private WebDriver driver;

        @BeforeMethod
        public void beforeTest() {
            System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.navigate().to("http://theinternet.przyklady.javastart.pl/checkboxes");
            driver.manage().window().maximize();
        }

        @Test
        public void checkboxesTest() {

            WebElement checkbox1 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
            WebElement checkbox2 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));

            Assert.assertFalse(checkbox1.isSelected());
            Assert.assertTrue(checkbox2.isSelected());

            checkbox1.click();
            checkbox2.click();

            Assert.assertTrue(checkbox1.isSelected());
            Assert.assertFalse(checkbox2.isSelected());

        }

        @AfterMethod
        public void afterTest() {
            driver.close();
            driver.quit();
        }

}
