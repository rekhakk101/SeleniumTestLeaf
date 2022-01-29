package week5.day1_day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact extends BaseClass {

	@Test(dataProvider = "getData")
	public void createContact(String fName, String lName) {

		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys(fName);
		driver.findElement(By.id("lastNameField")).sendKeys(lName);
		driver.findElement(By.name("submitButton")).click();
		WebElement firstName = driver.findElement(By.id("viewContact_firstName_sp"));
		System.out.println("First name entered is: " + firstName.getText());
		System.out.println("Page title is: " + driver.getTitle());

	}
	
	@DataProvider(name="getData", parallel=true)
	public String[][] sendData(){
		
		String[][] data = new String[2][2];
		
		data[0][0] = "Malavika";
		data[0][1] = "Prakash";
		
		data[1][0] = "Rekha";
		data[1][1] = "Abhil";
		
		return data;
		
	}

}
