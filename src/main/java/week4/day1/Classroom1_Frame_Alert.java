package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Classroom1_Frame_Alert {

	public static void main(String[] args) throws InterruptedException {

//		1. Navigate to https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		options.addArguments("--disable-notifications");
		
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.manage().window().maximize();
		
//		2. Click on Try it button
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
//		3. Enter your name in Alert field
//		4. Accept the alert
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Rekha");
		Thread.sleep(1000);
		alert.accept();
		
//		5. Verify your name is displayed correctly
		String text = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		if(text.contains("Rekha")) {
			System.out.println("Name displayed as expected");
		}else {
			System.out.println("Error!");
		}
		

	}

}
