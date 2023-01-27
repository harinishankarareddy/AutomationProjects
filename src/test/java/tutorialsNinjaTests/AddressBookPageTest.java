package tutorialsNinjaTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import tutorialsNinjaCommonInfo.BaseTest;
import tutorialsNinjaCommonInfo.CommonUtils;
import tutorialsNinjaPages.HeaderPage;
import tutorialsNinjaPages.LoginPage;
import tutorialsNinjaPages.AddressBookPage;
import tutorialsNinjaPages.MyAccountPage;

public class AddressBookPageTest extends BaseTest{
	
	@Test
	public void verifyModifyAddressBookFunctionality() {
		String expectedMessage="Your address has been successfully added";
		String expectedAddressAdded="ABCDEFGHIJ ABCDEFGHIJ";
		HeaderPage headerPage=new HeaderPage(driver);
		LoginPage loginPage=headerPage.navigateToLoginPage();
		loginPage.enterLoginCredentials();
		
		MyAccountPage myAccountPage=loginPage.clickOnLoginButton();
		AddressBookPage addressBookPage=myAccountPage.clickOnModifyAddressPageLink();
		String fname=CommonUtils.generateRandomString();
		String lname=CommonUtils.generateRandomString();
		String address1=CommonUtils.generateRandomString();
		String city=CommonUtils.generateRandomString();
		String postcod=CommonUtils.generateRandomNumber();
		String countryy=CommonUtils.generateRandomString();
		String state=CommonUtils.generateRandomString();
		addressBookPage.addNewAddressAndSubmit(fname, lname, address1, city, postcod, countryy, state);
		SoftAssert softAssert=new SoftAssert();
		String actualMessage=addressBookPage.getAddressAddedMessage();
		softAssert.assertTrue(actualMessage.contains(expectedMessage));
		System.out.println("Address added successfully");
		String actualAddressAdded=addressBookPage.getAddressAddedEntries();
		softAssert.assertTrue(actualAddressAdded.contains(expectedAddressAdded));		
		System.out.println("Added address displayed in the address entry");
		  softAssert.assertAll();

		
		
		
		
		
		
		
	}
}
		