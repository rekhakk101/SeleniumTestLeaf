package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Classroom2_snapdealScenario {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
//		1. Navigate to https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
//		2. Hover on Men's Fashion and select Shirts
		WebElement men = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(men).pause(Duration.ofSeconds(2)).perform();
		WebElement shirts = driver.findElement(By.xpath("//div[@id='category1Data']//span[text()='Shirts']"));
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		WebElement untilwait = wait.until(ExpectedConditions.visibilityOf(shirts));
		shirts.click();
		
//		3. Hover on First Result and Click on Quick View
		WebElement product1 = driver.findElement(By.xpath("//div[@id='products']/section[1]/div[1]/div[2]/a//img"));
		builder.moveToElement(product1).pause(1000).perform();
		driver.findElement(By.xpath("//div[@id='products']/section[1]/div[1]/div[2]/a/following-sibling::div/div")).click();
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./screenshots/Snapdeal_QuickView.png");
		FileUtils.copyFile(source, destination);
		
//		4. Close the browser

	}

}
