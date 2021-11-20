package signUp;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class SignUp {

	public void registerAsStudent(WebDriver driver) {

		driver.findElement(By.className("register-student")).click();

		sleep(1500);
		
		driver.findElement(By.linkText("I already have a membership")).click();
		
		sleep(1500);
		
		driver.navigate().back();
		
		driver.findElement(By.className("register-student")).click();

		sleep(1500);

		String name = getAlphaNumericString(8);

		driver.findElement(By.id("name")).sendKeys(name);

		driver.findElement(By.id("email")).sendKeys(name + "@gmail.com");
		
		driver.findElement(By.xpath("//i[contains(@class,'fa-eye')]")).click();

		driver.findElement(By.id("password")).sendKeys("4303921Ee!");

		driver.findElement(By.id("confirm_password")).sendKeys("4303921Ee!");
		
		sleep(1500);
		
		driver.findElement(By.xpath("//i[contains(@class,'fa-eye')]")).click();

		driver.findElement(By.id("phone")).sendKeys("+923013789789");

		driver.findElement(By.id("address_line1")).sendKeys("Raiwand Road");

		selectingCountry(driver);
		
		selectingcity(driver);

		driver.findElement(By.xpath("//div[@class='icheckbox_square-orange']")).click();
		
		driver.findElement(By.cssSelector("div button[class$='btn-terms']")).click();
		
		sleep(2500);
		
		driver.findElement(By.cssSelector("div button[class$='custom-close']")).click();
		
		sleep(4000);

		driver.findElement(By.xpath("//button[@id='student-registration-form-btn']")).click();

	}

	private static void sleep(int i) {

		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void selectingCountry(WebDriver driver) {

		Select dropDown = new Select(driver.findElement(By.id("country")));
		
		List <WebElement> list = dropDown.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());
		
		dropDown.selectByIndex(randomNum);

	}
	
	private static void selectingcity(WebDriver driver) {

		Select dropDown = new Select(driver.findElement(By.id("city")));
		
		List <WebElement> list = dropDown.getOptions();

		int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());
		
		dropDown.selectByIndex(randomNum);

	}
	private static String getAlphaNumericString(int n)
    {
  
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz";
  
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
  
        for (int i = 0; i < n; i++) {
  
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                = (int)(AlphaNumericString.length()
                        * Math.random());
  
            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                          .charAt(index));
        }
  
        return sb.toString();
    }

	
}
