package com.selenium.ecercise;

import org.testng.annotations.Test;

import com.selenium.test.Utils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Bai1 extends Base {
	private WebDriver driver;
	private GetDataFromExcel getData = new GetDataFromExcel();
	
	@Test
	public void textDataFromExcel() {
		// tat quang cao tren Chrome di , neu co
		ArrayList<DataGetTotal> dataList = getData.getData();

		for (DataGetTotal data : dataList) {
			  driver.findElement(By.xpath("//*[@id=\"sum1\"]")).clear();
			  driver.findElement(By.xpath("//*[@id=\"sum1\"]")).sendKeys(String.valueOf(data.getA()));
			  
			  driver.findElement(By.xpath("//*[@id=\"sum2\"]")).clear();
			  driver.findElement(By.xpath("//*[@id=\"sum2\"]")).sendKeys(String.valueOf(data.getB()));
			  
			  driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button")).click();
			  String result = driver.findElement(By.xpath("//*[@id=\"displayvalue\"]")).getText();
			  assert(result.equals(String.valueOf(data.getTotal()))) : "Wrong Result";
			  Utils.pause(3000);
		}
		
	}
	
	@DataProvider
	public Object[][] dataset() {
		return new Object[][] {
			{"1","2"},
			{"2","3"}
		};
	}
	
	
	@Test(dataProvider = "dataset")
	  public void dataFromProvider(String a, String b) {
		  driver.findElement(By.xpath("//*[@id=\"sum1\"]")).sendKeys(a);
		  driver.findElement(By.xpath("//*[@id=\"sum2\"]")).sendKeys(b);
		  driver.findElement(By.xpath("//*[@onclick=\"return total()\"]")).click();
		  String result = driver.findElement(By.xpath("//*[@id=\"displayvalue\"]")).getText();
		  assert(result.equals(String.valueOf(Integer.valueOf(a) + Integer.valueOf(b)))) : "Wrong Result";
	  }
	
	
	@Test
  public void inputTextAndShowResult() {
	  String input1 = "5";
	  String input2 = "6";
	  driver.findElement(By.xpath("//*[@id=\"sum1\"]")).sendKeys(input1);
	  driver.findElement(By.xpath("//*[@id=\"sum2\"]")).sendKeys(input2);
	  driver.findElement(By.xpath("//*[@onclick=\"return total()\"]")).click();
	  String result = driver.findElement(By.xpath("//*[@id=\"displayvalue\"]")).getText();
	  assert(result.equals("11")) : "Wrong Result";
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
