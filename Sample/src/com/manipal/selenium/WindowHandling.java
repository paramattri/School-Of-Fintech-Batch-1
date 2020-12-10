package com.manipal.selenium;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\School_Of_Fintech\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.naukri.com");
		
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows.size());
		
		for(String window : windows) {
			
			// Closing all the children windows
//			if(!parent.equals(window)) {
//				System.out.println(driver.switchTo().window(window).getTitle());
//				driver.close();
//			}
			
			//Closing only HSBC Window 
			if(driver.switchTo().window(window).getTitle().equals("HSBC"))
				driver.close();
		}
		
		Thread.sleep(2000);
		driver.quit();
	}

}
