//package com.manipal.selenium;
//
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class TableHandlingDemo {
//
//	public static void main(String[] args) {
//		
//		System.setProperty("webdriver.chrome.driver", "D:\\Work\\School_Of_Fintech\\Selenium\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		
//		driver.get("https://www.nseindia.com/live_market/dynaContent/live_analysis/top_gainers_losers.htm?cat=G\\r\\n");
//		
//		driver.findElement(By.xpath("//ul[@class='tab']/li/a[contains(text(),'Losers')]")).click();
//
//		List<WebElement> col = driver.findElements(By.xpath("//table[@id='topLosers']/tbody/tr/td[3]"));
//		System.out.println("No of cols are : " + col.size());
//
//		for (int i = 0; i < col.size(); i++)
//		{​​
//		System.out.println(col.get(i).getText());
//
//		}​​
//
//	}
//
//}
