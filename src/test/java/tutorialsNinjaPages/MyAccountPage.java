package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
	WebDriver driver;
	public MyAccountPage(WebDriver driver) {
		this.driver=driver;
	}
	By editAccountLink=By.partialLinkText("Edit your account information");
	By modifyAddressLink=By.partialLinkText("Modify your address book entries");
	By searchProductField=By.name("search");
	By searchBtn=By.className("btn-default");
	By subscriptionMessage=By.xpath("//div[@id='account-account']/div[@class='alert alert-success alert-dismissible']");
	By giftCertificateLink=By.partialLinkText("Gift Certificates");
	By camerasBtn=By.partialLinkText("Cameras");
	By subscribeBtn=By.partialLinkText("Subscribe / unsubscribe to newsletter");
	public String loginSuccess() {
		String title=driver.getTitle();
		return title;
	}
	public AccountInformationPage clickOnEditAccountInfoPageLink() {
		driver.findElement(editAccountLink).click();
		return new AccountInformationPage(driver);
	}
	public AddressBookPage clickOnModifyAddressPageLink() {
		driver.findElement(modifyAddressLink).click();
		return new AddressBookPage(driver);
	}
	public SearchPage searchAProduct() {
		driver.findElement(searchProductField).sendKeys("Mac Book");
		driver.findElement(searchBtn).click();
		return new SearchPage(driver);
	}
	public NewsletterSubscriptionPage subscribeOrUnsubscribeToNewsletter() {
		driver.findElement(subscribeBtn).click();
		return new NewsletterSubscriptionPage(driver);
	}
	public String subscriptionUpdateMessage() {
		String subscriptionMsg=driver.findElement(subscriptionMessage).getText();
		return subscriptionMsg;
	}
	public String editAccountInfoMsg() {
		String editAccountText=driver.findElement(editAccountLink).getText();
		return editAccountText;
	}
	public AddGiftCertificatePage navigateToGiftCertificatePage() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)","");
		driver.findElement(giftCertificateLink).click();
		return new AddGiftCertificatePage(driver);
	}
	public CamerasPage categoryCameras() {
		driver.findElement(camerasBtn).click();
		return new CamerasPage(driver);
	}
}