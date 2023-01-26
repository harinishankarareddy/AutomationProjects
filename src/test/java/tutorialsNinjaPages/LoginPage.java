package tutorialsNinjaPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tutorialsNinjaCommonInfo.CommonUtils;

public class LoginPage {
	WebDriver driver;
	By emailField=By.name("email");
	By passwordField=By.xpath("//input[@type='password']");
	By loginBtn=By.xpath("//input[@type='submit']");
	By forgotPwdLink=By.partialLinkText("Forgotten Password");
	By forgotPwdOption=By.partialLinkText("Forgotten Password");

	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	public MyAccountPage enterLoginCredentials(String email, String pwd) {
		String user=CommonUtils.readValues("user");
		String pwd1=CommonUtils.readValues("pwd");
		driver.findElement(emailField).sendKeys(user);
		driver.findElement(passwordField).sendKeys(pwd);
		
		return new MyAccountPage(driver);
		}
	public MyAccountPage clickOnLoginButton() {
		driver.findElement(loginBtn).click();
		return new MyAccountPage(driver);
	}
	public void clickOnforgotPwdLinkInLoginPage() {
		driver.findElement(forgotPwdLink).click();
	}
	public void clickOnforgotPasswordOptionFromRightMenu() {
		driver.findElement(forgotPwdOption).click();
	}



}
