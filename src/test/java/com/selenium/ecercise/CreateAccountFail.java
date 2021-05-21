package com.selenium.ecercise;

import org.testng.annotations.Test;
import org.testng.util.TimeUtils;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.helpers.Util;
import org.testng.annotations.AfterMethod;

public class CreateAccountFail {
	private WebDriver driver ;
	private WebElement element;  ; 
	
  @Test
  public void openWeb() {
	  element = driver.findElement(By.xpath("//*[@id=\"isAgeSelected\"]"));
	  // Cho co kieu dien
	  WebDriverWait waitDriver = new WebDriverWait(driver, 3000);
	  waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("xpath")));
	  // cho theo thoi gian mac dinh
	  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	  
	  
	  // check su hien dien cua 1 element
	  By locatorBy  = By.xpath("xpath");
	  if (isElementVisible(locatorBy)) {
		  //todo something
	  } else {
		fail("Message");
	  }
  }
  
 public boolean isElementVisible(By locator) {
	 try {
		 driver.findElement(locator);
		 return true;
	} catch (Exception e) {
		return false;
	}
 }
 
 public WebElement waitAndGetElement(By locator, int timeWait) {
	 // nua giay check 1 lan.
	 for (int i = 0; i < timeWait/500; i++) {
		if (isElementVisible(locator)) {
			return driver.findElement(locator);
		} else {
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		}
	}
	 return null; // cho het thoi gian ma k xuat hien thi tra ve null
 }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C://Users//LQA//Downloads//setting//chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();// open window full screen
	  driver.get("http://automationpractice.com/index.php");
	  
  }

  @AfterMethod
  public void afterMethod() {
  }

}
