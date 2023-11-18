package project_22;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class RemoveProductsFromCartAndAfterTC {

	WebDriver driver;
//	JavascriptExecutor jse = (JavascriptExecutor)driver;

	public RemoveProductsFromCartAndAfterTC(WebDriver ldriver) {
		driver = ldriver;
	}

	// Repository of an element
	By Cart = By.xpath("//div[@class='shop-menu pull-right']//child::ul//child::li[3]//child::a[1]");
	By RemoveProduct = By.xpath("//a[@class='cart_quantity_delete']");
	By ClickHere = By.xpath("//*[@id=\"empty_cart\"]/p/a/u");
	By Category = By.xpath("//div[@class='left-sidebar']//child::h2[contains(text(),'Category')]");
	By Brands = By.xpath("//div[@class='left-sidebar']//child::h2[contains(text(),'Brands')]");
	By CartBProduct = By.xpath("/html/body/section[2]/div[1]/div/div[1]/div[1]/div[3]/div/ul/li[1]/a");
	By SearchProd = By.name("search");
	By ClickSearch = By.id("submit_search");
	By ProdAddtoCart = By.xpath("//div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]/a");
	By ViewCart = By.xpath("//div[@class='shop-menu pull-right']//child::ul//child::li[3]//child::a[1]");
	By Quantity = By.xpath("//button[@class='disabled']");
	By GoToHome = By.xpath("//ol[@class='breadcrumb']//a[contains(text(),'Home') ]");
	By ViewProduct = By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[1]/div[2]/div/div[2]/ul/li/a");
	By WriteReview = By.xpath("//a[contains(text(),'Write Your Review') ]");
	By RName = By.id("name");
	By REmail = By.id("email");
	By RRview = By.id("review");
	By Rsubmit = By.id("button-review");
	By Rrecommended = By.xpath("//h2[contains(text(),'recommended items') ]");
	By RItem = By.xpath("//*[@id=\"recommended-item-carousel\"]/div/div[2]/div[1]/div/div/div/a");
	By ProceedCheckout = By.xpath("//a[@class='btn btn-default check_out']");
	By OrderPlace = By.xpath("//a[@class='btn btn-default check_out']");
	By AddressCP = By.xpath("//h2[contains(text(),'Address Details') ]");
	By CName = By.name("name_on_card");
	By CNumber = By.name("card_number");
	By CVC = By.name("cvc");
	By Cexpiry_month = By.name("expiry_month");
	By Cexpiry_year = By.name("expiry_year");
	By Pay = By.id("submit");
	By Invoice = By.xpath("//a[contains(text(),'Download Invoice') ]");

	@BeforeSuite
	public void url() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://automationexercise.com/");
		Thread.sleep(2000);
	}

	@Test(priority = 1, description = "Remove Products From Cart")
	public void RemoveProductsFromCart() throws InterruptedException {
		driver.findElement(Cart).click();
		Thread.sleep(1000);
		driver.findElement(RemoveProduct).click();
	}

	@Test(priority = 2, description = "View Category Products")
	public void ViewCategoryProducts() throws InterruptedException {
		driver.findElement(ClickHere).click();
		Thread.sleep(1000);
		WebElement category = driver.findElement(Category);
		if (category.isDisplayed()) {
			System.out.println("Category Displayed");
		} else {
			System.out.println("Category not Displayed");
		}
	}

	@Test(priority = 3, description = "View & Cart Brand Products")
	public void ViewCartBrandProducts() throws InterruptedException {
		WebElement brand = driver.findElement(Brands);
		if (brand.isDisplayed()) {
			System.out.println("Brands Displayed");
		} else {
			System.out.println("Brands not Displayed");
		}
		driver.findElement(CartBProduct).click();
		Thread.sleep(1000);
	}

	@Test(priority = 4, description = "Search Products and Verify Cart After Login")
	public void SearchProductsandVerifyCartAfterLogin() throws InterruptedException {
		driver.findElement(SearchProd).sendKeys("Tshirt");
		driver.findElement(ClickSearch).click();
		driver.findElement(ProdAddtoCart).click();
		Thread.sleep(2000);
		driver.findElement(Cart).click();
		Thread.sleep(1000);
		driver.findElement(Quantity).getText();
	}

	@Test(priority = 5, description = "Add review on product")
	public void Addreviewonproduct() throws InterruptedException {
		driver.findElement(GoToHome).click();
		Thread.sleep(1000);
		driver.findElement(ViewProduct).click();
		Thread.sleep(1000);
		driver.findElement(WriteReview).getText();
		driver.findElement(RName).sendKeys("Snehal");
		driver.findElement(REmail).sendKeys("Snehallanghe@gmail.com");
		driver.findElement(RRview).sendKeys("Write Review for the Product");
		driver.findElement(Rsubmit).click();
	}

	@Test(priority = 6, description = "Add to cart from Recommended items")
	public void AddtocartfromRecommendeditems() throws InterruptedException {
		driver.findElement(Rrecommended).getText();
		driver.findElement(RItem).click();
		Thread.sleep(2000);
		driver.findElement(Cart).click();
		Thread.sleep(1000);
	}

	@Test(priority = 7, description = "Verify address details in checkout page")
	public void Verifyaddressdetailsincheckoutpage() throws InterruptedException {
		driver.navigate().refresh();
		driver.findElement(Cart).click();
		driver.findElement(ProceedCheckout).click();
		Thread.sleep(1000);
		WebElement add = driver.findElement(AddressCP);
		if (add.isDisplayed()) {
			System.out.println("Address present");
		} else {
			System.out.println("Address not present");
		}
		driver.findElement(OrderPlace).click();
	}

	@Test(priority = 8, description = "Download Invoice after purchase order")

	public void DownloadInvoiceafterpurchaseorder() throws InterruptedException {
		driver.findElement(OrderPlace).click();
		driver.findElement(CName).sendKeys("Snehal");
		driver.findElement(CNumber).sendKeys("123456789");
		driver.findElement(CVC).sendKeys("1234");
		driver.findElement(Cexpiry_month).sendKeys("04");
		driver.findElement(Cexpiry_year).sendKeys("2025");
		driver.findElement(Pay).click();
		driver.findElement(Invoice).click();
	}

	@Test(priority = 8, description = "Verify Scroll Up using 'Arrow' button and Scroll Down functionality")

	public void scrollUp() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,1200)");
		Thread.sleep(2000);
		new Actions(driver).keyDown(Keys.ARROW_UP).perform();
	}
	
	@Test(priority = 9, description = "Verify Scroll down using 'Arrow' button and Scroll Down functionality")

	public void scrollDown() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,-800)");
		Thread.sleep(2000);
		new Actions(driver).keyDown(Keys.ARROW_DOWN).perform();
		Thread.sleep(2000);
		new Actions(driver).keyDown(Keys.ARROW_DOWN).perform();
		Thread.sleep(2000);
	}

	@AfterSuite
	public void DriverClose() {
		driver.close();
	}
}
