package MyAutomation;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterSuite;

public class TestNG_Annotation {
	
	// Precedence wise
	
		
	public void BeforeSuite() {
		System.out.println("this is before suite");
	}
	
	@BeforeTest
	
	public void Beforetest() {
		System.out.println("this is before Test");
	}
	
	
	@BeforeGroups
	
	public void BeforeClass() {
		System.out.println("this is before Class");
	}
	
	@BeforeTest
	
	public void BeforeMethod() {
		System.out.println("this is before method");
	}
	
	@Test
	

	 public void DropDownTest(){
		   WebDriver driver = new ChromeDriver();
		    System.setProperty("webdriver.chrome.driver", "C:\\eclipse-java-x86_64\\BrowserDriver\\chromedriver.exe");

			driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
			
			WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
			Select dropdown = new Select(staticDropDown);
			
			dropdown.selectByIndex(3);
			System.out.println(dropdown.getFirstSelectedOption().getText());
			//Thread.sleep(2000);
			
			dropdown.selectByVisibleText("INR");
			System.out.println(dropdown.getFirstSelectedOption().getText());
			//Thread.sleep(2000);
			
			dropdown.selectByValue("AED");
			System.out.println(dropdown.getFirstSelectedOption().getText());
			
			
			driver.quit();

		}
			
	
	
	
	
	
	@org.testng.annotations.AfterMethod
	
	public void AfterMethod() {
		System.out.println("this is After method");
	}

	
	@AfterClass
	
	public void AfterClass() {
		System.out.println("this is After Class");
	}
	
	
	@AfterTest
	
	public void AfterTest() {
		System.out.println("this is After Test");
	}
	@AfterSuite
	
	public void AfterSuite() {
		System.out.println("this is After Suite");
	}
	
}
