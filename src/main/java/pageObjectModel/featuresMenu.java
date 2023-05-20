package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class featuresMenu {
	
	WebDriver driver;
	
	public featuresMenu(WebDriver driver) {
		
	this.driver = driver;
	
	PageFactory.initElements(driver, this);	
	}
	
	//@FindBy(xpath="//*[@class=\"collapse navbar-collapse\"]//ancestor :: a[contains(text(),'Features')]")
	@FindBy(linkText="Features")
	private WebElement Feature; // Encapsulation is applied here 
	
	public WebElement FeatureMenu() {
		
		return Feature;
	}
	

}
