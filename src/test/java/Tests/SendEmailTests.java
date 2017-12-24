package Tests;

import Driver.DriverFactory;
import Email.Email;
import Pages.*;
import User.User;
import User.UserFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.Random;

public class SendEmailTests {
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
    public void SendEmail() {
        Random random = new Random();
        String emailSubject = "Hello:" + random.nextInt(1000);
        LoginForm loginForm = new LoginForm(driver);
        User user = UserFactory.getValidUser();
        Email email = new Email(user.login, emailSubject, "Hello");
        IncomingEmailPage inboxPage = loginForm.login(user, true, IncomingEmailPage.class);
        ComposeEmailPage createEmailPage = inboxPage.createNewEmail();
        SendStatusPage statusPage = createEmailPage.sendEmail(email);
        Assert.assertTrue(statusPage.emailSentConfirmationLabel.isDisplayed());
        EmailManagementForm emailMenu = new EmailManagementForm(driver);
        inboxPage = emailMenu.goToInbox();
        Assert.assertTrue(inboxPage.IsEmailFoundBySubject(emailSubject));
    }

    @AfterClass
    public void tearDown() {
        if(driver!=null) {
            System.out.println("Closing browser");
            driver.quit();
        }
    }
}
