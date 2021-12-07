
import java.sql.Driver;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import StudentProfile.StudentProfile;
import extraWork.DropDownPractice;
import extraWork.FrameWithDragDrop;
import extraWork.GettingLinksInWebPage;
import extraWork.HoverAndActionOfMouse;
import findTutor.FindTutor;
import findTutor.RecomendedAndRatedTeacher;
import findTutor.SearchTutorInFindTutor;
import helpMeFindTutor.HelpMeFindTutor;
import loginSignOut.Login;
import signUp.SignUp;
import tutorForMe.TutorForMe;



public class Main {

 

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "F:\\Projects\\Driver\\chromedriver.exe");

		//		System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.get("https://tutorsiq.com/");
		
		loginFunctionality(driver);
		
		FindTutor obj = new FindTutor();
		
		obj.searchByFee(driver);
		
		

	}

	public static void helpMeFindTutor(WebDriver driver) {
		

		loginFunctionality(driver);

		sleep(2000);

		driver.findElement(By.xpath("//a[text()='Help Me To Find Tutor']")).click();
		
		HelpMeFindTutor obj = new HelpMeFindTutor();
		
		obj.findTutor(driver);
	}
	public static void tutorForMe(WebDriver driver) {

		loginFunctionality(driver);

		sleep(2000);

		driver.findElement(By.xpath("//a[text()='Tutors For Me']")).click();

		TutorForMe  obj = new  TutorForMe();

		obj.listOfAvailableTeacher(driver);
	}

	public static void studentProfile(WebDriver driver) {

		loginFunctionality(driver);

		sleep(2000);

		driver.findElement(By.xpath("//a[text()='Profile']")).click();

		StudentProfile objProfile = new StudentProfile();

		objProfile.editProfile(driver);
	}


	public static void searchTutor(WebDriver driver) {

		SearchTutorInFindTutor obj = new SearchTutorInFindTutor();

		obj.searchByEachField(driver);

	}

	public static void findTutor(WebDriver driver) {

		FindTutor obj = new FindTutor();

		obj.searchByFee(driver);
	}

	public static void loginFunctionality(WebDriver driver){

		Login obj = new Login();

		obj.login(driver);

		//		obj.wrongLogin(driver);
		//		
		//		obj.forgotPassword(driver);

	}

	public static void signUpFunctionality(WebDriver driver) {

		SignUp obj = new SignUp();

		obj.registerAsStudent(driver);
	}

	public static void topRatedStudentAndTeacher(WebDriver driver) {

		RecomendedAndRatedTeacher obj = new RecomendedAndRatedTeacher();

		obj.selectRecomandedTeacherFromList(driver);
	}

	public static void listofTopRatedTeachers(WebDriver driver) {

		RecomendedAndRatedTeacher obj = new RecomendedAndRatedTeacher();

		obj.listOfAllRecomandedTeachers(driver);
	}

	public static void FavoriteTutor(WebDriver driver) {

		loginFunctionality(driver);
		
		sleep(2000);
		
		FavoriteTutor obj = new FavoriteTutor();

		obj.getAllFavoriteTutor(driver);
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

