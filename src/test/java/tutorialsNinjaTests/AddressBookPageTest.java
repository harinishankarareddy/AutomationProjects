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

public class AddressBookPageTest extends BaseTest{
	@Parameters({"defaultUser","defaultPwd"})
	@Test
	public void verifyModifyAddressBookFunctionality(String defaultEmail,String defaultPwd) {
		String expectedMessage="Your address has been successfully added";
		String expectedAddressAdded="ABCDEFGHIJ ABCDEFGHIJ";
		HeaderPage headerPage=new HeaderPage(driver);
		LoginPage loginPage=headerPage.navigateToLoginPage();
		loginPage.enterLoginCredentials();
		
		MyAccountPage myAccountPage=new MyAccountPage(driver);
		AddressBookPage addressBookPage=myAccountPage.clickOnModifyAddressPageLink();
		String fname=CommonUtils.generateRandomString();
		String lname=CommonUtils.generateRandomString();
		String address1=CommonUtils.generateRandomString();
		String city=CommonUtils.generateRandomString();
		String postcod=CommonUtils.generateRandomNumber();
		String countryy=CommonUtils.generateRandomString();
		String state=CommonUtils.generateRandomString();
		addressBookPage.addNewAddressAndSubmit(fname, lname, address1, city, postcod, countryy, state);
		String actualMessage=addressBookPage.getAddressAddedMessage();
		Assert.assertTrue(actualMessage.contains(expectedMessage));
		System.out.println("Address added successfully");
		String actualAddressAdded=addressBookPage.getAddressAddedEntries();
		Assert.assertTrue(actualAddressAdded.contains(expectedAddressAdded));
		System.out.println("Added address displayed in the address entry");
		
		
		
		
		
		
		
		
	}
}
		