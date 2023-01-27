package tutorialsNinjaTests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import tutorialsNinjaCommonInfo.BaseTest;
import tutorialsNinjaPages.CamerasPage;
import tutorialsNinjaPages.HeaderPage;
import tutorialsNinjaPages.LoginPage;
import tutorialsNinjaPages.MyAccountPage;
import tutorialsNinjaPages.ProductComparisionPage;

public class ProductComparisionTest extends BaseTest {
	@Parameters({"defaultUser","defaultPwd"})
  @Test
  public void productComparision(String email,String pwd) {
		String expectedProduct1="Canon EOS 5D";
		String expectedProduct2="Nikon D300";
		HeaderPage headerPage=new HeaderPage(driver);
		LoginPage loginPage=headerPage.navigateToLoginPage();
		loginPage.enterLoginCredentials(email, pwd);
		MyAccountPage myAccountPage=loginPage.clickOnLoginButton();
		CamerasPage camerasPage=myAccountPage.categoryCameras();
		camerasPage.selectProductAndCompare();
		ProductComparisionPage productComparisionPage=camerasPage.productCompareLink();
		String actualProduct1=productComparisionPage.getFirstProductName();
		Assert.assertEquals(actualProduct1,expectedProduct1);
		String actualProduct2=productComparisionPage.getSecondProductName();
		Assert.assertEquals(actualProduct2, expectedProduct2);
				
  }
}
