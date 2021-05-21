package com.selenium.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.sql.Driver;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class FisrtTestDemo {
	private WebDriver driver ;
	private WebElement element;  
	
	
//  @Test
//  public void openSite() {
//	  System.setProperty("webdriver.chrome.driver", "C://Users//LQA//Downloads//setting//chromedriver.exe");
//	  driver = new ChromeDriver();
//	  driver.manage().window().maximize();// open window full screen
//	  driver.get("https://www.seleniumeasy.com/test/");
//  }
  
//  @Test
//  public void findAndGetText() {
//	  element = driver.findElement(By.xpath("//*[@id=\"get-input\"]/button"));
//	  String text = element.getText();
//	  System.out.println("Hien thi text tim duoc theo xpath" + text);
//  }
  
  @Test
  public void inputAndShowText() {
	  String mess = "AAAAAAAAA";
	  element = driver.findElement(By.xpath("//*[@placeholder=\"Please enter your Message\"]"));
	  element.sendKeys(mess);
	  element = driver.findElement(By.xpath("//*[@id=\"get-input\"]/button"));
	  element.click();
	  element = driver.findElement(By.xpath("//*[@id=\"display\"]"));
	  String textShow = element.getText();
	  System.out.println(textShow.equals(mess) ? "TRUE " : "FALSE "); 
	  textShow = "A";
	  assertEquals(mess, textShow, "Text khong giong nhau.");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C://Users//LQA//Downloads//setting//chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();// open window full screen
	  driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
