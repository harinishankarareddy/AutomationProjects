package tutorialsNinjaTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import tutorialsNinjaCommonInfo.BaseTest;
import tutorialsNinjaCommonInfo.CommonUtils;
import tutorialsNinjaPages.HeaderPage;
import tutorialsNinjaPages.LoginPage;
import tutorialsNinjaPages.MyAccountPage;
import tutorialsNinjaPages.AccountInformationPage;

public class AccountInfoPageTest extends BaseTest{

	
	@Test
	public void verifyEditAccountInfoFunctionality() {
		String expectedMessage="Success: Your account has been successfully updated.";
		HeaderPage headerPage=new HeaderPage(driver);
		LoginPage loginpage=headerPage.navigateToLoginPage();
		loginpage.enterLoginCredentials();
		MyAccountPage myAccountPage=loginpage.clickOnLoginButton();
		AccountInformationPage accountInformationPage=myAccountPage.clickOnEditAccountInfoPageLink();
		String fname=CommonUtils.generateRandomString();
		String lname=CommonUtils.generateRandomString();
		String tel=CommonUtils.generateRandomNumber();
		accountInformationPage.editAccountInfoAndSubmit(fname, lname, tel);
		String actualMessage=accountInformationPage.getAccountUpdatedMessage();
		Assert.assertTrue(actualMessage.contains(expectedMessage));
	}

}














