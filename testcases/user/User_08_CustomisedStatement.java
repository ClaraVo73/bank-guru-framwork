package user;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.CustomisedStatementPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;

import java.util.Random;

public class User_08_CustomisedStatement extends BaseTest {
    private LoginPageObject loginPage;
    private HomePageObject homePage;
    private CustomisedStatementPageObject customisedStatementPage;

    @Parameters({"browser", "environment"})
    @BeforeClass
    public void beforeClass(String browserName, String environmentName) {
        driver = getBrowserDriver(browserName, environmentName);
        loginPage = PageGeneratorManager.getLoginPage(driver);
        homePage = loginPage.loginUser(GlobalConstants.USER_NAME, GlobalConstants.PASSWORD);
        homePage.openPagesFromMenuSub(driver, "Customised Statement");
        customisedStatementPage = PageGeneratorManager.getCustomisedStatementPage(driver);
        customisedStatementPage.closeGoogleAds(driver);
    }

    @Test
    public void CS01_Account_No_Cannot_Be_Empty() {
        customisedStatementPage.inputActionsToAccountNoTextbox(driver, Keys.TAB);
        Assert.assertEquals(customisedStatementPage.getErrorMessageAtAccountNoTextbox(driver), "Account Number must not be blank");
    }

    @Test
    public void CS02_Account_No_Must_Be_Numeric() {
        customisedStatementPage.inputToAccountNoTextbox(driver, "12345ab");
        Assert.assertEquals(customisedStatementPage.getErrorMessageAtAccountNoTextbox(driver), "Characters are not allowed");
        customisedStatementPage.inputToAccountNoTextbox(driver, "abc1234");
        Assert.assertEquals(customisedStatementPage.getErrorMessageAtAccountNoTextbox(driver), "Characters are not allowed");
    }

    @Test
    public void CS03_Account_No_Cannot_Have_Special_Character() {
        customisedStatementPage.inputToAccountNoTextbox(driver, "123#$%");
        Assert.assertEquals(customisedStatementPage.getErrorMessageAtAccountNoTextbox(driver), "Special characters are not allowed");
        customisedStatementPage.inputToAccountNoTextbox(driver, "!@#$%^&*");
        Assert.assertEquals(customisedStatementPage.getErrorMessageAtAccountNoTextbox(driver), "Special characters are not allowed");
    }

    @Test
    public void CS04_Account_No_Cannot_Have_Blank_Space() {
        customisedStatementPage.inputToAccountNoTextbox(driver, "123 456");
        Assert.assertEquals(customisedStatementPage.getErrorMessageAtAccountNoTextbox(driver), "Characters are not allowed");
    }

    @Test
    public void CS05_Account_No_First_Character_Cannot_Be_Space() {
        customisedStatementPage.inputToAccountNoTextbox(driver, " ");
        Assert.assertEquals(customisedStatementPage.getErrorMessageAtAccountNoTextbox(driver), "Characters are not allowed");
    }

    @Test
    public void CS07_Minimum_Transaction_Value_Must_Be_Numeric() {
        customisedStatementPage.inputToMinumumTransactionValueTextbox(driver, "12345ab");
        Assert.assertEquals(customisedStatementPage.getErrorMessageAtMinumumTransactionValueTextbox(driver), "Characters are not allowed");
        customisedStatementPage.inputToMinumumTransactionValueTextbox(driver, "abc1234");
        Assert.assertEquals(customisedStatementPage.getErrorMessageAtMinumumTransactionValueTextbox(driver), "Characters are not allowed");
    }

    @Test
    public void CS08_Minimum_Transaction_Value_Cannot_Have_Special_Character() {
        customisedStatementPage.inputToMinumumTransactionValueTextbox(driver, "123#$%");
        Assert.assertEquals(customisedStatementPage.getErrorMessageAtMinumumTransactionValueTextbox(driver), "Special characters are not allowed");
        customisedStatementPage.inputToMinumumTransactionValueTextbox(driver, "!@#$%^&*");
        Assert.assertEquals(customisedStatementPage.getErrorMessageAtMinumumTransactionValueTextbox(driver), "Special characters are not allowed");
    }

    @Test
    public void CS09_Minimum_Transaction_Value_Cannot_Have_Blank_Space() {
        customisedStatementPage.inputToMinumumTransactionValueTextbox(driver, "123 456");
        Assert.assertEquals(customisedStatementPage.getErrorMessageAtMinumumTransactionValueTextbox(driver), "Characters are not allowed");
    }

    @Test
    public void CS10_Minimum_Transaction_Value_First_Character_Cannot_Be_Space() {
        customisedStatementPage.inputToMinumumTransactionValueTextbox(driver, " ");
        Assert.assertEquals(customisedStatementPage.getErrorMessageAtMinumumTransactionValueTextbox(driver), "Characters are not allowed");
    }

    ////
    @Test
    public void CS12_Number_Of_Transaction_Must_Be_Numeric() {
        customisedStatementPage.inputToNumberOfTransactionTextbox(driver, "12345ab");
        Assert.assertEquals(customisedStatementPage.getErrorMessageAtNumberOfTransactionTextbox(driver), "Characters are not allowed");
        customisedStatementPage.inputToNumberOfTransactionTextbox(driver, "abc1234");
        Assert.assertEquals(customisedStatementPage.getErrorMessageAtNumberOfTransactionTextbox(driver), "Characters are not allowed");
    }

    @Test
    public void CS13_Number_Of_Transaction_Cannot_Have_Special_Character() {
        customisedStatementPage.inputToNumberOfTransactionTextbox(driver, "123#$%");
        Assert.assertEquals(customisedStatementPage.getErrorMessageAtNumberOfTransactionTextbox(driver), "Special characters are not allowed");
        customisedStatementPage.inputToNumberOfTransactionTextbox(driver, "!@#$%^&*");
        Assert.assertEquals(customisedStatementPage.getErrorMessageAtNumberOfTransactionTextbox(driver), "Special characters are not allowed");
    }

    @Test
    public void CS14_Number_Of_Transaction_Cannot_Have_Blank_Space() {
        customisedStatementPage.inputToNumberOfTransactionTextbox(driver, "123 456");
        Assert.assertEquals(customisedStatementPage.getErrorMessageAtNumberOfTransactionTextbox(driver), "Characters are not allowed");
    }

    @Test
    public void CS15_Number_Of_Transaction_First_Character_Cannot_Be_Space() {
        customisedStatementPage.inputToNumberOfTransactionTextbox(driver, " ");
        Assert.assertEquals(customisedStatementPage.getErrorMessageAtNumberOfTransactionTextbox(driver), "Characters are not allowed");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

}
