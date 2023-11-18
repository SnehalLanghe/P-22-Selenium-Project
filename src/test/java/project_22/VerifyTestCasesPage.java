package project_22;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class VerifyTestCasesPage {

	WebDriver driver;
	public VerifyTestCasesPage(WebDriver ldriver) {
		driver=ldriver;
	}
	
	//Repository of an element
	
	By TestCases=By.xpath("//*[@id=\"slider-carousel\"]/div/div[2]/div[1]/a[1]/button");
	
	
	@BeforeSuite
	public void  url() throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://automationexercise.com/");
		Thread.sleep(2000);
	}
	
	@Test(priority = 1, description = "Verify the Test cases page")
	public void VerifyTCPage()
	{
		driver.findElement(TestCases);
	}
	
	@AfterSuite
	public void DriverClose() {
		driver.close();
	}
}
