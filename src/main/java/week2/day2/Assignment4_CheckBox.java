package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4_CheckBox {

	public static void main(String[] args) {
		
		//Launch browser and url
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://leafground.com/pages/checkbox.html");
			driver.manage().window().maximize();
				
		//Select the languages that you know? (Multiple select)
			String check_Java = "//div[text()='Java']/input[@type='checkbox']";
			String check_Cplus = "//div[text()='C++']/input[@type='checkbox']";
			driver.findElement(By.xpath(check_Java)).click();
			driver.findElement(By.xpath(check_Cplus)).click();
			
		//Confirm Selenium is checked
			String check_Selenium = "//div[text()='Selenium']/input[@type='checkbox']";
			WebElement selenium = driver.findElement(By.xpath(check_Selenium));
			if(selenium.isSelected()) {
				System.out.println("Selenium checkbox is selected");
			}else {
				System.out.println("Selenium checkbox is not selected");
			}
			
		//DeSelect only checked
			String check_Selected = "//div[text()='I am Selected']/input[@type='checkbox']";
			WebElement iAmSelected = driver.findElement(By.xpath(check_Selected));
			if(iAmSelected.isSelected()) {
				iAmSelected.click();
			}else {
				System.out.println("Checkbox is not selected");
			}
			
		//Select all below checkboxes
			String check_options = "//div[contains(text(),'Option')]/input[@type='checkbox']";
			List<WebElement> optionElements = driver.findElements(By.xpath(check_options));
			for(WebElement i:optionElements) {
				i.click();
			}

	}

}
