package com.selenium.ecercise;

public class DataGetTotal {
	private int a, b;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
	public int getTotal() {
		int tong = a +b;
		return tong;
	}

	public DataGetTotal(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	public DataGetTotal() {
		super();
	}
}
