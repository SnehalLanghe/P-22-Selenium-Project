package project_22;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.google.common.base.Stopwatch;

public class RegisterUser {

	WebDriver driver;
	public RegisterUser(WebDriver ldriver) {
		driver=ldriver;
	}
	
	//Repository of an element
	By LoginPage=By.xpath("//div[@class='shop-menu pull-right']//child::ul//child::li[4]//child::a[1]");
	By Name=By.name("name");
	By Email=By.xpath("//input[@data-qa='signup-email']");
	By SignUp=By.xpath("//button[@data-qa='signup-button']");
	By Title=By.id("id_gender2");
	By Pass=By.id("password");
	By Day=By.id("days");
	By Month=By.id("months");
	By Year=By.id("years");
	By Fname=By.name("first_name");
	By Lname=By.name("last_name");
	By Company=By.name("company");
	By Add=By.id("address1");
	By Add2=By.id("address2");
	By Country=By.name("country");	
	By State=By.id("state");
	By City=By.id("city");
	By ZipCode=By.id("zipcode");
	By MobNo=By.id("mobile_number");	
	By CreateBtn=By.xpath("//button[@data-qa='create-account']");
	
	@BeforeSuite
	public void  url() throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://automationexercise.com/");
		Thread.sleep(2000);
	}
	
	@Test(priority = 1, description = "SignUp in the system")

	public void signUpMethod() throws IOException {
		Stopwatch watch = null;

		try {
			watch = Stopwatch.createStarted();
			driver.findElement(LoginPage).click();
			driver.findElement(Name).clear();
			driver.findElement(Name).sendKeys("Snehal Langhe"); 
			driver.findElement(Email).clear();
			driver.findElement(Email).sendKeys("snehallllanghe@gmail.com");
			driver.findElement(SignUp).click();
		} catch (Exception e) {
			watch.stop();
			System.out.println(e);
			System.out.println(watch.elapsed(TimeUnit.SECONDS) + "Seconds");
		}
	}
	
	@Test(priority = 2, description = "Fill the Registration page")

	public void registrationPage() throws InterruptedException
	{
	driver.findElement(Title).click();	
	driver.findElement(Pass).sendKeys("Password1");
	
	WebElement day=driver.findElement(Day);
	Select dayDropDown=new Select(day);
	dayDropDown.selectByValue("23");
	Thread.sleep(1000);
	
	WebElement month=driver.findElement(Month);
	Select monthDropDown=new Select(month);
	monthDropDown.selectByVisibleText("April");
	Thread.sleep(1000);
	
	WebElement year=driver.findElement(Year);
	Select yearDropDown=new Select(year);
	yearDropDown.selectByValue("1997");;
	Thread.sleep(1000);
	
	driver.findElement(Fname).sendKeys("Snehal");
	driver.findElement(Lname).sendKeys("Langhe");
	driver.findElement(Company).sendKeys("ExcelR");
	driver.findElement(Add).sendKeys("New Sangvi");
	driver.findElement(Add2).sendKeys("Pune");
	
	WebElement country=driver.findElement(Country);
	Select cDropDown=new Select(country);
	cDropDown.selectByVisibleText("India");
	Thread.sleep(1000);
	
	driver.findElement(State).sendKeys("Maharashtra");
	driver.findElement(City).sendKeys("Pune");
	driver.findElement(ZipCode).sendKeys("412210");
	driver.findElement(MobNo).sendKeys("1234567890");
	driver.findElement(CreateBtn).click();
	}
	
	@AfterSuite
	public void PMDriverClose() {
		driver.close();
	}

}
