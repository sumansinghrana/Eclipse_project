package MyAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;



public class TC1_GIM_Login {
	
	public static WebDriver driver;
	
	@Test
	@Parameters({"Browser","url","phone_number","password"})
	public void TC1_Login(String Browser,String url,String phone_number,String password) {
	
	if(Browser.equals("Chrome")) {
		
	System.setProperty("webdriver.chrome.driver", "C:\\eclipse-java-x86_64\\BrowserDriver\\chromedriver.exe");
	driver = new ChromeDriver();
	} 
	
	driver.manage().window().maximize();
    driver.get(url);
    driver.findElement(By.id("phone")).sendKeys("phone_number");
    driver.findElement(By.id("password")).sendKeys("password");
    driver.findElement(By.className("btn-danger")).click();
	
	}

}
