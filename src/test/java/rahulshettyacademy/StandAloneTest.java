package rahulshettyacademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import rahulshettyacademy.pageObjects.Landingpage;
import rahulshettyacademy.pageObjects.ProductCatalogue;



public class StandAloneTest {
	

	 public static void main(String[] args)
	 {
		String productname="ZARA COAT 3";
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(7));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		Landingpage landingpage=new Landingpage(driver);
		landingpage.goTo();
		landingpage.loginApplication("deepak121@gmail.com","Deepak@123");
		
		ProductCatalogue pc=new ProductCatalogue(driver);
		List<WebElement> products = pc.getProductList();
		
		//stream: it will iterate through each and every product
		//once one product retrived
		//filter: used to check the condition
		
		WebElement prod = products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		
		List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
		boolean match = cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equals(productname));
		Assert.assertTrue(match);
		
		driver.findElement(By.cssSelector("li button[type='button']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Select Country']")));
		
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("ind");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		List<WebElement> options = driver.findElements(By.cssSelector(".ta-results"));
		
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,3000)");
		
		w.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action__submit")));
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
		
		System.out.println(driver.findElement(By.cssSelector(".hero-primary")).getText());
		
		
	 }

}
