package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		
		this.driver=driver;
	}
	
	
	public void waitForElementToAppear(By FindBy)
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(7));
		w.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
		
	}
	
	
	

}
