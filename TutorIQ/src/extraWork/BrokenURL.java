package extraWork;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class BrokenURL {

	public void brokenURL(WebDriver driver) throws MalformedURLException, IOException {
		
		SoftAssert objAssert = new SoftAssert();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		
		WebElement element = footer.findElement(By.xpath("//table[@class='gf-t']/tbody/tr"));
		
		List <WebElement> list = element.findElements(By.tagName("a"));
		
		System.out.println(list.size());
		
		for (int i = 0; i < list.size(); i++) {
			
			String urlString = list.get(i).getAttribute("href");
			
			HttpURLConnection connection = (HttpURLConnection) new URL(urlString).openConnection();
			
			connection.setRequestMethod("HEAD");
			
			connection.connect();
			
			int code = connection.getResponseCode();
			
			objAssert.assertTrue(code<301, "Test is passed");
			
			System.out.println(code);
		}
		
		objAssert.assertAll();
		
	}
}
