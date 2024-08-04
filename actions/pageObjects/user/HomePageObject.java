package pageObjects.user;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import user.HomePageUI;
import user.LoginPageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver){
        this.driver = driver;
    }

    public NewCustomerPageObject clickToNewCustomerLink() {
        waitForElementClickable(driver, HomePageUI.NEW_CUSTOMER_LINK);
        clickToElement(driver,HomePageUI.NEW_CUSTOMER_LINK);
        return PageGeneratorManager.getNewCustomerPage(driver);
    }
}
