package project_22;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class POMRemoveProductsFromCartAndAfterTC {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		RemoveProductsFromCartAndAfterTC a=new RemoveProductsFromCartAndAfterTC(driver);
		VerifyProducts bProducts=new VerifyProducts(driver);
		a.url();
		bProducts.products();
		bProducts.AddToCart();
		a.RemoveProductsFromCart();
		a.ViewCategoryProducts();
		a.ViewCartBrandProducts();
		bProducts.AddToCart();
		a.SearchProductsandVerifyCartAfterLogin();
		a.Addreviewonproduct();
		a.scrollUp();
		a.scrollDown();
		a.DriverClose();
	}
	
}
