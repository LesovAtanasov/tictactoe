package com.example.philiptictactoe.application;

import android.app.Application;

public class PhilipTicTacToeApplication extends Application {
	private CrossSingleton isCross;

	@Override
	public void onCreate() {
		super.onCreate();
		isCross = CrossSingleton.getInstance();
		isCross.setCross(false);
	}
}
