package tutorialsNinjaPages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage {

	WebDriver driver;
	public ShoppingCartPage(WebDriver driver1) {
		this.driver=driver1;

	}
	By updateBtnPresent=By.xpath("//button[@data-original-title='Update']");
	By updateBtnDisplay=By.xpath("//button[@data-original-title='Update']");
	By shippingBtn=By.xpath("//div[@id='accordion']/div[2]/div/h4/a");
	By countryId=By.name("country_id");
	By zoneId=By.name("zone_id");
	By postCode=By.name("postcode");
	By getQuoteBtn=By.id("button-quote");
	By flatRateBtn=By.name("shipping_method");
	By applyShippingBtn=By.xpath("//input[@id='button-shipping']");
	By giftRemoveBtnPresence=By.xpath("//div[@id='content']/form/div/table/tbody/tr[2]/td[4]/div/span/button");
	By giftRemoveBtnDisplay=By.xpath("//div[@id='content']/form/div/table/tbody/tr[2]/td[4]/div/span/button");

	public boolean isUpdateBtnDisplayed() {
		int sizeOfList=driver.findElements(updateBtnPresent).size();
		if(sizeOfList!=0) {
			boolean actualResult=driver.findElement(updateBtnDisplay).isDisplayed();
			return actualResult;
		}
		return false;
	}

	public void expandShippingAndTaxes() {
		driver.findElement(shippingBtn).click();
		new Select(driver.findElement(countryId)).selectByVisibleText("Sweden");
		new Select(driver.findElement(zoneId)).selectByVisibleText("Stockholm");
		driver.findElement(postCode).sendKeys("15146");
		driver.findElement(getQuoteBtn).click();
	}
	public void selectShippingMethod() {

		driver.findElement(flatRateBtn).click();
		driver.findElement(applyShippingBtn).click();
	}
	public String shippingMessage() {
		String shippingSuccessMsg=driver.findElement(By.className("alert-dismissible")).getText();
		return shippingSuccessMsg;
	}
public boolean isGiftremoveBtnDisplayed() {
	int sizeOfList1=driver.findElements(giftRemoveBtnPresence).size();
	if(sizeOfList1!=0) {
		boolean actualResult=driver.findElement(giftRemoveBtnDisplay).isDisplayed();
		return actualResult;
	}
	return false;
}

}
