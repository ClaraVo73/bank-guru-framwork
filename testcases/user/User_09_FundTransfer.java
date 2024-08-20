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
import pageObjects.user.FundTransferPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;

import java.util.Random;

public class User_09_FundTransfer extends BaseTest {
    private LoginPageObject loginPage;
    private HomePageObject homePage;
    private FundTransferPageObject fundTransferPage;

    @Parameters({"browser", "environment"})
    @BeforeClass
    public void beforeClass(String browserName, String environmentName) {
        driver = getBrowserDriver(browserName, environmentName);
        loginPage = PageGeneratorManager.getLoginPage(driver);
        homePage = loginPage.loginUser(GlobalConstants.USER_NAME, GlobalConstants.PASSWORD);
        homePage.openPagesFromMenuSub(driver, "Fund Transfer");
        fundTransferPage = PageGeneratorManager.getFundTransferPage(driver);
        fundTransferPage.closeGoogleAds(driver);
    }

    @Test
    public void FT01_Payers_Account_Number_Cannot_Be_Empty() {
        fundTransferPage.inputActionsToPayersAccountNumberTextbox(Keys.TAB);
        Assert.assertEquals(fundTransferPage.getErrorMessageAtPayersAccountNumberTextbox(), "Payers Account Number must not be blank");
    }

    @Test
    public void FT02_Payers_Account_Number_Must_Be_Numeric() {
        fundTransferPage.inputToPayersAccountNumberTextbox("0375aASDD");
        Assert.assertEquals(fundTransferPage.getErrorMessageAtPayersAccountNumberTextbox(), "Characters are not allowed");
        fundTransferPage.inputToPayersAccountNumberTextbox("asdfghjertyu");
        Assert.assertEquals(fundTransferPage.getErrorMessageAtPayersAccountNumberTextbox(), "Characters are not allowed");
    }

    @Test
    public void FT03_Payers_Account_Number_Cannot_Have_Special_Character() {
        fundTransferPage.inputToPayersAccountNumberTextbox("0375#$%^^&&*");
        Assert.assertEquals(fundTransferPage.getErrorMessageAtPayersAccountNumberTextbox(), "Special characters are not allowed");
        fundTransferPage.inputToPayersAccountNumberTextbox("@#$%%^");
        Assert.assertEquals(fundTransferPage.getErrorMessageAtPayersAccountNumberTextbox(), "Special characters are not allowed");
    }

    @Test
    public void FT04_Payees_Account_Number_Cannot_Be_Empty() {
        fundTransferPage.inputActionsToPayeesAccountNumberTextbox(Keys.TAB);
        Assert.assertEquals(fundTransferPage.getErrorMessageAtPayeesAccountNumberTextbox(), "Payees Account Number must not be blank");
    }

    @Test
    public void FT05_Payees_Account_Number_Must_Be_Numeric() {
        fundTransferPage.inputToPayeesAccountNumberTextbox("0375aASDD");
        Assert.assertEquals(fundTransferPage.getErrorMessageAtPayeesAccountNumberTextbox(), "Characters are not allowed");
        fundTransferPage.inputToPayeesAccountNumberTextbox("asdfghjertyu");
        Assert.assertEquals(fundTransferPage.getErrorMessageAtPayeesAccountNumberTextbox(), "Characters are not allowed");
    }

    @Test
    public void FT06_Payees_Account_Number_Cannot_Have_Special_Character() {
        fundTransferPage.inputToPayeesAccountNumberTextbox("0375#$%^^&&*");
        Assert.assertEquals(fundTransferPage.getErrorMessageAtPayeesAccountNumberTextbox(), "Special characters are not allowed");
        fundTransferPage.inputToPayeesAccountNumberTextbox("@#$%%^");
        Assert.assertEquals(fundTransferPage.getErrorMessageAtPayeesAccountNumberTextbox(), "Special characters are not allowed");
    }

    @Test
    public void FT07_Amount_Cannot_Be_Empty() {
        fundTransferPage.inputActionsToAmountTextbox(Keys.TAB);
        Assert.assertEquals(fundTransferPage.getErrorMessageAtAmountTextbox(), "Amount field must not be blank");
    }

    @Test
    public void FT08_Amount_Must_Be_Numeric() {
        fundTransferPage.inputToAmountTextbox("0375aASDD");
        Assert.assertEquals(fundTransferPage.getErrorMessageAtAmountTextbox(), "Characters are not allowed");
        fundTransferPage.inputToAmountTextbox("asdfghjertyu");
        Assert.assertEquals(fundTransferPage.getErrorMessageAtAmountTextbox(), "Characters are not allowed");
    }

    @Test
    public void FT09_Amount_Cannot_Have_Special_Character() {
        fundTransferPage.inputToAmountTextbox("0375#$%^^&&*");
        Assert.assertEquals(fundTransferPage.getErrorMessageAtAmountTextbox(), "Special characters are not allowed");
        fundTransferPage.inputToAmountTextbox("@#$%%^");
        Assert.assertEquals(fundTransferPage.getErrorMessageAtAmountTextbox(), "Special characters are not allowed");
    }

    @Test
    public void FT10_Description_Cannot_Be_Empty() {
        fundTransferPage.inputActionsToDescriptionTextbox(Keys.TAB);
        Assert.assertEquals(fundTransferPage.getErrorMessageAtDescriptionTextbox(), "Description can not be blank");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

}
