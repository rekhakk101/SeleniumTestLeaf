package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_FBCreateAccount {
	
	public static void main(String[] args) {

		// Step 1: Download and set the path 
		WebDriverManager.chromedriver().setup();
		
		// Step 2: Launch the chromebrowser
		ChromeDriver driver = new ChromeDriver();
		
		// Step 3: Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		
		// Step 4: Maximise the window
		driver.manage().window().maximize();
		
		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// Step 6: Click on Create New Account button
		driver.findElement(By.linkText("Create New Account")).click();
		
		// Step 7: Enter the first name
		driver.findElement(By.xpath("//form[@id='reg']/div//input[@name='firstname']")).sendKeys("Sowparnika");
		
		// Step 8: Enter the last name
		driver.findElement(By.xpath("//form[@id='reg']/div//input[@name='lastname']")).sendKeys("Rameshwar");
		
		// Step 9: Enter the mobile number
		driver.findElement(By.xpath("//form[@id='reg']/div//input[@name='reg_email__']")).sendKeys("8886667774");
		
		// Step 10: Enter the password
		driver.findElement(By.xpath("//form[@id='reg']/div//input[@name='reg_passwd__']")).sendKeys("Sowparnika@123");
		
		// Step 11: Handle all the three drop downs
		WebElement day = driver.findElement(By.xpath("//div[@id='birthday_wrapper']//select[@id='day']"));
		Select d = new Select(day);
		d.selectByValue("4");
		
		WebElement month = driver.findElement(By.xpath("//div[@id='birthday_wrapper']//select[@id='month']"));
		Select m = new Select(month);
		m.selectByVisibleText("May");
		
		WebElement year = driver.findElement(By.xpath("//div[@id='birthday_wrapper']//select[@id='year']"));
		Select y = new Select(year);
		y.selectByVisibleText("2004");
		
		// Step 12: Select the radio button "Female"( A normal click will do for this step) 
		driver.findElement(By.xpath("//span[@data-type='radio']//label[text()='Female']/following-sibling::input[@name='sex']")).click();

	}

}
