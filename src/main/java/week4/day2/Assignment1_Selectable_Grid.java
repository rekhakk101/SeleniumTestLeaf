package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_Selectable_Grid {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/selectable/#display-grid");
		driver.manage().window().maximize();
		
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frameElement);
		
		WebElement one = driver.findElement(By.xpath("//li[text()='1']"));
		WebElement three = driver.findElement(By.xpath("//li[text()='3']"));
		WebElement five = driver.findElement(By.xpath("//li[text()='5']"));
		WebElement nine = driver.findElement(By.xpath("//li[text()='9']"));
		WebElement twelve = driver.findElement(By.xpath("//li[text()='12']"));
		
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(one).click(three).click(nine).click(twelve).keyUp(Keys.CONTROL).perform();
		
		String attribute = one.getAttribute("class");
		if(attribute.contains("selected")) {
			System.out.println("Element is selected");
		}else {
			System.out.println("Not selected");
		}

	}

}
