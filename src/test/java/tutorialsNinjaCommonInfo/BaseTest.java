package tutorialsNinjaCommonInfo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import tutorialsNinjaTests.ExtentReport;

public class BaseTest {
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentSparkReporter sparkReporter;
	
	@BeforeSuite
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
		
	}
	@Parameters("url")
	@BeforeMethod(alwaysRun = true)
	public void LaunchBrowserAndOpenUrl(String baseurl ) {
	
		//driver=null;
		String browser=CommonUtils.readValues("browser");
		if (browser.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else {
			WebDriverManager.safaridriver().setup();
			driver=new SafariDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseurl);
		
		
	}
	@AfterMethod
	public void QuitBrowser(ITestResult result) throws IOException {
	
		if(result.getStatus()==2) {
			test.log(Status.FAIL,"test is failed"+result.getName());//to add naem in extent report
			test.log(Status.FAIL,"test is failed"+result.getThrowable());//to add error/exception
			String screenShotPath=ExtentReport.takeScreenshot(driver, result.getName());
			
			test.addScreenCaptureFromPath(screenShotPath);// adding screenshot
			///to add screenshot in extent report
		} 
		driver.quit();
	}
	@AfterSuite
	public void endReport() {
		extent.flush();

	}
	
	
}
