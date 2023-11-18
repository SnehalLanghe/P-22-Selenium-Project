package project_22;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PlaceOrder {

	WebDriver driver;
	public PlaceOrder(WebDriver ldriver) {
		driver=ldriver;
	}
	
	//Repository of an element
	By ClickProducts=By.xpath("//div[@class='shop-menu pull-right']//child::ul//child::li[2]//child::a[1]");
	By VerifyAllProd=By.xpath("//h2[@class='title text-center']");
	By SearchProd=By.name("search");
	By ClickSearch=By.id("submit_search");
	By ProdAddtoCart=By.xpath("//div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]/a");
	By Cart2=By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");
	By PORegister=By.xpath("//*[@id=\"checkoutModal\"]//div//div//div[2]//p[@class='text-center'][2]//a//u");
	By ProceedCheckout=By.xpath("//a[@class='btn btn-default check_out']");
	By OrderPlace=By.xpath("//a[@class='btn btn-default check_out']");
	
	@BeforeSuite
	public void  url() throws InterruptedException, IOException
	{	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://automationexercise.com/");
		Thread.sleep(2000);
	}
	
	@Test(priority = 1, description = "Place Order: Register while Checkout")
	public void registerwhileCheckout() throws InterruptedException
	{
		driver.findElement(ClickProducts).click();
		Thread.sleep(2000);
		driver.findElement(SearchProd).sendKeys("Tshirt");
		driver.findElement(ClickSearch).click();
		driver.findElement(ProdAddtoCart).click();
		Thread.sleep(1000);
		driver.findElement(Cart2).click();
		Thread.sleep(1000);
		driver.findElement(ProceedCheckout).click();
		Thread.sleep(1000);
		driver.findElement(PORegister).click();
		Thread.sleep(1000);	
	}
	
	@Test(priority = 2, description = "Place Order: Register before Checkout")
	public void registerbeforeCheckout() throws InterruptedException
	{
		driver.navigate().refresh();
		driver.findElement(ClickProducts).click();
		Thread.sleep(2000);
		driver.findElement(SearchProd).sendKeys("Tshirt");
		driver.findElement(ClickSearch).click();
		driver.findElement(ProdAddtoCart).click();
		Thread.sleep(1000);
		driver.findElement(Cart2).click();
		Thread.sleep(1000);
		driver.findElement(ProceedCheckout).click();
		Thread.sleep(1000);	
		driver.findElement(OrderPlace).click();
	}
	
	@Test(priority = 3, description = "Place Order: Login before Checkout")
	public void loginbeforeCheckout() throws InterruptedException
	{
		driver.navigate().refresh();
		driver.findElement(ClickProducts).click();
		Thread.sleep(2000);
		driver.findElement(SearchProd).sendKeys("Tshirt");
		driver.findElement(ClickSearch).click();
		driver.findElement(ProdAddtoCart).click();
		Thread.sleep(1000);
		driver.findElement(Cart2).click();
		Thread.sleep(1000);
		driver.findElement(ProceedCheckout).click();
		Thread.sleep(1000);	
		driver.findElement(OrderPlace).click();
	}
	@AfterSuite
	public void DriverClose() {
		driver.close();
	}
}
