 package tutorialsNinjaTests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport{
	WebDriver driver;
	ExtentReports extent;
	ExtentTest log;

	By emailField=By.name("email");
	By passwordField=By.xpath("//input[@type='password']");
	By loginBtn=By.xpath("//input[@type='submit']");
	By myAccountBtn=By.partialLinkText("My Account");
	By HeaderPageloginBtn=By.partialLinkText("Login");
	
	@BeforeTest
	public void setExtent() {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\Harini\\eclipse-workspace-sita\\tutorialsNinja\\test-output\\extenReport.html");
		extent.attachReporter(spark);

	}
	
	@AfterTest
	public void endReport() {
		extent.flush();
		
	}
	
	
	
	
	
	
	
	
	
	@Test
	public void loginTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.tutorialsninja.com/demo/");
		
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
		String expectedTitle="MyAccount";
		Assert.assertEquals(actualTitle, expectedTitle);
		
		driver.quit(); 

	}
		
	
	@AfterMethod
	public void at(ITestResult result) throws IOException {

		if(result.getStatus()==2) {
			log.fail(result.getName()+"test is failed");//to add naem in extent report
			log.fail(result.getThrowable()+"test is failed");//to add error/exception
			String filePath=ExtentReport.takeScreenshot(driver,result.getName());
			
			File file=new File(filePath);
			log.fail(MediaEntityBuilder.createScreenCaptureFromPath(file.getAbsolutePath()).build());///to add screenshot in extent report
		} else if(result.getStatus()==1) {
			log.pass("test is passed");
		}else if(result.getStatus()==3) {
			log.skip("test is skipped");
		}
		extent.flush();
		driver.quit();
	}
	public static String takeScreenshot(WebDriver driver, String fileName) throws IOException{

		//take screenshot and store it as a file format
		TakesScreenshot takescreenshot=(TakesScreenshot)driver;
		File source=takescreenshot.getScreenshotAs(OutputType.FILE);
		
	
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
			Date date=new Date();
			String timestamp=sdf.format(date);
			String destination="C:\\Users\\Harini\\eclipse-workspace-sita\\tutorialsNinja\\Screenshots\\"+fileName+timestamp+".png";
			//copy the screenshot to a  desired loacation using copyfile method.
			FileUtils.copyFile(source, new File(destination));		
			return destination;

	}
}






