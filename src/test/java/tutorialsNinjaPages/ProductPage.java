package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	WebDriver driver;
	By cartBtn=By.id("button-cart");
	
	public ProductPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void addProductToCart() {
		driver.findElement(cartBtn).click();
	}
	
	
	
}
