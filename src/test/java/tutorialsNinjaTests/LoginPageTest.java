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

@Test
	public void verifyLogin() throws InterruptedException, IOException {
		test=extent.createTest("Login Test1");
		test.info("test info");		
		test.info("clickOn MyAccount and clickOn Login");
		String expectedTitle="My Account";
		HeaderPage headerPage=new HeaderPage(driver);
		LoginPage loginpage=headerPage.navigateToLoginPage();
		test.pass("Navigated to LoginPage");
		test.info("entering login credentials");
		loginpage.enterLoginCredentials();
		MyAccountPage myAccountPage=loginpage.clickOnLoginButton();
		test.pass("entered credentials and loggedin successfully");
		String actualTitle=myAccountPage.loginSuccess();
		Assert.assertEquals(actualTitle, expectedTitle);
		test.pass("Login Test Passes");

	}
	@Test
	public void verifyLogin2() throws InterruptedException, IOException {

	test=extent.createTest("Login Test2");	
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
	String expectedTitle="My Account ";
	Assert.assertEquals(actualTitle, expectedTitle);
	test.fail("Login Test failed");
	
	}

}







