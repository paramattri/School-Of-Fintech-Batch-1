package com.manipal.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElements {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\School_Of_Fintech\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		for(WebElement element : elements) {
			if(element.getText().equals("Gmail")) {
				element.click();
				Thread.sleep(5000);
				break;
			}
			System.out.println(element.getText());
		}
		System.out.println(elements.size());
		//Thread.sleep(5000);
		driver.quit();

	}

}
