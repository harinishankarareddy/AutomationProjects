package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddressBookPage {
	WebDriver driver;
	public AddressBookPage(WebDriver driver) {
		this.driver=driver;
	}
	By firstnameField=By.name("firstname");
	By lastnameField=By.name("lastname");
	
	By newAddressBtn=By.partialLinkText("New Address");
	By address_1Field=By.name("address_1");
	By cityField=By.name("city");
	By postcodeField=By.name("postcode");
	By countryIdField=By.name("country_id");
	By zoneIdField=By.name("zone_id");
	By defaultAddressRadioBtn=By.cssSelector("input[value='1']");
	By submitBtn=By.xpath("//input[@type='submit']");
	By addressAddedMsg=By.xpath("//div[@id='account-address']/div");
	By editAddressBtn=By.partialLinkText("Edit");
	By delNonDefaultAddressBtn=By.partialLinkText("Delete");
	By addressAddedEntry=By.xpath("//div[@id='content']/div//td");
	By clickOnAccount=By.partialLinkText("Account");
	
	public void addNewAddressAndSubmit(String firstname,String lastname,String address1,String city,String postCode,String country,String state) 
	{
		driver.findElement(newAddressBtn).click();
		driver.findElement(firstnameField).sendKeys(firstname);
		driver.findElement(lastnameField).sendKeys(lastname);
		driver.findElement(address_1Field).sendKeys(address1);
		driver.findElement(cityField).sendKeys(city);
		driver.findElement(postcodeField).sendKeys(postCode);
		new Select(driver.findElement(countryIdField)).selectByVisibleText("Sweden");
		new Select(driver.findElement(zoneIdField)).selectByVisibleText("Stockholm");
		driver.findElement(defaultAddressRadioBtn).click();
		driver.findElement(submitBtn).click();
	}
	
	public String getAddressAddedMessage() {
		String confirmMessage=driver.findElement(addressAddedMsg).getText();
		return confirmMessage;

	}
	public String getAddressAddedEntries() {
		String actualAddressText=driver.findElement(addressAddedEntry).getText();
		return actualAddressText;

	}
	public void editExistingAddress() {
		driver.findElement(editAddressBtn).click();

	}
	public void deleteExistingNonDefaultAddress() {
		driver.findElement(delNonDefaultAddressBtn).click();
	}
	
}
