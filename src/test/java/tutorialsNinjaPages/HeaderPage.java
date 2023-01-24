package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
	WebDriver driver;
	By myAccountBtn=By.partialLinkText("My Account");
	By loginBtn=By.partialLinkText("Login");
	By registerBtn=By.partialLinkText("Register");
	By wishListBtnHeaderBar=By.className("fa-heart");
	By shoppinCartBtn=By.partialLinkText("Shopping Cart");
	
	public HeaderPage(WebDriver driver) {
	this.driver=driver;
	}
	
	public LoginPage navigateToLoginPage() {
		driver.findElement(myAccountBtn).click();
		driver.findElement(loginBtn).click();
		return new LoginPage(driver);
	}
	public RegisterPage navigateToRegisterPage() {
		driver.findElement(myAccountBtn).click();
		driver.findElement(registerBtn).click();
		return new RegisterPage(driver);
	}
	public WishListPage navigateToWishListPage() {
		driver.findElement(wishListBtnHeaderBar).click();
		return new WishListPage(driver);
	}
	public ShoppingCartPage navigateToShoppingCartPage() {
		driver.findElement(shoppinCartBtn).click();
		return new ShoppingCartPage(driver);
	}
}
