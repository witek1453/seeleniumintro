package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LandingPage {


    @FindBy(css = "#Content a")
    private WebElement enterStoreLink;


    public LandingPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnEnterStoreLink() {
        WaitForElement.waitUntilElementsIsClickable(enterStoreLink);
        enterStoreLink.click();
    }
}
