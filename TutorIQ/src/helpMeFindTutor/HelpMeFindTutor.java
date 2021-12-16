package helpMeFindTutor;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.tree.DefaultTreeCellEditor.EditorContainer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.buffer.UnpooledByteBufAllocator;

public class HelpMeFindTutor {

	public void findTutor(WebDriver driver) {
		
		
		
		//	date(driver);

		studentName(driver);

		contactNumber(driver);

		whatsAppNumber(driver);

		selectStudents(driver);

		studentGender(driver);

		selectBoard(driver);

		gradeAndSubject(driver);

		institues(driver);

		country(driver);

		teacherGender(driver);

		tutorChannel(driver);
		
//		tutorSpeciality(driver);
//		
//		tutorExperience(driver);
//		
//		tutorAge(driver);
//		
//		teachingDuration(driver);
//
//		minFee(driver);
//		
//		maxFee(driver);
		
		applyForTutor(driver);

	}

	private void date(WebDriver driver) {

		driver.findElement(By.cssSelector("#datepicker")).click();

		sleep(2000);

		driver.findElement(By.cssSelector(".active.day")).click();

	}

	private  void validateDate(WebDriver driver) {

		WebElement ele = driver.findElement(By.cssSelector("#datepicker"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if ((Boolean)js.executeScript("return arguments[0].checkValidity();", ele).equals(false)) {

			selectStudents(driver);

			applyForTutor(driver);
		}

	}



	private void studentName(WebDriver driver) {

//		String name = driver.findElement(By.id("contact_person")).getAttribute("value");
//
//		if (name.isEmpty()) {
//
//			driver.findElement(By.id("contact_person")).sendKeys("Raza Ahmad");
//		}
		
		driver.findElement(By.id("contact_person")).clear();
		
		sleep(1500);
	}

	private  void validateStudentName(WebDriver driver) {

		WebElement ele = driver.findElement(By.id("contact_person"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if ((Boolean)js.executeScript("return arguments[0].checkValidity();", ele).equals(false)) {

			selectStudents(driver);

			applyForTutor(driver);
		}

	}

	private void contactNumber(WebDriver driver) {

		String name = driver.findElement(By.id("contact_no")).getAttribute("value");

		if (name.isEmpty()) {

			driver.findElement(By.id("contact_no")).sendKeys(mobileNumber());
		}
		else {
			
			driver.findElement(By.id("contact_no")).clear();
			
			driver.findElement(By.id("contact_no")).sendKeys(mobileNumber());
		}
		sleep(1500);
	}

	private  void validateContactNumber(WebDriver driver) {

		WebElement ele = driver.findElement(By.id("contact_no"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if ((Boolean)js.executeScript("return arguments[0].checkValidity();", ele).equals(false)) {

			selectStudents(driver);

			applyForTutor(driver);
		}

	}

	private void whatsAppNumber(WebDriver driver) {

		sleep(2000);

		if (driver.findElement(By.id("contact_no2")).getAttribute("value") == "") {

			driver.findElement(By.id("contact_no2")).sendKeys(mobileNumber());
		}
		else {

			driver.findElement(By.id("contact_no2")).clear();

			driver.findElement(By.id("contact_no2")).sendKeys(mobileNumber());
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

	private  void validateSelectStudent(WebDriver driver) {

		WebElement ele = driver.findElement(By.xpath("//select[@id='no_of_students']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if ((Boolean)js.executeScript("return arguments[0].checkValidity();", ele).equals(false)) {

			selectStudents(driver);

			applyForTutor(driver);
		}

	}

	private void studentGender(WebDriver driver) {

		WebElement dropDown = driver.findElement(By.xpath("//select[@id='student_gender']"));

		Select dd = new Select(dropDown);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(1, list.size());

		dd.selectByIndex(randomNum);

		sleep(1500);
	}

	private  void validateStudentGender(WebDriver driver) {

		WebElement ele = driver.findElement(By.xpath("//select[@id='student_gender']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if ((Boolean)js.executeScript("return arguments[0].checkValidity();", ele).equals(false)) {

			studentGender(driver);

			applyForTutor(driver);
		}

	}


	private void selectBoard(WebDriver driver) {

		WebElement dropDown = driver.findElement(By.xpath("//select[@id='board']"));

		Select dd = new Select(dropDown);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(1, list.size());

		dd.selectByIndex(randomNum);

		sleep(1500);
	}

	private  void validateSelectBoard(WebDriver driver) {

		WebElement ele = driver.findElement(By.xpath("//select[@id='board']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if ((Boolean)js.executeScript("return arguments[0].checkValidity();", ele).equals(false)) {

			selectBoard(driver);

			applyForTutor(driver);
		} 

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

	private  void validateGradeAndSubject(WebDriver driver) {

		WebElement ele = driver.findElement(By.id("csm"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if ((Boolean)js.executeScript("return arguments[0].checkValidity();", ele).equals(false)) {

			gradeAndSubject(driver);

			applyForTutor(driver);
		}

	}

	private void institues(WebDriver driver) {


		WebElement insitutesSelected = driver.findElement(By.xpath("//ul[@class='select2-selection__rendered']/ancestor::div[@class='col-md-6']"));

		List<WebElement> insitutesSelectedList = insitutesSelected.findElements(By.tagName("li"));

		if (insitutesSelectedList.size() == 1) {



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



			WebElement element = driver.findElement(By.id("institutes"));

			Select dd = new Select(element);

			List<WebElement> list = dd.getOptions();


			int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());

			dd.deselectByIndex(randomNum);
		}


	}

	private void teacherGender(WebDriver driver) {

		WebElement element = driver.findElement(By.id("teacher_gender"));

		Select dd = new Select(element);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(1, list.size());

		dd.selectByIndex(randomNum);

		sleep(400);
	}

	private  void validateTeacherGender(WebDriver driver) {

		WebElement ele = driver.findElement(By.id("teacher_gender"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if ((Boolean)js.executeScript("return arguments[0].checkValidity();", ele).equals(false)) {

			teacherGender(driver);

			applyForTutor(driver);
		}

	}

	private void tutorChannel(WebDriver driver) {

		WebElement element = driver.findElement(By.id("suitable_timings"));

		Select dd = new Select(element);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(1, list.size());

		dd.selectByIndex(randomNum);

		sleep(400);
	}

	private  void validateTutorChannel(WebDriver driver) {

		WebElement ele = driver.findElement(By.id("suitable_timings"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if ((Boolean)js.executeScript("return arguments[0].checkValidity();", ele).equals(false)) {

			tutorChannel(driver);

			applyForTutor(driver);
		}

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

		}
		else {

			driver.findElement(By.xpath("//input[@tabindex='0']")).sendKeys("Pak");

			WebElement element = driver.findElement(By.xpath("//ul[@id='select2-country-results']"));

			List<WebElement> list = element.findElements(By.tagName("li"));

			for (WebElement li : list) {


				if (li.getText().equalsIgnoreCase("Pakistan")) {

					li.click();

					sleep(500);
					
					city(driver);
					
					sleep(500);

					location(driver);
				}
			}
		}
		sleep(400);
	}

	private  void validateCountry(WebDriver driver) {



		WebElement ele = driver.findElement(By.id("country"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if ((Boolean)js.executeScript("return arguments[0].checkValidity();", ele).equals(false)) {

			country(driver);

			applyForTutor(driver);
		}

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

	private  void validateCity(WebDriver driver) {

		WebElement ele = driver.findElement(By.id("city"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if ((Boolean)js.executeScript("return arguments[0].checkValidity();", ele).equals(false)) {

			city(driver);

			applyForTutor(driver);
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

	private  void validateLocation(WebDriver driver) {

		WebElement ele = driver.findElement(By.id("location"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if ((Boolean)js.executeScript("return arguments[0].checkValidity();", ele).equals(false)) {

			location(driver);

			applyForTutor(driver);
		}

	}

	private void tutorSpeciality(WebDriver driver) {

		WebElement dropDown = driver.findElement(By.xpath("//select[@id='note']"));

		Select dd = new Select(dropDown);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(1, list.size());

		dd.selectByIndex(randomNum);

		sleep(1500);
	}

	private void tutorExperience(WebDriver driver) {

		WebElement dropDown = driver.findElement(By.xpath("//select[@id='experience']"));

		Select dd = new Select(dropDown);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(1, list.size());

		dd.selectByIndex(randomNum);

		sleep(1500);
	}

	private void tutorAge(WebDriver driver) {

		WebElement dropDown = driver.findElement(By.xpath("//select[@id='teacher_age']"));

		Select dd = new Select(dropDown);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(1, list.size());

		dd.selectByIndex(randomNum);

		sleep(1500);
	}

	private void teachingDuration(WebDriver driver) {

		WebElement dropDown = driver.findElement(By.xpath("//select[@id='teaching_duration']"));

		Select dd = new Select(dropDown);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(1, list.size());

		dd.selectByIndex(randomNum);

		sleep(1500);
	}

	private void minFee(WebDriver driver) {

		int randomNum = ThreadLocalRandom.current().nextInt(1, 3);

		if (randomNum == 1) {
			driver.findElement(By.xpath("//span[@id='select2-tuition_fee-container']")).click();

			sleep(400);

			driver.findElement(By.xpath("//input[@tabindex='0']")).sendKeys("5");

			WebElement element = driver.findElement(By.xpath("//ul[@id='select2-tuition_fee-results']"));

			List<WebElement> list = element.findElements(By.tagName("li"));

			int num = ThreadLocalRandom.current().nextInt(0, list.size());

			list.get(num).click();

		}
		else {
			
			WebElement dropDown = driver.findElement(By.xpath("//select[@id='tuition_fee']"));

			Select dd = new Select(dropDown);

			List<WebElement> list = dd.getOptions();

			int num = ThreadLocalRandom.current().nextInt(1, list.size());

			dd.selectByIndex(num);
		}


		sleep(1500);
	}

	private void maxFee(WebDriver driver) {

		int randomNum = ThreadLocalRandom.current().nextInt(1, 3);

		if (randomNum == 1) {
			driver.findElement(By.xpath("//span[@id='select2-tuition_max_fee-container']")).click();

			sleep(400);

			driver.findElement(By.xpath("//input[@tabindex='0']")).sendKeys("5");

			WebElement element = driver.findElement(By.xpath("//ul[@id='select2-tuition_max_fee-results']"));

			List<WebElement> list = element.findElements(By.tagName("li"));

			int num = ThreadLocalRandom.current().nextInt(0, list.size());

			list.get(num).click();

		}
		else {
			
			WebElement dropDown = driver.findElement(By.xpath("//select[@id='tuition_max_fee']"));

			Select dd = new Select(dropDown);

			List<WebElement> list = dd.getOptions();

			int num = ThreadLocalRandom.current().nextInt(1, list.size());

			dd.selectByIndex(num);
		}


		sleep(1500);
	}

	private void applyForTutor(WebDriver driver) {

//		if (message == null) {
//			 
//			validateDate(driver);
//
//			validateStudentName(driver);
//
//			validateContactNumber(driver);
//
//			validateSelectStudent(driver); 
//
//			validateStudentGender(driver);
//
//			validateSelectBoard(driver);
//
//			validateGradeAndSubject(driver);
//
//			validateTeacherGender(driver);
//
//			validateTutorChannel(driver);
//
//			validateCountry(driver);
//
//			validateCity(driver);
//
//			validateLocation(driver);
//			
//		}

	}
	
	private static void sleep(int i) {

		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String mobileNumber() {

		String countryCode = "+92";

		int code =  ThreadLocalRandom.current().nextInt(300, 349);

		String mobileCode = String.valueOf(code);

		int number = ThreadLocalRandom.current().nextInt(0000001, 9999999);

		String mainNumber = String.valueOf(number);

		String mobileNumberString = countryCode + mobileCode + mainNumber;

		return mobileNumberString;
	}

}
