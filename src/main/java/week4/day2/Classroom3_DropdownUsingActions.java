package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Classroom3_DropdownUsingActions {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

//		1. Navigate to http://www.leafground.com/pages/Dropdown.html
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

//		2. Select Selenium and LoadRunner from dropdown
		driver.findElement(By.xpath("//option[text()='Select your programs']")).click();
		WebElement selenium = driver.findElement(
				By.xpath("//option[text()='Select your programs']/following-sibling::option[text()='Selenium']"));
		WebElement loadrunner = driver.findElement(
				By.xpath("//option[text()='Select your programs']/following-sibling::option[text()='Loadrunner']"));

		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(selenium).click(loadrunner).keyUp(Keys.CONTROL).perform();

	}

}
