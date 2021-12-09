package extraWork;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class ScreenShotExample {
	
	public void takeScreenShot(WebDriver driver) throws IOException {
		
		driver.get("https://www.espncricinfo.com/");
		
		File scrShot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File destFile = new File("F:\\Projects\\ScreenShot\\dinka.png");
		
		FileUtils.copyFile(scrShot, destFile);
	}

}
