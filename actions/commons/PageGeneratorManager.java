package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.user.*;

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
    public static MiniStatementPageObject getMiniStatementPage(WebDriver driver){
        return  new MiniStatementPageObject(driver);
    }
    public static CustomisedStatementPageObject getCustomisedStatementPage(WebDriver driver){
        return new CustomisedStatementPageObject(driver);
    }

}
