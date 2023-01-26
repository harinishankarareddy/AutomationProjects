package tutorialsNinjaTests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import tutorialsNinjaCommonInfo.BaseTest;
import tutorialsNinjaPages.HeaderPage;
import tutorialsNinjaPages.LoginPage;
import tutorialsNinjaPages.MyAccountPage;
import tutorialsNinjaPages.ProductPage;
import tutorialsNinjaPages.SearchPage;
import tutorialsNinjaPages.ShoppingCartPage;
import tutorialsNinjaPages.WishListPage;

public class ShoppingCartTest extends BaseTest{
	@Parameters({"defaultUser","defaultPwd"})
	@Test
	public void verifyAddProductToCartFunctionality(String Email,String Pwd) {
		boolean isUpdateBtnDisplayedExpected=true;
		HeaderPage headerPage=new HeaderPage(driver);
		LoginPage loginPage=headerPage.navigateToLoginPage();
		MyAccountPage myAccountPage=loginPage.enterLoginCredentials(Email,Pwd);
		SearchPage searchPage=myAccountPage.searchAProduct();
		searchPage.selectFirstProductAndWishList();
		WishListPage wishListPage=headerPage.navigateToWishListPage();
		wishListPage.addWishlistProductToCart();
		ShoppingCartPage shoppingCartPage=wishListPage.clickOnItemBtnAndNavigateToCartPage();
		boolean isUpdateBtnDisplayedActual=shoppingCartPage.isUpdateBtnDisplayed();
		Assert.assertEquals(isUpdateBtnDisplayedActual, isUpdateBtnDisplayedExpected);	  

	}
	@Parameters({"defaultUser","defaultPwd"})
	@Test
	public void verifyShippingAndTaxesfunctionality(String Email,String Pwd) throws InterruptedException {
		String expectedMessage="Success: Your shipping estimate has been applied!";
		HeaderPage headerPage=new HeaderPage(driver);
		LoginPage loginPage=headerPage.navigateToLoginPage();
		MyAccountPage myAccountPage=loginPage.enterLoginCredentials(Email,Pwd);
		SearchPage searchPage=myAccountPage.searchAProduct();
		ProductPage productPage=searchPage.selectAProduct();
		productPage.addProductToCart();
		ShoppingCartPage shoppingCartPage= headerPage.navigateToShoppingCartPage();
		shoppingCartPage.expandShippingAndTaxes();
		shoppingCartPage.selectShippingMethod();
		String actualMessage=shoppingCartPage.shippingMessage();
		Assert.assertTrue(actualMessage.contains(expectedMessage));
		







	}

}
