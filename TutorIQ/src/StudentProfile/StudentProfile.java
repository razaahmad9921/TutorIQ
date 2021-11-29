package StudentProfile;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.checkerframework.framework.qual.LiteralKind;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudentProfile {


	private String mobileNumber() {

		String countryCode = "+92";

		int code =  ThreadLocalRandom.current().nextInt(300, 349);

		String mobileCode = String.valueOf(code);

		int number = ThreadLocalRandom.current().nextInt(0000000, 9999999);

		String mainNumber = String.valueOf(number);

		String mobileNumberString = countryCode + mobileCode + mainNumber;

		return mobileNumberString;
	}


	public void editProfile(WebDriver driver) {

//		whatsAppNumber(driver);
//
//		selectStudents(driver);
//		
		studentGender(driver);
	
//		selectBoard(driver);
//
//		gradeAndSubject(driver);
//
//		institues(driver);
//
//		teacherGender(driver);
//
//		tutorChannel(driver);
//
//		country(driver);
//
//		address(driver);
//
//		commentsAboutUs(driver);

		updateProfile(driver);
	}

	private void whatsAppNumber(WebDriver driver) {

	

		sleep(2000);

		if (driver.findElement(By.id("whatsapp_no")).getAttribute("value") == "") {

			driver.findElement(By.id("whatsapp_no")).sendKeys(mobileNumber());
		}
		else {

			driver.findElement(By.id("whatsapp_no")).clear();

			driver.findElement(By.id("whatsapp_no")).sendKeys(mobileNumber());
		}


		sleep(1000);
	}

	private void selectStudents(WebDriver driver) {

		WebElement dropDown = driver.findElement(By.xpath("//select[@id='no_of_students']"));

		Select dd = new Select(dropDown);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(1, list.size());

		dd.selectByIndex(randomNum);

		sleep(1500);

	}

	private void studentGender(WebDriver driver) {

		WebElement dropDown = driver.findElement(By.xpath("//select[@id='student_gender']"));

		Select dd = new Select(dropDown);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(1, list.size());

		dd.selectByIndex(0);

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

	private void gradeAndSubject(WebDriver driver) {


		WebElement element = driver.findElement(By.id("csm"));

		Select dd = new Select(element);

		List<WebElement> list = dd.getOptions();

		if (list.size() == 0) {
			
			selectGrade(driver);

			selectSubject(driver);

			sleep(2000);
		}
		else {

			int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());

			sleep(2000);

			dd.deselectByIndex(randomNum);
		}


	}

	private void institues(WebDriver driver) {

		
		WebElement insitutesSelected = driver.findElement(By.xpath("//ul[@class='select2-selection__rendered']/ancestor::div[@class='col-md-6']"));

		List<WebElement> insitutesSelectedList = insitutesSelected.findElements(By.tagName("li"));
		
		for (WebElement element : insitutesSelectedList) {
			
			System.out.println(element.getText());
		}
		
		if (insitutesSelectedList.size() == 1) {
			
			System.out.println("dinka Chika");
			
			WebElement element = driver.findElement(By.id("institutes"));

			Select dd = new Select(element);

			List<WebElement> list = dd.getOptions();
			

			int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());

			dd.selectByIndex(randomNum);

			sleep(400);

			randomNum = ThreadLocalRandom.current().nextInt(0, list.size());

			dd.selectByIndex(randomNum);

			sleep(400);

			randomNum = ThreadLocalRandom.current().nextInt(0, list.size());

			dd.selectByIndex(randomNum);

			sleep(400);
		}
		else {
			
			System.out.println("dinka Chika");
			
			WebElement element = driver.findElement(By.id("institutes"));

			Select dd = new Select(element);

			List<WebElement> list = dd.getOptions();
			
			
			int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());

			dd.deselectByIndex(randomNum);
		}


	}

	private void teacherGender(WebDriver driver) {

		WebElement element = driver.findElement(By.id("tutor_gender"));

		Select dd = new Select(element);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(1, list.size());

		dd.selectByIndex(randomNum);

		sleep(400);
	}

	private void tutorChannel(WebDriver driver) {

		WebElement element = driver.findElement(By.id("tutoring_channel"));

		Select dd = new Select(element);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(1, list.size());

		dd.selectByIndex(randomNum);

		sleep(400);
	}

	private void country(WebDriver driver) {

		driver.findElement(By.xpath("//span[@id='select2-country-container']")).click();

		sleep(400);

		int randomNum = ThreadLocalRandom.current().nextInt(1, 3);

		

		if (randomNum == 1) {

			driver.findElement(By.xpath("//input[@tabindex='0']")).sendKeys("Onl");

			WebElement element = driver.findElement(By.xpath("//ul[@id='select2-country-results']"));

			List<WebElement> list = element.findElements(By.tagName("li"));

			for (WebElement li : list) {

			

				if (li.getText().equalsIgnoreCase("Online")) {

					li.click();

				}
			}

		}else {

			driver.findElement(By.xpath("//input[@tabindex='0']")).sendKeys("Pak");

			WebElement element = driver.findElement(By.xpath("//ul[@id='select2-country-results']"));

			List<WebElement> list = element.findElements(By.tagName("li"));

			for (WebElement li : list) {

				
				if (li.getText().equalsIgnoreCase("Pakistan")) {

					li.click();

					city(driver);

					location(driver);
				}
			}
		}


		sleep(400);
	}

	private void city(WebDriver driver) {

		driver.findElement(By.xpath("//span[@id='select2-city-container']")).click();

		sleep(400);

		driver.findElement(By.xpath("//input[@tabindex='0']")).sendKeys("Lah");

		WebElement element = driver.findElement(By.xpath("//ul[@id='select2-city-results']"));

		List<WebElement> list = element.findElements(By.tagName("li"));

		for (WebElement li : list) {

			if (li.getText().equals("Lahore")) {

				li.click();
			}
		}


	}

	private static void location(WebDriver driver) {


		int toss = ThreadLocalRandom.current().nextInt(1, 3);

		if (toss == 1) {

			WebElement element = driver.findElement(By.id("location"));

			Select dd = new Select(element);

			List <WebElement> list = dd.getOptions();

			int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());

			dd.selectByIndex(randomNum);

		}
		else {

			driver.findElement(By.xpath("//span[@id ='select2-location-container']")).click();

			driver.findElement(By.cssSelector("input.select2-search__field[tabindex='0']")).sendKeys("shad");

			WebElement element = driver.findElement(By.xpath("//ul[@id='select2-location-results']"));

			List<WebElement> list = element.findElements(By.tagName("li"));

			for (WebElement li : list) {

				if (li.getText().equalsIgnoreCase("shadbagh")) {

					li.click();

					break;
				}
			}
		}

		sleep(2000);
	}

	private void updateProfile(WebDriver driver) {

		driver.findElement(By.id("update_student_profile")).click();
		
		sleep(500); 
		
		WebElement ele = driver.findElement(By.id("whatsapp_no"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
        
		Boolean isValidInput = (Boolean)js.executeScript("return arguments[0].checkValidity();", ele);
		System.out.println(isValidInput);
		String validationMessage = (String)js.executeScript("return arguments[0].validationMessage;", ele);
		System.out.println(validationMessage);
		
	
	}

	private static void address(WebDriver driver) {

		if (driver.findElement(By.xpath("//textarea[@id='address']")).getAttribute("value") == "") {

			driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys("House # 32 A/B Dilawar Road Chah Miran, Lahore");

		}
		else {

			driver.findElement(By.xpath("//textarea[@id='address']")).clear();

			driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys("House # 32 A/B Dilawar Road Chah Miran, Lahore");
		}


		sleep(2000);
	}



	private static void commentsAboutUs(WebDriver driver) {

		if (driver.findElement(By.xpath("//textarea[@id='comments']")).getAttribute("value") == "") {

			driver.findElement(By.xpath("//textarea[@id='comments']")).sendKeys("Bohat e chawal web banwai hai");

		}
		else {

			driver.findElement(By.xpath("//textarea[@id='comments']")).clear();

			driver.findElement(By.xpath("//textarea[@id='comments']")).sendKeys("Bohat e chawal web banwai hai");
		}

		sleep(2000);

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
