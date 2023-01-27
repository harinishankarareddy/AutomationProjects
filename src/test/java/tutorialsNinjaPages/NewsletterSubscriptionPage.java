package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import tutorialsNinjaCommonInfo.CommonUtils;

public class NewsletterSubscriptionPage {
	WebDriver driver;
	By yesBtn=By.cssSelector("input[value='1']");
	By continueBtn=By.cssSelector("input[type='submit']");
	By noBtn=By.cssSelector("input[value='0']");
	
	public NewsletterSubscriptionPage(WebDriver driver) {
		this.driver=driver;
	}
		
	public MyAccountPage SubscribeYesOrNo(String subscriptionType) {
		CommonUtils.readValues(subscriptionType);
		if(subscriptionType.equalsIgnoreCase("yes")) {
		driver.findElement(yesBtn).click();
		driver.findElement(continueBtn).click();
		return new MyAccountPage(driver);
		}
		else
		{
			driver.findElement(noBtn).click();
			driver.findElement(continueBtn).click();
			return new MyAccountPage(driver);
		}
		}
	}
	
	
	
	
	

