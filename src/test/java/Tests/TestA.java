package Tests;

import Driver.DriverFactory;
import Pages.AfterLoginForm;
import Pages.BasePage;
import Pages.LoginForm;
import User.UserFactory;
import User.User;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class TestA {

    WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) {
        System.out.println("*******************");
        System.out.println("launching browser");
        driver = DriverFactory.getDriver(browser);
        driver.navigate().to(BasePage.BASE_URL);
    }

    @Test
    public void validUserLogin() {
        LoginForm loginForm = PageFactory.initElements(driver, LoginForm.class);
        User user = UserFactory.getValidUser();
        AfterLoginForm validForm = loginForm.login(user, true, AfterLoginForm.class);
        Assert.assertEquals(validForm.userLoginEmail, user.name);
    }

    @AfterClass
    public void tearDown() {
        if(driver!=null) {
            System.out.println("Closing browser");
            driver.quit();
        }
    }

}