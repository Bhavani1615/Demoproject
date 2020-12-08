package PageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Framework.SeleniumKeywords;

public class HomePage {
WebDriver driver;

//identifying elements using different locators
@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul/li[1]/a")
@CacheLookup
WebElement books;

@FindBy(linkText="Computers")
@CacheLookup
WebElement computers;

@FindBy(linkText="Electronics")
@CacheLookup
WebElement electronics;

@FindBy(linkText="Apparel & Shoes")
@CacheLookup
WebElement apparel;

@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/h2/a")
@CacheLookup
WebElement item;

@FindBy(how=How.ID,using="add-to-cart-button-13")
@CacheLookup
WebElement addcart;

@FindBy(xpath="//*[@id='bar-notification']/p")
@CacheLookup
WebElement msg;

@FindBy(xpath="//*[@id='topcartlink']/a")
@CacheLookup
WebElement shoppingcart;

//Actions
public void goToCart()
{
	SeleniumKeywords.clickButton(shoppingcart);
}

public void addToCart()
{
	SeleniumKeywords.clickButton(addcart);
	
}

public void selectCategory()
{
	SeleniumKeywords.clickButton(books);
}

public void selectItem() throws InterruptedException
{
	Actions actions = new Actions(driver);

     //Scroll Down using Actions class
	actions.sendKeys(Keys.PAGE_DOWN).build().perform();

	Thread.sleep(2000);
	SeleniumKeywords.clickButton(item);
}

public String getMessage()
{
	return(SeleniumKeywords.errorMessage(msg));
}

//Constructor
public HomePage(WebDriver driver) {
	this.driver = driver;
	//initializing elements
	PageFactory.initElements(driver, this);
}

}
