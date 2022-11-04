package pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import static constants.Constant.LoginData.LOGIN;
import static constants.Constant.LoginData.PASSWORD;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By LOGIN_INPUT = By.id("sign");
    private final By PASSWORD_INPUT = By.id("password");
    private final By ENTER_BUTTON = By.id("signbutton");

    public LoginPage doAuth() {
        WebElement login = driver.findElement(LOGIN_INPUT);
        login.sendKeys(LOGIN);
        WebElement password = driver.findElement(PASSWORD_INPUT);
        password.sendKeys(PASSWORD);
        driver.findElement(ENTER_BUTTON).click();
        return this;
    }
}
