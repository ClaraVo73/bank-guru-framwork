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
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;

public class User_06_DeleteCustomer extends BaseTest {
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private CustomerPageObject deleteCustomerPage;

    @Parameters({"browser", "environment"})
    @BeforeClass
    public void beforeClass(String browserName, String environmentName) {
        driver = getBrowserDriver(browserName, environmentName);
        loginPage = PageGeneratorManager.getLoginPage(driver);
        homePage = loginPage.loginUser(GlobalConstants.USER_NAME, GlobalConstants.PASSWORD);
        homePage.openPagesFromMenuSub(driver, "Delete Customer");
        deleteCustomerPage = PageGeneratorManager.getCustomerPage(driver);
        deleteCustomerPage.closeGoogleAds(driver);
    }

    @Test
    public void DC01_CustomerID_Cannot_Be_Empty() {
        deleteCustomerPage.inputActionsToCustomerID(driver, Keys.TAB);
        Assert.assertEquals(deleteCustomerPage.getErrorMessageAtCustomerIDTextbox(driver), "Customer ID is required");
    }

    @Test
    public void DC02_CustomerID_Must_Be_Numeric() {
        deleteCustomerPage.inputToCustomerID(driver, "12345ab");
        Assert.assertEquals(deleteCustomerPage.getErrorMessageAtCustomerIDTextbox(driver), "Characters are not allowed");
        deleteCustomerPage.inputToCustomerID(driver, "abc1234");
        Assert.assertEquals(deleteCustomerPage.getErrorMessageAtCustomerIDTextbox(driver), "Characters are not allowed");
    }

    @Test
    public void DC03_CustomerID_Cannot_Have_Special_Character() {
        deleteCustomerPage.inputToCustomerID(driver, "123#$%");
        Assert.assertEquals(deleteCustomerPage.getErrorMessageAtCustomerIDTextbox(driver), "Special characters are not allowed");
        deleteCustomerPage.inputToCustomerID(driver, "!@#$%^&*");
        Assert.assertEquals(deleteCustomerPage.getErrorMessageAtCustomerIDTextbox(driver), "Special characters are not allowed");
    }

    @Test
    public void DC04_CustomerID_Cannot_Have_Blank_Space() {
        deleteCustomerPage.inputToCustomerID(driver, "123 456");
        Assert.assertEquals(deleteCustomerPage.getErrorMessageAtCustomerIDTextbox(driver), "Characters are not allowed");
    }

    @Test
    public void DC04_CustomerID_First_Character_Cannot_Be_Space() {
        deleteCustomerPage.inputToCustomerID(driver, " 12345");
        Assert.assertEquals(deleteCustomerPage.getErrorMessageAtCustomerIDTextbox(driver), "Characters are not allowed");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

}
