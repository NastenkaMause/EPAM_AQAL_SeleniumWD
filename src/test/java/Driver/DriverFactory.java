package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public abstract class DriverFactory {

    public static WebDriver getDriver() {

        WebDriver driver = null;
        String browser = System.getProperty("browser");

            switch (browser) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                default:
                    System.out.println("Invalid browser name");
            }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
        }

}

