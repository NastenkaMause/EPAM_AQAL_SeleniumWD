package Pages;

import Email.Email;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComposeEmailPage extends BasePage {

    @FindBy(id="to")
    private WebElement to;

    @FindBy(name="subject")
    private WebElement subject;

    @FindBy(id="text")
    private WebElement body;

    @FindBy(name="send")
    private WebElement sendButton;

    public ComposeEmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SendStatusPage sendEmail(Email email){
        this.subject.sendKeys(email.subject);
        this.body.sendKeys(email.body);
        this.to.sendKeys(email.to);
        this.sendButton.click();
        return new SendStatusPage(driver);
    }
}
