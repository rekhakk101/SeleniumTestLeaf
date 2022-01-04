package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Classroom1_CreateContact {

	public static void main(String[] args) {

		//Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Load the URL
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//Enter UserName
		driver.findElement(By.id("username")).sendKeys("DemoSalesmanager");
		
		//Enter Password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click Contacts Tab
		driver.findElement(By.linkText("Contacts")).click();
		
		//Click Create Contact
		driver.findElement(By.linkText("Create Contact")).click();
		
		//Type First Name
		driver.findElement(By.id("firstNameField")).sendKeys("Malavika");
		
		//Type Last Name
		driver.findElement(By.id("lastNameField")).sendKeys("Prakash");
		
		//Click Create Contact Button
		driver.findElement(By.name("submitButton")).click();
		
		//Print the first name and browser title 
		WebElement firstName = driver.findElement(By.id("viewContact_firstName_sp"));
		System.out.println("First name entered is: "+firstName.getText());
		System.out.println("Page title is: "+driver.getTitle());
		
		//Close the browser
		driver.close();
		

	}

}
