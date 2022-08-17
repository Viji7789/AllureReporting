package allureReports;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tests {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\chromedriver_win32\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void logoPresence() {
		boolean LogoStatus=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		Assert.assertEquals(LogoStatus, true);
	}
	
	@Test(priority=2)
	public void login() {
		driver.findElement(By.linkText("Log in")).click();
	}
	@Test(priority=3)
	public void register() {
		throw new SkipException("skip this test");
	}
	@AfterClass
	public void close_browser() {
		driver.quit();
	}
}
