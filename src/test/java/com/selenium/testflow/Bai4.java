package com.selenium.testflow;

import org.testng.annotations.Test;

import com.selenium.test.Utils;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Bai4 {

	private WebDriver driver;
	private WebElement element;

	@Test
	public void f() {
		element = driver.findElement(By.xpath("//*[@class=\"percenttext\"]"));
//		System.out.println(element.getText());
		
		driver.findElement(By.xpath("//*[@id=\"cricle-btn\"]")).click();
		boolean flag = false;
		for (int i = 0; i < 30; i++) {
			if (element.getText().equals("100%")) {
				System.out.println("Download done!");
				flag = true;
				break;
			} else {
				Utils.pause(1000); 
			}
		}
		if (!flag) {
			System.out.println("Download failed ! Time out !");
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C://Users//LQA//Downloads//setting//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/bootstrap-download-progress-demo.html");
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
