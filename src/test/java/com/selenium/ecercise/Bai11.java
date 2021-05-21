package com.selenium.ecercise;

import org.testng.annotations.Test;

import com.selenium.test.Utils;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Bai11 {
	private WebDriver driver;
	private List<WebElement> rowsOfTable, columsOfRow;
	private WebElement tableElement;

	@Test
	public void searchAndCheck() {
		// search
		driver.findElement(By.xpath("//*[@id=\"task-table-filter\"]")).sendKeys("smith");
		Utils.pause(1000);
		
		tableElement = driver.findElement(By.xpath("//*[@id=\"task-table\"]/tbody")); // get table
		rowsOfTable = tableElement.findElements(By.tagName("tr")); // get hang
		for (int row = 0; row < rowsOfTable.size(); row++) {
			boolean b  = driver.findElement(By.xpath("//*[@id=\"task-table\"]/tbody/tr[" + (row + 1) + "]")).getAttribute("style").contains("display: none");
			if (!b) {
				columsOfRow = rowsOfTable.get(row).findElements(By.tagName("td"));
				if (columsOfRow.get(2).getText().equals("John Smith")) { // get gia tri cua cot
					System.out.println(true);
				}
			}
			
		}
		
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C://Users//LQA//Downloads//setting//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
