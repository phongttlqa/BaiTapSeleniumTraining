package com.selenium.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class PopUpDemo {
	private WebDriver driver ;
	private WebElement element;  
	
  @Test
  public void switchPopupByID() {
	  element = driver.findElement(By.linkText("Follow On Twitter"));
	  element.click();
	  String parentWindowId = driver.getWindowHandle();
	  Set<String> handles = driver.getWindowHandles();// lay danh sach id cua cac window, trong TH co hai 2 cai.
	  String twitterPopunHandle = null;
	  for (String h : handles) {
		  if (!h.equals(parentWindowId)) {
			  twitterPopunHandle = h;
		  }
	  }
	  // con 2 cach khac
	  // switch sang tung window roi so sanh title
	  // switch sang tung window roi tim su xuat hien cua mot content nao do
	  // driver.getPageSource().contains("Doan text content can so sanh");
	  // ham nay se lay toan bo text cua trang web do. sau do contains voi dona text ta can tim.
	  
	  try {
		driver.switchTo().window(twitterPopunHandle);// tham so co the la name of popup ok
	  } catch (NoSuchWindowException e) {
		// TODO: something at here
	  }
	  Utils.pause(5000);
	  driver.close();// popup Twitter close
	  driver.switchTo().window(parentWindowId);
	  driver.findElement(By.linkText("Demo Home")).click();
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C://Users//LQA//Downloads//setting//chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
  }

  @AfterMethod
  public void afterMethod() {
	  Utils.pause(1000);
	  driver.close();
  }

}
