package com.selenium.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class DropDownListDemo {
	private WebDriver driver ;
  @Test
  public void dropDownDemo() throws InterruptedException {
	  driver.findElement(By.xpath("//span[@aria-labelledby=\"select2-country-container\"]")).click();
	  new Select(driver.findElement(By.xpath("//*[@id=\"country\"]"))).selectByIndex(4);
	  driver.findElement(By.xpath("//span[@aria-labelledby=\"select2-country-container\"]")).click();
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C://Users//LQA//Downloads//setting//chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();// open window full screen
	  driver.get("https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html");
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.close();
  }

}
