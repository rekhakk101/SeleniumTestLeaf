package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_HandleAlerts {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		
		//Click the button to display a alert box.
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert text displayed is : "+alert.getText());
		alert.accept();
		
		//Click the button to display a confirm box.
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		Alert alert1 = driver.switchTo().alert();
		System.out.println("Alert text displayed is : "+alert1.getText());
		alert1.dismiss();
		WebElement confText = driver.findElement(By.xpath("//button[text()='Confirm Box']/following-sibling::p"));
		System.out.println("Confirmation Text displayed is : "+confText.getText());
		
		//Click the button to display a prompt box.
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		Alert alert2 = driver.switchTo().alert();
		System.out.println("Alert text displayed is : "+alert2.getText());
		alert2.sendKeys("Rekha Test Leaf Academy");
		alert2.accept();
		String promptText = driver.findElement(By.xpath("//button[text()='Prompt Box']/following-sibling::p")).getText();
		System.out.println("Prompt Text displayed is : "+promptText);
		
		//Click the button to learn line-breaks in an alert.
		driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
		Alert alert3 = driver.switchTo().alert();
		String text = alert3.getText();
		System.out.println(text);
		text.replaceAll("[\n]", "");
		System.out.println(text);
		alert3.accept();
		
		//Click the below button and click OK.
		driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
		String text2 = driver.findElement(By.xpath("//div[text()='Happy Coding!']")).getText();
		System.out.println("Sweet Alert text is : "+text2);
		driver.findElement(By.xpath("//button[text()='OK']")).click();

	}

}
