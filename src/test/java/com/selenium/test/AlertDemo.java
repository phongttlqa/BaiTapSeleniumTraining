package com.selenium.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class AlertDemo {
	private WebDriver driver ;
	private WebElement element; 
	private Alert alert;
  @Test
  public void simpleAlert() {
	  driver.findElement(By.xpath("//*[@onclick=\"myAlertFunction()\"]")).click();
	  alert = driver.switchTo().alert();
	  Utils.pause(1000);
	  alert.accept();  // click OK Button
	  Utils.pause(1000);
  }
  
  
  @Test
  public void confirmAlert() {
	  element = driver.findElement(By.xpath("//*[@onclick=\"myConfirmFunction()\"]"));
	  element.click();
	  alert = driver.switchTo().alert();
	  Utils.pause(1000);
	  alert.accept();  // click OK Button
	  Utils.pause(1000);
	  
	  element.click();
	  alert = driver.switchTo().alert();
	  Utils.pause(1000);
	  alert.dismiss();  // click Cancel Button
	  Utils.pause(1000);
  }
  
  @Test
  public void promtAlert() {
	  driver.findElement(By.xpath("//*[@onclick=\"myPromptFunction()\"]")).click();
	  alert = driver.switchTo().alert();
	  Utils.pause(1000);
	  alert.sendKeys("Nhap mot doan text");
	  Utils.pause(1000);
	  alert.accept();
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
