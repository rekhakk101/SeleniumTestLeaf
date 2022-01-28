package week4.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_Sortable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/sortable/#default");
		driver.manage().window().maximize();
		Actions builder = new Actions(driver);
		
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frameElement);
		
		List<WebElement> items = driver.findElements(By.xpath("//li[contains(text(),'Item')]"));
		
		WebElement item2 = items.get(1);
		WebElement item5 = items.get(4);
		
//		builder.click(item2).clickAndHold().moveToElement(item5).release().build().perform();
//		builder.clickAndHold(item2).moveToElement(item5).release().perform();
		
		builder.moveToElement(item2).clickAndHold().moveToElement(item5).release().build().perform();
		
		

	}

}
