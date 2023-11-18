package project_22;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class POMRegisterUser {
	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//Object Creation and calling methods
		RegisterUser registerU=new RegisterUser(driver);
		registerU.url();
		registerU.signUpMethod();
		registerU.registrationPage();
		registerU.PMDriverClose();
	}
}
