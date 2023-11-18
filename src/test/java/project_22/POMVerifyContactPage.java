package project_22;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class POMVerifyContactPage {
	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		VerifyContactPage ruwem= new VerifyContactPage(driver);
		ruwem.url();
		ruwem.loginP();
		ruwem.contactUs();
		ruwem.DriverClose();
		
	}
}
