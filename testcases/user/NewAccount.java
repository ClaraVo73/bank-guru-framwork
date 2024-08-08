package user;

import commons.BaseTest;
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

public class NewAccount extends BaseTest {
    private LoginPageObject loginPage;
    private HomePageObject homePage;
    private AccountPageObject newAccountPage;

    @Parameters({"browser", "environment"})
    @BeforeClass
    public void beforeClass(String browserName, String environmentName) {
        driver = getBrowserDriver(browserName,environmentName);
        loginPage = PageGeneratorManager.getLoginPage(driver);
        homePage = loginPage.loginUser("mngr584256", "YsysYdU");
        homePage.openPagesFromMenuSub(driver,"New Account");
        newAccountPage = PageGeneratorManager.getAccountPage(driver);
    }

    @Test
    public void NA01_CustomerID_Cannot_Be_Empty() {
        newAccountPage.inputActionsToCustomerID(driver,Keys.TAB);
        Assert.assertEquals(newAccountPage.getErrorMessageAtCustomerIDTextbox(driver),"Customer ID is required");
    }
    @Test
    public void NA02_CustomerID_Must_Be_Numeric() {
        newAccountPage.inputToCustomerID(driver,"12345ab");
        Assert.assertEquals(newAccountPage.getErrorMessageAtCustomerIDTextbox(driver),"Characters are not allowed");
        newAccountPage.inputToCustomerID(driver,"abc1234");
        Assert.assertEquals(newAccountPage.getErrorMessageAtCustomerIDTextbox(driver),"Characters are not allowed");
    }
    @Test
    public void NA03_CustomerID_Cannot_Have_Special_Character() {
        newAccountPage.inputToCustomerID(driver,"123#$%");
        Assert.assertEquals(newAccountPage.getErrorMessageAtCustomerIDTextbox(driver),"Special characters are not allowed");
        newAccountPage.inputToCustomerID(driver,"!@#$%^&*");
        Assert.assertEquals(newAccountPage.getErrorMessageAtCustomerIDTextbox(driver),"Special characters are not allowed");
    }
    @Test
    public void NA04_CustomerID_Cannot_Have_Blank_Space() {
        newAccountPage.inputToCustomerID(driver,"123 456");
        Assert.assertEquals(newAccountPage.getErrorMessageAtCustomerIDTextbox(driver),"Characters are not allowed");
    }

    @Test
    public void NA05_CustomerID_First_Character_Cannot_Be_Space() {
        newAccountPage.inputToCustomerID(driver," 12345");
        Assert.assertEquals(newAccountPage.getErrorMessageAtCustomerIDTextbox(driver),"First character can not have space");
    }

    @Test
    public void NA06_Initial_Deposit_Cannot_Be_Empty() {
        newAccountPage.inputActionsToInitialDepositTextbox(Keys.TAB);
        Assert.assertEquals(newAccountPage.getErrorMessageAtInitialDepositTextbox(),"Initial Deposit must not be blank");
    }
    @Test
    public void NA07_Initial_Deposit_Must_Be_Numeric() {
        newAccountPage.inputToInitialDepositTextbox("12345ab");
        Assert.assertEquals(newAccountPage.getErrorMessageAtInitialDepositTextbox(),"Characters are not allowed");
        newAccountPage.inputToInitialDepositTextbox("abc1234");
        Assert.assertEquals(newAccountPage.getErrorMessageAtInitialDepositTextbox(),"Characters are not allowed");
    }
    @Test
    public void NA08_Initial_Deposit_Cannot_Have_Special_Character() {
        newAccountPage.inputToInitialDepositTextbox("123#$%");
        Assert.assertEquals(newAccountPage.getErrorMessageAtInitialDepositTextbox(),"Special characters are not allowed");
        newAccountPage.inputToInitialDepositTextbox("!@#$%^&*");
        Assert.assertEquals(newAccountPage.getErrorMessageAtInitialDepositTextbox(),"Special characters are not allowed");
    }
    @Test
    public void NA09_Initial_Deposit_Cannot_Have_Blank_Space() {
        newAccountPage.inputToInitialDepositTextbox("123 456");
        Assert.assertEquals(newAccountPage.getErrorMessageAtInitialDepositTextbox(),"Characters are not allowed");
    }

    @Test
    public void NA10_Initial_Deposit_First_Character_Cannot_Be_Space() {
        newAccountPage.inputToInitialDepositTextbox(" 12345");
        Assert.assertEquals(newAccountPage.getErrorMessageAtInitialDepositTextbox(),"First character can not have space");
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
