package MyAutomation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class StaticDropDown {

	WebDriver driver;
	
	//public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	
	@BeforeClass
	public void testSetuo() {
	System.setProperty("webdriver.chrome.driver", "C:\\eclipse-java-x86_64\\BrowserDriver\\chromedriver.exe");
	driver = new ChromeDriver();
	
	}
	
	@BeforeMethod
	public void openBrower() {
	
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	}
	
	  @Test
	  public void DropdownTest(){
    
		WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropDown);
		
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		
		dropdown.selectByVisibleText("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		
		dropdown.selectByValue("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		
		

	}
	  
	  @AfterTest
	  public void endtest(){
		  driver.quit();  	
	  }
	 
		
	}

//}
