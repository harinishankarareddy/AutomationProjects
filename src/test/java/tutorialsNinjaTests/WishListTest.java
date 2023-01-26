package tutorialsNinjaTests;

import org.openqa.selenium.Dimension;
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
	@Parameters({"defaultUser","defaultPwd"})
  @Test
  public void verifyAddProductToWishList(String Email,String Pwd) {
	  String expectedWishListMsg="Success: You have added MacBook to your wish list!";
	  boolean isCartBtnDisplayedExpected=true;
	  HeaderPage headerPage=new HeaderPage(driver);
	  LoginPage loginPage=headerPage.navigateToLoginPage();
	  MyAccountPage myAccountPage=loginPage.enterLoginCredentials(Email,Pwd);
	  SearchPage searchPage=myAccountPage.searchAProduct();
	  searchPage.selectFirstProductAndWishList();
	  String actualWishListMsg=searchPage.getWishListSuccessMsg();
	  SoftAssert softAssert=new SoftAssert();	  
	  softAssert.assertTrue(actualWishListMsg.contains(expectedWishListMsg));
	  WishListPage wishListPage=headerPage.navigateToWishListPage();
	  boolean isCartBtnDisplayedActual=wishListPage.isCartBtnDisplayed();
	  softAssert.assertEquals(isCartBtnDisplayedActual, expectedWishListMsg);
	  
	  wishListPage.addWishlistProductToCart();
	  wishListPage.removeProductFromWishList();
	  headerPage.navigateToWishListPage();
	  String expectedResult="Your wish list is empty.";
	  String actualResult=wishListPage.getWishListEmptyMsg();
	  softAssert.assertEquals(actualResult,expectedResult);
	  softAssert.assertAll();
	 
	  
  }
	@Parameters({"defaultUser","defaultPwd"})
  @Test
  public void verifyRemoveProductFromWishList(String Email,String Pwd) {
	  String expectedResult="Success: You have modified your wish list!";
	  HeaderPage headerPage=new HeaderPage(driver);
	  LoginPage loginPage=headerPage.navigateToLoginPage();
	  MyAccountPage myAccountPage=loginPage.enterLoginCredentials(Email,Pwd);
	  SearchPage searchPage=myAccountPage.searchAProduct();
	  WishListPage wishListPage=searchPage.selectFirstProductAndWishList();
	  headerPage.navigateToWishListPage();
	  Dimension expectedSize=wishListPage.getSizeOfWishList();
	  System.out.println("Size Of WishList:"+expectedSize);
	  wishListPage.removeProductFromWishList();
	  SoftAssert softAssert=new SoftAssert();
	  String actualResult=wishListPage.productRemovedFromWishlistMsg();
	  Assert.assertTrue(actualResult.contains(actualResult));
	  Dimension ActualSize=wishListPage.getSizeOfWishList();
	  System.out.println("Size Of WishList after Product Removal:"+ActualSize);
	  softAssert.assertNotSame(ActualSize, expectedSize);
	  softAssert.assertAll();
  } 
  
}
