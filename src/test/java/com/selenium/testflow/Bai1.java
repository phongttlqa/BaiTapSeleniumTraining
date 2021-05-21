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

public class Bai1 {
	private WebDriver driver;

	@Test
	public void f() {
		driver.findElement(By.xpath("//*[@id=\"downloadButton\"]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"Complete!\"]")));
		driver.findElement(By.xpath("//*[text()=\"Close\"]")).click();
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C://Users//LQA//Downloads//setting//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();// open window full screen
		driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
}
