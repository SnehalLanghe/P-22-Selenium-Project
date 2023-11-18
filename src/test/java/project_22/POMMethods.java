package project_22;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class POMMethods {
	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//Object Creation and calling methods
		
		VerifyTestCasesPage tc=new VerifyTestCasesPage(driver);
		//tc.url();
		//tc.VerifyTCPage();
		//tc.DriverClose();
		
		VerifyProducts p=new VerifyProducts(driver);
		p.url();
		p.products();
		p.VerifySubScription();
		p.AddToCart();
		
		
	}

}
