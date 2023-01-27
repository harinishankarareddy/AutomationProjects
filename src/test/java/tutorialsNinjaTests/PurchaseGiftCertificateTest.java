package tutorialsNinjaTests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import tutorialsNinjaCommonInfo.BaseTest;
import tutorialsNinjaPages.AddGiftCertificatePage;
import tutorialsNinjaPages.HeaderPage;
import tutorialsNinjaPages.LoginPage;
import tutorialsNinjaPages.MyAccountPage;
import tutorialsNinjaPages.PurchaseGiftCertificatePage;
import tutorialsNinjaPages.ShoppingCartPage;

public class PurchaseGiftCertificateTest extends BaseTest{
	
	@Parameters({"defaultUser","defaultPwd"})
  @Test(description="verifying purchase gift certificate functionality")
  public void GiftCertificateTest(String email,String pwd) {
	  HeaderPage headerPage=new HeaderPage(driver);
	  LoginPage loginPage=headerPage.navigateToLoginPage();
	  loginPage.enterLoginCredentials(email, pwd);
	  MyAccountPage myAccountPage=loginPage.clickOnLoginButton();
	  AddGiftCertificatePage addGiftCertificatePage=myAccountPage.navigateToGiftCertificatePage();
	  addGiftCertificatePage.purchaseGiftCertificate();
	  PurchaseGiftCertificatePage purchaseGiftCertificatePage=addGiftCertificatePage.nonRefundableOptionCheck();
	  purchaseGiftCertificatePage.navigateToShoppingCartPage();
	  ShoppingCartPage shoppingCartPage=new ShoppingCartPage(driver);
	  boolean actualResult=shoppingCartPage.isGiftremoveBtnDisplayed();
	  boolean expectedResult=true;
	  Assert.assertEquals(actualResult, expectedResult);
		  
	}
	@Parameters({"defaultUser","defaultPwd"})
	  @Test(description="verifying purchase gift certificate functionality")
	  public void GiftCertificateTest2(String email,String pwd) {
		  String expectedMessage="Warning: You must agree that the gift certificates are non-refundable!";
		  HeaderPage headerPage=new HeaderPage(driver);
		  LoginPage loginPage=headerPage.navigateToLoginPage();
		  loginPage.enterLoginCredentials(email, pwd);
		  MyAccountPage myAccountPage=loginPage.clickOnLoginButton();
		  AddGiftCertificatePage addGiftCertificatePage=myAccountPage.navigateToGiftCertificatePage();
		  addGiftCertificatePage.purchaseGiftCertificate();
		  addGiftCertificatePage.nonRefundableOptionUnCheck();
		  String actualMessage=addGiftCertificatePage.warningMessageNonrefundable();
		  Assert.assertEquals(actualMessage, expectedMessage);
	
	
	
	
	}
}