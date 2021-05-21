package com.selenium.testflow;

import org.testng.annotations.Test;

import com.selenium.test.Utils;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Bai6 {
	private WebDriver driver;
	private WebElement element;

	@Test
	public void f() {
		// click File Download
		driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[2]/li[2]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[2]/li[2]/ul")));
		driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[2]/li[2]/ul/li[6]")).click();

//		List<WebElement> listDropDown = driver.findElements(By.cssSelector(".dropdown-menu li"));
//		Iterator<WebElement> iterator = listDropDown.iterator();
//		while (iterator.hasNext()) {
//			WebElement dropDown = (WebElement) iterator.next();
//			String ssString = dropDown.getText();
//			if (ssString.equals("File Download")) {
//				dropDown.click();
//			}
//		}

		// mo vnExpress
		((JavascriptExecutor) driver).executeScript("window.open('about:blank', '-blank')");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("https://vnexpress.net/nhung-khac-biet-cua-song-than-covid-19-an-do-4268820.html");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"fck_detail \"]/p[1]")));
		String textString = driver.findElement(By.xpath("//*[@class=\"fck_detail \"]/p[1]")).getText();
//		System.out.println(textString);

		driver.switchTo().window(tabs.get(0));
		driver.findElement(By.xpath("//*[@id=\"textbox\"]")).sendKeys(textString);
		driver.findElement(By.xpath("//*[@id=\"create\"]")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"link-to-download\"]")));
		Utils.pause(3000);

		downloadFile();
	}

	private void downloadFile() {
		// before download
		int countFileBeforeDownload = countFileInDirectory();
		driver.findElement(By.xpath("//*[@id=\"link-to-download\"]")).click();
		try {
			waitForDownloadFileFullnameCompleted("easyinfo.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Download Failed !");
			
		}
		System.out.println(countFileBeforeDownload);
		int countFileAfterDownload = countFileInDirectory();
		System.out.println(countFileAfterDownload);
		assertEquals(countFileAfterDownload - countFileBeforeDownload, 1);
	}

	private int countFileInDirectory() {
		String pathFolderDownload = getPathCointainDownload();
		File file = new File(pathFolderDownload);
		int i = 0;
		for (File listOfFile : file.listFiles()) {
			if (listOfFile.isFile()) {
				i++;
			}
		}
		return i;
	}

	private String getPathCointainDownload() {
		String path = "";
		String machineName = System.getProperty("user.home");
		path = String.format("%s\\Downloads\\", machineName);
		return path;
	}

	public void waitForDownloadFileFullnameCompleted(String fileName) throws Exception {
		int i = 0;
		while (i < 30) {
			boolean exist = isFileExists(fileName);
			if (exist == true) {
				i = 30;
			}
			Thread.sleep(500);
			i = i + 1;
		}
	}

	public boolean isFileExists(String file) {
		try {
			String pathFolderDownload = getPathCointainDownload();
			File files = new File(pathFolderDownload + file);
			boolean exists = files.exists();
			return exists;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C://Users//LQA//Downloads//setting//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/");
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
