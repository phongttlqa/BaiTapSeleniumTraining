package com.selenium.ecercise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Bai6 {
	private WebDriver driver;
	private WebElement elementTable;
	private By nextLocator;
	private List<WebElement> rowsOfTable, columsOfRow;
	private List<String> persons = new ArrayList<String>();
	private int page;

	@Test
	public void countPersons() {
		page = 1;
		nextLocator = By.xpath("//*[@class=\"paginate_button next\"]");
		boolean flag = false;
		while (!flag) {
			countTable(page);
			if (!isElemenViseble(nextLocator)) {
				flag = true;
			}
			page++;
		}
		System.out.println("Co " + persons.size() + " nguoi o London.");
		for (String s : persons) {
			System.out.println(s);
		}
	}

	public boolean isElemenViseble(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void countTable(int page) {
		if (page != 1) {
			driver.findElement(By.xpath("//*[@id=\"example_next\"]")).click();
		}
		elementTable = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody")); // get table
		rowsOfTable = elementTable.findElements(By.tagName("tr")); // get hang
		for (int row = 0; row < rowsOfTable.size(); row++) {
			columsOfRow = rowsOfTable.get(row).findElements(By.tagName("td")); // get cot
			if (columsOfRow.get(2).getText().equals("London")) { // get gia tri cua cot
				persons.add(columsOfRow.get(0).getText());
			}
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C://Users//LQA//Downloads//setting//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
