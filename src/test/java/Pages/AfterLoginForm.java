package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AfterLoginForm extends BasePage {
	@FindBy(className="user_name")
    public WebElement userLoginEmail;

    public AfterLoginForm(WebDriver driver) {
        super(driver);
    }
}
