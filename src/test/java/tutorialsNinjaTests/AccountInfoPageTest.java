package tutorialsNinjaTests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import tutorialsNinjaCommonInfo.BaseTest;
import tutorialsNinjaCommonInfo.CommonUtils;
import tutorialsNinjaPages.HeaderPage;
import tutorialsNinjaPages.LoginPage;
import tutorialsNinjaPages.AddressBookPage;
import tutorialsNinjaPages.MyAccountPage;
import tutorialsNinjaPages.AccountInformationPage;

public class AccountInfoPageTest extends BaseTest{

	@Parameters({"defaultUser","defaultPwd"})
	@Test
	public void verifyEditAccountInfoFunctionality(String defaultEmail,String defaultPwd) {
		String expectedMessage="Success: Your account has been successfully updated.";
		HeaderPage headerPage=new HeaderPage(driver);
		LoginPage loginPage=headerPage.navigateToLoginPage();
		loginPage.enterLoginCredentials();
		MyAccountPage myAccountPage=new MyAccountPage(driver);
		AccountInformationPage accountInformationPage=myAccountPage.clickOnEditAccountInfoPageLink();
		String fname=CommonUtils.generateRandomString();
		String lname=CommonUtils.generateRandomString();
		String tel=CommonUtils.generateRandomNumber();
		accountInformationPage.editAccountInfoAndSubmit(fname, lname, tel);
		String actualMessage=accountInformationPage.getAccountUpdatedMessage();
		Assert.assertTrue(actualMessage.contains(expectedMessage));
	}

}














