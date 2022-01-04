package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Classroom1_CreateLeadWithXPath {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Load the URL
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		//Enter the credentials and login
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit' and @value='Login']")).click();
		
		System.out.println("Logged into Leaftaps successfully");
		System.out.println("Page title is "+driver.getTitle());
		
		//Click on link text
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		System.out.println("TestLeaf home page opened successfully");
		System.out.println("Page title is "+driver.getTitle());
		
		//click on Leads->Create Lead
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'/createLead')]")).click();
		
		System.out.println("CreateLead page opened successfully");
		System.out.println("Page title is "+driver.getTitle());
		
		//Fill in Create Lead form  
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Rekha");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("K");
		//Select a source from dropdown
		WebElement dropdown = driver.findElement(By.xpath("(//select[@class='inputBox'])[1]"));
		Select dd = new Select(dropdown);
			dd.selectByVisibleText("Tradeshow");
		
		//Click on 'CreateLead' button
		driver.findElement(By.xpath("//input[@type='submit' and @class='smallSubmit']")).click();
		
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
