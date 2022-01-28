package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment5_AmazonScenario {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		Actions builder = new Actions(driver);
		
//			1.Load the uRL https://www.amazon.in/
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
		
//			2.search as oneplus 9 pro 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
//		driver.findElement(By.xpath("(//div[@class='s-suggestion-container']/div)[1]")).click();
		
//			3.Get the price of the first product
		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("The price of the first product : "+price);
		
//			4. Print the number of customer ratings for the first displayed product
//		Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(250));
		String rating = driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base s-underline-text'])[1]")).getText();
		System.out.println("The number of customer ratings : "+rating);
		
//			5. Mouse Hover on the stars
		WebElement star = driver.findElement(By.xpath("//span[contains(text(),'out of 5 stars')]"));
		builder.moveToElement(star).perform();
		
//			6. Get the percentage of ratings for the 5 star.
		String percentage = driver.findElement(By.xpath("//table[@id='histogramTable']//tr/td[3]/span[2]/a")).getText();
		System.out.println("The percentage of ratings for the 5 star : "+percentage);
		
//			7. Click the first text link of the first image
		driver.findElement(By.xpath("//div[@class='sg-row']/div[2]//a/span")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandleslist = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowHandleslist.get(1));
		
//			8. Take a screen shot of the product displayed
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/AmazonPhone.png");
		FileUtils.copyFile(src, dest);
		
//			9. Click 'Add to Cart' button
		driver.findElement(By.id("add-to-cart-button")).click();
		
//			10. Get the cart subtotal and verify if it is correct.
		String subtotal = driver.findElement(By.xpath("(//span[@id='attach-accessory-cart-subtotal'])[1]")).getText();
		System.out.println("Cart subtotal of the product is : "+subtotal);

	}

}
