package com.selenium.ecercise;

import org.testng.annotations.Test;

import com.selenium.test.Utils;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
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

public class Bai4 {
	private WebDriver driver;
	private String sex, ageOfGroup, result;
	
  @Test
  public void getDataFromExcel() {
	  getData();
	  if (!sex.isEmpty()) {
		  String xpathSex = "//label/input[@value=\""+sex+"\"][@name=\"gender\"]";
		  driver.findElement(By.xpath(xpathSex)).click();
	  }
	  if (!ageOfGroup.isEmpty()) {
		  if (ageOfGroup.equals("0 to 5")) {
			  ageOfGroup = "0 - 5";
		  } else if (ageOfGroup.equals("5 to 15")) {
			  ageOfGroup = "5 - 15";
		  } else if (ageOfGroup.equals("15 to 50")){
			  ageOfGroup = "15 - 50";
		  }
		  String xpathAge = "//label/input[@value=\""+ageOfGroup+"\"][@name=\"ageGroup\"]";
		  driver.findElement(By.xpath(xpathAge)).click();;
	  }
	  driver.findElement(By.xpath("//*[@onclick=\"getValues();\"]")).click();

	  WebDriverWait wait = new WebDriverWait(driver, 500);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/p[2]")));
	  String text = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/p[2]")).getText();
	  assert(result.equals(text)) :  "Wrong Result";
//	  System.out.println("result" + result);
//	  System.out.println("text" + text);
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C://Users//LQA//Downloads//setting//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
  }
  
  public void getData() {
	  FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(new File("C:\\Users\\LQA\\Desktop\\PhongTT\\Bai4.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workbook.getSheetAt(0);
//			FormulaEvaluator formulaEvaluator=workbook.getCreationHelper().createFormulaEvaluator();  
			for (Row row : sheet) {
				for (Cell cell : row) {
					switch (cell.getColumnIndex()) {
					case 0:
						sex = cell.getStringCellValue();
						break;
					case 1:
						ageOfGroup = cell.getStringCellValue();
						break;
					case 2:
						result = cell.getStringCellValue();
						break;
					default:
						break;
					}
				}
			}
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }
}
