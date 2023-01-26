package tutorialsNinjaTests;

import java.io.IOException;

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

	@Parameters({"defaultUser","defaultPwd"})
	@Test
	public void verifyLogin(String user,String Pwd) throws InterruptedException, IOException {
		String expecteTitle="Account Login";
		HeaderPage headerPage=new HeaderPage(driver);
		LoginPage loginpage=headerPage.navigateToLoginPage();
		loginpage.enterLoginCredentials(user,Pwd);
		MyAccountPage myAccountPage=loginpage.clickOnLoginButton();
		CommonUtils.takeScreenshot(driver, "credentials");
		String actualTitle=myAccountPage.loginSuccess();
		Assert.assertEquals(actualTitle, expecteTitle);


	}







}







