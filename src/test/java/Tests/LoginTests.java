package Tests;

import Driver.DriverFactory;
import Pages.AfterLoginForm;
import Pages.BasePage;
import Pages.LoginForm;
import User.User;
import User.UserFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class LoginTests {

    WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) {
        System.out.println("*******************");
        System.out.println("launching browser");
        System.setProperty("browser", browser);
        driver = DriverFactory.getDriver();
    }

    @BeforeMethod
    public void setUpTest(){
        driver.navigate().to(BasePage.BASE_URL);
    }

    @Test
    public void validUserLogin() {
        LoginForm loginForm = new LoginForm(driver);
        User user = UserFactory.getValidUser();
        AfterLoginForm validForm = loginForm.login(user, true, AfterLoginForm.class);
        Assert.assertEquals(validForm.userLoginEmail.getText(), user.name);
    }

    @Test
    public void invalidUserLogin() {
        LoginForm loginForm = new LoginForm(driver);
        User user = UserFactory.getNotValidUser();
        loginForm = loginForm.login(user, true, LoginForm.class);
        Assert.assertTrue(loginForm.incorectInputError.isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        if(driver!=null) {
            System.out.println("Closing browser");
            driver.quit();
        }
    }
}