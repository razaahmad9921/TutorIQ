import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FavoriteTutor {

	public void  getAllFavoriteTutor(WebDriver driver) {

		driver.findElement(By.xpath("/html/body/header/nav/div/ul/li[4]/a")).click();

		sleep(6000);

		//Assert.assertEquals(driver.findElement(By.xpath("/html/body/section/div/div/div/div")).getText(), "No Record found for favorite tutors");

		WebElement element = driver.findElement(By.className("col-xl-8"));

		List<WebElement> list = element.findElements(By.className("teacher-listing-box"));

		//clickThroughProfilePicture(list, driver);
		
		//clickThroughTeacherName(list, driver);
		
		clickThroughViewButton(list, driver);
	}

	public void clickThroughProfilePicture( List <WebElement> list, WebDriver driver ) {

		if (list.size() == 1) {

			list.get(0).findElement(By.cssSelector("img.teacher-photo")).click();
		}
		else if (list.size() >= 2) {

			int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());

			list.get(randomNum).findElement(By.cssSelector("img.teacher-photo")).click();

			switchWindows(driver);

		}
		else {

			if(driver.findElement(By.xpath("/html/body/section/div/div/div/div")).getText().equals("No Record found for favorite tutors.")) {

				sleep(1500);

				driver.navigate().back();
			}

		}
	}

	public void clickThroughTeacherName( List <WebElement> list, WebDriver driver ) {

		if (list.size() == 1) {

			list.get(0).findElement(By.cssSelector("a.no-style")).click();
		}
		else if (list.size() >= 2) {

			int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());
			
			System.out.println(randomNum);

			list.get(randomNum).findElement(By.cssSelector("a.no-style")).click();

			switchWindows(driver);

		}
		else {

			if(driver.findElement(By.xpath("/html/body/section/div/div/div/div")).getText().equals("No Record found for favorite tutors.")) {

				sleep(1500);

				driver.navigate().back();
			}

		}
	}
	
	public void clickThroughViewButton( List <WebElement> list, WebDriver driver ) {

		if (list.size() == 1) {

			list.get(0).findElement(By.cssSelector("a.btn")).click();
		}
		else if (list.size() >= 2) {

			int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());
			
			System.out.println(randomNum);

			list.get(randomNum).findElement(By.cssSelector("a.btn")).click();

			switchWindows(driver);

		}
		else {

			if(driver.findElement(By.xpath("/html/body/section/div/div/div/div")).getText().equals("No Record found for favorite tutors.")) {

				sleep(1500);

				driver.navigate().back();
			}

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
