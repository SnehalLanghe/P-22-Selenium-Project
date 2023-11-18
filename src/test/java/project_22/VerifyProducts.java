package project_22;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class VerifyProducts {

	WebDriver driver;
	public VerifyProducts(WebDriver ldriver) {
		driver=ldriver;
	}
	
	//Repository of an element
	By ClickProducts=By.xpath("//div[@class='shop-menu pull-right']//child::ul//child::li[2]//child::a[1]");
	By VerifyAllProd=By.xpath("//h2[@class='title text-center']");
	By SearchProd=By.name("search");
	By ClickSearch=By.id("submit_search");
	By Subscription=By.id("susbscribe_email");
	By Subscribe=By.id("subscribe");
	By ProdAddtoCart=By.xpath("//div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]/a");
	By ViewCart=By.xpath("//div[@class='shop-menu pull-right']//child::ul//child::li[3]//child::a[1]");
	By Cart=By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");
	By Quantity =By.xpath("//button[@class='disabled']");
	
	@BeforeSuite
	public void  url() throws InterruptedException, IOException
	{
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://automationexercise.com/");
	//	Thread.sleep(2000);
	}
	
	@Test(priority = 1, description = "Verify all the Products")
	public void products() throws InterruptedException
	{
		driver.findElement(ClickProducts).click();
		Thread.sleep(2000);
		WebElement AllProduts=driver.findElement(VerifyAllProd);
		if(AllProduts.isDisplayed()) {
			System.out.println("All Products displayed");
		}
		else
		{
			System.out.println("All Products not displayed");
		}
		
		driver.findElement(SearchProd).sendKeys("Tshirt");
		driver.findElement(ClickSearch).click();
		}
	
	@Test(priority = 2, description = "Verify all the Subscription")
	public void VerifySubScription() {
		WebElement Sub=driver.findElement(Subscription);
		if(Sub.isEnabled()) {
			System.out.println("Subscription is present");
			driver.findElement(Subscription).sendKeys("snehallanghe@gmail.com");
			driver.findElement(Subscribe).click();
		}
		else
		{
			System.out.println("Subscription is not present");
		}
	}
	
	@Test(priority = 3, description = "Add Products in Cart")
	public void AddToCart() throws InterruptedException
	{
		       
		driver.findElement(ProdAddtoCart).click();
		Thread.sleep(2000);
		driver.findElement(Cart).click();
		Thread.sleep(1000);
		driver.findElement(Quantity).getText();
	}
	
	@AfterSuite
	public void DriverClose() {
		driver.close();
	}
}
