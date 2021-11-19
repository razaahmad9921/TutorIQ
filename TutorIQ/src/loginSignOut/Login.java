package loginSignOut;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Login {

	public void login(WebDriver driver) {

		driver.findElement(By.xpath("/html/body/header/nav/div/ul/li[5]")).click();

		sleep(1500);

		driver.findElement(By.cssSelector("input.form-control")).sendKeys("critical9031@gmail.com");

		driver.findElement(By.id("password")).sendKeys("4303921Ee!");

		driver.findElement(By.cssSelector("button.btn")).click();

	}

	public void wrongLogin(WebDriver driver) {

		driver.findElement(By.xpath("/html/body/header/nav/div/ul/li[5]")).click();

		sleep(1500);

		driver.findElement(By.cssSelector("input.form-control")).sendKeys("critical9031@gmail.com");

		driver.findElement(By.id("password")).sendKeys("4303921Ee");

		driver.findElement(By.cssSelector("button.btn")).click();
		
		sleep(1500);
		
		String messageGet = driver.findElement(By.className("alert-danger")).getText();
		
		String actualMessage = "Whoops";
			
		String[] message = messageGet.split("!");
		
		Assert.assertEquals(message[0], actualMessage);
	}
	
	public void forgotPassword(WebDriver driver) {
		
		driver.findElement(By.xpath("/html/body/header/nav/div/ul/li[5]")).click();

		sleep(1500);
		
		driver.findElement(By.className("forgot-pass-link")).click();
		
		sleep(1500);
		
		driver.findElement(By.className("form-control")).sendKeys("critical9031@gmail.com");
		
		sleep(1500);
		
		driver.findElement(By.className("btn")).click();
		
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
