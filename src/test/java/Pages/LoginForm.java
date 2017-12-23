package Pages;

import User.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class LoginForm extends BasePage {

	@FindBy(name="name")
	private WebElement name;

	@FindBy(name="pass")
	private WebElement password;

	@FindBy (name="domn")
	private Select domain;

	@FindBy (name="auth_type")
	private WebElement rememberMe;

	@FindBy(xpath = ".//input[@value='Войти']")
	private WebElement authButton;

	@FindBy (css = ".content.clear")
	protected WebElement incorectInputError;

	public LoginForm(WebDriver driver) {
		super(driver);
	}

	protected LoginForm setName(String name) {
		this.name.clear();
		this.name.sendKeys(name);
		return this;
	}

	protected LoginForm setPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
		return this;
	}

	protected LoginForm setDomain(String domain){
		List<WebElement> options = this.domain.getOptions();
		for (WebElement item:options) {
			if (item.getAttribute("value").equals(domain))
			{
				item.click();
				break;
			}
		}
		return this;
	}

	protected LoginForm rememberMe (boolean remember){
		this.rememberMe.isSelected();
		if ((remember && !this.rememberMe.isSelected()) || (!remember && this.rememberMe.isSelected()))
			this.rememberMe.click();
		return this;
	}

	protected LoginForm authButtonClick () throws InterruptedException {
		this.authButton.submit();
		Thread.sleep(7000);
		return this;
	}

	public <T extends BasePage> T login (User user, boolean rememberMe, Class<T> page)
	{
		this.setName(user.name);
		this.setPassword(user.password);
		this.setDomain(user.domain);
		this.rememberMe(rememberMe);
		try {
			this.authButtonClick();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return PageFactory.initElements(driver, page);
	}
}