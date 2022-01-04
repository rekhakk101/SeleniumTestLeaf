package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4_Button {
	
	static String buttonlink = "//h5[text()='Button']/following-sibling::img[@alt='Buttons']";

	public static void main(String[] args) {
		
		//Launch browser and url
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		
		//Click button to travel home page
		driver.findElement(By.id("home")).click();
		System.out.println("Click operation is working");
		driver.findElement(By.xpath(buttonlink)).click();
		
		//Find position of button (x,y)
		WebElement buttonToFindLocation = driver.findElement(By.id("position"));
		Point cordinates = buttonToFindLocation.getLocation();
		int xcordinate = cordinates.getX();
		int ycordinate = cordinates.getY();
		System.out.println("Cordinates of the 'Get Position' button are below");
		System.out.println("X Cordinate is: "+xcordinate);
		System.out.println("Y Cordinate is: "+ycordinate);
		
		//Find button color
		WebElement buttonToFindColor = driver.findElement(By.id("color"));
		String backgroundColor = buttonToFindColor.getAttribute("style");
		System.out.println(backgroundColor);
		
		//Find the height and width
		WebElement buttonToFindSize = driver.findElement(By.id("size"));
		int height = buttonToFindSize.getSize().getHeight();
		int width = buttonToFindSize.getSize().getWidth();
		System.out.println("Height: "+height+"    Width: "+width);
		
	}

}
