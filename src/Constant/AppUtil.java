package Constant;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class AppUtil {
public static WebDriver driver;
public static Properties config;
@BeforeSuite
public void setup() throws Throwable
{
	config = new Properties();
	config.load(new FileInputStream("D:\\selenium.8oclockBatch\\Hybrid_Frameworkbatch\\PropertyFiles\\primus.properties"));
	if(config.getProperty("Browser").equalsIgnoreCase("chrome"))
	{
		System.setProperty("webriver.chrome.driver","D:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(config.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	else if(config.getProperty("Browser").equalsIgnoreCase("fireFox"))
	{
		System.setProperty("webdriver.gecko.driver","d:/chromedriver.exe");
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.get(config.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	else
	{
		System.out.println("Browser value is Not Matching");
	}
}
@AfterSuite
public void tearDown()
{
	driver.quit();
}

	}

	
	


