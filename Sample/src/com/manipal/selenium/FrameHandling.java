package com.manipal.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\School_Of_Fintech\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
		
		WebElement frameElement = driver.findElement(By.xpath("//div[@class='module-surround']/iframe"));
		//switching using frame element
		//driver.switchTo().frame(frameElement);
		driver.switchTo().frame(0); //switching using index number
		
		driver.findElement(By.xpath("//div[@class='ytp-cued-thumbnail-overlay']/button")).click();
	
		Thread.sleep(4000);
		
		//Switching out of the frame, going back to default window
		driver.switchTo().defaultContent();
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		driver.quit();
	}

}
