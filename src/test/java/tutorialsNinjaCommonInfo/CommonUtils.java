package tutorialsNinjaCommonInfo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonUtils {
	public static String readValues(String key) {
		try {
			FileReader fr=new FileReader("src//test//java//application.properties");
			Properties prop=new Properties();
			prop.load(fr);
			String browser=prop.get(key).toString();
			return browser;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
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
	public static String generateRandomString() {
		String randomString=RandomStringUtils.randomAlphabetic(8);
		/*String s="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String randomString="";
		for (int i = 0; i < 10; i++) {
			int randomNum=new Random().nextInt(52);
			randomString+=s.charAt(i);
		}*/
		
		return randomString;
	}
	public static String generateRandomNumber() {
		String randomNumber=RandomStringUtils.randomNumeric(6);
		/*String s="0123456789";
		String randomNumber="";
		for (int i = 0; i < 5; i++) {
			int randomNum=new Random().nextInt(52);
			randomNumber+=s.charAt(3);
		}*/
		
		return randomNumber;
	}
}
