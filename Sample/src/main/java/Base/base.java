package Base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base 
{
	public static WebDriver driver;
	public void setup()
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
	}
	
	public void url(String url)
	{
		driver.get(url);
	}
	
	public void search(String value)
	{
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(value);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	public void teardown()
	{
		driver.quit();
	}
}


