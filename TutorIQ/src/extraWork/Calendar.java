package extraWork;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Calendar {

	public void selectDate(WebDriver driver) throws InterruptedException {

		driver.get("https://www.path2usa.com/travel-companions");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("travel_date")).click();


		//		driver.findElement(By.id("travel_date")).click();
		//		String temp = driver.findElement(By.cssSelector("[class=' table-condensed'] [class ='prev']")).getAttribute("style");
		//		
		//		if (temp.equalsIgnoreCase("visibility: visible;")) {
		//			
		//			System.out.println("Dinka chika");
		//		}
		//		else {
		//			
		//			driver.findElement(By.cssSelector("[class=' table-condensed'] [class ='next']")).click();
		//		}
		//		
		while(!driver.findElement(By.cssSelector("[class=' table-condensed'] [class ='datepicker-switch']")).
				getText().equalsIgnoreCase("October 2022")){


			driver.findElement(By.cssSelector("[class=' table-condensed'] [class ='next']")).click();

			Thread.sleep(1000);

		}

		List <WebElement> list = driver.findElements(By.className("day"));

		int count = list.size();

		int startingIndex = 0;
		
		for (WebElement day : list ) {
			
			startingIndex++;
			
			if(day.getText().equalsIgnoreCase("1")) {
				
				break;
			}
		}
		
		for(int i=startingIndex;i<count;i++)
		{
			String text=driver.findElements(By.className("day")).get(i).getText();
			if(text.equalsIgnoreCase("30"))
			{
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}
				
	}

}
