package tutorialsNinjaTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tutorialsNinjaCommonInfo.BaseTest;
import tutorialsNinjaPages.ForgotPasswordPage;
import tutorialsNinjaPages.HeaderPage;
import tutorialsNinjaPages.LoginPage;

public class ForgotPasswordTest extends BaseTest{
	@Parameters("email")
  @Test
  public void verifyForgotPwdFunctionality(String email) {
	  
	  String expectedMessage="Account Login";
	  HeaderPage headerPage=new HeaderPage(driver);
	  
	  LoginPage loginpage=headerPage.navigateToLoginPage();
	  loginpage.clickOnforgotPwdLinkInLoginPage();
	  ForgotPasswordPage forgotPwdPage=new ForgotPasswordPage(driver);
	  forgotPwdPage.enterEmailtoResetPwdAndClickContinueButton(email);
	  String actualMessage=driver.getTitle();
	  Assert.assertTrue(actualMessage.contains(expectedMessage));
	  
  }
	@Parameters("email")
  @Test
  public void verifyForgotPwdFunctionalityFromRightLink(String email) {
	  String expectedMessage="An email with a confirmation link has been sent your email address.";
	  HeaderPage headerPage=new HeaderPage(driver);
	  LoginPage loginpage=headerPage.navigateToLoginPage();
	  loginpage.clickOnforgotPasswordOptionFromRightMenu();
	  ForgotPasswordPage forgotPwdPage=new ForgotPasswordPage(driver);
	  forgotPwdPage.enterEmailtoResetPwdAndClickContinueButton(email);
	  String actualMessage=forgotPwdPage.getConfirmationMessage();
	  System.out.println(actualMessage);
	  Assert.assertEquals(actualMessage, expectedMessage);
	  }
  
  //dataprovider should be used to provide info 
  
  
  
  
  
}
