package pageObjects.user;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import user.AccountPageUI;
import user.CustomerPageUI;

public class AccountPageObject extends BasePage {
    private WebDriver driver;

    public AccountPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public AccountPageObject inputActionsToInitialDepositTextbox(Keys key) {
        waitForElementVisible(driver, AccountPageUI.INITIAL_DEPOSIT_TEXTBOX);
        sendKeyActionsToElement(driver, AccountPageUI.INITIAL_DEPOSIT_TEXTBOX, key);
        return PageGeneratorManager.getAccountPage(driver);
    }

    public AccountPageObject inputActionsToAccountNoTextbox(Keys key) {
        waitForElementVisible(driver, AccountPageUI.ACCOUNT_NO_TEXTBOX);
        sendKeyActionsToElement(driver, AccountPageUI.ACCOUNT_NO_TEXTBOX, key);
        return PageGeneratorManager.getAccountPage(driver);
    }

    public void inputToInitialDepositTextbox(String initialDeposit) {
        waitForElementVisible(driver, AccountPageUI.INITIAL_DEPOSIT_TEXTBOX);
        sendKeyToElement(driver, AccountPageUI.INITIAL_DEPOSIT_TEXTBOX, initialDeposit);
    }

    public void inputToAccountNoTextbox(String accountNo) {
        waitForElementVisible(driver, AccountPageUI.ACCOUNT_NO_TEXTBOX);
        sendKeyToElement(driver, AccountPageUI.ACCOUNT_NO_TEXTBOX, accountNo);
    }

    public String getErrorMessageAtInitialDepositTextbox() {
        waitForElementVisible(driver, AccountPageUI.INITIAL_DEPOSIT_ERROR_MESSAGE);
        return getElementText(driver, AccountPageUI.INITIAL_DEPOSIT_ERROR_MESSAGE);
    }

    public String getErrorMessageAtAccountNoTextbox() {
        waitForElementVisible(driver, AccountPageUI.ACCOUNT_NO_ERROR_MESSAGE);
        return getElementText(driver, AccountPageUI.ACCOUNT_NO_ERROR_MESSAGE);
    }
}
