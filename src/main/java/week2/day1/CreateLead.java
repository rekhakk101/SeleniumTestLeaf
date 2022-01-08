package week2.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Load the URL
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		//Enter the credentials and login
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		System.out.println("Logged into Leaftaps successfully");
		System.out.println("Page title is "+driver.getTitle());
		
		//Click on link text
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		System.out.println("TestLeaf home page opened successfully");
		System.out.println("Page title is "+driver.getTitle());
		
		//click on Leads->Create Lead
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
		System.out.println("CreateLead page opened successfully");
		System.out.println("Page title is "+driver.getTitle());
		
		//Fill in Create Lead form  
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Rekha");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("K");
		//Dropdown scenario
		WebElement dropdown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dd = new Select(dropdown);
			//dd.selectByIndex(10); //starts with index as 0
			//dd.selectByValue("LEAD_TRADESHOW");
			dd.selectByVisibleText("Tradeshow");
			
			//int size = dd.getOptions().size();
			//dd.deselectByIndex(size-2); //selects 2nd last element from drop down
		
		//Select country dropdown value that starts with E but the second match
		WebElement countrydropdown = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select countrydd = new Select(countrydropdown);
		int count = 0;
		List<WebElement> countryList = countrydd.getOptions();
		for(WebElement i:countryList) {
			if(i.getText().startsWith("E")) {
				count++;
				if(count==2) {
					System.out.println("Selected country is "+i.getText());
					i.click();
					break;
				}
			}
		}
		
		
		driver.findElement(By.className("smallSubmit")).click();
		
		String viewLeadTitle = "View Lead | opentaps CRM";
		if(viewLeadTitle.equalsIgnoreCase(driver.getTitle())) {
			System.out.println("View Lead page opened successfully");
		}
		
		//Logout from home page
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		String loginTitle = "Leaftaps - TestLeaf Automation Platform";
		if(loginTitle.equalsIgnoreCase(driver.getTitle())) {
			System.out.println("Logged out successfully");
		}
			
	}

}
