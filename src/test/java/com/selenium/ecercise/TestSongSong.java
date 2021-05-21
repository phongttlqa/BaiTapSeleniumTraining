package com.selenium.ecercise;

import org.testng.annotations.Test;

import com.selenium.test.Utils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class TestSongSong {
	private WebDriver driver;
	private WebElement elementFrom, elementTo;

	@Test
	public void dragAndDrop() {
		Actions action = new Actions(driver);
		elementFrom = driver.findElement(By.xpath("//*[@id=\"credit2\"]/a"));
		elementTo = driver.findElement(By.xpath("//*[@id=\"bank\"]/li"));
		action.dragAndDrop(elementFrom, elementTo).build().perform();
		Utils.pause(1000);
		elementFrom = driver.findElement(By.xpath("//*[@id=\"credit1\"]/a"));
		elementTo = driver.findElement(By.xpath("//*[@id=\"loan\"]/li"));
		action.dragAndDrop(elementFrom, elementTo).build().perform();
		Utils.pause(1000);
		elementFrom = driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
		elementTo = driver.findElement(By.xpath("//*[@id=\"amt7\"]/li"));
		action.dragAndDrop(elementFrom, elementTo).build().perform();
		Utils.pause(1000);
		elementFrom = driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
		elementTo = driver.findElement(By.xpath("//*[@id=\"amt8\"]/li"));
		action.dragAndDrop(elementFrom, elementTo).build().perform();
		Utils.pause(1000);
	}

	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C://Users//LQA//Downloads//setting//geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get("http://demo.guru99.com/test/drag_drop.html");
			System.out.println("Run FireFox");
		} else {
			System.setProperty("webdriver.chrome.driver", "C://Users//LQA//Downloads//setting//chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://demo.guru99.com/test/drag_drop.html");
			System.out.println("Run Google Chrome");
		}
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
