package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
	WebDriver driver;
	
	By emailField=By.id("input-email");
	By resetButton=By.xpath("//input[@type='submit']");
	By confirmMessage=By.className("alert-dismissible");
	
	public ForgotPasswordPage(WebDriver driver) {
		this.driver=driver;
	}
	public void enterEmailtoResetPwdAndClickContinueButton(String email) {
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(resetButton).click();
	}

	public String getConfirmationMessage() {
		String ConfirmMessage=driver.findElement(confirmMessage).getText();
		System.out.println(ConfirmMessage);
		return ConfirmMessage;
	}




}


