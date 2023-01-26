package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import tutorialsNinjaCommonInfo.CommonUtils;

public class AddGiftCertificatePage {
	WebDriver driver;
	public AddGiftCertificatePage(WebDriver driver){
		this.driver=driver;
	}

	public void purchaseGiftCertificate() {
		driver.findElement(By.name("to_name")).sendKeys("Blippi");
		driver.findElement(By.name("to_email")).sendKeys("blippi@gmail.com");
		driver.findElement(By.cssSelector("input[value='7']")).click();
		driver.findElement(By.xpath("//textarea[@id='input-message']")).sendKeys("Happy Birthday");
		driver.findElement(By.name("amount")).clear();
		driver.findElement(By.name("amount")).sendKeys("10");	

	}
	public PurchaseGiftCertificatePage nonRefundableOptionCheck() {
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		return new PurchaseGiftCertificatePage(driver);
	}
	public AddGiftCertificatePage nonRefundableOptionUnCheck() {

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		return new AddGiftCertificatePage(driver);
	}


	public String warningMessageNonrefundable() {
		String warningMessage=driver.findElement(By.xpath("//div[@id='account-voucher']/div")).getText();
		return warningMessage;
	}














}
