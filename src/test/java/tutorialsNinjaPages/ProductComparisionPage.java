package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductComparisionPage {
	WebDriver driver;
	By firstProd=By.xpath("//div[@id='content']/table/tbody[1]/tr[1]/td[2]/a/strong[text()='Canon EOS 5D'] ");
	By secondProd=By.xpath("//div[@id='content']/table/tbody[1]/tr[1]/td[3]/a/strong[text()='Nikon D300']");
	By firstProdNum=By.xpath("//div[@id='content']/table/tbody[1]/tr[4]/td[2]");
	By secondProdNum=By.xpath("//div[@id='content']/table/tbody[1]/tr[4]/td[3]");
	
	public ProductComparisionPage(WebDriver driver) {
		this.driver=driver;
	}
	public String getFirstProductName() {
		String getfirstProdName=driver.findElement(firstProd).getText();
		return getfirstProdName;
	}
	public String getSecondProductName() {
		String getsecondProdName=driver.findElement(secondProd).getText();
		return getsecondProdName;
	}
	public String getFirstProductNumber() {
		String firstProdNumber=driver.findElement(firstProdNum).getText();
		return firstProdNumber;
	}
	public String getSecondProductNumber() {
		String secondProdNumber=driver.findElement(secondProdNum).getText();
		return secondProdNumber;
	}
	
	
	
}
