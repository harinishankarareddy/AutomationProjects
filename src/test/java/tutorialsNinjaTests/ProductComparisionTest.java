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
		String expectedProdNum2="Product 44";
		test=extent.createTest("Product Comparision Test");
		test.info("clickOn MyAccount and clickOn Login");
		HeaderPage headerPage=new HeaderPage(driver);
		LoginPage loginPage=headerPage.navigateToLoginPage();
		test.pass("Navigated To LoginPage");
		test.info("Enter valid credentials to Login");
		loginPage.enterLoginCredentials();
		MyAccountPage myAccountPage=loginPage.clickOnLoginButton();
		test.pass("Logged into the account Successfully");
		test.info("Click on ProductCategory 'Cameras'");
		CamerasPage camerasPage=myAccountPage.categoryCameras();
		test.info("Add Products to Compare");
		camerasPage.firstProductToCompare();
		camerasPage.secondProductToCompare();
		test.info("Click on Product compare Link");
		ProductComparisionPage productComparisionPage=camerasPage.productCompareLink();
		test.pass("Products are added to Product Compare Page");
		test.info("Compare the added products and validate");
		SoftAssert softAssert=new SoftAssert();	
		String actualProduct1=productComparisionPage.getFirstProductName();
		softAssert.assertEquals(actualProduct1,expectedProduct1);
		String actualProduct2=productComparisionPage.getSecondProductName();
		softAssert.assertEquals(actualProduct2, expectedProduct2);
		test.pass("Product names comparision test passed");
		String actualProdNum1=productComparisionPage.getFirstProductNumber();
		softAssert.assertEquals(actualProdNum1, expectedProdNum1);
		String actualProdNum2=productComparisionPage.getSecondProductNumber();
		softAssert.assertEquals(actualProdNum2, expectedProdNum2);
		test.pass("Product number comparision test passed");
		softAssert.assertAll();		
  }
}
