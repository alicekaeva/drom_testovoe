package tests.printdata;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Urls.DROM_MAIN_PAGE;

public class PrintDataTest extends BaseTest {
    //to run this, change config to nexus
    @Test
    public void printDropdownContent() {
        basePage.open(DROM_MAIN_PAGE);
        mainPage.gatherBrands();
    }
}
