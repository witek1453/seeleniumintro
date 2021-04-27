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

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class WebElemetsTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl/test/full_form.html");
        driver.manage().window().maximize();
    }

    @Test
    public void typingIntoWebElementTest() throws InterruptedException {

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("Selenium Start");
        String typeUserNameValue = usernameField.getAttribute("value");
        sleep();
        Assert.assertEquals(typeUserNameValue, "Selenium Start");

    }

    private void sleep() throws InterruptedException {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void uploadPickingTest() throws InterruptedException {
        sleep();

        WebElement upload_file = driver.findElement(By.id("upload_file"));
        upload_file.sendKeys("C:\\Users\\wit\\Documents\\test.txt");

        sleep();
    }

    @Test
    public void typingAndClearingValueInsideWebElementTest() throws InterruptedException {

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("Selenium Start");
        String typeUserNameValue = usernameField.getAttribute("value");
        Assert.assertEquals(typeUserNameValue, "Selenium Start");
        sleep();

        usernameField.clear();
        String emptyUserNameField = usernameField.getAttribute("value");
        Assert.assertEquals(emptyUserNameField,"");
        sleep();
    }

    @Test
    public void checkRadioButtonTest() throws InterruptedException {

        WebElement maleRadioButton = driver.findElement(By.cssSelector("input[value='male']"));
        WebElement femaleRadioButton = driver.findElement(By.cssSelector("input[value='female']"));

        maleRadioButton.click();
        assertTrue(maleRadioButton.isSelected());
        sleep();

        femaleRadioButton.click();
        assertTrue(femaleRadioButton.isSelected());
        Assert.assertFalse(maleRadioButton.isSelected());
        sleep();
    }

    @Test
    public void checkboxButtonTest() throws InterruptedException {

        WebElement pizzaCheckbox = driver.findElement(By.cssSelector("input[value='pizza']"));
        WebElement spaghettiCheckbox = driver.findElement(By.cssSelector("input[value='spaghetti']"));
        WebElement hamburgerCheckbox = driver.findElement(By.cssSelector("input[value='hamburger']"));

        Assert.assertFalse(pizzaCheckbox.isSelected());
        Assert.assertFalse(spaghettiCheckbox.isSelected());
        Assert.assertFalse(hamburgerCheckbox.isSelected());

        pizzaCheckbox.click();
        spaghettiCheckbox.click();
        hamburgerCheckbox.click();

        sleep();

        assertTrue(pizzaCheckbox.isSelected());
        assertTrue(spaghettiCheckbox.isSelected());
        assertTrue(hamburgerCheckbox.isSelected());

        sleep();

        pizzaCheckbox.click();
        spaghettiCheckbox.click();
        hamburgerCheckbox.click();

        Assert.assertFalse(pizzaCheckbox.isSelected());
        Assert.assertFalse(spaghettiCheckbox.isSelected());
        Assert.assertFalse(hamburgerCheckbox.isSelected());
    }

    @Test
    public void dropDownListingTest(){

        WebElement countryWebElement = driver.findElement(By.id("country"));
        Select countryDropDown = new Select(countryWebElement);

        List<WebElement> options = countryDropDown.getOptions();
        List<String> namesOfOptions = new ArrayList<String>();

        for (WebElement option : options) {
            namesOfOptions.add(option.getText());
            System.out.println(option.getText());
        }

        List<String> expectedNamesOfOptions = new ArrayList<String>();
        expectedNamesOfOptions.add("Germany");
        expectedNamesOfOptions.add("Poland");
        expectedNamesOfOptions.add("UK");

        Assert.assertEquals(namesOfOptions,expectedNamesOfOptions);

    }

    @Test
    public void selectingOptionsFromDropDownTest() throws InterruptedException {

        WebElement countryWebElement = driver.findElement(By.id("country"));
        Select countryDropDown = new Select(countryWebElement);

        sleep();

        countryDropDown.selectByIndex(1);

        sleep();

        Assert.assertEquals(countryDropDown.getFirstSelectedOption().getText(),"Poland");

        countryDropDown.selectByValue("de_DE");

        sleep();

        Assert.assertEquals(countryDropDown.getFirstSelectedOption().getText(),"Germany");

        countryDropDown.selectByVisibleText("UK");

        sleep();

        Assert.assertEquals(countryDropDown.getFirstSelectedOption().getText(),"UK");
    }


    @Test
    public void checkIfElementsOnPageTest(){

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement emailLabel = driver.findElement(By.cssSelector("span[class='help-block']"));

        System.out.println("Is usernameField displayed: " + usernameField.isDisplayed());
        System.out.println("Is usernameField enabled: " + usernameField.isEnabled());

        System.out.println("Is passwordField displayed: " + passwordField.isDisplayed());
        System.out.println("Is passwordField enabled: " + passwordField.isEnabled());

        System.out.println("Is emailLabel displayed: " + emailLabel.isDisplayed());
        System.out.println("Is emailLabel enabled: " + emailLabel.isEnabled());

        assertTrue(usernameField.isDisplayed());
        assertTrue(passwordField.isDisplayed());
        assertTrue(emailLabel.isDisplayed());

        assertTrue(usernameField.isEnabled());
        assertFalse(passwordField.isEnabled());
    }


        @AfterMethod
        public void afterTest () {
            driver.close();
            driver.quit();
        }
    }


