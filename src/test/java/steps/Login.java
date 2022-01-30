package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public ChromeDriver driver;
	
	@Given("Launch the browser")
	public void launchTheBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Given("Load the url")
	public void loadTheUrl() {
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
	}
	
	@Given("Enter the user name as DemoSalesManager")
	public void enterTheUserNameAsDemoSalesManager() {
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
	}
	
	@Given("Enter the password as crmsfa")
	public void enterThePasswordAsCrmsfa() {
		driver.findElement(By.id("password")).sendKeys("crmsfa");
	}
	
	@When("Click on Login button")
	public void clickOnLoginButton() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	@Then("Home page should be displayed")
	public void homePageShouldBeDisplayed() {
	    String title = driver.getTitle();
	    if(title.contains("TestLeaf")) {
	    	System.out.println("Home page loaded successfully");
	    }else {
	    	System.out.println("Loaded a wrong page");
	    }
	}

}
