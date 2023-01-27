package tutorialsNinjaTests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsDemo {
	WebDriver driver;
	@Test
	public void loginTest() throws InterruptedException, IOException {
		ExtentTest log;
		By emailField=By.name("email");
		By passwordField=By.xpath("//input[@type='password']");
		By loginBtn=By.xpath("//input[@type='submit']");
		By myAccountBtn=By.partialLinkText("My Account");
		By HeaderPageloginBtn=By.partialLinkText("Login");
		
				
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\Harini\\eclipse-workspace-sita\\tutorialsNinja\\test-output\\extenReport.html");
		extent.attachReporter(spark);
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.tutorialsninja.com/demo/");
		
		File sourceScreeshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destScreenshotPath="C:\\Users\\Harini\\eclipse-workspace-sita\\tutorialsNinja\\Screenshots\\Screenshots.png";
		FileUtils.copyFile(sourceScreeshot, new File(destScreenshotPath));

		log=extent.createTest("login Test");	
		log.info("test info");		
	
		log.info("clickOn MyAccount and clickOn Login");
		driver.findElement(myAccountBtn).click();
		driver.findElement(HeaderPageloginBtn).click();
		log.pass("Navigated to LoginPage");
	
		log.info("entering login credentials");
		driver.findElement(emailField).sendKeys("practicetestingsita@gmail.com");
		driver.findElement(passwordField).sendKeys("Hello@123");
		driver.findElement(loginBtn).click();
		log.pass("entered credentials and loggedin successfully");
		
		String actualTitle=driver.getTitle();
		String expectedTitle="My Account";
		Assert.assertEquals(actualTitle, expectedTitle);
		log.addScreenCaptureFromPath(destScreenshotPath,"HomePage Screenshot");
		
		Assert.fail("hsdhhj");
		
			
		
		extent.flush();
		driver.quit();
	}

}
