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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport{
	WebDriver driver;

	ExtentReports extent;
	ExtentTest test;
	ExtentSparkReporter sparkReporter;
	By emailField=By.name("email");
	By passwordField=By.xpath("//input[@type='password']");
	By loginBtn=By.xpath("//input[@type='submit']");
	By myAccountBtn=By.partialLinkText("My Account");
	By HeaderPageloginBtn=By.partialLinkText("Login");
	By forgotPwdLink=By.partialLinkText("Forgotten Password");
	By emailFieldPwd=By.id("input-email");
	By resetButton=By.xpath("//input[@type='submit']");
	By confirmMessage=By.className("alert-dismissible");
	
	
	@BeforeTest
	public void setExtent() {
		extent = new ExtentReports();
		sparkReporter= new ExtentSparkReporter("C:\\Users\\Harini\\eclipse-workspace-sita\\tutorialsNinja\\test-output\\extentReports.html");
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setDocumentTitle("Automation Reports");
		sparkReporter.config().setReportName("Functional Report");
		sparkReporter.config().setTheme(Theme.STANDARD);
		extent.setSystemInfo("HostName","LocalHost");
		extent.setSystemInfo("UserName", "Harini");
		extent.setSystemInfo("OS", "Windows11");
		extent.setSystemInfo("Browser", "Edge");
	}

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.tutorialsninja.com/demo/");
	}
	
	@Test
	public void loginTest() throws InterruptedException {

		test=extent.createTest("login Test");	
		test.info("test info");		
		test.info("clickOn MyAccount and clickOn Login");
		driver.findElement(myAccountBtn).click();
		driver.findElement(HeaderPageloginBtn).click();
		test.pass("Navigated to LoginPage");
		test.info("entering login credentials");
		driver.findElement(emailField).sendKeys("practicetestingsita@gmail.com");
		driver.findElement(passwordField).sendKeys("Hello@123");
		driver.findElement(loginBtn).click();
		test.pass("entered credentials and loggedin successfully");
		String actualTitle=driver.getTitle();
		String expectedTitle="My Account";
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.fail("jadhjd");
		
	}

	@Test
	public void forgotPassword() throws InterruptedException {
		test=extent.createTest("Forgot Password Test");
		test.info("clickOn MyAccount and clickOn Login");
		driver.findElement(myAccountBtn).click();
		driver.findElement(HeaderPageloginBtn).click();
		test.pass("Navigated to LoginPage");
		test.info("Click on ForgotPwd Link");
		driver.findElement(forgotPwdLink).click();
		test.pass("Navigated to ForgotPwdPage");
		test.info("Enter Email to ResetPwd And Click Continue Button");
		driver.findElement(emailFieldPwd).sendKeys("practicetestingsita@gmail.com");
		driver.findElement(resetButton).click();
		test.pass("Password reset initiated");
		String expectedTitle="Account Login";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if(result.getStatus()==2) {
			test.log(Status.FAIL,"test is failed"+result.getName());//to add naem in extent report
			test.log(Status.FAIL,"test is failed"+result.getThrowable());//to add error/exception
			String screenShotPath=ExtentReport.takeScreenshot(driver, result.getName());
			
			test.addScreenCaptureFromPath(screenShotPath);// adding screenshot
			///to add screenshot in extent report
		} else if(result.getStatus()==1) {
			test.log(Status.PASS,"test is passed"+result.getName());
		}else if(result.getStatus()==3) {
			test.log(Status.SKIP,"test is skipped"+result.getName());
		}
		driver.quit();
	}
	@AfterTest
	public void endReport() {
		extent.flush();

	}
	public static String takeScreenshot(WebDriver driver, String screenShotName) throws IOException{
		String dateName=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		TakesScreenshot takescreenshot=(TakesScreenshot)driver;
		File source=takescreenshot.getScreenshotAs(OutputType.FILE);	
		String destination="C:\\Users\\Harini\\eclipse-workspace-sita\\tutorialsNinja\\Screenshots\\"+screenShotName+dateName+".png";
		//copy the screenshot to a  desired loacation using copyfile method.
		FileUtils.copyFile(source, new File(destination));		
		return destination;
	}
}






