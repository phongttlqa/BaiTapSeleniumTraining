package com.selenium.ecercise;

import org.testng.annotations.Test;

import com.selenium.test.Utils;

import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Bai8 {
	private WebDriver driver;
	private WebElement elementTable;
	private By nextLocator =  By.xpath("//*[@class=\"paginate_button next\"]");
	private List<WebElement> rowsOfTable, columsOfRow;
	private List<Person> persons = new ArrayList<Person>();

	@Test
	public void personsInNewYork() {
		persons.clear();
		int page = 1;
		boolean flag = false;
		while (!flag) {
			countTable(page, "New York");
			if (!isElemenViseble(nextLocator)) {
				flag = true;
			}
			page++;
		}
		System.out.println("Co " + persons.size() + " nguoi o New York.");
		for (Person person : persons) {
			System.out.println(person.getName());
		}
	}
	
	@Test
	public void personsInNewYorkBySearch() {
		driver.findElement(By.xpath("//*[@id=\"example_filter\"]/label/input")).sendKeys("New York");
		Utils.pause(2000);
		persons.clear();
		int page = 1;
		boolean flag = false;
		while (!flag) {
			countTable(page, "New York");
			if (!isElemenViseble(nextLocator)) {
				flag = true;
			}
			page++;
		}
		System.out.println("Co " + persons.size() + " nguoi o New York.");
		for (Person person : persons) {
			System.out.println(person.getName());
		}
	}
	

	@Test
	public void AccountantInTokyo() {
		persons.clear();
		int page = 1;
		boolean flag = false;
		while (!flag) {
			countTable(page, "Tokyo", "Accountant");
			if (!isElemenViseble(nextLocator)) {
				flag = true;
			}
			page++;
		}
		System.out.println("Co " + persons.size() + " nguoi o Tokyo lam Accountant.");
		for (Person person : persons) {
			System.out.println(person.getName());
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
	
	public void countTable(int p, String address) {
		if (p != 1) {
			driver.findElement(nextLocator).click();
		}
		elementTable = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody")); 
		rowsOfTable = elementTable.findElements(By.tagName("tr")); 
		for (int row = 0; row < rowsOfTable.size(); row++) {
			columsOfRow = rowsOfTable.get(row).findElements(By.tagName("td")); 
			if (columsOfRow.get(2).getText().equals(address)) { 
				persons.add(new Person(columsOfRow.get(0).getText(), columsOfRow.get(2).getText(),
						columsOfRow.get(1).getText()));
			}
		}
	}
	
	public void countTable(int p, String address, String job) {
		if (p != 1) {
			driver.findElement(nextLocator).click();
		}
		elementTable = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody"));
		rowsOfTable = elementTable.findElements(By.tagName("tr")); 
		for (int row = 0; row < rowsOfTable.size(); row++) {
			columsOfRow = rowsOfTable.get(row).findElements(By.tagName("td")); 
			if (columsOfRow.get(2).getText().equals(address) && columsOfRow.get(1).getText().equals(job)) {
				persons.add(new Person(columsOfRow.get(0).getText(), columsOfRow.get(2).getText(),
						columsOfRow.get(1).getText()));
			}
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C://Users//LQA//Downloads//setting//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/table-data-download-demo.html");
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
