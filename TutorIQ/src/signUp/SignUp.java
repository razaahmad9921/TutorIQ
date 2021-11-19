package signUp;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SignUp {

	public void registerAsStudent(WebDriver driver) {

		driver.findElement(By.className("register-student")).click();

		sleep();

		driver.findElement(By.id("name")).sendKeys("Sumail Hassan");

		driver.findElement(By.id("email")).sendKeys("critical9031@gmail.com");

		driver.findElement(By.id("password")).sendKeys("4303921Ee!");

		driver.findElement(By.id("confirm_password")).sendKeys("4303921Ee!");

		driver.findElement(By.id("phone")).sendKeys("+923013789789");

		driver.findElement(By.id("address_line1")).sendKeys("Raiwand Road");

		selectingCountry(driver);

		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/form/div[9]/div[1]/label/div/label/div")).click();

		//driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/form/div[9]/div[3]/button")).click();

	}

	private static void sleep() {

		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void selectingCountry(WebDriver driver) {

		Select dropDown = new Select(driver.findElement(By.id("country")));

		dropDown.selectByIndex(1);

		Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), "ONLINE");


		sleep();


		dropDown.selectByVisibleText("Pakistan");

		Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), "Pakistan");


	}

	
}
