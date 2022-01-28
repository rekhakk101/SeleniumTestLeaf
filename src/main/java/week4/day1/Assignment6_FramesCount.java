package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment6_FramesCount {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
//			Launch http://leafground.com/pages/frame.html
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		
//			1.Take the the screenshot of the click me button of first frame
		WebElement frameElement1 = driver.findElement(By.xpath("//iframe[@src='default.html']"));
		driver.switchTo().frame(frameElement1);
		WebElement click = driver.findElement(By.id("Click"));
		File source = click.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/clickElement.png");
		FileUtils.copyFile(source, dest);
		
		driver.switchTo().defaultContent();
		
//			2.Find the number of frames
//			  - find the Elements by tagname - iframe
//			  - Store it in a list
//			  - Get the size of the list. (This gives the count of the frames visible to the main page)
		List<WebElement> frameTags = driver.findElements(By.tagName("iframe"));
		System.out.println("No.of frames : "+frameTags.size());
		

	}

}
