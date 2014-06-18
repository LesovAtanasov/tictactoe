package com.example.philiptictactoe.listeners;

import com.example.philiptictactoe.GetUsernamesActivity;
import com.example.philiptictactoe.MainActivity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class StartGameButtonListener implements OnClickListener {

	private MainActivity mainActivity;

	public StartGameButtonListener(MainActivity mainActivity) {
		this.mainActivity = mainActivity;
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(mainActivity, GetUsernamesActivity.class);
		mainActivity.startActivity(intent);
	}
}
