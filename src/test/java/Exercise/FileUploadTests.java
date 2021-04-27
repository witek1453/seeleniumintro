package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/upload");
        driver.manage().window().maximize();
    }

    @Test
    public void fileUploadTest() throws InterruptedException {

        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        WebElement uploadButton = driver.findElement(By.id("file-submit"));

        chooseFile.sendKeys("C:\\testfile.txt");
        uploadButton.click();

        WebElement messageFileUpload = driver.findElement(By.xpath("//*[@class='example']/h3"));
        Assert.assertEquals(messageFileUpload.getText(),"File Uploaded!");


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
