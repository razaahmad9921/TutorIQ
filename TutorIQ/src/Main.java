import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {


	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	
		System.setProperty("webdriver.chrome.driver", "D:/Projects/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.get("https://tutorsiq.com/");
		
		loginFunctionality(driver);
		
		//topRatedStudentAndTeacher(driver);
		
		sleep();
		
		listofTopRatedTeachers(driver);
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
		
		TopRatedStudentAndTeacher obj = new TopRatedStudentAndTeacher();
		
		obj.selectRecomandedTeacherFromList(driver);
	}
	
	public static void listofTopRatedTeachers(WebDriver driver) {
		
		TopRatedStudentAndTeacher obj = new TopRatedStudentAndTeacher();
		
		obj.listOfAllRecomandedTeachers(driver);
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
