package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListPage {
	WebDriver driver;
	public WishListPage(WebDriver driver) {
		this.driver=driver;
	}
	By getModelName=By.xpath("//div[@class='table-responsive']//td[text()='Model']");
	By clickCartBtn=By.xpath("//button[@data-original-title='Add to Cart']");
	By removeItemFromWishList=By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/a");
	By cartTotal=By.id("cart-total");
	By viewCart=By.xpath("//strong/i[@class='fa fa-shopping-cart']");
	By getWishListEmptyMsg=By.xpath("//div[@id='content']/p[text()='Your wish list is empty.']");

	public String getProductModel() {
		String getProdModel=driver.findElement(getModelName).getText();
		return getProdModel;

	}
	public WishListPage addWishlistProductToCart() {
		driver.findElement(clickCartBtn).click();
		return this;		
	}
	public WishListPage removeProductFromWishList() {
		driver.findElement(removeItemFromWishList).click();
		return this;		
	}
	public String getWishListEmptyMsg() {
		String actualResult=driver.findElement(getWishListEmptyMsg).getText();
		return actualResult;

	}
	public ShoppingCartPage clickOnItemBtnAndNavigateToCartPage() {
		driver.findElement(cartTotal).click();
		driver.findElement(viewCart).click();
		return new ShoppingCartPage(driver);

	}

}
