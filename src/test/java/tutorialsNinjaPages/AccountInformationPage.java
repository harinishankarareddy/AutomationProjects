package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountInformationPage {
	WebDriver driver;
	
	
	By firstnameField=By.name("firstname");
	By lastnameField=By.name("lastname");
	By telephoneField=By.name("telephone");
	By submitBtn=By.xpath("//input[@type='submit']");
	By editAccConfirmMsg=By.className("alert-dismissible");
	By modifyAddressLink=By.partialLinkText("Modify your address book entries");
	By newAddressBtn=By.partialLinkText("New Address");
	By address_1Field=By.name("address_1");
	By cityField=By.name("city");
	By postcodeField=By.name("postcode");
	By countryIdField=By.name("country_id");
	By zoneIdField=By.name("zone_id");
	By defaultAddressRadioBtn=By.cssSelector("input[value='1']");
	By addressAddedMsg=By.xpath("//div[@id='account-address']/div");
	By editAddressBtn=By.partialLinkText("Edit");
	By delNonDefaultAddressBtn=By.partialLinkText("Delete");
	By addressAddedEntry=By.xpath("//div[@id='content']/div//td");
	
	public AccountInformationPage(WebDriver driver1) {
		this.driver=driver1;
	}
	public void editAccountInfoAndSubmit(String firstname,String lastname,String telephone) {
		
		driver.findElement(firstnameField).clear();
		driver.findElement(firstnameField).sendKeys(firstname);
		driver.findElement(lastnameField).clear();
		driver.findElement(lastnameField).sendKeys(lastname);
		driver.findElement(telephoneField).clear();
		driver.findElement(telephoneField).sendKeys(telephone);
		driver.findElement(submitBtn).click();
	}
	public String getAccountUpdatedMessage() {
		String ConfirmMessage=driver.findElement(editAccConfirmMsg).getText();		
		return ConfirmMessage;
	}
	
	













}
