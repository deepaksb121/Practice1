package rahulshettyacademy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class Landingpage extends AbstractComponent {
	
	WebDriver driver;
	
	public Landingpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="#userEmail")
	WebElement username;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(css="#login")
	WebElement submit;


	public void loginApplication(String userid, String passcode)
	{
		username.sendKeys(userid);
		password.sendKeys(passcode);
		submit.click();
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}

}
