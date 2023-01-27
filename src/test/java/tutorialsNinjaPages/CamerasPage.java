package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CamerasPage {
	WebDriver driver;
	public CamerasPage(WebDriver driver) {
		this.driver=driver;
	}
	By firstProdCompare=By.xpath("//div[@id='content']/div[2]/div[1]/div/div[2]/div[2]/button[3]/i");
	By secondProdCompare=By.xpath("//div[@id='content']/div[2]/div[2]/div/div[2]/div[2]/button[3]/i");
	By productCompare=By.id("compare-total");
	
	public void selectProductAndCompare() {
		driver.findElement(firstProdCompare).click();
		driver.findElement(secondProdCompare).click();
	}
	public ProductComparisionPage productCompareLink() {
		driver.findElement(productCompare).click();
		return new ProductComparisionPage(driver);
	}
	


}
