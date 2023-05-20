package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Login")
	private WebElement LoginMenu; // Encapsulation is applied here 
	@FindBy(id="input-email")
	private WebElement UserNameField; // Encapsulation is applied here 
	
	public WebElement loginMenu() {
		return LoginMenu;
	}
	
	public WebElement usernamefield() {
		return UserNameField;
	}

}
