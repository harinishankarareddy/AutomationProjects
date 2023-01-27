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

	
	@Test
	public void verifyLogin() throws InterruptedException, IOException {
		String expecteTitle="Account Login";
		HeaderPage headerPage=new HeaderPage(driver);
		LoginPage loginpage=headerPage.navigateToLoginPage();
		Thread.sleep(2000);
		loginpage.enterLoginCredentials();
		MyAccountPage myAccountPage=loginpage.clickOnLoginButton();
		CommonUtils.takeScreenshot(driver, "credentials");
		String actualTitle=myAccountPage.loginSuccess();
		Assert.assertEquals(actualTitle, expecteTitle);


	}







}







