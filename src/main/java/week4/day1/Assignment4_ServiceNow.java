package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4_ServiceNow {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
//		Step1: Load ServiceNow application URL
		driver.get("https://dev109433.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
//		Step2: Enter username (Check for frame before entering the username)
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		
//		Step3: Enter password 
		driver.findElement(By.id("user_password")).sendKeys("Learn101@");
		
//		Step4: Click Login
		driver.findElement(By.id("sysverb_login")).click();
		
//		Step5: Search “incident “ Filter Navigator
		driver.findElement(By.id("filter")).sendKeys("incident",Keys.ENTER);
		
//		Step6: Click “All”
		WebElement all = driver.findElement(By.xpath("//ul[@class='sn-widget-list_v2 sn-widget-list_dense collapse in']/li[6]//div[text()='All']"));
		all.click();
		
//		Step7: Click New button
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//button[text()='New']")).click();
		
//		Step8: Select a value for Caller and Enter value for short_description
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']/span")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandleslist = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowHandleslist.get(1)).manage().window().maximize();
		
		WebElement dropdown = driver.findElement(By.xpath("//span[@class='input-group-addon input-group-select']//select[@role='listbox']"));
		Select dd = new Select(dropdown);
		dd.selectByValue("first_name");
		driver.findElement(By.xpath("//label[text()='Search']/following-sibling::input")).sendKeys("re",Keys.ENTER);
		
		driver.findElement(By.xpath("//table[@id='sys_user_table']//tr[1]/td[3]/a")).click();
		driver.switchTo().window(windowHandleslist.get(0));
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("incident.short_description")).sendKeys("Test Description");
		
//		Step9: Read the incident number and save it a variable
		String incidentNumber = driver.findElement(By.id("incident.number")).getText();
		
//		Step10: Click on Submit button
		driver.findElement(By.xpath("//div[@class='form_action_button_container']/button[text()='Submit']")).click();
		
//		Step 11: Search the same incident number in the next search screen as below
		driver.findElement(By.xpath("//label[text()='Search']/following-sibling::input")).sendKeys(incidentNumber,Keys.ENTER);
		
//		Step12: Verify the incident is created successful and take snapshot of the created incident.
		driver.findElement(By.xpath("//table[@id='incident_table']//tr[1]/td[3]/a")).click();
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./screenshots/ServiceNow.png");
		FileUtils.copyFile(source, destination);
		
		WebElement incidentNumberSnippet = driver.findElement(By.id("incident.number"));
		File src = incidentNumberSnippet.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/ServiceNow_IncidentNumber.png");
		FileUtils.copyFile(src, dest);
		

	}

}
