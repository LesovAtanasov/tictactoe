package com.example.philiptictactoe.application;

public class CrossSingleton {
	
	private static CrossSingleton instance;
	private boolean isCross;
	
	private CrossSingleton() {
		
	}
	
	public static CrossSingleton getInstance() {
		if(instance == null) {
			return instance = new CrossSingleton();
		} else {
			return instance;
		}
	}

	public void setCross(boolean b) {
		isCross = b;
	}
	
	public boolean getCross() {
		return isCross;
	}
	
}
