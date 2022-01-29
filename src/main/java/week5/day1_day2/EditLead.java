package week5.day1_day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead extends BaseClass {
	
	@BeforeClass
	public void setUp() {
		filename = "EditLead";
	}

	static String url = "http://leaftaps.com/opentaps/control/login";
	static String firstnameTextBox = "//div[@id='findLeads']//input[@name='firstName']";
	static String findLeadsButton = "//button[text()='Find Leads']";
	static String leadIDlink = "//table[@class='x-grid3-row-table']//a[1]";
	static String editlink = "//a[@class='subMenuButton' and text()='Edit']";
	static String updateButton = "//input[@class='smallSubmit' and @value='Update']";

	@Test
	public void editLead() {

		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath(firstnameTextBox)).sendKeys("Abhil");
		driver.findElement(By.xpath(findLeadsButton)).click();
		driver.findElement(By.xpath(leadIDlink)).click();
		String actualTitle = "View Lead | opentaps CRM";
		if (actualTitle.equalsIgnoreCase(driver.getTitle())) {
			System.out.println("Title of the page is: " + driver.getTitle());
		} else {
			System.out.println("Title is not matching");
		}
		driver.findElement(By.xpath(editlink)).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Edited Company");
		driver.findElement(By.xpath(updateButton)).click();
		String updatedCompany = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("Updated Company name is: " + updatedCompany);

	}

}
