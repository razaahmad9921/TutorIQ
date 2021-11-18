import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchTutor {

	public void clearFilter(WebDriver driver) {

		driver.findElement(By.xpath("//div[@class='filter']/child::button")).click();
	}

	public void searchByGender(WebDriver driver) {

		driver.findElement(By.xpath("//span[@id='select2-gender_id-container']")).click();

		WebElement element = driver.findElement(By.cssSelector("ul.select2-results__options"));

		List<WebElement> list = element.findElements(By.tagName("li"));

		int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());

		sleep(1500);

		list.get(randomNum).click();

	}

	public void searchByBoard(WebDriver driver) {

		System.out.println("dinka");
		
		driver.findElement(By.xpath("//input[@placeholder='Select Categories']")).click();

		WebElement element = driver.findElement(By.xpath("//ul[@id='select2-categories-results']"));

		List<WebElement> list = element.findElements(By.tagName("li"));

		int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());

		list.get(randomNum).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Select Categories']")).click();
		
		randomNum = ThreadLocalRandom.current().nextInt(0, list.size());
		
		list.get(randomNum).click();
		
		sleep(4500);

	}
	
	public void clickSearchButton(WebDriver driver) {
		
		driver.findElement(By.cssSelector("div.button-hold")).click();

		sleep(8000);
	}
	private static void sleep(int i) {

		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
