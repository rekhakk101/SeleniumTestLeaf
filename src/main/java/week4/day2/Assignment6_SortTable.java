package week4.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment6_SortTable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
//		1. Get all values of Name , store in a List and sort
		driver.get("http://www.leafground.com/pages/sorttable.html");
		List<WebElement> names = driver.findElements(By.xpath("//table[@id='table_id']/tbody/tr/td[2]"));
		List<String> namesList = new ArrayList<String>();
		for (WebElement eachname : names) {
			namesList.add(eachname.getText());
		}
		Collections.sort(namesList);
		System.out.println(namesList);
		
//		2. Click on the Name header
		driver.findElement(By.xpath("//th[text()='Name']")).click();
		
//		3. Again get all values and store in a list
		List<WebElement> names1 = driver.findElements(By.xpath("//table[@id='table_id']/tbody/tr/td[2]"));
		List<String> namesList1 = new ArrayList<String>();
		for (WebElement eachname : names1) {
			namesList1.add(eachname.getText());
		}
		System.out.println(namesList1);
		
//		4. Compare both the list
		if(namesList.equals(namesList1)) {
			System.out.println("List items are same");
		}else {
			System.out.println("error!");
		}

	}

}
