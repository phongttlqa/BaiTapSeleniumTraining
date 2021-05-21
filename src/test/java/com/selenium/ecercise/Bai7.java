package com.selenium.ecercise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Bai7 extends Base {
	private WebDriver driver;
	private WebElement element;

	@Test
	public void sigup() {
		// click login
		driver.findElement(By.xpath("//*[@title=\"Log in to your customer account\"]")).click();
		// *[text()="Please enter your email address to create an account."]
		// nhap email
		driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys("sinh.dir@toannhat.vn");
		// click create button
		driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]")).click();
		
		element =  new WebDriverWait(driver, 10000).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_gender1\"]")));
		element.click();
		
		// nhap thong tin
		driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]")).sendKeys("Tran");
		driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]")).sendKeys("Phong");
		driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("123456abc");
		// chon ngay thang nam sinh
		driver.findElement(By.xpath("//*[@id=\"days\"]")).click();
		new Select(driver.findElement(By.xpath("//*[@id=\"days\"]"))).selectByValue("16");
		driver.findElement(By.xpath("//*[@id=\"months\"]")).click();
		new Select(driver.findElement(By.xpath("//*[@id=\"months\"]"))).selectByIndex(7);
		driver.findElement(By.xpath("//*[@id=\"years\"]")).click();
		new Select(driver.findElement(By.xpath("//*[@id=\"years\"]"))).selectByValue("1994");
		// check box
		driver.findElement(By.xpath("//*[@id=\"newsletter\"]")).click();

		// nhap dia chi
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("AAAA");
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("BBBB");
		driver.findElement(By.xpath("//*[@id=\"company\"]")).sendKeys("LQA");
		driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("Nguyen Co Thach");
		driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Hanoi");

		//
		driver.findElement(By.xpath("//*[@id=\"id_state\"]")).click();
		new Select(driver.findElement(By.xpath("//*[@id=\"id_state\"]"))).selectByIndex(1);
		// zip code
		driver.findElement(By.xpath("//*[@id=\"postcode\"]")).sendKeys("10001");
		// country
		//
		driver.findElement(By.xpath("//*[@id=\"id_country\"]")).click();
		new Select(driver.findElement(By.xpath("//*[@id=\"id_country\"]"))).selectByIndex(1);
		// mobile
		driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]")).sendKeys("0388359558");
		driver.findElement(By.xpath("//*[@id=\"alias\"]")).sendKeys("demoyotu3@gmail.com");
		// click
		 driver.findElement(By.xpath("//*[@id=\"submitAccount\"]")).click();

	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C://Users//LQA//Downloads//setting//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}

	@AfterMethod
	public void afterMethod() {
//		driver.close();
	}

}
