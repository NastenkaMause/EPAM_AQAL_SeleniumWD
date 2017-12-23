package Pages;

import Driver.DriverMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected static DriverMethods driver;
    public static final String BASE_URL = "http://i.ua/";

    public BasePage(WebDriver driver) {
        this.driver = new DriverMethods(driver);
        PageFactory.initElements(driver,this);
    }

}
