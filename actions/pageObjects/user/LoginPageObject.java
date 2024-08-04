package pageObjects.user;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import user.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }
    public LoginPageObject inputActionsToUserID(Keys key) {
        waitForElementVisible(driver, LoginPageUI.USERID_TEXTBOX);
        sendKeyActionsToElement(driver, LoginPageUI.USERID_TEXTBOX,key);
        return PageGeneratorManager.getLoginPage(driver);
    }

    public String getErrorMessageAtUserIDTextbox() {
        waitForElementVisible(driver, LoginPageUI.USERID_ERROR_MESSAGE);
        return getElementText(driver, LoginPageUI.USERID_ERROR_MESSAGE);
    }

    public String getErrorMessageAtPassWordTextbox() {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_ERROR_MESSAGE);
        return getElementText(driver, LoginPageUI.PASSWORD_ERROR_MESSAGE);
    }

    public void inputToUserID(String userName) {
        waitForElementVisible(driver,LoginPageUI.USERID_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.USERID_TEXTBOX, userName);
    }

    public void inputToPassword(String password) {
        waitForElementVisible(driver,LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public HomePageObject clickToLoginButton() {
        waitForElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getHomePage(driver);
    }
    public HomePageObject loginUser(String userName, String password){
        inputToUserID(userName);
        inputToPassword(password);
        return clickToLoginButton();

    }
}
