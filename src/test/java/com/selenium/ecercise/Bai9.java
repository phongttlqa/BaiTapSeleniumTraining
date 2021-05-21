package com.selenium.ecercise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class Bai9 {
	private WebDriver driver;
	
  @Test
  public void selectDay() {
	  driver.findElement(By.xpath("//*[@id=\"from\"]")).click();
	  driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select")).click();
	  new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select"))).selectByIndex(0);
	  driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]")).click();
	  new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select"))).selectByIndex(2);
	  driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[1]/a")).click();
	  
	  
	  
	  driver.findElement(By.xpath("//*[@id=\"to\"]")).click();
	  driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select")).click();
	  new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select"))).selectByIndex(0);
	  driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]")).click();
	  new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select"))).selectByVisibleText("May");
	  driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[3]/a")).click();
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C://Users//LQA//Downloads//setting//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/jquery-date-picker-demo.html");
  }

  @AfterMethod
  public void afterMethod() {
	  //driver.close();
  }

}
