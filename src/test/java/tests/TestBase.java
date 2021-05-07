package tests;

import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import navigation.ApplicationURLS;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static navigation.ApplicationURLS.APPLICATION_URL;

public class TestBase {



    @BeforeMethod
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
    }


    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}
