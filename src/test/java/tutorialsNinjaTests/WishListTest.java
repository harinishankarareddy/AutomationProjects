package tutorialsNinjaTests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import tutorialsNinjaCommonInfo.BaseTest;
import tutorialsNinjaPages.HeaderPage;
import tutorialsNinjaPages.LoginPage;
import tutorialsNinjaPages.MyAccountPage;
import tutorialsNinjaPages.SearchPage;
import tutorialsNinjaPages.WishListPage;

public class WishListTest extends BaseTest{
	
  @Test
  public void verifyProductWishListFunctionality(String defaultName,String defaultPwd) {
	  String expectedWishListMsg="Success: You have added MacBook to your wish list!";
	  String expectedProdModel="Model";
	  HeaderPage headerPage=new HeaderPage(driver);
	  LoginPage loginPage=headerPage.navigateToLoginPage();
	  MyAccountPage myAccountPage=loginPage.enterLoginCredentials();
	  SearchPage searchPage=myAccountPage.searchAProduct();
	  searchPage.selectFirstProductAndWishList();
	  String actualWishListMsg=searchPage.getWishListSuccessMsg();
	  SoftAssert softAssert=new SoftAssert();	  
	  softAssert.assertTrue(actualWishListMsg.contains(expectedWishListMsg));
	  WishListPage wishListPage=headerPage.navigateToWishListPage();
	  String actualProdModel=wishListPage.getProductModel();
	  softAssert.assertEquals(actualProdModel, expectedProdModel);
	  
	  wishListPage.addWishlistProductToCart();
	  wishListPage.removeProductFromWishList();
	  headerPage.navigateToWishListPage();
	  String expectedResult="Your wish list is empty.";
	  String actualResult=wishListPage.getWishListEmptyMsg();
	  softAssert.assertEquals(actualResult,expectedResult);
	  softAssert.assertAll();
	  
	  
  }
}
