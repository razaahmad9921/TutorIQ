package extraWork;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;

public class GettingLinksInWebPage {
	
	public void getAllLinks(WebDriver driver) {
		
		//getting all links in the page
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> element = driver.findElements(By.tagName("a"));
		
		System.out.println("links in the page:" + element.size());
		
		/* if we want to know the links count in a specific webelement 
		 for that we have to make subset of the main webdriver whose scope is
		 limited to the specific web element 
		 */
		 
	
		
	}
}
