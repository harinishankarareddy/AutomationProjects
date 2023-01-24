package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class WishListPage {
	WebDriver driver;
	public WishListPage(WebDriver driver) {
		this.driver=driver;
	}
	By isCartBtnPresent=By.xpath("//button[@data-original-title='Add to Cart']");
	By isCartBtnVisible=By.xpath("//button[@data-original-title='Add to Cart']");
	By clickCartBtn=By.xpath("//button[@data-original-title='Add to Cart']");
	By removeItemFromWishList=By.cssSelector("a[data-original-title='Remove']");
	By cartTotal=By.id("cart-total");
	By viewCart=By.xpath("//strong/i[@class='fa fa-shopping-cart']");
	By getWishListEmptyMsg=By.xpath("//div[@id='content']/p[text()='Your wish list is empty.']");
	By wishListBtnSize=By.id("wishlist-total");
	
	
	public boolean isCartBtnDisplayed() {
		int sizeOfList=driver.findElements(isCartBtnPresent).size();
		if(sizeOfList!=0) {
			boolean actualResult=driver.findElement(isCartBtnVisible).isDisplayed();
			return actualResult;
		}
		return false;
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
	public Dimension getSizeOfWishList() {
		Dimension sizeOfWishList=driver.findElement(wishListBtnSize).getSize();
		return sizeOfWishList;
			
	}
	public String productRemovedFromWishlistMsg() {
		String productRemoveMsg=driver.findElement(By.xpath("//div[@id='account-wishlist']/div[1]/i")).getText();
		return productRemoveMsg;
	}
	
	
	
}
