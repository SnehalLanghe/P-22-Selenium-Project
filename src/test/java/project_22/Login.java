package project_22;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.base.Stopwatch;

public class Login {

	WebDriver driver;
	public Login(WebDriver ldriver) {
		driver=ldriver;
	}
	
	//Repository of an element
		By LoginPage=By.xpath("//div[@class='shop-menu pull-right']//child::ul//child::li[4]//child::a[1]");
		By Email=By.xpath("//input[@data-qa='login-email']");
		By Password=By.name("password");
		By LoginBtn=By.xpath("//button[@data-qa='login-button']");
		By Logout=By.xpath("//div[@class='shop-menu pull-right']//child::ul//child::li[4]//child::a[1]");
		By ErrorContainer=By.xpath("//input[@name='password']//following::p[1]");
		
	
	public void  loginP() throws InterruptedException, IOException
	{		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://automationexercise.com/");
		Thread.sleep(2000);
		
		String filePath="C://Users//Abhijeet//Documents//Snehal Selenium Testing//Data Driver Files/Project22.xlsx";
		FileInputStream file=new FileInputStream(filePath);
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet sheet= workbook.getSheet("Data");
		
		int rows=sheet.getLastRowNum();
		System.out.println("Total number of Rows = "+rows);
	
		for(int i=1; i<=rows; i++)
		{
			XSSFRow row=sheet.getRow(i);
			XSSFCell username=row.getCell(0);
			XSSFCell password=row.getCell(1);
			XSSFCell result=row.createCell(2);
			System.out.println("Username As--> "+ username);
			System.out.println("Password As--> "+ password);
			Stopwatch watch=null;
			
			try {
			watch=Stopwatch.createStarted();
			driver.findElement(LoginPage).click();
			driver.findElement(Email).clear();
			driver.findElement(Email).sendKeys(username.toString()); //Added tostring becacuse emailID has interger value we need to convert it
			driver.findElement(Password).clear();
			driver.findElement(Password).sendKeys(password.toString());
			driver.findElement(LoginBtn).click();
			Thread.sleep(2000);
			driver.findElement(Logout).click();
			
			System.out.println("Credential is Valid = "+username +" and " +password );
			result.setCellValue("Valid");
			Thread.sleep(2000);
			}
			catch (Exception e) {
				
				WebElement errorContainer = driver.findElement(ErrorContainer);
				String headerError=errorContainer.getText();
				System.out.println("Credential is Invalid = "+username +" and " +password);
				result.setCellValue("Invalid");
				result.setCellValue(headerError);
				driver.navigate().refresh();
				watch.stop();
			}
		}
		file.close();
		//Close file if we want to enter output in file
		FileOutputStream fileOutput= new FileOutputStream(filePath);
		workbook.write(fileOutput);
}
}
