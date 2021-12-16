package extraWork;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverLogLevel;
import org.openqa.selenium.interactions.Actions;

public class FrameWithDragDrop {
	
	public void frameWork(WebDriver driver) {
		
		driver.get("https://jqueryui.com/droppable/");
		
		/*if we want to get the frames in the whole page then we can use these lines
		and if we want to switch between the frame we can use index number of frame
		 
		List<WebElement> list = driver.findElements(By.tagName("iframe"));
		
		System.out.println(list.size());
		
		driver.switchTo().frame(0); 
		
		*/
		
		//if you want to access the frame by webElement 
		
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		
		
		Actions act = new Actions(driver);
		
		WebElement source = driver.findElement(By.id("draggable"));
		
		WebElement target = driver.findElement(By.id("droppable"));
		
		act.dragAndDrop(source, target).build().perform();
		
		driver.switchTo().defaultContent();
		
		
		
	}

}
