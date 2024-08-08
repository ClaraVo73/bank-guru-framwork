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
import pageObjects.user.ChangePasswordPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;

import java.util.Random;

public class ChangePassword extends BaseTest {
    private LoginPageObject loginPage;
    private HomePageObject homePage;
    private ChangePasswordPageObject changePasswordPage;

    @Parameters({"browser", "environment"})
    @BeforeClass
    public void beforeClass(String browserName, String environmentName) {
        driver = getBrowserDriver(browserName, environmentName);
        loginPage = PageGeneratorManager.getLoginPage(driver);
        homePage = loginPage.loginUser(GlobalConstants.USER_NAME, GlobalConstants.PASSWORD);
        homePage.openPagesFromMenuSub(driver, "Change Password");
        changePasswordPage = PageGeneratorManager.getChangePasswordPage(driver);
    }

    @Test
    public void CP01_Old_Password_Cannot_Be_Empty() {
        changePasswordPage.inputActionsToOldPasswordTextbox(Keys.TAB);
        Assert.assertEquals(changePasswordPage.getErrorMessageAtOldPasswordTextbox(), "Old Password must not be blank");
    }

    @Test
    public void CP02_New_Password_Cannot_Be_Empty() {
        changePasswordPage.inputToOldPasswordTextbox(GlobalConstants.PASSWORD);
        changePasswordPage.inputActionsToNewPasswordTextbox(Keys.TAB);
        Assert.assertEquals(changePasswordPage.getErrorMessageAtNewPasswordTextbox(), "New Password must not be blank");
    }

    @Test
    public void CP03_New_Password_Must_Have_One_Numeric_Value() {
        changePasswordPage.inputToNewPasswordTextbox("Ngan!@#$");
        Assert.assertEquals(changePasswordPage.getErrorMessageAtNewPasswordTextbox(), "Enter at-least one numeric value");
    }

    @Test
    public void CP04_New_Password_Must_Have_One_Special_Character() {
        changePasswordPage.inputToNewPasswordTextbox("Ngan12345");
        Assert.assertEquals(changePasswordPage.getErrorMessageAtNewPasswordTextbox(), "Enter at-least one special character");
    }

    @Test
    public void CP05_New_Password_Cannot_Have_String_Password() {
        changePasswordPage.inputToNewPasswordTextbox("Password123@");
        Assert.assertEquals(changePasswordPage.getErrorMessageAtNewPasswordTextbox(), "Choose a difficult Password");
    }

    @Test
    public void CP06_Confirm_Password_Cannot_Be_Empty() {
        changePasswordPage.inputToNewPasswordTextbox("Ngan&789");
        changePasswordPage.inputActionsToConfirmPasswordTextbox(Keys.TAB);
        Assert.assertEquals(changePasswordPage.getErrorMessageAtConfirmPasswordTextbox(), "Confirm Password must not be blank");
    }

    @Test
    public void CP07_Confirm_Password_And_New_Password_Must_Be_Matched() {
        changePasswordPage.inputToConfirmPasswordTextbox("Ha*6789");
        Assert.assertEquals(changePasswordPage.getErrorMessageAtConfirmPasswordTextbox(), "Passwords do not Match");
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
