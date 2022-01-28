package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_MergeContact {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

//		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
//		 * 
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

//		 * 2. Enter UserName and Password Using Id Locator
//		 * 
		driver.findElement(By.id("username")).sendKeys("DemoSalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

//		 * 3. Click on Login Button using Class Locator
//		 * 
		driver.findElement(By.className("decorativeSubmit")).click();

//		 * 4. Click on CRM/SFA Link
//		 * 
		driver.findElement(By.linkText("CRM/SFA")).click();

//		 * 5. Click on contacts Button
//		 * 	
		driver.findElement(By.linkText("Contacts")).click();

//		 * 6. Click on Merge Contacts using Xpath Locator
//		 * 
		driver.findElement(By.xpath("//ul[@class='shortcuts']//a[text()='Merge Contacts']")).click();

//		 * 7. Click on Widget of From Contact
//		 * 
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a/img")).click();

//		 * 8. Click on First Resulting Contact
//		 * 
		Set<String> windowHandlesFrom = driver.getWindowHandles();
		List<String> windowsListFrom = new ArrayList<String>(windowHandlesFrom);

		String parentWindow = windowsListFrom.get(0);
		String secondWindow = windowsListFrom.get(1);

		driver.switchTo().window(secondWindow);
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//table[1]/tbody/tr[1]/td[1]/div/a[1]")).click();

//		 * 9. Click on Widget of To Contact
//		 * 
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a/img")).click();

//		 * 10. Click on Second Resulting Contact
//		 * 
		Set<String> windowHandlesTo = driver.getWindowHandles();
		List<String> windowsListTo = new ArrayList<String>(windowHandlesTo);

		String parentWindowTo = windowsListTo.get(0);
		String secondWindowTo = windowsListTo.get(1);

		driver.switchTo().window(secondWindowTo);
		driver.manage().window().maximize();

		driver.findElement(
				By.xpath("//div[@class='x-grid3-row    x-grid3-row-alt']/table[1]/tbody/tr[1]/td[1]/div/a[1]")).click();

		driver.switchTo().window(parentWindowTo);

//		 * 11. Click on Merge button using Xpath Locator
//		 * 
		driver.findElement(By.xpath("//a[text()='Merge']")).click();

//		 * 12. Accept the Alert
//		 * 
		driver.switchTo().alert().accept();

//		 * 13. Verify the title of the page
		System.out.println(driver.getTitle());

	}

}
