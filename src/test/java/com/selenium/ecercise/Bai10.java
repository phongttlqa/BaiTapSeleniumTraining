package com.selenium.ecercise;

import org.testng.annotations.Test;

import com.selenium.test.Utils;

import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Bai10 {
	private WebDriver driver;
	private WebElement elementTable;
	private By nextLocator;
	private List<WebElement> rowsOfTable;
	private int page;

	@Test
	public void countPersons() {
		// Trang nay load ra toan bo cac hang luon, khong theo page
		// bai 6 va 8 load theo page
		nextLocator = By.xpath("//*[@class=\"next_link\"]");
		elementTable = driver.findElement(By.xpath("//*[@class=\"table table-hover\"]/tbody"));
		rowsOfTable = elementTable.findElements(By.tagName("tr"));
		System.out.println("So luong record la : " + rowsOfTable.size());

		page = 1;
		boolean flag = false;
		while (!flag) {
			countRecordOnPage(rowsOfTable.size(), page);
			if (!isElemenViseble(nextLocator)) {
				flag = true;
			} else {
				driver.findElement(nextLocator).click();
			}
			page++;
		}
	}

	public void countRecordOnPage(int size, int p) {
		int count = 0;
		for (int i = 1; i <= size; i++) {
			if (driver.findElement(By.xpath("//*[@id=\"myTable\"]/tr[" + i + "]")).getAttribute("style")
					.contains("display: table-row;")) {
				count++;
			}
		}
		System.out.println("Page " + p + " co " + count + " record.");
	}

	public boolean isElemenViseble(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C://Users//LQA//Downloads//setting//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();// open window full screen
		driver.get("https://www.seleniumeasy.com/test/table-pagination-demo.html");
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
