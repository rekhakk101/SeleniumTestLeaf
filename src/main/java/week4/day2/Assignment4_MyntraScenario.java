package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4_MyntraScenario {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		Actions builder = new Actions(driver);

//			1) Open https://www.myntra.com/
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));

//			2) Mouse hover on MeN 
		WebElement men = driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[text()='Men']"));
		builder.moveToElement(men).perform();

//			3) Click Jackets 
		driver.findElement(By.xpath("(//a[text()='Jackets'])[1]")).click();

//			4) Find the total count of item 
		String jacketsCount = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		String[] split = jacketsCount.split(" ");
		String totalCount = split[2];
		System.out.println("Jackets count : " + totalCount);
		int count = Integer.parseInt(totalCount);

//			5) Validate the sum of categories count matches
		List<WebElement> sumOfCategories = driver.findElements(By.xpath("//span[@class='categories-num']"));
		int sum = 0;
		for (WebElement eachelement : sumOfCategories) {
			String text = eachelement.getText();
			String stringVal = text.substring(text.indexOf('(') + 1, text.indexOf(')'));
			int val = Integer.parseInt(stringVal);
			sum = sum + val;
		}
		if (sum == count) {
			System.out.println("Sum of categories count matches");
		}

//			6) Check jackets
		driver.findElement(By.xpath("//label[text()='Jackets']/div")).click();

//			7) Click + More option under BRAND
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();

//			8) Type Duke and click checkbox
		driver.findElement(By.xpath("//div[@class='brand-more']/following-sibling::div/div/input")).sendKeys("Duke");
		driver.findElement(By.xpath("//label[text()='Duke']/div")).click();

//			9) Close the pop-up x
		driver.findElement(By.xpath("//input[@placeholder='Search brand']/following-sibling::span")).click();

//			10) Confirm all the Coats are of brand Duke
//			    Hint : use List 
		List<WebElement> coats = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		Set<String> coatsBrand = new LinkedHashSet<String>();
		for (WebElement eachcoat : coats) {
			coatsBrand.add(eachcoat.getText());
		}
		if (coatsBrand.size() == 1) {
			System.out.println("All the coats displayed are of brand Duke");
		}

//			11) Sort by Better Discount
		WebElement sort = driver.findElement(By.xpath("//div[text()='Sort by : ']"));
		builder.moveToElement(sort).perform();
		driver.findElement(By.xpath("//label[text()='Better Discount']")).click();

//			12) Find the price of first displayed item
		String price = driver.findElement(By.xpath("(//div[@class='product-price']/span/span)[1]")).getText();
		System.out.println("The price of first selected item : " + price);

//			Click on the first product
		driver.findElement(By.xpath("(//div[@class='product-sliderContainer']//picture/img)[1]")).click();
		Set<String> windows = driver.getWindowHandles();
		List<String> windowsList = new ArrayList<String>(windows);
		driver.switchTo().window(windowsList.get(1));

//			13) Take a screen shot
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./screenshots/MyntraJacket.png");
		FileUtils.copyFile(source, destination);

//			14) Click on WishList Now
		driver.findElement(By.xpath("//span[text()='Wishlist']")).click();

//			15) Close Browser
		driver.quit();

	}

}
