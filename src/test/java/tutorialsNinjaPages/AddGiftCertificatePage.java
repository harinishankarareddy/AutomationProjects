package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddGiftCertificatePage {
	WebDriver driver;
	public AddGiftCertificatePage(WebDriver driver){
		this.driver=driver;
	}
	By recipientName=By.name("to_name");
	By recipientEmail=By.name("to_email");
	By giftTheme=By.cssSelector("input[value='7']");
	By giftMsg=By.xpath("//textarea[@id='input-message']");
	By amoutClear=By.name("amount");
	By amountNew=By.name("amount");
	By nonRefundableCheck=By.name("agree");
	By continueBtn=By.xpath("//input[@type='submit']");
	By warningMsgrefundable=By.xpath("//div[@id='account-voucher']/div");

	public void purchaseGiftCertificate() {
		driver.findElement(recipientName).sendKeys("Blippi");
		driver.findElement(recipientEmail).sendKeys("blippi@gmail.com");
		driver.findElement(giftTheme).click();
		driver.findElement(giftMsg).sendKeys("Happy Birthday");
		driver.findElement(amoutClear).clear();
		driver.findElement(amountNew).sendKeys("10");	

	}
	public PurchaseGiftCertificatePage nonRefundableOptionCheck() {
		driver.findElement(nonRefundableCheck).click();
		driver.findElement(continueBtn).click();
		return new PurchaseGiftCertificatePage(driver);
	}
	public AddGiftCertificatePage nonRefundableOptionUnCheck() {

		driver.findElement(continueBtn).click();
		return new AddGiftCertificatePage(driver);
	}


	public String warningMessageNonrefundable() {
		String warningMessage=driver.findElement(warningMsgrefundable).getText();
		return warningMessage;
	}














}
