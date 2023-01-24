package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewsletterSubscriptionPage {
	WebDriver driver;
	public NewsletterSubscriptionPage(WebDriver driver) {
		this.driver=driver;
	}
	By yesBtn=By.cssSelector("input[value='1']");
	By continueBtn=By.cssSelector("input[type='submit']");
	By noBtn=By.cssSelector("input[value='0']");
	
	public MyAccountPage SubscribeYes() {
		driver.findElement(yesBtn).click();
		driver.findElement(continueBtn).click();
		return new MyAccountPage(driver);
	}
	
	public MyAccountPage SubscribeNo() {
		driver.findElement(noBtn).click();
		driver.findElement(continueBtn).click();
		return new MyAccountPage(driver);
	}
	
	
	
}
