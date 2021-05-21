package com.selenium.ecercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Base {
	private WebDriver webDriver;
	
	public boolean isElemenViseble(By by) {
		try {
			webDriver.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
