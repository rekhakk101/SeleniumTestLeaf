package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Classroom1_erailScenario {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
//		1. Navigate to erail.in
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		
//		2. Enter From station as MS
		WebElement from = driver.findElement(By.id("txtStationFrom"));
		from.clear();
		from.sendKeys("MS",Keys.ENTER);
		
//		3. Enter To Station as MDU
		WebElement to = driver.findElement(By.id("txtStationTo"));
		to.clear();
		to.sendKeys("MDU",Keys.ENTER);
		
//		4. Uncheck Sort on Date Checkbox
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
//		5. Get all Train Names and verify there are no duplicates
		List<WebElement> trainNames = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr/td[2]/a"));
		List<String> names = new ArrayList<String>();
		for(int i=0; i<trainNames.size(); i++) {
			String text = trainNames.get(i).getText();
			names.add(text);
		}
		System.out.println(names);
		Set<String> namesSet =new LinkedHashSet<String>(names);
		if(names.size()==namesSet.size()){
			System.out.println("There are no dulpicate train names");
		}else {
			System.out.println("There are dulpicate train names");
		}
	}

}
