package StudentProfile;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.checkerframework.framework.qual.LiteralKind;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

public class StudentProfile {


	private String mobileNumber() {

		String countryCode = "+92";

		int code =  ThreadLocalRandom.current().nextInt(300, 349);

		String mobileCode = String.valueOf(code);

		int number = ThreadLocalRandom.current().nextInt(0000000, 9999999);

		String mainNumber = String.valueOf(number);

		String mobileNumberString = countryCode + mobileCode + mainNumber;

		System.out.println(mobileNumberString);

		return mobileNumberString;
	}


	public void editProfile(WebDriver driver) {

		driver.findElement(By.id("whatsapp_no")).sendKeys(mobileNumber());

		sleep(1000);

//		selectStudents(driver);
//		
//		selectGender(driver);
		
//		selectBoard(driver);
		
		selectGrade(driver);
		
		selectSubject(driver);
		
		sleep(2000);
		
		gradeAndSubject(driver);
	}

	private void selectStudents(WebDriver driver) {

		WebElement dropDown = driver.findElement(By.xpath("//select[@id='no_of_students']"));

		Select dd = new Select(dropDown);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(1, list.size());

		dd.selectByIndex(randomNum);

		sleep(1500);
		
	}

	private void selectGender(WebDriver driver) {

		WebElement dropDown = driver.findElement(By.xpath("//select[@id='student_gender']"));

		Select dd = new Select(dropDown);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(1, list.size());

		dd.selectByIndex(randomNum);

		sleep(1500);
	}

	private void selectBoard(WebDriver driver) {

		WebElement dropDown = driver.findElement(By.xpath("//select[@id='board']"));

		Select dd = new Select(dropDown);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(1, list.size());

		dd.selectByIndex(randomNum);

		sleep(1500);
	}
	
	private void selectGrade(WebDriver driver) {

		WebElement dropDown = driver.findElement(By.xpath("//select[@id='grade']"));

		Select dd = new Select(dropDown);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(1, list.size());

		dd.selectByIndex(randomNum);

		sleep(2500);
	}
	
	private void selectSubject(WebDriver driver) {

		WebElement dropDown = driver.findElement(By.xpath("//div[@id='subjects']"));


		List<WebElement> list = dropDown.findElements(By.tagName("div"));

		int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());
		
		System.out.println("listSize:" + list.size());
		
		if (randomNum == 0) {
			
			list.get(0).findElement(By.id("subjects_sac")).click();
			
		}
		else {
			
			int i = 1;
			
			while(i <= randomNum) {
				
				list.get(i).findElement(By.id("subjects")).click();
				i++;
				sleep(400);
			}
		}

		sleep(1500);
		
		driver.findElement(By.cssSelector("div button[id$='add_grade_sub']")).click();
	}
	
	public void gradeAndSubject(WebDriver driver) {
		
	//	driver.findElement(By.xpath("//div[@class='grade_list']//span[@role='combobox']']")).click();
		
		WebElement element = driver.findElement(By.id("csm"));
		
		Select dd = new Select(element);
		
		List<WebElement> list = dd.getOptions();
	
		int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());
	
		System.out.println("listSize:" + list.size());
		
		sleep(2000);
		
		dd.deselectByIndex(randomNum);
		
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
