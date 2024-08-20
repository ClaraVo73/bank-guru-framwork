package template;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
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
    }

    @Test
    public void Close_Google_Ads() {
       // changePasswordPage.sleepInSecond(50);
        WebDriverWait wait = new WebDriverWait(driver,20);
        try {
            // Kiểm tra sự tồn tại của iframe quảng cáo
            if (driver.findElements(By.cssSelector("iframe[id^='google_ads']:not([style*='display: none;'])")).size() > 0) {
                // Chờ iframe có thể được chuyển đến và chuyển đến iframe
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[id^='google_ads']:not([style*='display: none;'])")));

                // In ra nội dung của iframe để kiểm tra
                String iframeContent = driver.findElement(By.tagName("body")).getText();
                log.info("Iframe content: " + iframeContent);

                // Kiểm tra sự tồn tại và tương tác với nút đóng quảng cáo
                WebElement closeAdButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#dismiss-button")));
                if (closeAdButton != null) {
                    closeAdButton.click();
                    log.info("Ad closed successfully.");
                } else {
                    log.info("Close button not found in the ad iframe.");
                }

                driver.switchTo().defaultContent(); // Quay lại nội dung chính sau khi đóng quảng cáo
            } else {
                log.info("Ad iframe not found.");
            }
        } catch (Exception e) {
            log.error("Failed to close ad: " + e.getMessage());
            e.printStackTrace();
        }


    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
