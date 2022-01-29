package week5.day1_day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact extends BaseClass {

	@Test
	public void mergeContact() {

		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//ul[@class='shortcuts']//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a/img")).click();
		Set<String> windowHandlesFrom = driver.getWindowHandles();
		List<String> windowsListFrom = new ArrayList<String>(windowHandlesFrom);

		String parentWindow = windowsListFrom.get(0);
		String secondWindow = windowsListFrom.get(1);

		driver.switchTo().window(secondWindow);
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//table[1]/tbody/tr[1]/td[1]/div/a[1]")).click();
		
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a/img")).click();

		Set<String> windowHandlesTo = driver.getWindowHandles();
		List<String> windowsListTo = new ArrayList<String>(windowHandlesTo);

		String parentWindowTo = windowsListTo.get(0);
		String secondWindowTo = windowsListTo.get(1);

		driver.switchTo().window(secondWindowTo);
		driver.manage().window().maximize();

		driver.findElement(
				By.xpath("//div[@class='x-grid3-row    x-grid3-row-alt']/table[1]/tbody/tr[1]/td[1]/div/a[1]")).click();

		driver.switchTo().window(parentWindowTo);

		driver.findElement(By.xpath("//a[text()='Merge']")).click();

		driver.switchTo().alert().accept();

		System.out.println(driver.getTitle());

	}

}
