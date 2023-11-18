package project_22;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class VerifyContactPage {

	WebDriver driver;
	public VerifyContactPage(WebDriver ldriver) {
		driver=ldriver;
	}
	
	//Repository of an element
	By LoginPage=By.xpath("//div[@class='shop-menu pull-right']//child::ul//child::li[4]//child::a[1]");
	By Email=By.xpath("//input[@data-qa='login-email']");
	By Password=By.name("password");
	By LoginBtn=By.xpath("//button[@data-qa='login-button']");
	By ContactUsP=By.xpath("//div[@class='shop-menu pull-right']//child::ul//child::li[9]//child::a[1]");
	By Cname=By.name("name");
	By Cemail=By.name("email");
	By Csubject=By.name("subject");
	By Cmsg=By.name("message");
	By Csubmit=By.name("submit");
	By VerifiedContactPage=By.xpath("//div[@class='status alert alert-success']");
	
	@BeforeSuite
	public void  url() throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://automationexercise.com/");
		Thread.sleep(2000);
	}
	
	@Test(priority = 1, description = "Login using existing creds in the system")

	public void loginP() throws InterruptedException, IOException
	{
		driver.findElement(LoginPage).click();
		driver.findElement(Email).clear();
		driver.findElement(Email).sendKeys("snehallanghe@gmail.com"); 
		driver.findElement(Password).clear();
		driver.findElement(Password).sendKeys("Password1");
		driver.findElement(LoginBtn).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2, description = "Open and fill Contact Us Page")

	public void contactUs()
	{
		driver.findElement(ContactUsP).click();
		driver.findElement(Cname).sendKeys("Snehal");
		driver.findElement(Cemail).sendKeys("Snehallanghe@gmail.com");
		driver.findElement(Cmsg).sendKeys("Verify Contact UsPage");
		driver.findElement(Csubmit).click();
		Alert a=driver.switchTo().alert();
		System.out.println(a.getText());
		a.accept();
		String VCPage=driver.findElement(VerifiedContactPage).getText();
		System.out.println(VCPage);
		}
	
	
	
	@AfterSuite
	public void DriverClose() {
		driver.close();
	}
}
