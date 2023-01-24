package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
	WebDriver driver;
	public SearchPage(WebDriver driver) {
		this.driver=driver;
	}
	By firstProduct=By.partialLinkText("MacBook");
	By wishListBtn=By.xpath("//button[@data-original-title='Add to Wish List']");
	By WishListMsg=By.className("alert-dismissible");
	By productImg=By.partialLinkText("MacBook Air");

	public void selectFirstProductAndWishList() {
		driver.findElement(firstProduct).click();
		driver.findElement(wishListBtn).click();
	}
	public String getWishListSuccessMsg() {
		String wishListMsg=driver.findElement(WishListMsg).getText();
		return wishListMsg;
	}
	public ProductPage selectAProduct() {
		driver.findElement(productImg).click();
		return new ProductPage(driver);
	}
}
