package pageObjects.user;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import user.BasePageUI;
import user.CustomerPageUI;

public class CustomerPageObject extends BasePage {


    private WebDriver driver;

    public CustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public CustomerPageObject inputActionsToCustomerName(Keys key) {
        waitForElementVisible(driver, CustomerPageUI.CUSTOMER_NAME_TEXTBOX);
        sendKeyActionsToElement(driver, CustomerPageUI.CUSTOMER_NAME_TEXTBOX, key);
        return PageGeneratorManager.getCustomerPage(driver);
    }

    public CustomerPageObject inputActionsToAddress(Keys key) {
        waitForElementVisible(driver, CustomerPageUI.ADDRESS_TEXTBOX);
        sendKeyActionsToElement(driver, CustomerPageUI.ADDRESS_TEXTBOX, key);
        return PageGeneratorManager.getCustomerPage(driver);
    }

    public CustomerPageObject inputActionsToCity(Keys key) {
        waitForElementVisible(driver, CustomerPageUI.CITY_TEXTBOX);
        sendKeyActionsToElement(driver, CustomerPageUI.CITY_TEXTBOX, key);
        return PageGeneratorManager.getCustomerPage(driver);
    }

    public CustomerPageObject inputActionsToState(Keys key) {
        waitForElementVisible(driver, CustomerPageUI.STATE_TEXTBOX);
        sendKeyActionsToElement(driver, CustomerPageUI.STATE_TEXTBOX, key);
        return PageGeneratorManager.getCustomerPage(driver);
    }

    public CustomerPageObject inputActionsToPIN(Keys key) {
        waitForElementVisible(driver, CustomerPageUI.PIN_TEXTBOX);
        sendKeyActionsToElement(driver, CustomerPageUI.PIN_TEXTBOX, key);
        return PageGeneratorManager.getCustomerPage(driver);
    }

    public CustomerPageObject inputActionsToMobileNumber(Keys key) {
        waitForElementVisible(driver, CustomerPageUI.MOBILE_NUMBER_TEXTBOX);
        sendKeyActionsToElement(driver, CustomerPageUI.MOBILE_NUMBER_TEXTBOX, key);
        return PageGeneratorManager.getCustomerPage(driver);
    }

    public CustomerPageObject inputActionsToEmail(Keys key) {
        waitForElementVisible(driver, CustomerPageUI.EMAIL_TEXTBOX);
        sendKeyActionsToElement(driver, CustomerPageUI.EMAIL_TEXTBOX, key);
        return PageGeneratorManager.getCustomerPage(driver);
    }


    public void inputToCustomerName(String customerName) {
        waitForElementVisible(driver, CustomerPageUI.CUSTOMER_NAME_TEXTBOX);
        sendKeyToElement(driver, CustomerPageUI.CUSTOMER_NAME_TEXTBOX, customerName);
    }

    public void inputToAddress(String address) {
        waitForElementVisible(driver, CustomerPageUI.ADDRESS_TEXTBOX);
        sendKeyToElement(driver, CustomerPageUI.ADDRESS_TEXTBOX, address);
    }

    public void inputToCity(String city) {
        waitForElementVisible(driver, CustomerPageUI.CITY_TEXTBOX);
        sendKeyToElement(driver, CustomerPageUI.CITY_TEXTBOX, city);
    }

    public void inputToState(String state) {
        waitForElementVisible(driver, CustomerPageUI.STATE_TEXTBOX);
        sendKeyToElement(driver, CustomerPageUI.STATE_TEXTBOX, state);
    }

    public void inputToPIN(String pin) {
        waitForElementVisible(driver, CustomerPageUI.PIN_TEXTBOX);
        sendKeyToElement(driver, CustomerPageUI.PIN_TEXTBOX, pin);
    }

    public void inputToMobileNumber(String mobileNumber) {
        waitForElementVisible(driver, CustomerPageUI.MOBILE_NUMBER_TEXTBOX);
        sendKeyToElement(driver, CustomerPageUI.MOBILE_NUMBER_TEXTBOX, mobileNumber);
    }

    public void inputToEmail(String email) {
        waitForElementVisible(driver, CustomerPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, CustomerPageUI.EMAIL_TEXTBOX, email);
    }

    public String getErrorMessageAtUserIDTextbox() {
        waitForElementVisible(driver, CustomerPageUI.CUSTOMER_NAME_ERROR_MESSAGE);
        return getElementText(driver, CustomerPageUI.CUSTOMER_NAME_ERROR_MESSAGE);
    }

    public String getErrorMessageAtAddressTextbox() {
        waitForElementVisible(driver, CustomerPageUI.ADDRESS_ERROR_MESSAGE);
        return getElementText(driver, CustomerPageUI.ADDRESS_ERROR_MESSAGE);
    }

    public String getErrorMessageAtCityTextbox() {
        waitForElementVisible(driver, CustomerPageUI.CITY_ERROR_MESSAGE);
        return getElementText(driver, CustomerPageUI.CITY_ERROR_MESSAGE);
    }

    public String getErrorMessageAtStateTextbox() {
        waitForElementVisible(driver, CustomerPageUI.STATE_ERROR_MESSAGE);
        return getElementText(driver, CustomerPageUI.STATE_ERROR_MESSAGE);
    }

    public String getErrorMessageAtPINTextbox() {
        waitForElementVisible(driver, CustomerPageUI.PIN_ERROR_MESSAGE);
        return getElementText(driver, CustomerPageUI.PIN_ERROR_MESSAGE);
    }

    public String getErrorMessageAtMobileNumberTextbox() {
        waitForElementVisible(driver, CustomerPageUI.MOBILE_NUMBER_ERROR_MESSAGE);
        return getElementText(driver, CustomerPageUI.MOBILE_NUMBER_ERROR_MESSAGE);
    }

    public String getErrorMessageAtEmailTextbox() {
        waitForElementVisible(driver, CustomerPageUI.EMAIL_ERROR_MESSAGE);
        return getElementText(driver, CustomerPageUI.EMAIL_ERROR_MESSAGE);
    }

    public void clickToEditSubmitButton() {
        waitForElementClickable(driver, CustomerPageUI.SUBMIT_EDIT_PAGE_BUTTON);
        clickToElement(driver, CustomerPageUI.SUBMIT_EDIT_PAGE_BUTTON);
    }

    public String getHeadingEditCustomerPage() {
        waitForElementVisible(driver, CustomerPageUI.EDIT_CUSTOMER_HEADING);
        return getElementText(driver, CustomerPageUI.EDIT_CUSTOMER_HEADING);
    }

    public boolean isAllLabelsAtNewCustomerPageDisplayed(String labelName) {
        waitForElementVisible(driver, CustomerPageUI.ALL_LABEL,labelName);
        return isElementDisplayed(driver, CustomerPageUI.ALL_LABEL,labelName);
    }

    public void closeAdvertisement() {
        waitForElementVisible(driver, BasePageUI.ADVERTISEMENT_IFRAME);
        switchToFrameIframe(driver, BasePageUI.ADVERTISEMENT_IFRAME);
    }

    public void selectFemale() {
        waitForElementClickable(driver,CustomerPageUI.FEMALE_RADIO);
        checkToDefaultCheckboxOrRadio(driver,CustomerPageUI.FEMALE_RADIO);
    }

    public void inputToDateOfBirth(String dateOfBirth) {
        waitForElementVisible(driver,CustomerPageUI.DATE_OF_BIRTH_TEXTBOX);
        sendKeyToElement(driver,CustomerPageUI.DATE_OF_BIRTH_TEXTBOX, dateOfBirth);
    }

    public void inputToPassword(String password) {
        waitForElementVisible(driver,CustomerPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver,CustomerPageUI.PASSWORD_TEXTBOX, password);
    }

    public void clickToNewCustomerSubmitButton() {
        waitForElementVisible(driver,CustomerPageUI.SUBMIT_NEW_CUSTOMER_PAGE_BUTTON);
        clickToElement(driver,CustomerPageUI.SUBMIT_NEW_CUSTOMER_PAGE_BUTTON);
    }

    public String getAddNewCustomerSuccessMessage() {
        waitForElementVisible(driver,CustomerPageUI.ADD_NEW_CUSTOMER_SUCCESS_MESSAGE);
        return getElementText(driver,CustomerPageUI.ADD_NEW_CUSTOMER_SUCCESS_MESSAGE);
    }

    public String getValueCustomerID() {
        waitForElementVisible(driver,CustomerPageUI.CUSTOMER_ID_LABEL);
        return getElementText(driver,CustomerPageUI.CUSTOMER_ID_LABEL);
    }
}
