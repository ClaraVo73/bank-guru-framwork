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
import pageObjects.user.MiniStatementPageObject;

import java.util.Random;

public class MiniStatement extends BaseTest {
    private LoginPageObject loginPage;
    private HomePageObject homePage;
    private MiniStatementPageObject miniStatementPage;

    @Parameters({"browser", "environment"})
    @BeforeClass
    public void beforeClass(String browserName, String environmentName) {
        driver = getBrowserDriver(browserName, environmentName);
        loginPage = PageGeneratorManager.getLoginPage(driver);
        homePage = loginPage.loginUser(GlobalConstants.USER_NAME, GlobalConstants.PASSWORD);
        homePage.openPagesFromMenuSub(driver, "Mini Statement");
        miniStatementPage = PageGeneratorManager.getMiniStatementPage(driver);
    }

    @Test
    public void MS01_Account_No_Cannot_Be_Empty() {
        miniStatementPage.inputActionsToAccountNoTextbox(driver,Keys.TAB);
        Assert.assertEquals(miniStatementPage.getErrorMessageAtAccountNoTextbox(driver), "Account Number must not be blank");
    }

    @Test
    public void MS02_Account_No_Must_Be_Numeric() {
        miniStatementPage.inputToAccountNoTextbox(driver,"12345ab");
        Assert.assertEquals(miniStatementPage.getErrorMessageAtAccountNoTextbox(driver), "Characters are not allowed");
        miniStatementPage.inputToAccountNoTextbox(driver,"abc1234");
        Assert.assertEquals(miniStatementPage.getErrorMessageAtAccountNoTextbox(driver), "Characters are not allowed");
    }

    @Test
    public void MS03_Account_No_Cannot_Have_Special_Character() {
        miniStatementPage.inputToAccountNoTextbox(driver,"123#$%");
        Assert.assertEquals(miniStatementPage.getErrorMessageAtAccountNoTextbox(driver), "Special characters are not allowed");
        miniStatementPage.inputToAccountNoTextbox(driver,"!@#$%^&*");
        Assert.assertEquals(miniStatementPage.getErrorMessageAtAccountNoTextbox(driver), "Special characters are not allowed");
    }

    @Test
    public void MS04_Account_No_Cannot_Have_Blank_Space() {
        miniStatementPage.inputToAccountNoTextbox(driver,"123 456");
        Assert.assertEquals(miniStatementPage.getErrorMessageAtAccountNoTextbox(driver), "Characters are not allowed");
    }

    @Test
    public void MS05_Account_No_First_Character_Cannot_Be_Space() {
        miniStatementPage.inputToAccountNoTextbox(driver," ");
        Assert.assertEquals(miniStatementPage.getErrorMessageAtAccountNoTextbox(driver), "Characters are not allowed");
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
