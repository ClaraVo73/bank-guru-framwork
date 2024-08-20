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
        changePasswordPage.closeGoogleAds(driver);
    }

    @Test
    public void CP01_Old_Password_Cannot_Be_Empty() {
        log.info("CP01_Old_Password - Step 01: Press tab at old password textbox");
        changePasswordPage.inputActionsToOldPasswordTextbox(Keys.TAB);

        log.info("CP01_Old_Password - Step 02: Verify show error message: Old Password must not be blank");
        verifyEquals(changePasswordPage.getErrorMessageAtOldPasswordTextbox(), "Old Password must not be blank");
    }

    @Test
    public void CP02_New_Password_Cannot_Be_Empty() {
        log.info("CP02_New_Password - Step 01: Input valid old password textbox");
        changePasswordPage.inputToOldPasswordTextbox(GlobalConstants.PASSWORD);

        log.info("CP02_New_Password - Step 02: Press tab at new password textbox");
        changePasswordPage.inputActionsToNewPasswordTextbox(Keys.TAB);

        log.info("CP02_New_Password - Step 03: Verify show error message: New Password must not be blank ");
        verifyEquals(changePasswordPage.getErrorMessageAtNewPasswordTextbox(), "New Password must not be blank");
    }

    @Test
    public void CP03_New_Password_Must_Have_One_Numeric_Value() {
        log.info("CP03_New_Password - Step 01: Input new password without numeric value");
        changePasswordPage.inputToNewPasswordTextbox("Ngan!@#$");

        log.info("CP03_New_Password - Step 02: Verify show error message: Enter at-least one numeric value");
        verifyEquals(changePasswordPage.getErrorMessageAtNewPasswordTextbox(), "Enter at-least one numeric value");
    }

    @Test
    public void CP04_New_Password_Must_Have_One_Special_Character() {
        log.info("CP04_New_Password - Step 01: Input new password without special character");
        changePasswordPage.inputToNewPasswordTextbox("Ngan12345");

        log.info("CP04_New_Password - Step 02: Verify show error message: Enter at-least one special character");
        verifyEquals(changePasswordPage.getErrorMessageAtNewPasswordTextbox(), "Enter at-least one special character");
    }

    @Test
    public void CP05_New_Password_Cannot_Have_String_Password() {
        log.info("CP04_New_Password - Step 01: Input a simple new password with 'password'");
        changePasswordPage.inputToNewPasswordTextbox("Password123@");

        log.info("CP04_New_Password - Step 02: Verify show error message: Enter at-least one special character");
        verifyEquals(changePasswordPage.getErrorMessageAtNewPasswordTextbox(), "Choose a difficult Password");
    }

    @Test
    public void CP06_Confirm_Password_Cannot_Be_Empty() {
        log.info("CP06_Confirm_Password - Step 01: Press valid password");
        changePasswordPage.inputToNewPasswordTextbox("Ngan&789");

        log.info("CP06_Confirm_Password - Step 02: Press tab at confirm password");
        changePasswordPage.inputActionsToConfirmPasswordTextbox(Keys.TAB);

        log.info("CP06_Confirm_Password - Step 03: Verify show error message:Confirm Password must not be blank ");
        verifyEquals(changePasswordPage.getErrorMessageAtConfirmPasswordTextbox(), "Confirm Password must not be blank");
    }

    @Test
    public void CP07_Confirm_Password_And_New_Password_Must_Be_Matched() {
        log.info("CP07_Confirm_Password - Step 01: Input confirm password does not matched new password");
        changePasswordPage.inputToConfirmPasswordTextbox("Ha*6789");

        log.info("CP07_Confirm_Password - Step 02: Input confirm password does not matched new password");
        verifyEquals(changePasswordPage.getErrorMessageAtConfirmPasswordTextbox(), "Passwords do not Match");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
