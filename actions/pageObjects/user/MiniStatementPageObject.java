package pageObjects.user;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import user.AccountPageUI;

public class MiniStatementPageObject extends BasePage {
    private WebDriver driver;

    public MiniStatementPageObject(WebDriver driver) {
        this.driver = driver;
    }

}
