package tutorForMe;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StudentProfile.StudentProfile;
import net.bytebuddy.description.ModifierReviewable.OfAbstraction;

public class TutorForMe {
	
	public void listOfAvailableTeacher(WebDriver driver) {
		
		String fullMessage = driver.findElement(By.cssSelector("div[class$='alert alert-info page-message'] p")).getText();
		
		String [] arrMessage = fullMessage.split("[.]");
		
		String actualMessage = arrMessage[0];
		
		String message = "No record found based on your saved preferences";
		
		
		if (actualMessage.equalsIgnoreCase(message)) {
			
			driver.findElement(By.xpath("//a[@class='btn btn-sm btn-warning btn-profile-link']")).click();
			
			 StudentProfile  objProfile = new  StudentProfile();
			 
			 //objProfile.editProfile(driver);
		}
		else {
			
			
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='main-box box teacher-listing-box']"));
				
			//clickThroughProfilePicture(list, driver);
			
			clickThroughTeacherName(list, driver);
		
		}
	}
	
	public void clickThroughProfilePicture( List <WebElement> list, WebDriver driver ) {

		if (list.size() == 1) {

			list.get(0).findElement(By.cssSelector("img.teacher-photo")).click();
		}
		else  {

			int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());

			list.get(randomNum).findElement(By.cssSelector("img.teacher-photo")).click();

			switchWindows(driver);

		}
	
	}

	public void clickThroughTeacherName( List <WebElement> list, WebDriver driver ) {

		if (list.size() == 1) {

			list.get(0).findElement(By.cssSelector("a.no-style")).click();
		}
		else  {

			int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());
			
			System.out.println(randomNum);

			list.get(randomNum).findElement(By.cssSelector("a.no-style")).click();

			switchWindows(driver);

		}

	}
	
	public void clickThroughViewButton( List <WebElement> list, WebDriver driver ) {

		if (list.size() == 1) {

			list.get(0).findElement(By.cssSelector("a.btn")).click();
		}
		else  {

			int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());
			
			list.get(randomNum).findElement(By.cssSelector("a.btn")).click();

			switchWindows(driver);

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
