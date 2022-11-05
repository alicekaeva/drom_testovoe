package tests.base;

import common.CommonActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static common.Config.HOLD_BROWSER_OPEN;

public class BaseMobileTest extends BaseWebTest {
    protected WebDriver driver;

    @BeforeMethod
    public void driver() {
        driver = CommonActions.createMobileDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        if (HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }
}
