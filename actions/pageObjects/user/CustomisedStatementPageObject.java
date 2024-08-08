package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import user.CustomisedStatementPageUI;

import java.util.TreeMap;

public class CustomisedStatementPageObject extends BasePage {
    private WebDriver driver;

    public CustomisedStatementPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToMinumumTransactionValueTextbox(WebDriver driver, String value) {
        waitForElementVisible(driver, CustomisedStatementPageUI.MINIMUM_TRANSACTION_VALUE_TEXTBOX);
        sendKeyToElement(driver, CustomisedStatementPageUI.MINIMUM_TRANSACTION_VALUE_TEXTBOX,value);
    }

    public String getErrorMessageAtMinumumTransactionValueTextbox(WebDriver driver) {
        waitForElementVisible(driver, CustomisedStatementPageUI.MINIMUM_TRANSACTION_VALUE_ERROR_MESSAGE);
        return getElementText(driver, CustomisedStatementPageUI.MINIMUM_TRANSACTION_VALUE_ERROR_MESSAGE);
    }

    public void inputToNumberOfTransactionTextbox(WebDriver driver, String value) {
        waitForElementVisible(driver, CustomisedStatementPageUI.NUMBER_OF_TRANSACTION_TEXTBOX);
        sendKeyToElement(driver, CustomisedStatementPageUI.NUMBER_OF_TRANSACTION_TEXTBOX,value);
    }

    public String getErrorMessageAtNumberOfTransactionTextbox(WebDriver driver) {
        waitForElementVisible(driver, CustomisedStatementPageUI.NUMBER_OF_TRANSACTION_ERROR_MESSAGE);
        return getElementText(driver, CustomisedStatementPageUI.NUMBER_OF_TRANSACTION_ERROR_MESSAGE);
    }
}
