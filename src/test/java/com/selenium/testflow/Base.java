package com.selenium.testflow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.test.Utils;

public class Base {
	
	public boolean isElemenViseble(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean isElemenViseble(WebDriver driver,By by, long timeOut) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeOut));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public WebElement wait(WebDriver driver, By by, long timeout) {
		for (int i = 0; i < timeout/500; i++) {
			if (isElemenViseble(driver,by)) {
				return driver.findElement(by);
			} else {
				Utils.pause(500); // cho 0.5s check 1 lan.
			}
		}
		return null;
	}
	
	public void pause(long time) throws InterruptedException {
			Thread.sleep(time);
	}
	
	public WebElement waitLoadElement(WebDriver driver, By by, long timeout) { // millis
		for (int i = 0; i < timeout/500; i++) {
			if (isElemenViseble(driver, by)) {
				return driver.findElement(by);
			} else {
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500)); // wait 0.5s
			}
		}
		return null;
	}
	
	public void explicitWaitVisible(WebDriver driver, By by, long timeout) { // millis
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void explicitWaitInvisible(WebDriver driver, By by, long timeout) { // millis
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	
	public void implicitWait(WebDriver driver,long timeout) { // millis
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(timeout));
	}
}
