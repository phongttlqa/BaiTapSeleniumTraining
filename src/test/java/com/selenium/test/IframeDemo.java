package com.selenium.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class IframeDemo {
	private WebDriver driver ;
	private WebElement element; 
	
  @Test
  public void iframeDemo() {
	  String parentWindowID = driver.getWindowHandle();
	  WebElement frame1 = driver.findElement(By.id("Frame1Id"));
	  driver.switchTo().frame(frame1);
	  // thao tac binh thuong tren frame1 nhu 1 window
	  driver.switchTo().window(parentWindowID);
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C://Users//LQA//Downloads//setting//chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
  }

  @AfterMethod
  public void afterMethod() {
	  Utils.pause(1000);
	  driver.close();
  }

}
