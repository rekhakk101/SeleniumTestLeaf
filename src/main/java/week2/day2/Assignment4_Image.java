package week2.day2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4_Image {

	public static void main(String[] args) throws IOException {
		
		//Launch browser and url
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		
		//Click on this image to go home page
		String image1 = "//label[text()='Click on this image to go home page']/following-sibling::img";
		driver.findElement(By.xpath(image1)).click();
		String homePageTitle = "TestLeaf - Selenium Playground";
		if(driver.getTitle().equalsIgnoreCase(homePageTitle)) {
			System.out.println("Home page loaded successfully");
		}else {
			System.out.println("Failed to open Home page");
		}
		driver.navigate().back();
		
		//Am I Broken Image?
		List<WebElement> allImages = driver.findElements(By.tagName("img"));
		for (int i=0;i<allImages.size();i++) {
			String url = allImages.get(i).getAttribute("src"); 
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection(); 
			con.setRequestMethod("GET"); 
			if (String.valueOf(con.getResponseCode()).equals("200")){ 
				System.out.println("Image @ url " + url + " exists at server"); 
			}else {
				System.out.println("Image @ url " + url + " does not exists at server"); 
			}
				
		}
		
		
		//Click me using Keyboard or Mouse
		String image3 = "//label[text()='Click me using Keyboard or Mouse']/following-sibling::img";
		driver.findElement(By.xpath(image3)).click();
		System.out.println("Home page loaded successfully");
		

	}

}
