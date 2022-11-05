package tests;

import org.testng.annotations.Test;
import pages.main.MainPage;
import tests.base.BaseMobileTest;

import static constants.Constant.Urls.DROM_MAIN_PAGE;

public class PrintDataTest extends BaseMobileTest {
    @Test
    public void printDropdownContent() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open(DROM_MAIN_PAGE);
        mainPage.gatherBrands();
    }
}
