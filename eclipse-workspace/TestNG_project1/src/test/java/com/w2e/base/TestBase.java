package com.w2e.base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.w2e.utilities.ExcelReader;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestBase {
	
	/*  below are will be initialized 
	 * 	WebDriver
	 * properties 
	 * logs -  log4j jar file
	 * extent report 
	 * DB
	 * excel
	 * mail
	 */
	
	public static WebDriver driver;
	
	public static Properties config  = new Properties();
	public static Properties OR  = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testdata.xlsx");
	
	public static WebDriverWait wait;
	
	
	
	
	
	
	@BeforeSuite
	public void setup() throws InterruptedException {
		
	
		
 		if(driver==null) {
			 try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				config.load(fis);
				
				log.debug("Config file loaded!!!");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded!!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 if(config.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			//System.out.println(System.getProperty("user.dir"));
				//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
			
			log.debug("Chrome launched !!");
			
			//System.setProperty("webdriver.chrome.driver", "C:\\eclipse-java-x86_64\\BrowserDriver\\chromedriver.exe");
		    //driver = new ChromeDriver();
					
				
					
			}
			 else if(config.getProperty("browser").equals("firefox")) {
					System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
					driver = new FirefoxDriver();
					System.out.println("firefox"+System.getProperty("user.dir")) ;
					
				}
				
				else if(config.getProperty("browser").equals("ie")) {
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe.exe");
				driver = new InternetExplorerDriver();
			}  
			
			driver.get(config.getProperty("testsiteurl"));
			log.debug("navigated to : " + config.getProperty("testsiteurl"));
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait( Integer.parseInt(config.getProperty("implicit.wait")),TimeUnit.SECONDS);
			wait = new WebDriverWait(driver,5);
		} 
		
	}	
	
	public boolean isElementPresent(By by) {
		
		try {
			
			driver.findElement(by);
			return true;
			
		}catch(NoSuchElementException e) {
			
			return false;
			
		}
		
	}
	
	
	@AfterSuite
	public void tearDown() {
		
		
		
		if(driver!=null) {
		driver.quit();
		}
		log.debug("test execution completed !!!!");
		
	}

	
	
}
