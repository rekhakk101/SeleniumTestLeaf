package week5.day1_day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead extends BaseClass {

	static String findLeadsButton = "//button[text()='Find Leads']";
	static String emailTab = "//span[text()='Email']";
	static String emailText = "//label[text()='Email Address:']/following-sibling::div/input[@name='emailAddress']";
	static String leadNamelink = "//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a[1]";
	static String duplicateLeadlink = "//a[@class='subMenuButton' and text()='Duplicate Lead']";
	static String createLeadSubmit = "//input[@name='submitButton' and @value='Create Lead']";

	@Test
	public void duplicateLead() {

		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath(emailTab)).click();
		driver.findElement(By.xpath(emailText)).sendKeys("test@gmail.com");
		driver.findElement(By.xpath(findLeadsButton)).click();
		String firstName = driver.findElement(By.xpath(leadNamelink)).getText();
		System.out.println("Firt Lead Name : " + firstName);
		driver.findElement(By.xpath(leadNamelink)).click();
		driver.findElement(By.xpath(duplicateLeadlink)).click();
		String duplicateLeadPageTitle = driver.getTitle();
		System.out.println("Duplicate Lead Page Title is: " + duplicateLeadPageTitle);
		driver.findElement(By.xpath(createLeadSubmit)).click();
		String firstNameDuplicateLeadPage = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if (firstNameDuplicateLeadPage.equalsIgnoreCase(firstName)) {
			System.out.println("Lead name matches");
		} else {
			System.out.println("Lead name is not matching");
		}

	}

}
