package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class ExplicitWaitTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_controls");
        driver.manage().window().maximize();
    }

    @Test
    public void waitForDisappearingElement()  {

        WebElement checkbox = driver.findElement(By.id("checkbox"));
        WebElement removeOrAddButton = driver.findElement(By.id("btn"));

        assertFalse(checkbox.isSelected());
        assertTrue(checkbox.isDisplayed());

        removeOrAddButton.click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.invisibilityOf(checkbox));

        WebElement messageLabel = driver.findElement(By.id("message"));
        assertEquals(messageLabel.getText(), "It's gone!");


    }

@Test

public  void waitForPresenceOfTheElement (){
    WebElement checkbox = driver.findElement(By.id("checkbox"));
    WebElement removeOrAddButton = driver.findElement(By.id("btn"));

    assertFalse(checkbox.isSelected());
    assertTrue(checkbox.isDisplayed());

    removeOrAddButton.click();

    WaitUntil waitUntil = new WaitUntil(driver);
    waitUntil.waitUntilElementIsInvisible(checkbox);

    WebElement messageLabel = driver.findElement(By.id("message"));
    assertEquals(messageLabel.getText(), "It's gone!");

    removeOrAddButton.click();

    checkbox = waitUntil.waitUntilPresenceOfElementLocated(By.id("checkbox"));

    assertTrue(checkbox.isDisplayed());
    assertFalse(checkbox.isSelected());
}


    @AfterMethod
    public void afterTest () {
        driver.close();
        driver.quit();
    }
}
