package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Classroom2_FindContacts {

	public static void main(String[] args) {
		
		//		Open the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//		Load the URL
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//		Maximize the browser
		driver.manage().window().maximize();
		
		//		Enter UserName
		driver.findElement(By.id("username")).sendKeys("DemoSalesmanager");
		
		//		Enter Password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//		Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//		Click CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//		Click Contacts Tab
		driver.findElement(By.linkText("Contacts")).click();
		
		//		Click Find Contacts
		driver.findElement(By.linkText("Find Contacts")).click();
		
		//		Click Email Tab
		driver.findElement(By.xpath("//span[@class='x-tab-strip-text ' and text()='Email']")).click();
		
		//		Type email as babu@testleaf.com
		driver.findElement(By.name("emailAddress")).sendKeys("babu@testleaf.com");
		
		//		Click Find Contacts
		driver.findElement(By.xpath("//button[@type='button' and text()='Find Contacts']")).click();
		
		//		Close the browser
		driver.close();

	}

}
