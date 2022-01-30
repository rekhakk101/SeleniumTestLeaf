package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafTaps_steps extends BaseClass {
	

	/*@Given("Login to the LeafTaps application")
	public void login_to_the_leaf_taps_application() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
	}*/

	@Given("Click on CRM\\/SFA link")
	public void click_on_crm_sfa_link() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

	@Given("Navigate to Leads tab")
	public void navigate_to_leads_tab() {
		driver.findElement(By.linkText("Leads")).click();
	}

	@Given("Click on Create Lead button")
	public void click_on_create_lead_button() {
		driver.findElement(By.linkText("Create Lead")).click();
	}

	@Given("Enter Company name as {string}")
	public void enter_company_name_as_bank_of_baroda(String cname) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
	}

	@Given("Enter First name as {string}")
	public void enter_first_name_as_judy(String fname) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
	}

	@Given("Enter Last name as {string}")
	public void enter_last_name_as_jerry(String lname) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
	}

	@When("Click on Submit button")
	public void click_on_submit_button() {
		driver.findElement(By.className("smallSubmit")).click();
	}

	@Then("View Lead page should be displayed")
	public void view_lead_page_should_be_displayed() {
		String title = driver.getTitle();
		if(title.contains("View Lead")) {
			System.out.println("Created Lead successfully");
		}else {
			System.out.println("Wrong page is loaded");
		}
	}
	
	@Given("Click on Find Leads button")
	public void clickOnFindLeadsButton() {
		String findLeadsButton = "//button[text()='Find Leads']";
		driver.findElement(By.xpath(findLeadsButton)).click();
	}
	
	@Given("Click on Find Leads")
	public void clickOnFindLeads() {
		String findLeadsButton = "//button[text()='Find Leads']";
		driver.findElement(By.xpath(findLeadsButton)).click();
	}
	@Given("Click on fisrt appeared Lead from the list")
	public void clickOnFisrtAppearedLeadFromTheList() {
		String leadIDlink = "//table[@class='x-grid3-row-table']//a[1]";
		driver.findElement(By.xpath(leadIDlink)).click();
	}
	@Given("Click on Edit button")
	public void clickOnEditButton() {
		String editlink = "//a[@class='subMenuButton' and text()='Edit']";
		driver.findElement(By.xpath(editlink)).click();
	}
	@Given("Clear Company name and Enter a new Company name")
	public void clearCompanyNameAndEnterANewCompanyName() {
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Edited Company");
	}
	@When("Click on Update")
	public void clickOnUpdate() {
		String updateButton = "//input[@class='smallSubmit' and @value='Update']";
		driver.findElement(By.xpath(updateButton)).click();
	}
	@Given("Click on Phone tab and Enter Phone number as {string}")
	public void clickOnPhoneTabAndEnterPhoneNumberAs(String phNo) {
		String phoneTab = "//div[@id='findLeads']//span[text()='Phone']";
		String phoneNumber = "//div[@class='x-tab-panel-bwrap']//input[@name='phoneNumber']";
		driver.findElement(By.xpath(phoneTab)).click();
		driver.findElement(By.xpath(phoneNumber)).sendKeys(phNo);
	}
	@When("Click on Delete button")
	public void clickOnDeleteButton() {
		String deleteButton = "//div[@class='frameSectionExtra']/a[text()='Delete']";
		driver.findElement(By.xpath(deleteButton)).click();
	}
	@Then("My Leads page should be displayed")
	public void myLeadsPageShouldBeDisplayed() {
		String title = driver.getTitle();
		if(title.contains("My Leads")) {
			System.out.println("Created Lead successfully");
		}else {
			System.out.println("Wrong page is loaded");
		}
	}
	
	@Given("Click on Email tab and Enter Email ID as {string}")
	public void clickOnEmailTabAndEnterEmailIDAs(String string) {
		String emailTab = "//span[text()='Email']";
		String emailText = "//label[text()='Email Address:']/following-sibling::div/input[@name='emailAddress']";
		driver.findElement(By.xpath(emailTab)).click();
		driver.findElement(By.xpath(emailText)).sendKeys("test@gmail.com");
	}
	@Given("Click on Duplicate Lead button")
	public void clickOnDuplicateLeadButton() {
		String duplicateLeadlink = "//a[@class='subMenuButton' and text()='Duplicate Lead']";
		driver.findElement(By.xpath(duplicateLeadlink)).click();
	}
	@When("Click on Create Lead")
	public void clickOnCreateLead() {
		String createLeadSubmit = "//input[@name='submitButton' and @value='Create Lead']";
		driver.findElement(By.xpath(createLeadSubmit)).click();
	}

}
