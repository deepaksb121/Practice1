package rahulshettyacademy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{

	WebDriver driver;
	public ProductCatalogue(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	 
	By FindBy=By.cssSelector(".mb-3");

	public List<WebElement> getProductList()
	{
		waitForElementToAppear(FindBy);
		return products;
	}
	
	

}
