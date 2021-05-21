package com.selenium.ecercise;

import org.testng.annotations.Test;

import com.selenium.test.Utils;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Bai3 {
	private WebDriver driver;
	private WebElement element;
  @Test
  public void basic() {
	  driver.findElement(By.xpath("//label/input[@value=\"Male\"][@name=\"gender\"]")).click();
	  driver.findElement(By.xpath("//label/input[@value=\"5 - 15\"][@name=\"ageGroup\"]")).click();
	  Utils.pause(3000);
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C://Users//LQA//Downloads//setting//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
