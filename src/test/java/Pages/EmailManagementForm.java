package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailManagementForm extends BasePage {

    @FindBy(xpath=".//a[contains(@href, 'list/INBOX')]")
    public WebElement inbox;

    public EmailManagementForm(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public IncomingEmailPage goToInbox(){
        inbox.click();
        return new IncomingEmailPage(driver);
    }
}
