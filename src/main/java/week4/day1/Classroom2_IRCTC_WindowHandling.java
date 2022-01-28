package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Classroom2_IRCTC_WindowHandling {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

//			1. Navigate to https://www.irctc.co.in/nget/train-search
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();

//			2. Close Sweet Alert
		driver.findElement(By.xpath("//button[text()='OK']")).click();

//			3. Click on Flights
		driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();

//			4. Navigate to new window and print its title
		Set<String> windowHandlesSet = driver.getWindowHandles();
		System.out.println(windowHandlesSet);
		List<String> windowsList = new ArrayList<String>(windowHandlesSet);

		String secondWindow = windowsList.get(1);
		driver.switchTo().window(secondWindow);
		System.out.println(driver.getTitle());

//			5. Close the Parent Window
		String parentWindow = windowsList.get(0);
		driver.switchTo().window(parentWindow);
		driver.close();

	}

}
