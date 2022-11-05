package tests;

import org.testng.annotations.Test;
import pages.main.MainPage;
import tests.base.BaseWebTest;

import static constants.Constant.Urls.DROM_FILTERED_PAGE;

public class CheckFilteredTest extends BaseWebTest {
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
}
