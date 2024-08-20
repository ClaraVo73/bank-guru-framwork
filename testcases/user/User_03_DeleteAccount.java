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
import pageObjects.user.AccountPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;

import java.util.Random;

public class User_03_DeleteAccount extends BaseTest {
    private LoginPageObject loginPage;
    private HomePageObject homePage;
    private AccountPageObject deleteAccountPage;

    @Parameters({"browser", "environment"})
    @BeforeClass
    public void beforeClass(String browserName, String environmentName) {
        driver = getBrowserDriver(browserName, environmentName);
        loginPage = PageGeneratorManager.getLoginPage(driver);
        homePage = loginPage.loginUser(GlobalConstants.USER_NAME, GlobalConstants.PASSWORD);
        homePage.openPagesFromMenuSub(driver, "Delete Account");
        deleteAccountPage = PageGeneratorManager.getAccountPage(driver);
        deleteAccountPage.closeGoogleAds(driver);
    }

    @Test
    public void EA01_Account_No_Cannot_Be_Empty() {
        deleteAccountPage.inputActionsToAccountNoTextbox(driver, Keys.TAB);
        Assert.assertEquals(deleteAccountPage.getErrorMessageAtAccountNoTextbox(driver), "Account Number must not be blank");
    }

    @Test
    public void EA02_Account_No_Must_Be_Numeric() {
        deleteAccountPage.inputToAccountNoTextbox(driver, "12345ab");
        Assert.assertEquals(deleteAccountPage.getErrorMessageAtAccountNoTextbox(driver), "Characters are not allowed");
        deleteAccountPage.inputToAccountNoTextbox(driver, "abc1234");
        Assert.assertEquals(deleteAccountPage.getErrorMessageAtAccountNoTextbox(driver), "Characters are not allowed");
    }

    @Test
    public void EA03_Account_No_Cannot_Have_Special_Character() {
        deleteAccountPage.inputToAccountNoTextbox(driver, "123#$%");
        Assert.assertEquals(deleteAccountPage.getErrorMessageAtAccountNoTextbox(driver), "Special characters are not allowed");
        deleteAccountPage.inputToAccountNoTextbox(driver, "!@#$%^&*");
        Assert.assertEquals(deleteAccountPage.getErrorMessageAtAccountNoTextbox(driver), "Special characters are not allowed");
    }

    @Test
    public void EA04_Account_No_Cannot_Have_Blank_Space() {
        deleteAccountPage.inputToAccountNoTextbox(driver, "123 456");
        Assert.assertEquals(deleteAccountPage.getErrorMessageAtAccountNoTextbox(driver), "Characters are not allowed");
    }

    @Test
    public void EA05_Account_No_First_Character_Cannot_Be_Space() {
        deleteAccountPage.inputToAccountNoTextbox(driver, " ");
        Assert.assertEquals(deleteAccountPage.getErrorMessageAtAccountNoTextbox(driver), "Characters are not allowed");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

}
