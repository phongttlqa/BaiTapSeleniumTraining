package com.selenium.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class CheckboxDemo {
	private WebDriver driver ;
	private WebElement element; 
  @Test
  public void checkBoxTest() throws InterruptedException {
	  element = driver.findElement(By.xpath("//*[@id=\"isAgeSelected\"]"));
	  if (!element.isSelected()) {
		  element.click();  
	  } 
	  Thread.sleep(3000);
	  element.click();
	  Thread.sleep(3000);
//	  element = driver.findElement(By.xpath("//*[@id=\"txtAge\"]"));
//	  String textCheckBoxString  = element.getText();
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C://Users//LQA//Downloads//setting//chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();// open window full screen
	  driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
