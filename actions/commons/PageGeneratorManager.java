package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.user.AccountPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;
import pageObjects.user.CustomerPageObject;

public class PageGeneratorManager {
    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }
    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }
    public static CustomerPageObject getCustomerPage(WebDriver driver) {
        return new CustomerPageObject(driver);
    }
    public static AccountPageObject getAccountPage(WebDriver driver){
        return  new AccountPageObject(driver);
    }

}
