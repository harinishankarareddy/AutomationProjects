package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchaseGiftCertificatePage {
WebDriver driver;
public PurchaseGiftCertificatePage(WebDriver driver) {
	this.driver=driver;
}

public ShoppingCartPage navigateToShoppingCartPage() {
	driver.findElement(By.partialLinkText("Continue")).click();
	return new ShoppingCartPage(driver);
	
}









}
