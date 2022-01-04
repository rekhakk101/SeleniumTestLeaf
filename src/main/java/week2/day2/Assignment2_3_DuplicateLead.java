package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_3_DuplicateLead {
	
	static String findLeadsButton = "//button[text()='Find Leads']";
	static String emailTab = "//span[text()='Email']";
	static String emailText = "//label[text()='Email Address:']/following-sibling::div/input[@name='emailAddress']";
	static String leadNamelink = "//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a[1]";
	static String duplicateLeadlink = "//a[@class='subMenuButton' and text()='Duplicate Lead']";
	static String createLeadSubmit = "//input[@name='submitButton' and @value='Create Lead']";
	
	public static void main(String[] args) {
		
		//		1	Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		//		2	Enter the username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		//		3	Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//		4	Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//		5	Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//		6	Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		
		//		7	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//		8	Click on Email
		driver.findElement(By.xpath(emailTab)).click();
		
		//		9	Enter Email
		driver.findElement(By.xpath(emailText)).sendKeys("test@gmail.com");
		
		//		10	Click find leads button
		driver.findElement(By.xpath(findLeadsButton)).click();
		
		//		11	Capture name of First Resulting lead
		String firstName = driver.findElement(By.xpath(leadNamelink)).getText();
		System.out.println("Firt Lead Name : "+firstName);
		
		//		12	Click First Resulting lead
		driver.findElement(By.xpath(leadNamelink)).click();
		
		//		13	Click Duplicate Lead
		driver.findElement(By.xpath(duplicateLeadlink)).click();
		
		//		14	Verify the title as 'Duplicate Lead'
		String duplicateLeadPageTitle = driver.getTitle();
		System.out.println("Duplicate Lead Page Title is: "+duplicateLeadPageTitle);
		
		//		15	Click Create Lead
		driver.findElement(By.xpath(createLeadSubmit)).click();
		
		//		16	Confirm the duplicated lead name is same as captured name
		String firstNameDuplicateLeadPage = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if(firstNameDuplicateLeadPage.equalsIgnoreCase(firstName)) {
			System.out.println("Lead name matches");
		}else {
			System.out.println("Lead name is not matching");
		}
		
		//		17	Close the browser (Do not log out)
		driver.close();

	}

}
