package project_22;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class POMPlaceOrder extends RegisterUser {
	
	public POMPlaceOrder(WebDriver ldriver) {
		super(ldriver);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		PlaceOrder po=new PlaceOrder(driver);
		RegisterUser ru = new RegisterUser(driver);
		po.url();
		po.registerwhileCheckout();
		ru.signUpMethod();
		ru.registrationPage();
		driver.navigate().refresh();
		ru.signUpMethod();
		ru.registrationPage();
		po.registerbeforeCheckout();
		Login login=new Login(driver);
		login.loginP();
		po.loginbeforeCheckout();
		
	}

}
