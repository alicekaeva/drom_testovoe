package tests.checkfilteredcars;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Urls.DROM_FILTERED_PAGE;

public class CheckFilteredTest extends BaseTest {
    //to run this, change config to mac_chrome
    @Test
    public void checkCars() {
        basePage.open(DROM_FILTERED_PAGE);
        mainPage.checkCrossedText();
        mainPage.checkYear();
        mainPage.checkMileage();
        mainPage.goToSecondPage();
        mainPage.checkCrossedText();
        mainPage.checkYear();
        mainPage.checkMileage();
    }
}
