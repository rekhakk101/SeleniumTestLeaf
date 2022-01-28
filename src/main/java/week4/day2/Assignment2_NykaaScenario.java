package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_NykaaScenario {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

//			1) Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//			2) Mouseover on Brands and Search L'Oreal Paris
		Actions builder = new Actions(driver);
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		builder.moveToElement(brands).perform();

//			3) Click L'Oreal Paris
		WebElement loreal = driver.findElement(By.xpath(
				"//div[@id='list_topbrands' and text()='topbrands']/following-sibling::div/a[text()=\"L'Oreal Paris\"]"));
		loreal.click();

//			4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		String lorealTitle = driver.getTitle();
		if (lorealTitle.contains("L'Oreal Paris")) {
			System.out.println("Title name have L'Oreal Paris");
		} else {
			System.out.println("Error! Title name doesn't have L'Oreal Paris");
		}

//			5) Click sort By and select customer top rated
		driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']/parent::div/following-sibling::div")).click();

//			6) Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']/parent::div/following-sibling::div")).click();

//			7) Click->Concern->Color Protection
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']/parent::div/following-sibling::div")).click();

//			8)check whether the Filter is applied with Shampoo
		List<WebElement> filters = driver.findElements(By.xpath(
				"//span[text()='Filters Applied']/parent::div/following-sibling::div//span[@class='filter-value']"));
		List<String> filter = new ArrayList<String>();
		for (int i = 0; i < filters.size(); i++) {
			String text = filters.get(i).getText();
			if (text.equalsIgnoreCase("Shampoo")) {
				System.out.println("Selected filters contains Shampoo");
			}
			filter.add(text);
		}

//			9) Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//div[text()=\"L'Oreal Paris Colour Protect Shampoo\"]")).click();

//			10) GO to the new window and select size as 360ml
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandles = new ArrayList<String>(windowHandlesSet);
		String productWindow = windowHandles.get(1);
		driver.switchTo().window(productWindow);
		WebElement dropdown = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select dd = new Select(dropdown);
		dd.selectByVisibleText("360ml");

//			11) Print the MRP of the product
		String mrp = driver.findElement(By.xpath("//span[text()='MRP:']/following-sibling::span")).getText();
		System.out.println("MRP of the product is " + mrp);

//			12) Click on ADD to BAG
		driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();

//			13) Go to Shopping Bag 
		driver.findElement(By.xpath("//span[@class='cart-count']/parent::button")).click();

//			14) Print the Grand Total amount
		driver.switchTo().frame(0);
		String grandTotalAmount = driver.findElement(By.xpath("//span[text()='Grand Total']/following-sibling::div"))
				.getText();
		System.out.println("Grand Total amount : " + grandTotalAmount);

//			15) Click Proceed
		driver.findElement(By.xpath("//span[text()='PROCEED']")).click();
		driver.switchTo().defaultContent();

//			16) Click on Continue as Guest
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();

//			17) Check if this grand total is the same in step 14
		String totalAmountCheckout = driver.findElement(By.xpath("//div[text()='Grand Total']/following-sibling::div"))
				.getText();
		if (totalAmountCheckout.equalsIgnoreCase(grandTotalAmount)) {
			System.out.println("Grand total is same");
		}

//			18) Close all windows
		for (String window : windowHandles) {
			driver.switchTo().window(window).close();
		}

	}

}
