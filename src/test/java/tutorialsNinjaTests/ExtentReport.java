package tutorialsNinjaTests;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import tutorialsNinjaCommonInfo.CommonUtils;

public class ExtentReport {
	WebDriver driver;
	ExtentReports extent;
	ExtentTest log;

	By emailField=By.name("email");
	By passwordField=By.xpath("//input[@type='password']");
	By loginBtn=By.xpath("//input[@type='submit']");
	By myAccountBtn=By.partialLinkText("My Account");
	By HeaderPageloginBtn=By.partialLinkText("Login");
	@Test
	public void loginTest() throws InterruptedException {

		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\Harini\\eclipse-workspace-sita\\tutorialsNinja\\test-output\\extenReport.html");
		//File file=new File("extentReport.html");
		//ExtentSparkReporter spark=new ExtentSparkReporter(file);

		extent.attachReporter(spark);

		log=extent.createTest("login Test");	
		log.info("test info");

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		log.info("opening the url");
		driver.get("http://www.tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		log.pass("Url is launched successfully");
	
		log.info("clickOn MyAccount and clickOn Login");
		driver.findElement(myAccountBtn).click();
		driver.findElement(HeaderPageloginBtn).click();
		log.pass("Navigated to LoginPage");
	
		log.info("entering login credentials");
		driver.findElement(emailField).sendKeys("practicetestingsita@gmail.com");
		driver.findElement(passwordField).sendKeys("Hello@123");
		driver.findElement(loginBtn).click();
		log.pass("entered credentials and loggedin successfully");

		
		Assert.fail("hsgdhagd");
		extent.flush();
		driver.quit();

		  

	}
	@AfterMethod
	public void at(ITestResult result) {

		if(result.getStatus()==2) {
			log.fail(result.getName()+"test is failed");
			String filePath=CommonUtils.takeScreenshot(driver,result.getName());
			File file=new File(filePath);
			log.fail(MediaEntityBuilder.createScreenCaptureFromPath(file.getAbsolutePath()).build());
		} else if(result.getStatus()==1)
			log.pass("test is passed");
		extent.flush();
		driver.quit();
	}
}






