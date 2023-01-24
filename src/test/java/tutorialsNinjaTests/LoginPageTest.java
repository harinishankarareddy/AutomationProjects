package tutorialsNinjaTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import tutorialsNinjaCommonInfo.BaseTest;
import tutorialsNinjaCommonInfo.CommonUtils;
import tutorialsNinjaPages.AccountInformationPage;
import tutorialsNinjaPages.HeaderPage;
import tutorialsNinjaPages.LoginPage;
import tutorialsNinjaPages.MyAccountPage;

public class LoginPageTest extends BaseTest {
	String expectedMsg="Edit your account information";
	String expectedLoginPageUrl="http://tutorialsninja.com/demo/index.php?route=account/account";
	
	@Test(dataProvider = "loginCredentials")
	public void verifyLogin(String type,String Email,String Pwd) throws InterruptedException {
		HeaderPage headerPage=new HeaderPage(driver);
		LoginPage loginpage=headerPage.navigateToLoginPage();
		loginpage.enterLoginCredentials(type,Email,Pwd);
		loginpage.clickOnLoginButton();
		CommonUtils.takeScreenshot(driver, "credentials");
		MyAccountPage myAccountPage=new MyAccountPage(driver);
		if(type.equalsIgnoreCase("valid")) {
			String actualMsg=myAccountPage.editAccountInfoMsg();
			Assert.assertEquals(actualMsg, expectedMsg);
		}else
		{
		String actualLoginPageUrl=driver.getCurrentUrl();
		Assert.assertEquals(actualLoginPageUrl, expectedLoginPageUrl); 
		CommonUtils.takeScreenshot(driver, "InvalidType");
		}
		
	}
	
	
	@DataProvider(name="loginCredentials")
	public Object[][] loginData() {
	    return new Object[][] {
	      new Object[] { "valid","practicetestingsita@gmail.com", "Hello@123" },
	      new Object[] { "invalidPwd","practicetestingsita@gmail.com", "Helllloooo" },
	      new Object[] { "invalidEmail","practice@gmail.com", "Hello@123" },
	      new Object[] { "bothInvalid","practice@gmail.com", "Helllloooo" },
	      new Object[] { "BothEmpty","", "" },
	      };
	
	
	
	
	
	
	}
	
	
	
	
}


