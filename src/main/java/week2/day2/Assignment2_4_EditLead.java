package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_4_EditLead {
	
	static String url = "http://leaftaps.com/opentaps/control/login";
	static String firstnameTextBox = "//div[@id='findLeads']//input[@name='firstName']";
	static String findLeadsButton = "//button[text()='Find Leads']";
	static String leadIDlink = "//table[@class='x-grid3-row-table']//a[1]";
	static String editlink = "//a[@class='subMenuButton' and text()='Edit']";
	static String updateButton = "//input[@class='smallSubmit' and @value='Update']";

	public static void main(String[] args) {
		
		//* 1	Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		//* 2	Enter the username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		//* 3	Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//* 4	Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//* 5	Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//* 6	Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		
		//* 7	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//* 8	Enter first name
		driver.findElement(By.xpath(firstnameTextBox)).sendKeys("Abhil");
		
		//* 9	Click Find leads button
		driver.findElement(By.xpath(findLeadsButton)).click();
		
		//* 10 Click on first resulting lead
		driver.findElement(By.xpath(leadIDlink)).click();
		
		//* 11 Verify title of the page
		String actualTitle = "View Lead | opentaps CRM";
		if(actualTitle.equalsIgnoreCase(driver.getTitle())) {
			System.out.println("Title of the page is: "+driver.getTitle());
		}else {
			System.out.println("Title is not matching");
		}
		
		//* 12 Click Edit
		driver.findElement(By.xpath(editlink)).click();
		
		//* 13 Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Edited Company");
		
		//* 14 Click Update
		driver.findElement(By.xpath(updateButton)).click();
		
		//* 15 Confirm the changed name appears
		String updatedCompany = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("Updated Company name is: "+updatedCompany);
		
		//* 16 Close the browser (Do not log out)
		driver.close();

	}

}
