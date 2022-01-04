package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_2_DeleteLead {
	
	static String url = "http://leaftaps.com/opentaps/control/login";
	static String phoneTab = "//div[@id='findLeads']//span[text()='Phone']";
	static String phoneNumber = "//div[@class='x-tab-panel-bwrap']//input[@name='phoneNumber']";
	static String findLeadsButton = "//button[text()='Find Leads']";
	//static String leadIDlink = "//table[@class='x-grid3-row-table']//a[1]";
	static String leadIDlink = "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[1]";
	static String deleteButton = "//div[@class='frameSectionExtra']/a[text()='Delete']";
	static String findLeadsLink = "//ul[@class='shortcuts']/li[3]/a";
	static String message = "//div[@class='x-panel-bbar']//div[@class='x-paging-info']";

	public static void main(String[] args) {
		
		//1 Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		//2 Enter the username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		//3 Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//4 Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//5 Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//6 Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		
		//7 Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
			
		//8 Click on Phone
		driver.findElement(By.xpath(phoneTab)).click();
		
		//9 Enter phone number
		driver.findElement(By.xpath(phoneNumber)).sendKeys("322-5111");
		
		//10 Click find leads button
		driver.findElement(By.xpath(findLeadsButton)).click();
		
		//11 Capture lead ID of First Resulting lead
		String leadID = driver.findElement(By.xpath(leadIDlink)).getText();
		System.out.println("Fist Lead ID in search results: "+leadID);
		
		//12 Click First Resulting lead
		driver.findElement(By.xpath(leadIDlink)).click();
		
		//13 Click Delete
		driver.findElement(By.xpath(deleteButton)).click();
		
		//14 Click Find leads
		driver.findElement(By.xpath(findLeadsLink)).click();
		
		//15 Enter captured lead ID
		driver.findElement(By.xpath(phoneTab)).click();
		driver.findElement(By.xpath(phoneNumber)).sendKeys("322-5111");
		
		//16 Click find leads button
		driver.findElement(By.xpath(findLeadsButton)).click();
		
		//17 Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		String noRecordsMessage = driver.findElement(By.xpath(message)).getText();
		System.out.println("Message displayed : "+noRecordsMessage);
		
		//18 Close the browser (Do not log out)
		driver.close();

	}

}
