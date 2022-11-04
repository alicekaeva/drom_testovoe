package tests.addtofav;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Urls.DROM_AUTH_PAGE;

public class AddToFavouriteTest extends BaseTest {
    //to run this, change config to mac_chrome
    @Test
    public void checkAddingСarToFavourite() {
        basePage.open(DROM_AUTH_PAGE);
        loginPage.doAuth();
        mainPage.addFavourite();
    }
}
