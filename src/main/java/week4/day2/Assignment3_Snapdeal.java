package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3_Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

//			1. Launch https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));

//			2. Go to Mens Fashion
		Actions builder = new Actions(driver);
		WebElement mensFashion = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		builder.moveToElement(mensFashion).perform();

//			3. Go to Sports Shoes
		driver.findElement(By.xpath(
				"//span[text()=\"Men's Fashion\"]/parent::a/following-sibling::div//span/ancestor::p/following-sibling::p//span[text()='Sports Shoes']"))
				.click();
		Thread.sleep(3000);

//			4. Get the count of the sports shoes
		String countSportsShoes = driver
				.findElement(By.xpath("//h1[@category='Sports Shoes for Men']/following-sibling::span")).getText();
		System.out.println("Number of shoes displayed : " + countSportsShoes);

//			5. Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();

//			6. Sort by Low to High
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.xpath("//li[@data-sorttype=\"plth\"]")).click();
		Thread.sleep(4000);

//			7. Check if the items displayed are sorted correctly
		List<WebElement> items = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<Integer> prices = new ArrayList<Integer>();
		for (WebElement eachitem : items) {
			String attribute = eachitem.getAttribute("display-price");
			int price = Integer.parseInt(attribute);
			prices.add(price);
		}
		int firstShoePrice = prices.get(0);
		Collections.sort(prices);
		int firstShoePriceAfterSort = prices.get(0);
		if (firstShoePrice == firstShoePriceAfterSort) {
			System.out.println("Items displayed are sorted correctly");
		} else {
			System.out.println("Error! Sorted order is not as expected");
		}

//			8.Select the price range (900-1200)
		WebElement fromVal = driver.findElement(By.xpath("//input[@name='fromVal']"));
		fromVal.clear();
		fromVal.sendKeys("900");
		WebElement toVal = driver.findElement(By.xpath("//input[@name='toVal']"));
		toVal.clear();
		toVal.sendKeys("1200");
		driver.findElement(
				By.xpath("//input[@name='toVal']/ancestor::div[@class='price-input']/following-sibling::div")).click();

//			9.Filter with color Navy 
		driver.findElement(By.xpath("//div[@data-filtername='Color_s']//div[@class='filter-type-name lfloat']"));
		driver.findElement(By.xpath("//input[@id='Color_s-Navy']/parent::div")).click();

//			10 verify the all applied filters 
		List<WebElement> filters = driver
				.findElements(By.xpath("//div[@class='filters-top-selected']//div[@class='navFiltersPill']/a"));
		System.out.println("Applied filters are: ");
		for (WebElement filter : filters) {
			System.out.println(filter.getText());
		}

//			11. Mouse Hover on first resulting Training shoes
		WebElement firstResult = driver.findElement(By.xpath("(//div[@class='product-tuple-image ']//img)[1]"));
		builder.moveToElement(firstResult).perform();

//			12. click QuickView button
		driver.findElement(By.xpath("//img/parent::picture/parent::a/following-sibling::div/div")).click();

//			13. Print the cost and the discount percentage
		String price = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		String discountPercentage = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("Price : " + price);
		System.out.println("Discount percentage : " + discountPercentage);

//			14. Take the snapshot of the shoes.
		WebElement shoesSnap = driver.findElement(By.xpath("//ul[@id='bx-slider-qv-image-panel']/li/img"));
		File source = shoesSnap.getScreenshotAs(OutputType.FILE);
		File destination = new File("./screenshots/shoesPic.png");
		FileUtils.copyFile(source, destination);

//			15. Close the current window
		driver.findElement(By.xpath("//div[@class='close close1 marR10']/i[@class='sd-icon sd-icon-delete-sign']"))
				.click();

//			16. Close the main window
		driver.close();
	}

}
