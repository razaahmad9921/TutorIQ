import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {



	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "F:\\Projects\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://tutorsiq.com/");

		loginFunctionality(driver);

		//topRatedStudentAndTeacher(driver);

		sleep();

		//findTutor(driver);

		//FavoriteTutor(driver);

		//listofTopRatedTeachers(driver);

		searchTutor(driver);
	}

	public static void searchTutor(WebDriver driver) {

		SearchTutor obj = new SearchTutor();

		obj.searchByGender(driver);

		obj.searchByBoard(driver);

		obj.searchByClass(driver);

		obj.searchBySubject(driver);

		obj.searchByMinimumFee(driver);

		obj.searchByMaximumFee(driver);
		
		obj.searchByInstitutes(driver);
		
		obj.searchByExperience(driver);
		
		obj.searchByAge(driver);
		
		obj.searchByLocation(driver);
		
		obj.searchByTutorName(driver);
		
		obj.searchByTutorChannel(driver);
		
		obj.clickSearchButton(driver);





		//obj.clearFilter(driver);
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

		TopRatedStudentAndTeacher obj = new TopRatedStudentAndTeacher();

		obj.selectRecomandedTeacherFromList(driver);
	}

	public static void listofTopRatedTeachers(WebDriver driver) {

		TopRatedStudentAndTeacher obj = new TopRatedStudentAndTeacher();

		obj.listOfAllRecomandedTeachers(driver);
	}

	public static void FavoriteTutor(WebDriver driver) {

		FavoriteTutor obj = new FavoriteTutor();

		obj.getAllFavoriteTutor(driver);
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
