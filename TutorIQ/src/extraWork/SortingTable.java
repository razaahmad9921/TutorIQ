package extraWork;

import java.lang.reflect.Array;
import java.sql.DriverPropertyInfo;
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;

import javax.print.attribute.standard.PrinterInfo;

import org.asynchttpclient.util.AuthenticatorUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.css.model.Value;
import org.openqa.selenium.support.ByIdOrName;
import org.testng.annotations.BeforeClass;

public class SortingTable {
	
	public void sortTable(WebDriver driver) {
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//thead/tr/th[1]")).click();
		
		List <WebElement> list = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		
		String strArry [] = new String[list.size()];
		
		for(int i=0;i < list.size();i++)
		{
			strArry[i]=list.get(i).getText(); 
		}
		/*
		 * Compare the String
		 */
		boolean sortFunctionality = true;
		outer: 
		for(int i=0;i < strArry.length;i++)
		{
			for(int j=i+1;j < i;j++)
			{
				int result = strArry[j].compareTo(strArry[i]);
				if(!(result > 0))
				{
						System.out.println("Data in the Table is not SORTED::" +strArry[j]+":::"+ strArry[i]);
						sortFunctionality=false;
						break outer;
				}
				else
				{
					 System.out.println("Data in the Table is SORTED::" +strArry[j]+":::"+ strArry[i]);
				}
			}
		}
		
		if(sortFunctionality)
		{
			System.out.println("SORT Functionality is working");
		}
		else
		{
			System.out.println("SORT Functionality is not working");
		}
		
	}
	
	public void searchItem(WebDriver driver) {
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.id("search-field")).sendKeys("dinka");
		
		List <WebElement> list = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		
		String strArry [] = new String[list.size()];
		
		for(int i=0;i < list.size();i++)
		{
			strArry[i]=list.get(i).getText();
			
			System.out.println(strArry[i]);
		}
	}
	
	public void searchAllItems(WebDriver driver) {
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		int count = 0;
		
		ArrayList<String> strArray =new ArrayList<String>();
		
		do {
			List <WebElement> list = driver.findElements(By.xpath("//tbody/tr/td[1]"));
			
			for(WebElement liElement : list) {
				
				String tempString = liElement.getText();
				if(tempString.equalsIgnoreCase("Cheese")) {
					
					count++;
					
					strArray.add(tempString);
					
					System.out.println(strArray);
				}
				
			}
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			
		} while (driver.findElement(By.xpath("//a[@aria-label='Next']")).getAttribute("aria-disabled").equalsIgnoreCase("false")); 
						
	}
}
