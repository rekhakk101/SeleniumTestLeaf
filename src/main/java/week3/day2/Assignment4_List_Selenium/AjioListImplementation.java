package week3.day2.Assignment4_List_Selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AjioListImplementation {

	public static void main(String[] args) {
		
//		    1. Launch the URL https://www.ajio.com/
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		
//			2. In the search box, type as "bags" and press enter
		WebElement search = driver.findElement(By.name("searchVal"));
		search.sendKeys("bags",Keys.ENTER);
		
//			3. To the left  of the screen under " Gender" click the "Men"
		driver.findElement(By.xpath("//input[@id='Men']/following-sibling::label")).click();
		
//			4. Under "Category" click "Fashion Bags"
		driver.findElement(By.xpath("//input[@id='Men - Fashion Bags']/following-sibling::label")).click();
		
//			5. Print the count of the items Found. 
		WebElement items = driver.findElement(By.xpath("//div[@id='breadcrumb-container']/following-sibling::div//div[@class='length']"));
		String text = items.getText();
		String[] number = text.split(" ");
		System.out.println("No. of items found : "+number[0]);
		
//			6. Get the list of brand of the products displayed in the page and print the list.
		driver.findElement(By.xpath("//span[text()='brands']/parent::div")).click();
		driver.findElement(By.xpath("//input[@name='brand']/ancestor::li//div[@id='verticalsizegroupformat']")).click();
		List<WebElement> brandNames = driver.findElements(By.xpath("//div[@id='modalId']//span[@class='facet-list-title-name']"));
		List<String> brand = new ArrayList<String>();
		for (int i=0; i<brandNames.size(); i++) {
			brand.add(brandNames.get(i).getText());
//			System.out.println(brandNames.get(i).getText());
		}
//		Print the list of brands
		System.out.println(brand);
		
		driver.findElement(By.xpath("//div[@id='modalId']//div[@class='ic-close-quickview']")).click();
		
//			7. Get the list of names of the bags and print it
		List<WebElement> bagNames = driver.findElements(By.xpath("//div[@class='nameCls']"));
		List<String> bagName = new ArrayList<String>();
		for(int i=0; i<bagNames.size(); i++) {
			bagName.add(bagNames.get(i).getText());
		}
//		Print the list of bag names
		System.out.println(bagName);

	}

}
