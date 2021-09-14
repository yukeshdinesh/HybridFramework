package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	WebDriver driver;
	String Username;
	String Password;

	public LoginPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user-name")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "login-button")
	WebElement Login;
	
	@FindBy(xpath = "//*[@data-test='error']")
	WebElement errorElement;
	
	public void siginin(String s) {
		
		switch (s) {
		case "Standard":
			Username="standard_user";
			Password = "secret_sauce";
			break;
		case "Invalid":
			Username="Invalid";
			Password = "secret_sauce";
			break;
		case "NoPwd":
			Username="Invalid";
			Password = "";
			break;
		case "NoUser":
			Username="";
			Password = "secret_sauce";
			break;

		default:
			Username="standard_user";
			Password = "secret_sauce";
			break;
		}
		
		username.sendKeys(Username);
		password.sendKeys(Password);
		Login.click();
	}

	public void multiSiginin(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		Login.click();
		
	}
	
	public String getError() {
		return errorElement.getText();
	}
}
