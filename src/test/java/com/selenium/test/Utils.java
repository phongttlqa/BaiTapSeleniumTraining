package com.selenium.test;

public final class Utils {
	public static void pause(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Error timeout for pause process");
		}
	}

}
