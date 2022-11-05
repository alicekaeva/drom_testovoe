package tests.printdata;

import common.CommonActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.base.BasePage;
import pages.main.MainPage;
import tests.base.BaseTest;

import static common.Config.HOLD_BROWSER_OPEN;
import static constants.Constant.Urls.DROM_MAIN_PAGE;

public class PrintDataTest {

    WebDriver driver;

    @BeforeMethod
    public void driver() {
        driver = CommonActions.createMobileDriver();
    }

    @Test
    public void printDropdownContent() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open(DROM_MAIN_PAGE);
        mainPage.gatherBrands();
    }

    @AfterSuite(alwaysRun = true)
    public void close() {
        if (HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }
}
