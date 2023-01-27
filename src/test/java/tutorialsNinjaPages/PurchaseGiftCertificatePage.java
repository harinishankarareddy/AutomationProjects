package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchaseGiftCertificatePage {
	WebDriver driver;
	By continueBtn=By.partialLinkText("Continue");
	public PurchaseGiftCertificatePage(WebDriver driver) {
		this.driver=driver;
	}

	public ShoppingCartPage navigateToShoppingCartPage() {
		driver.findElement(continueBtn).click();
		return new ShoppingCartPage(driver);

	}









}
