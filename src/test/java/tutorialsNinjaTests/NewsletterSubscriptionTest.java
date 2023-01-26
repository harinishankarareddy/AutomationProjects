package tutorialsNinjaTests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import tutorialsNinjaCommonInfo.BaseTest;
import tutorialsNinjaPages.HeaderPage;
import tutorialsNinjaPages.LoginPage;
import tutorialsNinjaPages.MyAccountPage;
import tutorialsNinjaPages.NewsletterSubscriptionPage;

public class NewsletterSubscriptionTest extends BaseTest{
	@Parameters({"subscriptionType","defaultUser","defaultPwd"})
  @Test
  public void verifyNewsletterSubscriptionFunctionality(String subscriptionType,String Email,String Pwd) {
		String expectedMsg="Success: Your newsletter subscription has been successfully updated!";
	  HeaderPage headerPage=new HeaderPage(driver);
	  LoginPage loginPage=headerPage.navigateToLoginPage();
	  loginPage.enterLoginCredentials(Email,Pwd);
	  MyAccountPage myAccountPage=loginPage.clickOnLoginButton();
	  
	  NewsletterSubscriptionPage newsletterSubscriptionPage=myAccountPage.subscribeOrUnsubscribeToNewsletter();
	  newsletterSubscriptionPage.SubscribeYesOrNo(subscriptionType);
	  String actualMsg=myAccountPage.subscriptionUpdateMessage();
	  Assert.assertEquals(actualMsg, expectedMsg);
  }
	
	 
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
