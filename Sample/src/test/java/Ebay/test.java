package Ebay;

import java.util.Arrays;

import org.testng.annotations.Test;

import page.homepage;
import page.results;

public class test 
{
	homepage homepage = new homepage();
	results results = new results();
	@Test(priority=0)
	public void functionaltest()
	{
		String value="tv";
		homepage.setup();
		homepage.url("https://www.ebay.com/");
		homepage.search(value);;
		String title=homepage.title();
		if(title.contains(value))
		{
			System.out.println("title matches"+" "+value);
		}
		else
		{
			System.out.println("titel missmatches");
		}
		homepage.teardown();
	}
	@Test(priority=1)
	public void detailtest()
	{
		String value="outdoortoys";
		results.setup();
		results.url("https://www.ebay.com/");
		results.search(value);
		String[] f=results.productdetails(3);
		String[] s=results.secondpagedetails();
		
		if(f[0].matches(s[0])&&f[1].matches(s[1]))
		{
			System.out.println("details matches"+" "+Arrays.toString(s));
		}
		else
		{
			System.out.println("details missmatch");
		}
		results.teardown();
	}

}
