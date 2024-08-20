package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.user.AccountPageObject;
import pageObjects.user.CustomerPageObject;
import user.AccountPageUI;
import user.BasePageUI;
import user.CustomerPageUI;
import user.HomePageUI;

import java.util.List;
import java.util.Set;

public class BasePage {
    public static BasePage getBasePageObject() {
        return new BasePage();
    }

    private By getByLocator(String locatorType) {
        By by = null;
        if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
            by = By.id(locatorType.substring(3));
        } else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
            by = By.cssSelector(locatorType.substring(4));
        } else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
            by = By.xpath(locatorType.substring(6));
        } else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=") || locatorType.startsWith("Name=")) {
            by = By.name(locatorType.substring(5));
        } else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=") || locatorType.startsWith("Class=")) {
            by = By.className(locatorType.substring(6));
        } else {
            throw new RuntimeException("Locator type is not supported!");
        }
        return by;
    }

    private String getDynamicXpath(String locatorType, String... dynamicValues) {
        if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
            locatorType = String.format(locatorType, (Object[]) dynamicValues);
        }
        return locatorType;

    }

    private WebElement getWebElement(WebDriver driver, String locatorType) {
        return driver.findElement(getByLocator(locatorType));
    }

    public List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
        return driver.findElements(getByLocator(locatorType));
    }

    public void clickToElement(WebDriver driver, String locatorType) {
        getWebElement(driver, locatorType).click();
    }

    public void clickToElement(WebDriver driver, String locatorType, String... dynamicValues) {
        getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();
    }

    public void sendKeyToElement(WebDriver driver, String locatorType, String textValue) {
        WebElement element = getWebElement(driver, locatorType);
        element.clear();
        element.sendKeys(textValue);
    }

    public void sendKeyActionsToElement(WebDriver driver, String locatorType, CharSequence... key) {
        WebElement element = getWebElement(driver, locatorType);
        element.clear();
        element.sendKeys(key);
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getElementText(WebDriver driver, String locatorType) {
        return getWebElement(driver, locatorType).getText();
    }

    public void checkToDefaultCheckboxOrRadio(WebDriver driver, String locatorType) {
        WebElement element = getWebElement(driver, locatorType);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String locatorType, String... dynamicValues) {
        return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isDisplayed();
    }

    public void switchToFrameIframe(WebDriver driver, String locatorType) {
        driver.switchTo().frame(getWebElement(driver, locatorType));
        driver.quit();
    }

    public void waitForElementVisible(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
    }

    public void waitForElementVisible(WebDriver driver, String locatorType, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
    }

    public void waitForElementClickable(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
    }

    public void waitForElementClickable(WebDriver driver, String locatorType, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
    }

    private long longTimeout = 30;

    public void openPagesFromMenuSub(WebDriver driver, String pageName) {
        waitForElementClickable(driver, HomePageUI.MENU_SUB_LINK, pageName);
        clickToElement(driver, HomePageUI.MENU_SUB_LINK, pageName);
    }

    //CustomerID
    public CustomerPageObject inputActionsToCustomerID(WebDriver driver, Keys key) {
        waitForElementVisible(driver, BasePageUI.CUSTOMER_ID_TEXTBOX);
        sendKeyActionsToElement(driver, BasePageUI.CUSTOMER_ID_TEXTBOX, key);
        return PageGeneratorManager.getCustomerPage(driver);
    }

    public void inputToCustomerID(WebDriver driver, String customerId) {
        waitForElementVisible(driver, BasePageUI.CUSTOMER_ID_TEXTBOX);
        sendKeyToElement(driver, BasePageUI.CUSTOMER_ID_TEXTBOX, customerId);
    }

    public String getErrorMessageAtCustomerIDTextbox(WebDriver driver) {
        waitForElementVisible(driver, BasePageUI.CUSTOMER_ID_ERROR_MESSAGE);
        return getElementText(driver, BasePageUI.CUSTOMER_ID_ERROR_MESSAGE);
    }

    //AccountNo
    public AccountPageObject inputActionsToAccountNoTextbox(WebDriver driver, Keys key) {
        waitForElementVisible(driver, BasePageUI.ACCOUNT_NO_TEXTBOX);
        sendKeyActionsToElement(driver, BasePageUI.ACCOUNT_NO_TEXTBOX, key);
        return PageGeneratorManager.getAccountPage(driver);
    }

    public void inputToAccountNoTextbox(WebDriver driver, String accountNo) {
        waitForElementVisible(driver, BasePageUI.ACCOUNT_NO_TEXTBOX);
        sendKeyToElement(driver, BasePageUI.ACCOUNT_NO_TEXTBOX, accountNo);
    }

    public String getErrorMessageAtAccountNoTextbox(WebDriver driver) {
        waitForElementVisible(driver, BasePageUI.ACCOUNT_NO_ERROR_MESSAGE);
        return getElementText(driver, BasePageUI.ACCOUNT_NO_ERROR_MESSAGE);
    }

    public void closeGoogleAds(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        try {
            if (getListWebElement(driver,BasePageUI.GOOGLE_AD_IFRAME).size() > 0) {
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByLocator(BasePageUI.GOOGLE_AD_IFRAME)));
                WebElement closeAdButton = wait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(BasePageUI.CLOSE_BUTTON_AT_IFRAME)));
                if (closeAdButton != null) {
                    closeAdButton.click();
                } else {
                }
                driver.switchTo().defaultContent();
            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
