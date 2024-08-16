package pageObjects.user;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import user.AccountPageUI;
import user.ChangePasswordPageUI;

public class ChangePasswordPageObject extends BasePage {
    private WebDriver driver;

    public ChangePasswordPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public ChangePasswordPageObject inputActionsToOldPasswordTextbox(Keys key) {
        waitForElementVisible(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
        sendKeyActionsToElement(driver,  ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, key);
        return PageGeneratorManager.getChangePasswordPage(driver);
    }

    public ChangePasswordPageObject inputActionsToNewPasswordTextbox(Keys key) {
        waitForElementVisible(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
        sendKeyActionsToElement(driver,  ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, key);
        return PageGeneratorManager.getChangePasswordPage(driver);
    }

    public ChangePasswordPageObject inputActionsToConfirmPasswordTextbox(Keys key) {
        waitForElementVisible(driver, ChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyActionsToElement(driver,  ChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX, key);
        return PageGeneratorManager.getChangePasswordPage(driver);
    }

    public void inputToOldPasswordTextbox(String password) {
        waitForElementVisible(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, password);
    }

    public void inputToNewPasswordTextbox(String password) {
        waitForElementVisible(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, password);
    }

    public void inputToConfirmPasswordTextbox(String password) {
        waitForElementVisible(driver, ChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, ChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }

    public String getErrorMessageAtOldPasswordTextbox() {
        waitForElementVisible(driver, ChangePasswordPageUI.OLD_PASSWORD_ERROR_MESSAGE);
        return getElementText(driver, ChangePasswordPageUI.OLD_PASSWORD_ERROR_MESSAGE);
    }

    public String getErrorMessageAtNewPasswordTextbox() {
        waitForElementVisible(driver, ChangePasswordPageUI.NEW_PASSWORD_ERROR_MESSAGE);
        return getElementText(driver, ChangePasswordPageUI.NEW_PASSWORD_ERROR_MESSAGE);
    }

    public String getErrorMessageAtConfirmPasswordTextbox() {
        waitForElementVisible(driver, ChangePasswordPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
        return getElementText(driver, ChangePasswordPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
    }


}
