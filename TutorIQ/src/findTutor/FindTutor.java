package findTutor;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindTutor {

	public void openAllTabs(WebDriver driver) {
		
	}
	
	public void searchByFee(WebDriver driver) {

		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[1]/div[1]/div")).click();

		WebElement element = driver.findElement(By.xpath("//ul[@id='select2-fee_sort-results']"));

		List<WebElement> list = element.findElements(By.tagName("li"));

		int randomNum = ThreadLocalRandom.current().nextInt(0, list.size() + 1);

		list.get(randomNum).click();

		getListOfAllTutor(driver); 

	}

	public void getListOfAllTutor(WebDriver driver) {

		WebElement element = driver.findElement(By.className("col-xl-6"));

		List<WebElement> list = element.findElements(By.className("teacher-listing-box"));
		
		clickThroughTeacherName(list, driver);

	}

	public void clickThroughProfilePicture( List <WebElement> list, WebDriver driver ) {

		if (list.size() >= 1) {

			int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());

			list.get(randomNum).findElement(By.cssSelector("img.teacher-photo")).click();

			switchWindows(driver);
		}

		else {

			sleep(1500);

			driver.navigate().back();
		}
	}
	public void clickThroughTeacherName( List <WebElement> list, WebDriver driver ) {

//		if (list.size() >= 1) {
//
//			int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());
//
//			System.out.println(randomNum);
//
//			list.get(randomNum).findElement(By.cssSelector("a.no-style")).click();
//
//			switchWindows(driver);
//
//		}
//		else {
//
//			sleep(1500);
//
//			driver.navigate().back();
//
//		}
		
		for (int i = 0; i < list.size(); i++) {
			
			String key = Keys.chord(Keys.LEFT_CONTROL, Keys.ENTER);
			
			list.get(i).findElement(By.cssSelector("a.no-style")).sendKeys(key);
			
			
		}
	}

	public void clickThroughViewButton( List <WebElement> list, WebDriver driver ) {

		if (list.size() >= 1) {

			int randomNum = ThreadLocalRandom.current().nextInt(0, list.size() + 1);



			list.get(randomNum).findElement(By.cssSelector("a.btn")).click();

			switchWindows(driver);

		}
		else {

			sleep(1500);

			driver.navigate().back();

		}
	}

	private static void switchWindows(WebDriver driver) {

		sleep(3000);

		Set<String> tabs = driver.getWindowHandles();

		Iterator<String> it = tabs.iterator();

		String parent = it.next();

		String child = it.next();

		driver.switchTo().window(child);

		driver.close();

		driver.switchTo().window(parent);
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
