package com.manipal.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseEventAction {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\School_Of_Fintech\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		Actions builder = new Actions(driver);
		
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		
		Thread.sleep(5000);
		
		//builder.dragAndDrop(drag, drop).build().perform();
		
		//String verification = driver.findElement(By.xpath("//p[contains(text(),'Dropped!')]")).getText();
		
//		if(verification.equals("Dropped!"))
//			System.out.println("Successful");
//		else
//			System.out.println("UnSuccessful");
		
		builder.clickAndHold(drag).moveToElement(drop).release().build().perform();
		
		String verification = driver.findElement(By.xpath("//p[contains(text(),'Dropped!')]")).getText();
		
		if(verification.equals("Dropped!"))
			System.out.println("Successful");
		else
			System.out.println("UnSuccessful");

	}

}
