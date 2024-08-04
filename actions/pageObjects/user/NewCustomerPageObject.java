package pageObjects.user;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import user.HomePageUI;
import user.LoginPageUI;
import user.NewCustomerPageUI;

public class NewCustomerPageObject extends BasePage {
    private WebDriver driver;

    public NewCustomerPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void clickToNewCustomerLink() {
        waitForElementClickable(driver, HomePageUI.NEW_CUSTOMER_LINK);
        clickToElement(driver,HomePageUI.NEW_CUSTOMER_LINK);
    }

    public NewCustomerPageObject inputActionsToCustomerName(Keys key) {
        waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
        sendKeyActionsToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, key);
        return PageGeneratorManager.getNewCustomerPage(driver);
    }
    public void inputToCustomerName(String customerName) {
        waitForElementVisible(driver,NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
        sendKeyToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, customerName);
    }
    public String getErrorMessageAtUserIDTextbox() {
        waitForElementVisible(driver,NewCustomerPageUI.CUSTOMER_NAME_ERROR_MESSAGE);
        return getElementText(driver,NewCustomerPageUI.CUSTOMER_NAME_ERROR_MESSAGE);
    }


}
