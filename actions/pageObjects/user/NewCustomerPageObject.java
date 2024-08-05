package pageObjects.user;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import user.NewCustomerPageUI;

public class NewCustomerPageObject extends BasePage {
    private WebDriver driver;

    public NewCustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public NewCustomerPageObject inputActionsToCustomerName(Keys key) {
        waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
        sendKeyActionsToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, key);
        return PageGeneratorManager.getNewCustomerPage(driver);
    }

    public NewCustomerPageObject inputActionsToAddress(Keys key) {
        waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTBOX);
        sendKeyActionsToElement(driver, NewCustomerPageUI.ADDRESS_TEXTBOX, key);
        return PageGeneratorManager.getNewCustomerPage(driver);
    }

    public NewCustomerPageObject inputActionsToCity(Keys key) {
        waitForElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
        sendKeyActionsToElement(driver, NewCustomerPageUI.CITY_TEXTBOX, key);
        return PageGeneratorManager.getNewCustomerPage(driver);
    }

    public NewCustomerPageObject inputActionsToState(Keys key) {
        waitForElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
        sendKeyActionsToElement(driver, NewCustomerPageUI.STATE_TEXTBOX, key);
        return PageGeneratorManager.getNewCustomerPage(driver);
    }

    public NewCustomerPageObject inputActionsToPIN(Keys key) {
        waitForElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
        sendKeyActionsToElement(driver, NewCustomerPageUI.PIN_TEXTBOX, key);
        return PageGeneratorManager.getNewCustomerPage(driver);
    }

    public NewCustomerPageObject inputActionsToMobileNumber(Keys key) {
        waitForElementVisible(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
        sendKeyActionsToElement(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX, key);
        return PageGeneratorManager.getNewCustomerPage(driver);
    }

    public NewCustomerPageObject inputActionsToEmail(Keys key) {
        waitForElementVisible(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
        sendKeyActionsToElement(driver, NewCustomerPageUI.EMAIL_TEXTBOX, key);
        return PageGeneratorManager.getNewCustomerPage(driver);
    }

    public void inputToCustomerName(String customerName) {
        waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
        sendKeyToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, customerName);
    }

    public void inputToAddress(String address) {
        waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTBOX);
        sendKeyToElement(driver, NewCustomerPageUI.ADDRESS_TEXTBOX, address);
    }

    public void inputToCity(String city) {
        waitForElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
        sendKeyToElement(driver, NewCustomerPageUI.CITY_TEXTBOX, city);
    }

    public void inputToState(String state) {
        waitForElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
        sendKeyToElement(driver, NewCustomerPageUI.STATE_TEXTBOX, state);
    }

    public void inputToPIN(String pin) {
        waitForElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
        sendKeyToElement(driver, NewCustomerPageUI.PIN_TEXTBOX, pin);
    }

    public void inputToMobileNumber(String mobileNumber) {
        waitForElementVisible(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
        sendKeyToElement(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX, mobileNumber);
    }

    public void inputToEmail(String email) {
        waitForElementVisible(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, NewCustomerPageUI.EMAIL_TEXTBOX, email);
    }

    public String getErrorMessageAtUserIDTextbox() {
        waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_ERROR_MESSAGE);
        return getElementText(driver, NewCustomerPageUI.CUSTOMER_NAME_ERROR_MESSAGE);
    }

    public String getErrorMessageAtAddressTextbox() {
        waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_ERROR_MESSAGE);
        return getElementText(driver, NewCustomerPageUI.ADDRESS_ERROR_MESSAGE);
    }

    public String getErrorMessageAtCityTextbox() {
        waitForElementVisible(driver, NewCustomerPageUI.CITY_ERROR_MESSAGE);
        return getElementText(driver, NewCustomerPageUI.CITY_ERROR_MESSAGE);
    }

    public String getErrorMessageAtStateTextbox() {
        waitForElementVisible(driver, NewCustomerPageUI.STATE_ERROR_MESSAGE);
        return getElementText(driver, NewCustomerPageUI.STATE_ERROR_MESSAGE);
    }

    public String getErrorMessageAtPINTextbox() {
        waitForElementVisible(driver, NewCustomerPageUI.PIN_ERROR_MESSAGE);
        return getElementText(driver, NewCustomerPageUI.PIN_ERROR_MESSAGE);
    }

    public String getErrorMessageAtMobileNumberTextbox() {
        waitForElementVisible(driver, NewCustomerPageUI.MOBILE_NUMBER_ERROR_MESSAGE);
        return getElementText(driver, NewCustomerPageUI.MOBILE_NUMBER_ERROR_MESSAGE);
    }

    public String getErrorMessageAtEmailTextbox() {
        waitForElementVisible(driver, NewCustomerPageUI.EMAIL_ERROR_MESSAGE);
        return getElementText(driver, NewCustomerPageUI.EMAIL_ERROR_MESSAGE);
    }


    public boolean isAllLabelsAtNewCustomerPageDisplayed(String labelName) {
        waitForElementVisible(driver,NewCustomerPageUI.ALL_LABEL,labelName);
        return isElementDisplayed(driver,NewCustomerPageUI.ALL_LABEL,labelName);
    }
}
