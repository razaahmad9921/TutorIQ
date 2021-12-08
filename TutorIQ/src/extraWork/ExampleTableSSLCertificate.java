package extraWork;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExampleTableSSLCertificate {

	//this is my code 
	public void getDataForthColoumn(WebDriver driver) {

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		

		WebElement element = driver.findElement(By.xpath("//div[@class='tableFixHead']/table/tbody"));
		
		List <WebElement> list = element.findElements(By.tagName("tr"));
		
		System.out.println(list.size());
		
		for(int i = 0; i < list.size(); i++) {
			
			System.out.println(list.get(i).findElement(By.cssSelector("td:nth-child(4)")).getText());
		}
	}
	

	
	//this is rahul Shetty
	public void getDataForthColoumnRahul(WebDriver driver) {

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		jse.executeScript("window.scrollBy(0,500)");
		
		jse.executeScript("document.querySelector('.tableFixHead').scrollBy(0,500)");
		
		List <WebElement> list = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
	
		
		int sum = 0;
		
		for(int i = 0; i < list.size(); i++) {
			
			sum = sum + Integer.parseInt(list.get(i).getText());
			
			System.out.println(sum);
		}
	}
}
