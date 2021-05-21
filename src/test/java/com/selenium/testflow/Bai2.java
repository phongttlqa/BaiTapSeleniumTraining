package com.selenium.testflow;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Bai2 {
	private WebDriver driver;

	@Test
	public void f() {
		driver.findElement(By.xpath("//*[@id=\"save\"]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'First Name')]")));
		String text = driver.findElement(By.xpath("//*[contains(text(), 'First Name')]")).getText();
		System.out.println(text);
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C://Users//LQA//Downloads//setting//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();// open window full screen
		driver.get("https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html");
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
