package extraWork;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DelegateFileFilter;

public class ScreenShotExample {
	
	public void takeScreenShot(WebDriver driver) throws IOException {
		
		driver.get("https://www.espncricinfo.com/");
		
		File scrShot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File destFile = new File("F:\\Projects\\ScreenShot\\dinka.png");
		
		FileUtils.copyFile(scrShot, destFile);
		
		//take screen shot of a webElement 
		
		WebElement element = driver.findElement(By.cssSelector(".featured-scoreboard.slick-slider-container"));
		
		File temp = element.getScreenshotAs(OutputType.FILE);
		
		destFile = new File("F:\\Projects\\ScreenShot\\chika.png");
		
		FileUtils.copyFile(temp, destFile);
		
		//getting the dimension of the web element
		
		System.out.println(element.getRect().getDimension().getHeight());
		
		System.out.println(element.getRect().getDimension().getWidth());
	}
	
	
}
