package extraWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriverBuilder;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

import org.openqa.selenium.By;

public class RelativeLocators {
	
	public void locatorExample(WebDriver driver) throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		Thread.sleep(3000);
		
		WebElement element = driver.findElement(By.cssSelector("[name = 'name']"));
		
		String textString = driver.findElement(with(By.tagName("label")).above(element)).getText();
		
		System.out.println(textString); 
		
		WebElement ele = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		
		 driver.findElement(with(By.tagName("input")).below(ele)).click();
		
		
	}

}
 