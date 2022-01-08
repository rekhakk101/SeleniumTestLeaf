package week2.day2;

import java.util.List;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DailyQnA_IRCTC_dd {
	
	static int i = 0;

	public static void main(String[] args) {
		
		//select country dropdown value from IRCTC website that starts with E but the second match
		// Launch browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();

		// load url
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");

		// implicitwait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Identify the element and store
		WebElement element=driver.findElement(By.id("userRegistrationForm:nationalityId"));

		// create an object using Select class for an webelement 
		Select dropdown=new Select(element);

		// get collection of webelement and store it in list
		List<WebElement> options = dropdown.getOptions();

		//iterations through each webElement based on condection
		for (WebElement eachoption : options) {
			if (eachoption.getText().startsWith("E")) {
				i++;
				if (i==2) {
					System.out.println(eachoption.getText());
					eachoption.click();
					break;
				}
			}
		}

		//close browser
		driver.close();

	}

}
