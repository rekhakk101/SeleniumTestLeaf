package week2.day2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4_Link {
	
	static String hyperlink = "//h5[text()='HyperLink']/following-sibling::img";
	static String goToHomeHyperlink = "//label[text()='(Interact with same link name)']/preceding-sibling::a";

	public static void main(String[] args) throws IOException {
		
		//Launch browser and url
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://leafground.com/pages/Link.html");
			driver.manage().window().maximize();
				
		//Go to Home Page link validation
			driver.findElement(By.linkText("Go to Home Page")).click();
			String actualtitle = "TestLeaf - Selenium Playground";
			if(actualtitle.equalsIgnoreCase(driver.getTitle())) {
				System.out.println("Successfully launched the Home Page");
			}else {
				System.out.println("Issues in loading the page");
			}
			driver.findElement(By.xpath(hyperlink)).click();
			
		//Find where am supposed to go without clicking me?
			
		
		//Verify am I broken?			
			WebElement brokenLink = driver.findElement(By.linkText("Verify am I broken?"));
			String url = brokenLink.getAttribute("href");
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			if(String.valueOf(con.getResponseCode()).equals("200")) {
				System.out.println("Link @ url "+url+" exists at server");
			}else {
				System.out.println("Link @ url "+url+" doesn't exists at server");
			}
			
			
		//Go to Home Page (Interact with same link name)
			driver.findElement(By.xpath(goToHomeHyperlink)).click();
			driver.findElement(By.xpath(hyperlink)).click();
			System.out.println("Interacted with same link and came back to Play with links page");
			
		//How many links are available in this page?
			driver.findElement(By.linkText("How many links are available in this page?")).click();
			int size = driver.findElements(By.tagName("a")).size();
			System.out.println("Number of links in the page: "+size);
			

	}

}
