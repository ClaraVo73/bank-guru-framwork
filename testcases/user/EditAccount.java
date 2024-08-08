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

public class EditAccount extends BaseTest {
    private LoginPageObject loginPage;
    private HomePageObject homePage;
    private AccountPageObject editAccountPage;

    @Parameters({"browser", "environment"})
    @BeforeClass
    public void beforeClass(String browserName, String environmentName) {
        driver = getBrowserDriver(browserName, environmentName);
        loginPage = PageGeneratorManager.getLoginPage(driver);
        homePage = loginPage.loginUser(GlobalConstants.USER_NAME, GlobalConstants.PASSWORD);
        homePage.openPagesFromMenuSub(driver, "Edit Account");
        editAccountPage = PageGeneratorManager.getAccountPage(driver);
    }

    @Test
    public void EA01_Initial_Deposit_Cannot_Be_Empty() {
        editAccountPage.inputActionsToAccountNoTextbox(Keys.TAB);
        Assert.assertEquals(editAccountPage.getErrorMessageAtAccountNoTextbox(), "Account Number must not be blank");
    }

    @Test
    public void EA02_Initial_Deposit_Must_Be_Numeric() {
        editAccountPage.inputToAccountNoTextbox("12345ab");
        Assert.assertEquals(editAccountPage.getErrorMessageAtAccountNoTextbox(), "Characters are not allowed");
        editAccountPage.inputToAccountNoTextbox("abc1234");
        Assert.assertEquals(editAccountPage.getErrorMessageAtAccountNoTextbox(), "Characters are not allowed");
    }

    @Test
    public void EA03_Initial_Deposit_Cannot_Have_Special_Character() {
        editAccountPage.inputToAccountNoTextbox("123#$%");
        Assert.assertEquals(editAccountPage.getErrorMessageAtAccountNoTextbox(), "Special characters are not allowed");
        editAccountPage.inputToAccountNoTextbox("!@#$%^&*");
        Assert.assertEquals(editAccountPage.getErrorMessageAtAccountNoTextbox(), "Special characters are not allowed");
    }

    @Test
    public void EA04_Initial_Deposit_Cannot_Have_Blank_Space() {
        editAccountPage.inputToAccountNoTextbox("123 456");
        Assert.assertEquals(editAccountPage.getErrorMessageAtAccountNoTextbox(), "Characters are not allowed");
    }

    @Test
    public void EA05_Initial_Deposit_First_Character_Cannot_Be_Space() {
        editAccountPage.inputToAccountNoTextbox(" 12345");
        Assert.assertEquals(editAccountPage.getErrorMessageAtAccountNoTextbox(), "First character can not have space");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public int numberRandom() {
        Random rand = new Random();
        return rand.nextInt(99999);
    }

}
