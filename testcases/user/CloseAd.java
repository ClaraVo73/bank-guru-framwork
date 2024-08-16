package user;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.ChangePasswordPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;


public class CloseAd extends BaseTest {
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
        closeAdIfPresent();
    }

    @Test
    public void CP01_Old_Password_Cannot_Be_Empty() {
        log.info("CP01_Old_Password - Step 01: Press tab at old password textbox");
        changePasswordPage.inputActionsToOldPasswordTextbox(Keys.TAB);

        log.info("CP01_Old_Password - Step 02: Verify show error message: Old Password must not be blank");
        verifyEquals(changePasswordPage.getErrorMessageAtOldPasswordTextbox(), "Old Password must not be blank");
    }
    private void closeAdIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20); // Tăng thời gian chờ lên 20 giây

            // Kiểm tra sự tồn tại của iframe
            if (driver.findElements(By.cssSelector("iframe[id^='google_ads']")).size() > 0) {
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[id^='google_ads']")));

                WebElement closeAdButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[role='button'][aria-label='Close']")));
                closeAdButton.click();

                driver.switchTo().defaultContent(); // Quay lại nội dung chính sau khi đóng quảng cáo
                System.out.println("Ad closed successfully.");
            } else {
                System.out.println("Ad iframe not found.");
            }
        } catch (Exception e) {
            System.out.println("Failed to close ad: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
