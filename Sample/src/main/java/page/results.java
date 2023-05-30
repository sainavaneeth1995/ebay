package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.base;

public class results extends base
{
	By firstprods = By.xpath("//div[@class='s-item__title']");
	By firstprice = By.xpath("//span[@class='s-item__price']");
	By seconprods = By.xpath("//h1[@class='x-item-title__mainTitle']");
	By seconprice = By.xpath("//span[@itemprop='price']");
	
	public String[] productdetails(int index)
	{
		String f[] = new String[2];
		List<WebElement>prodname=driver.findElements(firstprods);
		List<WebElement>price=driver.findElements(firstprice);
		
		f[0]=prodname.get(index-1).getText();
		f[1]=price.get(index-1).getText().substring(1);
		prodname.get(index-1).click();
		return f;
		
	}
	
	public String[] secondpagedetails()
	{
		String s[] = new String[2];
		try {Thread.sleep(2000);} catch (Exception e) {}
		ArrayList<String> pages = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(pages.get(1));
		s[0]=driver.findElement(seconprods).getText();
		s[1]=driver.findElement(seconprice).getAttribute("content");
		return s;
	}
}
