package user;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;
import pageObjects.user.NewCustomerPageObject;

import java.util.Random;

public class NewCustomer extends BaseTest {
    private LoginPageObject loginPage;
    private HomePageObject homePage;
    private NewCustomerPageObject newCustomerPage;

    @Parameters({"browser", "environment"})
    @BeforeClass
    public void beforeClass(String browserName, String environmentName) {
        driver = getBrowserDriver(browserName, environmentName);
        loginPage = PageGeneratorManager.getLoginPage(driver);
        homePage = loginPage.loginUser("mngr584256", "YsysYdU");
    }

    @Test
    public void NC01_Name_Cannot_Be_Empty() {
        homePage.openPagesFromMenuSub(driver,"New Customer");
        newCustomerPage = PageGeneratorManager.getNewCustomerPage(driver);

       // newCustomerPage = homePage.clickToNewCustomerLink();
        newCustomerPage.inputActionsToCustomerName(Keys.TAB);
        Assert.assertEquals(newCustomerPage.getErrorMessageAtUserIDTextbox(), "Customer name must not be blank");
    }
    @Test
    public void NC02_Name_Cannot_Be_Numeric() {
        newCustomerPage.inputToCustomerName("123");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtUserIDTextbox(), "Numbers are not allowed");
        newCustomerPage.inputToCustomerName("nam123");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtUserIDTextbox(), "Numbers are not allowed");
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
