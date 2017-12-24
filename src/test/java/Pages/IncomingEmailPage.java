package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IncomingEmailPage extends BasePage {

    @FindBy(css=".make_message>a")
    private WebElement createEmail;

    public IncomingEmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ComposeEmailPage createNewEmail(){
        createEmail.click();
        return new ComposeEmailPage(driver);
    }

    public boolean IsEmailFoundBySubject(String subject){
        List<WebElement> emailList = driver.findElements(By.className("sbj"));
        for (WebElement item:emailList) {
            if(item.getText().equals(subject))
                return true;
        }
        return false;
    }
}
