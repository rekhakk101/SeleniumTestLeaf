package week2.day1;

import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_DropdownFields {

	public static void main(String[] args) {
		
		//Launch browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		
		//Select training program using Index
		WebElement drop1 = driver.findElement(By.id("dropdown1"));
		Select dd1 = new Select(drop1);
		dd1.selectByIndex(3);
		String selectedText1 = dd1.getFirstSelectedOption().getText();
		System.out.println("Selected text is "+selectedText1);
		
		//Select training program using Text
		WebElement drop2 = driver.findElement(By.name("dropdown2"));
		Select dd2 = new Select(drop2);
		dd2.selectByVisibleText("Selenium");
		String selectedText2 = dd2.getFirstSelectedOption().getText();
		System.out.println("Selected text is "+selectedText2);
		
		//Select training program using Value
		WebElement drop3 = driver.findElement(By.id("dropdown3"));
		Select dd3 = new Select(drop3);
		dd3.selectByValue("2");
		String selectedText3 = dd3.getFirstSelectedOption().getText();
		System.out.println("Selected text is "+selectedText3);
		
		//Get the number of dropdown options
		WebElement drop4 = driver.findElement(By.className("dropdown"));
		Select dd4 = new Select(drop4);
		int size = dd4.getOptions().size();
		System.out.println("Size "+size);
		
		//You can also use sendKeys to select
		WebElement drop5 = driver.findElement(By.xpath("//select[@class='dropdown']/following::select"));
		Select dd5 = new Select(drop5);
		drop5.sendKeys("Loadrunner");
		String selectedText5 = dd5.getFirstSelectedOption().getText();
		System.out.println("Selected text is "+selectedText5);
		
		//Select multiple options
		WebElement drop6 = driver.findElement(By.xpath("//select[@class='dropdown']/following::select/following::select"));
		Select dd6 = new Select(drop6);
		if(dd6.isMultiple()) {
			dd6.selectByIndex(1);
			dd6.selectByIndex(3);
		}else {
			System.out.println("Multiple select is not allowed!");
		}
		
		//Close the browser
		driver.close();

	}

}
