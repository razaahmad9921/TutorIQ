package extraWork;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;

public class GettingLinksInWebPage {
	
	public void getAllLinks(WebDriver driver) throws InterruptedException {
		 
		//getting all links in the page
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> tempElements = driver.findElements(By.tagName("a"));
		 
		System.out.println("links in the page:" + tempElements.size());
		
		/* if we want to know the links count in a specific webelement  
		 for that we have to make subset of the main webdriver whose scope is
		 limited to the specific web element 
		 */
		 
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		
		WebElement element = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		System.out.println(element.findElements(By.tagName("a")).size());
		
		for(int i = 1; i < element.findElements(By.tagName("a")).size(); i++) {
			
			String keyString = Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			System.out.println(element.findElements(By.tagName("a")).get(i).getText());
			
			element.findElements(By.tagName("a")).get(i).sendKeys(keyString);

		}
		
		Set <String> windowSet = driver.getWindowHandles();
		
		Iterator<String> iterator = windowSet.iterator();
		
		while (iterator.hasNext()) {
			
			driver.switchTo().window(iterator.next());
			
		}
	}
}
