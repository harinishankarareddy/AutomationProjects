package tutorialsNinjaTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import tutorialsNinjaCommonInfo.BaseTest;
import tutorialsNinjaPages.HeaderPage;
import tutorialsNinjaPages.RegisterPage;

public class RegisterPageTest extends BaseTest{
	
	
  @Test
  public void verifyValidRegisterFunctionality() {
	  String expectedRegisterPage="http://tutorialsninja.com/demo/index.php?route=account/success";
	  HeaderPage headerPage=new HeaderPage(driver);
	  RegisterPage registerpage=headerPage.navigateToRegisterPage();
	  registerpage.enterDataToRegisterAccount();
	  String actualRegisterPage=driver.getCurrentUrl();
	  Assert.assertEquals(actualRegisterPage, expectedRegisterPage);
	 	  
  }	  
   
}

	


