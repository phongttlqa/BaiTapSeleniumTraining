package com.selenium.testflow;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Bai3{
	private WebDriver driver;

	@Test
	public void f() {
		By alertBy =  By.xpath("//*[@class=\"modal-content\"]");
		
		assertEquals(isElemenViseble(alertBy), false);
		
		driver.findElement(By.xpath("//*[@class=\"btn btn-warning\"]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(alertBy));
		assertEquals(isElemenViseble(alertBy), true);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(alertBy));
		assertEquals(isElemenViseble(By.xpath("//*[@class=\"modal-open\"]")), false);
		
	}
	
	public boolean isElemenViseble(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C://Users//LQA//Downloads//setting//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();// open window full screen
		driver.get("https://www.seleniumeasy.com/test/bootstrap-progress-bar-dialog-demo.html");
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
