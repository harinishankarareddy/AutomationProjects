package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
	public void enterDataToRegisterAccountAndClickOnSubmit(String firstname,String lastname,String email,String telephone,String password,String confirmPwd) {
		driver.findElement(firstnameField).sendKeys(firstname);
		driver.findElement(lastnameField).sendKeys(lastname);
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(telephoneField).sendKeys(telephone);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(confirmPwdField).sendKeys(confirmPwd);
		driver.findElement(checkbox).click();
		driver.findElement(registerBtn).click();

	}




}
