package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DailyQnA2_ddSelectSecondlast {

	public static void main(String[] args) {
		// Selenium program to select last but one option from the dropdown
		
		//Launch browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		
		//Select dropdown
		WebElement dropdown = driver.findElement(By.id("dropdown1"));
		Select dd = new Select(dropdown);
		int size = dd.getOptions().size();
		dd.selectByIndex(size-2);
		String selectedOption = dd.getFirstSelectedOption().getText();
		System.out.println("Selected option is "+selectedOption);

	}

}
