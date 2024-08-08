package pageObjects.user;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import user.AccountPageUI;
import user.CustomerPageUI;

public class AccountPageObject extends BasePage {
    private WebDriver driver;

    public AccountPageObject(WebDriver driver){
        this.driver = driver;
    }

    public AccountPageObject inputActionsToInitialDepositTextbox(Keys key) {
        waitForElementVisible(driver, AccountPageUI.INITIAL_DEPOSIT_TEXTBOX);
        sendKeyActionsToElement(driver, AccountPageUI.INITIAL_DEPOSIT_TEXTBOX, key);
        return PageGeneratorManager.getAccountPage(driver);
    }

    public void inputToInitialDepositTextbox(String initialDeposit) {
        waitForElementVisible(driver, AccountPageUI.INITIAL_DEPOSIT_TEXTBOX);
        sendKeyToElement(driver, AccountPageUI.INITIAL_DEPOSIT_TEXTBOX, initialDeposit);
    }

    public String getErrorMessageAtInitialDepositTextbox() {
        waitForElementVisible(driver,AccountPageUI.INITIAL_DEPOSIT_ERROR_MESSAGE);
        return getElementText(driver, AccountPageUI.INITIAL_DEPOSIT_ERROR_MESSAGE);
    }
}
