package findTutor;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchTutorInFindTutor {


	public void searchByEachField(WebDriver driver) {

		searchByGender(driver);

		clickSearchButton(driver);

		sleep(4500);

		clearFilter(driver);

		searchByBoard(driver);

		clickSearchButton(driver);

		sleep(4500);

		clearFilter(driver);

		searchByClass(driver);

		clickSearchButton(driver);

		sleep(4500);

		clearFilter(driver);

		searchBySubject(driver);

		clickSearchButton(driver);

		sleep(4500);

		clearFilter(driver);

		searchByMinimumFee(driver);

		clickSearchButton(driver);

		sleep(4500);

		clearFilter(driver);

		searchByMaximumFee(driver);

		clickSearchButton(driver);

		sleep(4500);

		clearFilter(driver);

		searchByInstitutes(driver);

		clickSearchButton(driver);

		sleep(4500);

		clearFilter(driver);

		searchByExperience(driver);

		clickSearchButton(driver);

		sleep(4500);

		clearFilter(driver);

		searchByAge(driver);

		clickSearchButton(driver);

		sleep(4500);

		clearFilter(driver);

		searchByLocation(driver);

		clickSearchButton(driver);

		sleep(4500);

		clearFilter(driver);

		searchByTutorName(driver);

		clickSearchButton(driver);

		sleep(4500);

		clearFilter(driver);
		
		searchByQualification(driver);
		
		clickSearchButton(driver);

		sleep(4500);

		clearFilter(driver);

		searchByTutorChannel(driver);

		clickSearchButton(driver);

		sleep(4500);

		clearFilter(driver);

	}
	
	public void searchByAllFields(WebDriver driver) {
		
		searchByGender(driver);

		sleep(2000);


		searchByBoard(driver);

		sleep(2000);

		searchByClass(driver);

		sleep(2000);

		searchBySubject(driver);

		sleep(2000);

		searchByMinimumFee(driver);

		sleep(2000);

		searchByMaximumFee(driver);

		sleep(2000);

		searchByInstitutes(driver);

		sleep(2000);

		searchByExperience(driver);

		sleep(2000);

		searchByAge(driver);

		sleep(2000);

		searchByLocation(driver);

		sleep(2000);

		searchByTutorName(driver);

		sleep(2000);
		
		searchByQualification(driver);
		
		sleep(2000);

		searchByTutorChannel(driver);

		sleep(2000);
		
		clickSearchButton(driver);
		
		clearFilter(driver);
	}

	private void clearFilter(WebDriver driver) {

		driver.findElement(By.xpath("//div[@class='filter']/child::button")).click();
	}


	private void searchByGender(WebDriver driver) {

		driver.findElement(By.xpath("//span[@id='select2-gender_id-container']")).click();

		WebElement element = driver.findElement(By.cssSelector("ul.select2-results__options"));

		List<WebElement> list = element.findElements(By.tagName("li"));

		int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());

		sleep(1500);

		list.get(randomNum).click();

	}

	private void searchByBoard(WebDriver driver) {

		WebElement dropDown = driver.findElement(By.xpath("//select[@name='categories[]']"));

		Select dd = new Select(dropDown);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());

		dd.selectByIndex(randomNum);

		sleep(1500);

	}

	private void searchByClass(WebDriver driver) {

		WebElement dropDown = driver.findElement(By.xpath("//select[@id='class']"));

		Select dd = new Select(dropDown);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(1, list.size());

		System.out.println(randomNum);

		dd.selectByIndex(randomNum);

		sleep(1500);

	}

	private void searchBySubject(WebDriver driver) {

		WebElement dropDown = driver.findElement(By.xpath("//select[@id='subjects']"));

		Select dd = new Select(dropDown);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());

		dd.selectByIndex(randomNum);

		sleep(1500);

	}

	private void searchByMinimumFee(WebDriver driver) {

		WebElement dropDown = driver.findElement(By.xpath("//select[@id='minimum_fee']"));

		Select dd = new Select(dropDown);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());

		dd.selectByIndex(randomNum);

		sleep(1500);

	}

	private void searchByMaximumFee(WebDriver driver) {

		WebElement dropDown = driver.findElement(By.xpath("//select[@id='maximum_fee']"));

		Select dd = new Select(dropDown);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());

		dd.selectByIndex(randomNum);

		sleep(3000);

	}

	private void searchByInstitutes(WebDriver driver) {

		WebElement dropDown = driver.findElement(By.xpath("//select[@name='insts[]']"));

		Select dd = new Select(dropDown);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());

		dd.selectByIndex(randomNum);

		sleep(1500);

	}

	private void searchByExperience(WebDriver driver) {

		WebElement dropDown = driver.findElement(By.xpath("//select[@id='experience']"));

		Select dd = new Select(dropDown);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());

		dd.selectByIndex(randomNum);

		sleep(1500);

	}

	private void searchByAge(WebDriver driver) {

		WebElement dropDown = driver.findElement(By.xpath("//select[@id='age']"));

		Select dd = new Select(dropDown);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());

		dd.selectByIndex(randomNum);

		sleep(1500);

	}

	private void searchByLocation(WebDriver driver) {

		WebElement dropDown = driver.findElement(By.xpath("//select[@name='locations[]']"));

		Select dd = new Select(dropDown);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());

		dd.selectByIndex(randomNum);

		sleep(1500);

	}

	private void searchByQualification(WebDriver driver) {

		WebElement dropDown = driver.findElement(By.xpath("//select[@name='locations[]']"));

		Select dd = new Select(dropDown);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());

		dd.selectByIndex(randomNum);

		sleep(1500);

	}


	private void searchByTutorName(WebDriver driver) {

		driver.findElement(By.xpath("//input[@id='qual_name']")).sendKeys("Raza Ahmad");

		sleep(1500);

		driver.findElement(By.xpath("//button[@class='btn-search']")).click();
	}

	private void searchByTutorChannel(WebDriver driver) {

		WebElement dropDown = driver.findElement(By.xpath("//select[@name='suitable_timings']"));

		Select dd = new Select(dropDown);

		List<WebElement> list = dd.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());

		dd.selectByIndex(randomNum);

		sleep(1500);

	}

	private void clickSearchButton(WebDriver driver) {

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
