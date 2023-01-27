package tutorialsNinjaTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import tutorialsNinjaCommonInfo.BaseTest;
import tutorialsNinjaCommonInfo.CommonUtils;
import tutorialsNinjaPages.HeaderPage;
import tutorialsNinjaPages.LoginPage;
import tutorialsNinjaPages.MyAccountPage;

public class LoginPageTest extends BaseTest {
	String expectedMsg="Edit your account information";
	String expectedLoginPageUrl="http://tutorialsninja.com/demo/index.php?route=account/account";

	
	//@Test
	public void verifyLogin() throws InterruptedException, IOException {
		String expectedTitle="My Account";
		HeaderPage headerPage=new HeaderPage(driver);
		LoginPage loginpage=headerPage.navigateToLoginPage();
		loginpage.enterLoginCredentials();
		MyAccountPage myAccountPage=loginpage.clickOnLoginButton();
		CommonUtils.takeScreenshot(driver, "credentials");
		String actualTitle=myAccountPage.loginSuccess();
		Assert.assertEquals(actualTitle, expectedTitle);

	}


	@Test
	public void verifyLogin2() throws InterruptedException, IOException {

	test=extent.createTest("login Test");	
	test.info("test info");		
	test.info("clickOn MyAccount and clickOn Login");
	HeaderPage headerPage=new HeaderPage(driver);
	LoginPage loginpage=headerPage.navigateToLoginPage();
	test.pass("Navigated to LoginPage");
	test.info("entering login credentials");
	loginpage.enterLoginCredentials();
	MyAccountPage myAccountPage=loginpage.clickOnLoginButton();
	test.pass("entered credentials and loggedin successfully");
	String actualTitle=myAccountPage.loginSuccess();
	String expectedTitle="My Account";
	Assert.assertEquals(actualTitle, expectedTitle);
	test.pass("Login Test Passed");
	}

}







