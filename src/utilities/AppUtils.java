package utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtils {
	public static WebDriver driver;
    public static Properties config;
    @BeforeTest
    public void setup() throws Throwable
    {
    	config =new Properties();
    	config.load(new FileInputStream("D\\selenium.8oclockBatch\\DDT_FrameWork\\PropertyFiles\\Login.properties"));
    	if(config.getProperty("Browser").equalsIgnoreCase("chrome"))
    	{
    		driver = new ChromeDriver();
    	}
    	else if(config.getProperty("Browser").equalsIgnoreCase("firefox"))
    	{
    		driver =new FirefoxDriver();
    	}
    	else
    	{
    		System.out.println("Browser value is Not Matching");
    	}
    }
    @AfterTest
    public void tearDown()
    {
    	driver.close();
    	}
    }
	
	
	

