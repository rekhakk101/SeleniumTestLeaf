package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3_HandleWindows {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		
		//Click button to open home page in New Window
		driver.findElement(By.xpath("//button[text()='Open Home Page']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList =new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowHandlesList.get(1)).manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.switchTo().window(windowHandlesList.get(0));
		
		//Find the number of opened windows
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> windowHandles2List = new ArrayList<String>(windowHandles2);
		System.out.println(windowHandles2List);
		System.out.println("Page titles of opened windows:");
		driver.switchTo().window(windowHandles2List.get(1)).manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.switchTo().window(windowHandles2List.get(2)).manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.switchTo().window(windowHandles2List.get(3)).manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.switchTo().window(windowHandles2List.get(0));
		
		//Close all except this window
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> windowHandles3List = new ArrayList<String>(windowHandles3);
		System.out.println(windowHandles3List);
		System.out.println("Scenario-Close all except this window");
		for (String window : windowHandles3List) {
			if(!window.equalsIgnoreCase(windowHandles3List.get(0))) {
				driver.switchTo().window(window).close();
			}
		}
		driver.switchTo().window(windowHandles3List.get(0));
		
		//Wait for 2 new Windows to open
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Set<String> windowHandles4 = driver.getWindowHandles();
		List<String> windowHandles4List = new ArrayList<String>(windowHandles4);
		System.out.println("Scenario-Pages opened after 5sec wait");
		driver.switchTo().window(windowHandles4List.get(1)).manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.switchTo().window(windowHandles4List.get(2)).manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.switchTo().window(windowHandles4List.get(0));

	}

}
