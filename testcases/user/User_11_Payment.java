package user;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;

import java.util.Random;

public class User_11_Payment extends BaseTest {
    private LoginPageObject loginPage;
    private HomePageObject homePage;
    private CustomerPageObject newCustomerPage;
    private String emailAddress, customerID;

    @Parameters({"browser", "environment"})
    @BeforeClass
    public void beforeClass(String browserName, String environmentName) {
        driver = getBrowserDriver(browserName, environmentName);
        loginPage = PageGeneratorManager.getLoginPage(driver);
        homePage = loginPage.loginUser(GlobalConstants.USER_NAME, GlobalConstants.PASSWORD);
        homePage.openPagesFromMenuSub(driver, "New Customer");
        newCustomerPage = PageGeneratorManager.getCustomerPage(driver);
        newCustomerPage.closeGoogleAds(driver);

        emailAddress = "hangan" + numberRandom() + "@gmail.com";
    }

    @Test
    public void PM01_Create_New_Customer_Successfully() {
        newCustomerPage.inputToCustomerName("Clara");
        newCustomerPage.selectFemale();
        newCustomerPage.inputToDateOfBirth("16/09/1992");
        newCustomerPage.inputToAddress("89 Hung Vuong");
        newCustomerPage.inputToCity("Da Nang");
        newCustomerPage.inputToState("South");
        newCustomerPage.inputToPIN("123456");
        newCustomerPage.inputToMobileNumber("045456789");
        newCustomerPage.inputToEmail(emailAddress);
        newCustomerPage.inputToPassword("123456");
        newCustomerPage.sleepInSecond(3);

        newCustomerPage.clickToNewCustomerSubmitButton();
        newCustomerPage.sleepInSecond(100);
        Assert.assertEquals(newCustomerPage.getAddNewCustomerSuccessMessage(), "Customer Registered Successfully!!!");
    }

    //@Test
    public void PM02_() {
        customerID = newCustomerPage.getValueCustomerID();

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    public int numberRandom() {
        Random rand = new Random();
        return rand.nextInt(99999);
    }

}
