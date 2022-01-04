package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_EditFields {

	public static void main(String[] args) {
		
		//Launch browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		
		//Enter your email address
		driver.findElement(By.id("email")).sendKeys("rekhakk101@gmail.com");
		
		//Append a text and press keyboard tab
		WebElement text2 = driver.findElement(By.xpath("//label[text()='Append a text and press keyboard tab']/following-sibling::input"));
		text2.sendKeys("Rekha",Keys.TAB);
		
		//Get default text entered
		String attribute = driver.findElement(By.name("username")).getAttribute("value");
		System.out.println(attribute);
		
		//Clear the text
		WebElement text4 = driver.findElement(By.xpath("//label[text()='Clear the text']/following-sibling::input"));
		text4.clear();
		
		//Confirm that edit field is disabled
		WebElement text5 = driver.findElement(By.xpath("//label[text()='Confirm that edit field is disabled']/following-sibling::input"));
		if(text5.isEnabled()) {
			System.out.println("Text field is enabled");
		}else {
			System.out.println("Text field is disabled");
		}
		
		//Close the browser
		driver.close();

	}

}
