package tests.checkfilteredcars;

import common.CommonActions;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.main.MainPage;
import tests.base.BaseTest;

import static common.Config.HOLD_BROWSER_OPEN;
import static constants.Constant.Urls.DROM_FILTERED_PAGE;

public class CheckFilteredTest {
    WebDriver driver;
    @BeforeMethod
    public void driver() {
        driver = CommonActions.createDriver();
    }
    @Test
    public void checkCars() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open(DROM_FILTERED_PAGE);
        mainPage.checkCrossedText();
        mainPage.checkYear();
        mainPage.checkMileage();
        mainPage.goToSecondPage();
        mainPage.checkCrossedText();
        mainPage.checkYear();
        mainPage.checkMileage();
    }
    @AfterSuite(alwaysRun = true)
    public void close() {
        if (HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }
}
