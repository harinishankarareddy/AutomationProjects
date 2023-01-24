package tutorialsNinjaPages;

import org.openqa.selenium.By;
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
		driver.findElement(By.partialLinkText("Subscribe / unsubscribe to newsletter")).click();
		return new NewsletterSubscriptionPage(driver);
	}
	public String subscriptionUpdateMessage() {
		String subscriptionMsg=driver.findElement(subscriptionMessage).getText();
		return subscriptionMsg;
		
	}
}