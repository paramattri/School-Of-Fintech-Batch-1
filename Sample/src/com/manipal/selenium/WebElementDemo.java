package com.manipal.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementDemo {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\School_Of_Fintech\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/radio.html");
		String text = driver.findElement(By.xpath("//strong[contains(text(),\"Radio\")]")).getText();
		System.out.println(text);
		Thread.sleep(2000);
		String tagType = driver.findElement(By.xpath("//*[contains(text(),\"Rad\")]")).getTagName();
		System.out.println(tagType);
		String tagAttribute = driver.findElement(By.id("vfb-7-1")).getAttribute("name");
		System.out.println(tagAttribute);
		driver.quit();
	}

}
