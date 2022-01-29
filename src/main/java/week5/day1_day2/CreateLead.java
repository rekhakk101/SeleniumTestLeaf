package week5.day1_day2;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseClass{
	
	@BeforeClass
	public void setUp() {
		filename = "CreateLead";
	}

	@Test(dataProvider="getExcelData")
	public void createLead(String cName, String fName, String lName) {

		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		WebElement dropdown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dd = new Select(dropdown);
		dd.selectByVisibleText("Tradeshow");
		driver.findElement(By.className("smallSubmit")).click();
	}

}
