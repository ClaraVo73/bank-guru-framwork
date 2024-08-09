package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class PaymentPageObject extends BasePage {
    private WebDriver driver;

    public PaymentPageObject(WebDriver driver) {
        this.driver = driver;
    }

}
