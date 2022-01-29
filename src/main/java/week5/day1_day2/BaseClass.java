package week5.day1_day2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	public ChromeDriver driver;
	public String filename;
	
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void login(String url, String uname, String pwd) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get(url);
				driver.manage().window().maximize();
				driver.findElement(By.id("username")).sendKeys(uname);
				driver.findElement(By.id("password")).sendKeys(pwd);
				driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	@AfterMethod
	public void closeBrowser() {
				driver.close();
	}
	
	@DataProvider(name="getExcelData")
	public String[][] getExcelData() throws IOException {		
		return ReadExcel.readExcel(filename);
	}

}
