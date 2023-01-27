package tutorialsNinjaTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import tutorialsNinjaCommonInfo.BaseTest;
import tutorialsNinjaPages.CamerasPage;
import tutorialsNinjaPages.HeaderPage;
import tutorialsNinjaPages.LoginPage;
import tutorialsNinjaPages.MyAccountPage;
import tutorialsNinjaPages.ProductComparisionPage;

public class ProductComparisionTest extends BaseTest {
	
  @Test
  public void productComparision() {
		String expectedProduct1="Canon EOS 5D";
		String expectedProduct2="Nikon D300";
		String expectedProdNum1="Product 3";
		String expectedProdNum2="Product 4";
		HeaderPage headerPage=new HeaderPage(driver);
		LoginPage loginPage=headerPage.navigateToLoginPage();
		loginPage.enterLoginCredentials();
		MyAccountPage myAccountPage=loginPage.clickOnLoginButton();
		CamerasPage camerasPage=myAccountPage.categoryCameras();
		camerasPage.selectProductAndCompare();
		ProductComparisionPage productComparisionPage=camerasPage.productCompareLink();
		String actualProduct1=productComparisionPage.getFirstProductName();
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(actualProduct1,expectedProduct1);
		String actualProduct2=productComparisionPage.getSecondProductName();
		softAssert.assertEquals(actualProduct2, expectedProduct2);
		
		String actualProdNum1=productComparisionPage.getFirstProductNumber();
		softAssert.assertEquals(actualProdNum1, expectedProdNum1);
		
		String actualProdNum2=productComparisionPage.getSecondProductNumber();
		softAssert.assertEquals(actualProdNum2, expectedProdNum2);	
		softAssert.assertAll();		
  }
}
