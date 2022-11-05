package tests.base;

import common.CommonActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static common.Config.HOLD_BROWSER_OPEN;

public class BaseWebTest {
    protected WebDriver driver;

    @BeforeMethod
    public void driver() {
        driver = CommonActions.createDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        if (HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }
}
