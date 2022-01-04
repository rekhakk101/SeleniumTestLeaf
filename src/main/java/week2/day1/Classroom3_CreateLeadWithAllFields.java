package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Classroom3_CreateLeadWithAllFields {

	public static void main(String[] args) {
		
	//		1. Launch URL "http://leaftaps.com/opentaps/control/login"
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
	//		2. Enter UserName and Password 	
		driver.findElement(By.id("username")).sendKeys("DemoSalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
	//		3. Click on Login Button 
		driver.findElement(By.className("decorativeSubmit")).click();
		
	//		4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
	//		5. Click on Leads Button	
		driver.findElement(By.linkText("Leads")).click();
		
	//		6. Click on create Lead Button
		driver.findElement(By.linkText("Create Lead")).click();
		
	//		7. Enter all the fields in CreateLead page
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_parentPartyId")).sendKeys("Company");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Rekha");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Krishnankutty");
		WebElement source = driver.findElement(By.id("createLeadForm_dataSourceId"));
			Select src = new Select(source);
			src.selectByVisibleText("Tradeshow");
		WebElement marketingCampaign = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
			Select mc = new Select(marketingCampaign);
			mc.selectByValue("CATRQ_CARNDRIVER");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("rekha");
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("kk");
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Mrs");
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("1/2/98");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Tester");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("SelDec");
		driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("700000");
		/*WebElement currency = driver.findElement(By.id("createLeadForm_currencyUomId"));
			Select cur = new Select(currency);
			cur.selectByValue("INR");	*/	
		WebElement industry = driver.findElement(By.id("createLeadForm_industryEnumId"));
			Select ind = new Select(industry);
			ind.selectByIndex(6);
		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("20");
		WebElement ownership = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
			Select o = new Select(ownership);
			o.selectByIndex(2);
		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("100231");
		driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("JJ");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Creating a Lead under Leads tab");
		driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("SelDec batch");
		
	//		8. Enter all the fields in contact information  
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("91");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("8877669989");
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("456");
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("9989090675");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("sys@testleaf.com");
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("https://www.testleaftaps.com");
		
	//		9. Enter all the fields in primary address
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Rekha");
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Rekha K");
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("Avenue street, Himalaya Nagar");
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("Sarayu, Jaipur");
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Citytest");
		WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
			Select st = new Select(state);
			st.selectByIndex(3);
		/*WebElement country = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
			Select co = new Select(country);
			co.selectByVisibleText("United States");*/
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("568890");
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("67");
		
	//		10. Get the Firstname and print it	
		String firstName = driver.findElement(By.id("createLeadForm_firstName")).getAttribute("value");
		System.out.println("First name is "+firstName);
		
	//		11. Click on create Lead Button	 
		driver.findElement(By.className("smallSubmit")).click();
		
	//		12. Get and Verify the Title of the resulting Page(View Lead)
		String title = "View Lead | opentaps CRM";
		String actualtitle = driver.getTitle();
		if(title.equalsIgnoreCase(actualtitle)) {
			System.out.println("Title of the page is "+actualtitle);
		}
		
	//		Close the browser
		driver.close();

	}

}
