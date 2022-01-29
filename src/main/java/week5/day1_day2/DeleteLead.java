package week5.day1_day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead extends BaseClass {

	static String url = "http://leaftaps.com/opentaps/control/login";
	static String phoneTab = "//div[@id='findLeads']//span[text()='Phone']";
	static String phoneNumber = "//div[@class='x-tab-panel-bwrap']//input[@name='phoneNumber']";
	static String findLeadsButton = "//button[text()='Find Leads']";
	// static String leadIDlink = "//table[@class='x-grid3-row-table']//a[1]";
	static String leadIDlink = "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[1]";
	static String deleteButton = "//div[@class='frameSectionExtra']/a[text()='Delete']";
	static String findLeadsLink = "//ul[@class='shortcuts']/li[3]/a";
	static String message = "//div[@class='x-panel-bbar']//div[@class='x-paging-info']";

	@Test
	public void deleteLead() {

		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath(phoneTab)).click();
		driver.findElement(By.xpath(phoneNumber)).sendKeys("322-5111");
		driver.findElement(By.xpath(findLeadsButton)).click();
		String leadID = driver.findElement(By.xpath(leadIDlink)).getText();
		System.out.println("Fist Lead ID in search results: " + leadID);
		driver.findElement(By.xpath(leadIDlink)).click();
		driver.findElement(By.xpath(deleteButton)).click();
		driver.findElement(By.xpath(findLeadsLink)).click();
		driver.findElement(By.xpath(phoneTab)).click();
		driver.findElement(By.xpath(phoneNumber)).sendKeys("322-5111");
		driver.findElement(By.xpath(findLeadsButton)).click();
		String noRecordsMessage = driver.findElement(By.xpath(message)).getText();
		System.out.println("Message displayed : " + noRecordsMessage);

	}

}
