package pageObjects.user;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import user.FundTransferUI;

public class FundTransferPageObject extends BasePage {
    private WebDriver driver;

    public FundTransferPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public FundTransferPageObject inputActionsToPayersAccountNumberTextbox(Keys key) {
        waitForElementVisible(driver, FundTransferUI.PAYERS_ACCOUNT_NO_TEXTBOX);
        sendKeyActionsToElement(driver, FundTransferUI.PAYERS_ACCOUNT_NO_TEXTBOX,key);
        return PageGeneratorManager.getFundTransferPage(driver);
    }

    public FundTransferPageObject inputActionsToPayeesAccountNumberTextbox(Keys key) {
        waitForElementVisible(driver, FundTransferUI.PAYEES_ACCOUNT_NO_TEXTBOX);
        sendKeyActionsToElement(driver, FundTransferUI.PAYEES_ACCOUNT_NO_TEXTBOX,key);
        return PageGeneratorManager.getFundTransferPage(driver);
    }

    public FundTransferPageObject inputActionsToAmountTextbox(Keys key) {
        waitForElementVisible(driver, FundTransferUI.AMOUNT_TEXTBOX);
        sendKeyActionsToElement(driver, FundTransferUI.AMOUNT_TEXTBOX,key);
        return PageGeneratorManager.getFundTransferPage(driver);
    }

    public FundTransferPageObject inputActionsToDescriptionTextbox(Keys key) {
        waitForElementVisible(driver, FundTransferUI.DESCRIPTION_TEXTBOX);
        sendKeyActionsToElement(driver, FundTransferUI.DESCRIPTION_TEXTBOX,key);
        return PageGeneratorManager.getFundTransferPage(driver);
    }

    public void inputToPayersAccountNumberTextbox(String value) {
        waitForElementVisible(driver,FundTransferUI.PAYERS_ACCOUNT_NO_TEXTBOX);
        sendKeyToElement(driver,FundTransferUI.PAYERS_ACCOUNT_NO_TEXTBOX,value);
    }

    public void inputToPayeesAccountNumberTextbox(String value) {
        waitForElementVisible(driver,FundTransferUI.PAYEES_ACCOUNT_NO_TEXTBOX);
        sendKeyToElement(driver,FundTransferUI.PAYEES_ACCOUNT_NO_TEXTBOX,value);
    }

    public void inputToAmountTextbox(String value) {
        waitForElementVisible(driver,FundTransferUI.AMOUNT_TEXTBOX);
        sendKeyToElement(driver,FundTransferUI.AMOUNT_TEXTBOX,value);
    }

    public String getErrorMessageAtPayersAccountNumberTextbox() {
        waitForElementVisible(driver,FundTransferUI.PAYERS_ACCOUNT_NO_ERROR_MESSAGE);
        return getElementText(driver,FundTransferUI.PAYERS_ACCOUNT_NO_ERROR_MESSAGE);
    }

    public String getErrorMessageAtPayeesAccountNumberTextbox() {
        waitForElementVisible(driver,FundTransferUI.PAYEES_ACCOUNT_NO_ERROR_MESSAGE);
        return getElementText(driver,FundTransferUI.PAYEES_ACCOUNT_NO_ERROR_MESSAGE);
    }

    public String getErrorMessageAtAmountTextbox() {
        waitForElementVisible(driver,FundTransferUI.AMOUNT_ERROR_MESSAGE);
        return getElementText(driver,FundTransferUI.AMOUNT_ERROR_MESSAGE);
    }

    public String getErrorMessageAtDescriptionTextbox() {
        waitForElementVisible(driver,FundTransferUI.DESCRIPTION_ERROR_MESSAGE);
        return getElementText(driver,FundTransferUI.DESCRIPTION_ERROR_MESSAGE);
    }
}
