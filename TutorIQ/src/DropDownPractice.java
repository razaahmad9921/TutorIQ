import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class DropDownPractice {
	
	public void autoSuggestiveDropDown(WebDriver driver) {
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("autosuggest")).sendKeys("Pa");
		
		sleep();
		
		WebElement element = driver.findElement(By.xpath("//ul[@id='ui-id-1']"));
		
		List <WebElement> list = element.findElements(By.tagName("li"));
		
		for (WebElement webElement : list) {
			
			if (webElement.getText().equalsIgnoreCase("Pakistan")) {
				
				webElement.click();
				
				break;
			}
		}
	}

	public void clickingDropDownIncreasingNumberRahulShetty(WebDriver driver) {

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("divpaxinfo")).click();

		sleep();



		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		for(int i=1;i<5;i++)

		{

			driver.findElement(By.id("hrefIncAdt")).click();

		}

		driver.findElement(By.id("btnclosepaxoption")).click();

		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}

	public void citiesOfIndiaInDynamicDropDown(WebDriver driver) {

		//code to select cities from drop down upper part

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

		WebElement element = driver.findElement(By.xpath("/html/body/form/div[4]/div[2]/div/div[5]/div[2]/div[2]/div[2]/div[3]/div/div[3]/div/div[1]/div[2]/div/table/tbody/tr[2]/td[2]/div[3]/div[1]"));

		List<WebElement> elements = element.findElements(By.tagName("ul"));

		sleep();

		for(WebElement citiList : elements) {

			List<WebElement> cities = citiList.findElements(By.tagName("li"));

			for(WebElement li : cities) {

				if (li.getText().equals("Chennai (MAA)")) {

					li.click();

					break;
				}

			}
		}

		sleep();
		WebElement element1 = driver.findElement(By.xpath("/html/body/form/div[4]/div[2]/div/div[5]/div[2]/div[2]/div[2]/div[3]/div/div[3]/div/div[2]/div[2]/div/table/tbody/tr[2]/td[2]/div[3]/div[1]"));

		List<WebElement> elements1 = element1.findElements(By.tagName("ul"));

		for(WebElement citiList : elements1) {

			List<WebElement> cities = citiList.findElements(By.tagName("li"));

			for(WebElement li : cities) {

				if (li.getText().equals("Gorakhpur (GOP)")) {

					li.click();
				
					break;
				}

			}
		}
		sleep();
	}

	public void internationalCitiesDropDown(WebDriver driver) {

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

		WebElement element = driver.findElement(By.xpath("/html/body/form/div[4]/div[2]/div/div[5]/div[2]/div[2]/div[2]/div[3]/div/div[3]/div/div[1]/div[2]/div/table/tbody/tr[2]/td[2]/div[3]/div[2]"));

		List<WebElement> elements = element.findElements(By.tagName("ul"));

		sleep();
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 
		 js.executeScript("arguments[0].scrollIntoView();", elements.get(0));
		for(WebElement citiList : elements) {

			List<WebElement> cities = citiList.findElements(By.tagName("li"));

			for(WebElement li : cities) {

				if (li.getText().equals("Dubai, All Airports(DWC) (DXB)")) {

					li.click();
					
					break;
				}

			}
		}
		sleep();
		WebElement element1 = driver.findElement(By.xpath("/html/body/form/div[4]/div[2]/div/div[5]/div[2]/div[2]/div[2]/div[3]/div/div[3]/div/div[2]/div[2]/div/table/tbody/tr[2]/td[2]/div[3]/div[2]"));

		List<WebElement> elements1 = element1.findElements(By.tagName("ul"));

		for(WebElement citiList : elements1) {

			List<WebElement> cities = citiList.findElements(By.tagName("li"));

			for(WebElement li : cities) {

				if (li.getText().equals("Male (MLE)")) {

					li.click();
					break;
				}

			}
		}

		sleep();

	}
	private static void sleep() {

		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
