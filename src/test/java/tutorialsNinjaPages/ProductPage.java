package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	WebDriver driver;
	public ProductPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void addProductToCart() {
		driver.findElement(By.id("button-cart")).click();
	}
	
	
	
}
