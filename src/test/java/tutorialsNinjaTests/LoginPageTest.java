package tutorialsNinjaTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import tutorialsNinjaCommonInfo.BaseTest;
import tutorialsNinjaPages.HeaderPage;
import tutorialsNinjaPages.LoginPage;

public class LoginPageTest extends BaseTest {
	
	String expectedLoginPageUrl="http://tutorialsninja.com/demo/index.php?route=account/account";
	
	@Test
	public void verifyLoginWithValidCredentials() throws InterruptedException {
		HeaderPage headerPage=new HeaderPage(driver);
		LoginPage loginpage=headerPage.navigateToLoginPage();
		loginpage.enterLoginCredentials();
		loginpage.clickOnLoginButton();
		String actualLoginPageUrl=driver.getCurrentUrl();
		Assert.assertEquals(actualLoginPageUrl, expectedLoginPageUrl); 	  
	}
	
}
