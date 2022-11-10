package com.MyStore.testCases;

import org.apache.logging.log4j.Logger;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.MyStore.utility.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	 ReadConfig  readConfig = new ReadConfig();
     
	    String url = readConfig.getBaseUrl();
	    String browser=readConfig.getBrowser();
	    public String emailAddress = readConfig.getEmail();
	    String password = readConfig.getPassword();
	    
	    public static WebDriver driver;
	    
	    public static Logger logger;
	    
	    @BeforeClass
	    public void setup() {
	    	
	    	switch(browser.toLowerCase())
	    	{
	    	case "chrome":
	    		WebDriverManager.chromedriver().setup();
	    		driver=new ChromeDriver();
	    		break;
	    	case "firefox":
	    		WebDriverManager.firefoxdriver().setup();
	    		driver=new FirefoxDriver();
	    		break;
	    	default:
	    		driver=null;
	    		break;

	    	}
	    	
	    	//implicity...... wait of 10 secs
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    	
	    	//for logging
	    	logger = LogManager.getLogger("MyStoreV1");
	    	
	    	driver.get(url);
			logger.info("url oppened");
	    	
	    }
	    
	    @AfterClass
	    public void tearDown()
	    {
	    	driver.close();
	    	driver.quit();
	    }
	    
	    public void captureScreenShot(WebDriver driver, String testName)
	    {
	    	TakesScreenshot screenshot = (TakesScreenshot) driver;
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			File dst = new File(System.getProperty("user.dir")+"\\Screenshot\\"+testName+".png");
			try {
				FileUtils.copyFile(src, dst);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
	    }


	
}
