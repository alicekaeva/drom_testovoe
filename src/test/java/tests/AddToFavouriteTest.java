package tests;

import org.testng.annotations.Test;
import pages.login.LoginPage;
import pages.main.MainPage;
import tests.base.BaseWebTest;

import static constants.Constant.Urls.DROM_AUTH_PAGE;

public class AddToFavouriteTest extends BaseWebTest {

    @Test
    public void checkAddingСarToFavourite() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.open(DROM_AUTH_PAGE);
        loginPage.doAuth();
        mainPage.addFavourite();
    }
}
