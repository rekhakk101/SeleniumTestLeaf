package week6;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import week5.day1_day2.BaseClass;

public class LearnAssertion extends BaseClass {

	@Test
	public void createLead() {

		driver.findElement(By.linkText("CRM/SFA")).click();
		boolean displayed = driver.findElement(By.linkText("CRM/SFA")).isDisplayed();
		Assert.assertTrue(displayed);
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Madhav");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Prakash");
		driver.findElement(By.className("smallSubmit")).click();
		String expTitle = "View | opentaps CRM";
		
		//Assert.assertEquals(driver.getTitle(), expTitle);
		
		SoftAssert sAssert = new SoftAssert();
		sAssert.assertEquals(driver.getTitle(), expTitle);
		
		sAssert.assertAll(); //to mark the test case failed if any of the assertions are failed
	}

}
