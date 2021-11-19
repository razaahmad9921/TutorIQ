package findTutor;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RecomendedAndRatedTeacher {

	
	public void selectRecomandedTeacherFromList(WebDriver driver) {
		
		driver.findElement(By.className("featured-list"));
		
		WebElement element = driver.findElement(By.xpath("/html/body/section/div/div/div[3]/div[1]/div"));
		
		List<WebElement> list = element.findElements(By.tagName("li"));
		
		for(WebElement li : list) {
			
			String[] name = li.getText().split("\n");
			
			if(name[0].equals("Sarah Manzoor")) {
				
				li.click();
				break;
			}
		}
		
	}
	
	public void listOfAllRecomandedTeachers(WebDriver driver) {
		
	
		
		driver.findElement(By.cssSelector("a[href='https://tutorsiq.com/recommended-tutors']")).click();

	
	}
}
