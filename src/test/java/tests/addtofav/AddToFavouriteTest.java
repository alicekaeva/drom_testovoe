package tests.addtofav;

import common.CommonActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static common.Config.HOLD_BROWSER_OPEN;
import static constants.Constant.Urls.DROM_AUTH_PAGE;

public class AddToFavouriteTest extends BaseTest {
    WebDriver driver;
    @BeforeMethod
    public void driver() {
        driver = CommonActions.createDriver();
    }
    @Test
    public void checkAddingСarToFavourite() {
        basePage.open(DROM_AUTH_PAGE);
        loginPage.doAuth();
        mainPage.addFavourite();
    }
    @AfterSuite(alwaysRun = true)
    public void close() {
        if (HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }
}
