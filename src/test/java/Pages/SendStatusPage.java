package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendStatusPage extends BasePage {

    @FindBy(css=".block_confirmation .content.clear")
    public WebElement emailSentConfirmationLabel;

    public SendStatusPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
