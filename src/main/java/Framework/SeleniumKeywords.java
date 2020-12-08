package Framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumKeywords {
	static WebDriver driver;
	public static WebDriver  launchbrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\seleniumalljarfiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
		
	}
	public static void clickButton(WebElement we)
	{
		we.click();
	}
	public static String errorMessage(WebElement we)
	{
		return(we.getText());
	}
	public static void sendData(WebElement we,String data)
	{
		we.sendKeys(data);
	}

}
