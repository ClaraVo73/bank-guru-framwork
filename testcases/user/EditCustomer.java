package user;

import commons.BaseTest;
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

import java.util.Random;

public class EditCustomer extends BaseTest {
    private LoginPageObject loginPage;
    private HomePageObject homePage;
    private CustomerPageObject editCustomerPage;

    @Parameters({"browser", "environment"})
    @BeforeClass
    public void beforeClass(String browserName, String environmentName) {
        driver = getBrowserDriver(browserName,environmentName);
        loginPage = PageGeneratorManager.getLoginPage(driver);
        homePage = loginPage.loginUser("mngr584256", "YsysYdU");
        homePage.openPagesFromMenuSub(driver,"Edit Customer");
        editCustomerPage = PageGeneratorManager.getCustomerPage(driver);
    }

    @Test
    public void EC01_CustomerID_Cannot_Be_Empty() {
        editCustomerPage.inputActionsToCustomerID(driver,Keys.TAB);
        Assert.assertEquals(editCustomerPage.getErrorMessageAtCustomerIDTextbox(driver),"Customer ID is required");
    }
    @Test
    public void EC02_CustomerID_Must_Be_Numeric() {
        editCustomerPage.inputToCustomerID(driver,"12345ab");
        Assert.assertEquals(editCustomerPage.getErrorMessageAtCustomerIDTextbox(driver),"Characters are not allowed");
        editCustomerPage.inputToCustomerID(driver,"abc1234");
        Assert.assertEquals(editCustomerPage.getErrorMessageAtCustomerIDTextbox(driver),"Characters are not allowed");
    }
    @Test
    public void EC03_CustomerID_Cannot_Have_Special_Character() {
        editCustomerPage.inputToCustomerID(driver,"123#$%");
        Assert.assertEquals(editCustomerPage.getErrorMessageAtCustomerIDTextbox(driver),"Special characters are not allowed");
        editCustomerPage.inputToCustomerID(driver,"!@#$%^&*");
        Assert.assertEquals(editCustomerPage.getErrorMessageAtCustomerIDTextbox(driver),"Special characters are not allowed");
    }
    @Test
    public void EC04_Valid_CustomerID() {
        editCustomerPage.inputToCustomerID(driver,"67047");
        editCustomerPage.clickToEditSubmitButton();
        Assert.assertEquals(editCustomerPage.getHeadingEditCustomerPage(),"Edit Customer");
    }

    @Test
    public void EC05_Address_Cannot_Be_Empty() {
        editCustomerPage.inputActionsToAddress(Keys.TAB);
        Assert.assertEquals(editCustomerPage.getErrorMessageAtAddressTextbox(),"Address Field must not be blank");
    }

    @Test
    public void EC06_City_Cannot_Be_Empty() {
        editCustomerPage.inputToAddress("166 Quang Trung");
        editCustomerPage.inputActionsToCity(Keys.TAB);
        Assert.assertEquals(editCustomerPage.getErrorMessageAtCityTextbox(),"City Field must not be blank");
    }
    @Test
    public void EC07_City_Cannot_Be_Numeric() {
        editCustomerPage.inputToCity("123456");
        Assert.assertEquals(editCustomerPage.getErrorMessageAtCityTextbox(),"Numbers are not allowed");
        editCustomerPage.inputToCity("HCM123");
        Assert.assertEquals(editCustomerPage.getErrorMessageAtCityTextbox(),"Numbers are not allowed");
    }
    @Test
    public void EC08_City_Cannot_Have_Special_Character() {
        editCustomerPage.inputToCity("!@#$%^&*");
        Assert.assertEquals(editCustomerPage.getErrorMessageAtCityTextbox(),"Special characters are not allowed");
        editCustomerPage.inputToCity("HCM!@#$%^&*");
        Assert.assertEquals(editCustomerPage.getErrorMessageAtCityTextbox(),"Special characters are not allowed");
    }

    @Test
    public void EC09_State_Cannot_Be_Empty() {
        editCustomerPage.inputToCity("Ho Chi Minh");
        editCustomerPage.inputActionsToState(Keys.TAB);
        Assert.assertEquals(editCustomerPage.getErrorMessageAtStateTextbox(),"State must not be blank");
    }
    @Test
    public void EC10_State_Cannot_Be_Numeric() {
        editCustomerPage.inputToState("123456");
        Assert.assertEquals(editCustomerPage.getErrorMessageAtStateTextbox(),"Numbers are not allowed");
        editCustomerPage.inputToState("HCM123");
        Assert.assertEquals(editCustomerPage.getErrorMessageAtStateTextbox(),"Numbers are not allowed");
    }
    @Test
    public void EC11_State_Cannot_Have_Special_Character() {
        editCustomerPage.inputToState("!@#$%^&*");
        Assert.assertEquals(editCustomerPage.getErrorMessageAtStateTextbox(),"Special characters are not allowed");
        editCustomerPage.inputToState("HCM!@#$%^&*");
        Assert.assertEquals(editCustomerPage.getErrorMessageAtStateTextbox(),"Special characters are not allowed");
    }
    @Test
    public void EC12_PIN_Must_Be_Numeric() {
        editCustomerPage.inputToState("South");
        editCustomerPage.inputToPIN("123pin");
        Assert.assertEquals(editCustomerPage.getErrorMessageAtPINTextbox(),"Characters are not allowed");
        editCustomerPage.inputToPIN("Bigpin");
        Assert.assertEquals(editCustomerPage.getErrorMessageAtPINTextbox(),"Characters are not allowed");
    }
    @Test
    public void EC13_PIN_Cannot_Be_Empty() {
        editCustomerPage.inputActionsToPIN(Keys.TAB);
        Assert.assertEquals(editCustomerPage.getErrorMessageAtPINTextbox(),"PIN Code must not be blank");
    }

    @Test
    public void EC14_PIN_Must_Have_6_Digits() {
        editCustomerPage.inputToPIN("12345");
        Assert.assertEquals(editCustomerPage.getErrorMessageAtPINTextbox(),"PIN Code must have 6 Digits");
    }
    @Test
    public void EC15_PIN_Cannot_Have_Special_Character() {
        editCustomerPage.inputToPIN("#$&%^*");
        Assert.assertEquals(editCustomerPage.getErrorMessageAtPINTextbox(),"Special characters are not allowed");
        editCustomerPage.inputToPIN("123&%^");
        Assert.assertEquals(editCustomerPage.getErrorMessageAtPINTextbox(),"Special characters are not allowed");
    }
    @Test
    public void EC16_Mobile_Number_Cannot_Be_Empty() {
        editCustomerPage.inputToPIN("123456");
        editCustomerPage.inputActionsToMobileNumber(Keys.TAB);
        Assert.assertEquals(editCustomerPage.getErrorMessageAtMobileNumberTextbox(),"Mobile no must not be blank");
    }
    @Test
    public void EC17_Mobile_Cannot_Have_Special_Character() {
        editCustomerPage.inputToMobileNumber("123$%^&&*");
        Assert.assertEquals(editCustomerPage.getErrorMessageAtMobileNumberTextbox(),"Special characters are not allowed");
        editCustomerPage.inputToMobileNumber("^&**+%^&&*");
        Assert.assertEquals(editCustomerPage.getErrorMessageAtMobileNumberTextbox(),"Special characters are not allowed");
    }

    @Test
    public void EC19_Email_Cannot_Be_Empty() {
        editCustomerPage.inputToMobileNumber("0123456789");
        editCustomerPage.inputActionsToEmail(Keys.TAB);
        Assert.assertEquals(editCustomerPage.getErrorMessageAtEmailTextbox(),"Email-ID must not be blank");
    }

    @Test
    public void EC19_Email_Must_Be_In_Format() {
        editCustomerPage.inputToEmail("ngan");
        Assert.assertEquals(editCustomerPage.getErrorMessageAtEmailTextbox(), "Email-ID is not valid");
        editCustomerPage.inputToEmail("ngan@");
        Assert.assertEquals(editCustomerPage.getErrorMessageAtEmailTextbox(), "Email-ID is not valid");
        editCustomerPage.inputToEmail("ngan@gmail");
        Assert.assertEquals(editCustomerPage.getErrorMessageAtEmailTextbox(), "Email-ID is not valid");
        editCustomerPage.inputToEmail("ngan@gmailcom");
        Assert.assertEquals(editCustomerPage.getErrorMessageAtEmailTextbox(), "Email-ID is not valid");
        editCustomerPage.inputToEmail("ngan1244gmail.com");
        Assert.assertEquals(editCustomerPage.getErrorMessageAtEmailTextbox(), "Email-ID is not valid");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
