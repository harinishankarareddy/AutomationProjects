package tutorialsNinjaCommonInfo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
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
			return fileName;

	}
	public static String generateRandomString() {
		String s="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String randomString="";
		for (int i = 0; i < 10; i++) {
			int randomNum=new Random().nextInt(52);
			randomString+=s.charAt(i);
		}
		
		return randomString;
	}
	public static String generateRandomNumber() {
		String s="0123456789";
		String randomNumber="";
		for (int i = 0; i < 5; i++) {
			int randomNum=new Random().nextInt(52);
			randomNumber+=s.charAt(3);
		}
		
		return randomNumber;
	}
}
