package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class baseClass {
	public static WebDriver driver;
	public Properties prop;
	public WebDriver intializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/faysal/eclipse-workspace/End2EndFramework/src/main/java/resources/data.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/faysal/Downloads/chromedriver");
			driver= new ChromeDriver();
		}
	else if(browserName.equals("firefox")) {
		//driver = new FirefoxDriver();
	}
	else if(browserName.equals("IE")) {
		
	}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/Users/faysal/Desktop/TestFiles/"+result+"ErrorScreenshot.png"));
		
	}

}
