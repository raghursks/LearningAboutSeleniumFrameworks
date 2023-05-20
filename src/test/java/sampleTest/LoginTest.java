package sampleTest;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjectModel.LoginPage;
import pageObjectModel.featuresMenu;
import resources.Base;

public class LoginTest extends Base {

	public WebDriver driver;

	@Test(dataProvider = "getLoginData")
	public void Login(String email, String password, String expectedStatus) throws IOException {

		featuresMenu featuremenu = new featuresMenu(driver);

		featuremenu.FeatureMenu().click();

		LoginPage loginpage = new LoginPage(driver);

		loginpage.loginMenu().click();
		
		System.out.println("Login Menu is clicked"+loginpage);

		loginpage.usernamefield().sendKeys(email);
		
		System.out.println("Email id is entered successfully"+loginpage);

	}

	@BeforeMethod
	public void openApplication() throws IOException {

		driver = intializeDriver();
		driver.get(prop.getProperty("url"));

	}


	@DataProvider

	public Object[][] getLoginData() {

		//Object[][] data = { { "raghu", "sample", "successfull" }, { "raghu", "sampletest", "fail" } };
		Object[][] data = { { "raghu", "sample", "successfull" }};

		return data;

	}

	@AfterMethod
	public void browserClosing() {

		driver.quit();
}
}
