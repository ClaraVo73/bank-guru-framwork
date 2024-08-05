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

    @Test
    public void NC03_Name_Cannot_Have_Special_Characters() {
        newCustomerPage.inputToCustomerName("name@#$");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtUserIDTextbox(), "Special characters are not allowed");
        newCustomerPage.inputToCustomerName("%^&&*123");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtUserIDTextbox(), "Special characters are not allowed");
    }

    @Test
    public void NC04_Name_Cannot_Have_First_Blank_Space() {
        newCustomerPage.inputToCustomerName(" name");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtUserIDTextbox(), "First character can not have space");
    }

    @Test
    public void NC05_Address_Cannot_Be_Empty() {
        newCustomerPage.inputToCustomerName("Name");
        newCustomerPage.inputActionsToAddress(Keys.TAB);
        Assert.assertEquals(newCustomerPage.getErrorMessageAtAddressTextbox(), "Address Field must not be blank");
    }

    @Test
    public void NC06_Address_Cannot_Have_First_Blank_Space() {
        newCustomerPage.inputToAddress(" Hung Vuong");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtAddressTextbox(), "First character can not have space");
    }

    @Test
    public void NC08_City_Cannot_Be_Empty() {
        newCustomerPage.inputToAddress("Hung Vuong");
        newCustomerPage.inputActionsToCity(Keys.TAB);
        Assert.assertEquals(newCustomerPage.getErrorMessageAtCityTextbox(), "City Field must not be blank");
    }

    @Test
    public void NC09_City_Cannot_Be_Numeric() {
        newCustomerPage.inputToCity("1234");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtCityTextbox(), "Numbers are not allowed");
        newCustomerPage.inputToCity("Ha Noi 1234");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtCityTextbox(), "Numbers are not allowed");
    }

    @Test
    public void NC10_City_Cannot_Have_Special_Character() {
        newCustomerPage.inputToCity("!@#$$%");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtCityTextbox(), "Special characters are not allowed");
        newCustomerPage.inputToCity("Ha Noi @#$$");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtCityTextbox(), "Special characters are not allowed");
    }

    @Test
    public void NC11_City_Cannot_Have_First_Blank_Space() {
        newCustomerPage.inputToCity(" Ha Noi");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtCityTextbox(), "First character can not have space");
    }

    @Test
    public void NC12_State_Cannot_Be_Empty() {
        newCustomerPage.inputToCity("Ha Noi");
        newCustomerPage.inputActionsToState(Keys.TAB);
        Assert.assertEquals(newCustomerPage.getErrorMessageAtStateTextbox(), "State must not be blank");
    }

    @Test
    public void NC13_State_Cannot_Be_Numeric() {
        newCustomerPage.inputToState("1234");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtStateTextbox(), "Numbers are not allowed");
        newCustomerPage.inputToState("Mien Nam 1234");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtStateTextbox(), "Numbers are not allowed");
    }

    @Test
    public void NC14_State_Cannot_Have_Special_Character() {
        newCustomerPage.inputToState("!@#$$%");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtStateTextbox(), "Special characters are not allowed");
        newCustomerPage.inputToState("Mien Nam @#$$");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtStateTextbox(), "Special characters are not allowed");
    }

    @Test
    public void NC15_State_Cannot_Have_First_Blank_Space() {
        newCustomerPage.inputToState(" Mien Nam");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtStateTextbox(), "First character can not have space");
    }

    @Test
    public void NC16_PIN_Must_Be_Numeric() {
        newCustomerPage.inputToState("Mien Nam");
        newCustomerPage.inputToPIN("1234PIN");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtPINTextbox(), "Characters are not allowed");
    }

    @Test
    public void NC17_PIN_Cannot_Be_Empty() {
        newCustomerPage.inputActionsToPIN(Keys.TAB);
        Assert.assertEquals(newCustomerPage.getErrorMessageAtPINTextbox(), "PIN Code must not be blank");
    }

    @Test
    public void NC18_PIN_Must_6_Digits() {
        newCustomerPage.inputToPIN("12345");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtPINTextbox(), "PIN Code must have 6 Digits");
    }

    @Test
    public void NC19_PIN_Cannot_Have_Special_Character() {
        newCustomerPage.inputToPIN("!@#$123");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtPINTextbox(), "Special characters are not allowed");
    }

    @Test
    public void NC20_PIN_Cannot_Have_First_Blank_Space() {
        newCustomerPage.inputToPIN(" 12345");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtPINTextbox(), "First character can not have space");
    }

    @Test
    public void NC21_PIN_Cannot_Have_Blank_Space() {
        newCustomerPage.inputToPIN("12 345");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtPINTextbox(), "Characters are not allowed");
    }

    @Test
    public void NC22_Mobile_Cannot_Be_Empty() {
        newCustomerPage.inputToPIN("123456");
        newCustomerPage.inputActionsToMobileNumber(Keys.TAB);
        Assert.assertEquals(newCustomerPage.getErrorMessageAtMobileNumberTextbox(), "Mobile no must not be blank");
    }

    @Test
    public void NC23_Mobile_Cannot_Have_First_Blank_Space() {
        newCustomerPage.inputToMobileNumber(" 0124536779");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtMobileNumberTextbox(), "First character can not have space");
    }

    @Test
    public void NC24_Mobile_Cannot_Have_Blank_Space() {
        newCustomerPage.inputToMobileNumber("012 45678");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtMobileNumberTextbox(), "Characters are not allowed");
    }

    @Test
    public void NC25_PIN_Cannot_Have_Special_Character() {
        newCustomerPage.inputToMobileNumber("013455#$%^");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtMobileNumberTextbox(), "Special characters are not allowed");
    }

    @Test
    public void NC26_Email_Cannot_Be_Empty() {
        newCustomerPage.inputToMobileNumber("0123456789");
        newCustomerPage.inputActionsToEmail(Keys.TAB);
        Assert.assertEquals(newCustomerPage.getErrorMessageAtEmailTextbox(), "Email-ID must not be blank");
    }

    @Test
    public void NC27_Email_Must_Be_In_Correct_Format() {
        newCustomerPage.inputToEmail("ngan");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtEmailTextbox(), "Email-ID is not valid");
        newCustomerPage.inputToEmail("ngan@");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtEmailTextbox(), "Email-ID is not valid");
        newCustomerPage.inputToEmail("ngan@gmail");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtEmailTextbox(), "Email-ID is not valid");
        newCustomerPage.inputToEmail("ngan@gmailcom");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtEmailTextbox(), "Email-ID is not valid");
        newCustomerPage.inputToEmail("ngan1244gmail.com");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtEmailTextbox(), "Email-ID is not valid");
    }

    @Test
    public void NC29_Email_Cannot_Have_First_Blank_Space() {
        newCustomerPage.inputToEmail(" ngan1244@gmail.com");
        Assert.assertEquals(newCustomerPage.getErrorMessageAtEmailTextbox(), "First character can not have space");
    }

    @Test
    public void NC30_All_Label_Are_As_Requirement() {
        Assert.assertTrue(newCustomerPage.isAllLabelsAtNewCustomerPageDisplayed("Customer Name"));
        Assert.assertTrue(newCustomerPage.isAllLabelsAtNewCustomerPageDisplayed("Gender"));
        Assert.assertTrue(newCustomerPage.isAllLabelsAtNewCustomerPageDisplayed("Date of Birth"));
        Assert.assertTrue(newCustomerPage.isAllLabelsAtNewCustomerPageDisplayed("Address"));
        Assert.assertTrue(newCustomerPage.isAllLabelsAtNewCustomerPageDisplayed("City"));
        Assert.assertTrue(newCustomerPage.isAllLabelsAtNewCustomerPageDisplayed("State"));
        Assert.assertTrue(newCustomerPage.isAllLabelsAtNewCustomerPageDisplayed("PIN"));
        Assert.assertTrue(newCustomerPage.isAllLabelsAtNewCustomerPageDisplayed("Mobile Number"));
        Assert.assertTrue(newCustomerPage.isAllLabelsAtNewCustomerPageDisplayed("E-mail"));
        Assert.assertTrue(newCustomerPage.isAllLabelsAtNewCustomerPageDisplayed("Password"));
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
