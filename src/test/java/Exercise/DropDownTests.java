package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dropdown");
        driver.manage().window().maximize();
    }

    @Test
    public void checkboxesTest() {

        WebElement dropdownWebElemnt = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdownWebElemnt);

        String selectedOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption, "Please select an option");

        select.selectByValue("1");
        selectedOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption, "Option 1");




    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
