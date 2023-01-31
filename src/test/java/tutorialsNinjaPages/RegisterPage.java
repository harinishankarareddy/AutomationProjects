package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import tutorialsNinjaCommonInfo.CommonUtils;

public class RegisterPage {
	WebDriver driver;
	By firstnameField=By.name("firstname");
	By lastnameField=By.name("lastname");
	By emailField=By.name("email");
	By telephoneField=By.xpath("//input[@type='tel']");
	By passwordField=By.xpath("//input[@type='password']");
	By confirmPwdField=By.name("confirm");
	By checkbox=By.cssSelector("[type='checkbox']");
	By registerBtn=By.cssSelector("[type='submit']");

	public RegisterPage(WebDriver driver) {
		this.driver=driver;
	}
	public void enterDataToRegisterAccount() {
		String firstname=CommonUtils.generateRandomString();
		String lastname=CommonUtils.generateRandomString();
		String password=CommonUtils.generateRandomString();
		String telephone=CommonUtils.generateRandomNumber();
		driver.findElement(firstnameField).sendKeys(firstname);
		driver.findElement(lastnameField).sendKeys(lastname);
		driver.findElement(emailField).sendKeys("testingsita@gmail.com");
		driver.findElement(telephoneField).sendKeys(telephone);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(confirmPwdField).sendKeys(password);
		driver.findElement(checkbox).click();
		driver.findElement(registerBtn).click();

	}
	




}
