package extraWork;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HoverAndActionOfMouse {

	
	@Test
	public void example(WebDriver driver) {
		
		driver.get("https://prezentar.net/Welcome");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("txtmail")).sendKeys("razalion903@gmail.com");
		
		driver.findElement(By.id("txtpasscord")).sendKeys("123456");
		
		driver.findElement(By.id("btnsubmit")).click();
		
		driver.findElement(By.xpath("//a[.='Templates']")).click();
		
		WebElement element = driver.findElement(By.xpath("//div[@class='tab-r-wrapper admin_templates_list custom-scroll']"));
		
		List<WebElement> list = element.findElements(By.xpath("//div[@class='tab-right-list  ']"));
		
		System.out.println(list.size());
		
		Actions act = new Actions(driver);
		
		act.moveToElement(list.get(2)).build().perform();
		
		act.click(list.get(2).findElement(By.cssSelector("div a i"))).build().perform();
		
		
	}
}
