package com.example.philiptictactoe.listeners;

import com.example.philiptictactoe.GameActivity;
import com.example.philiptictactoe.GetUsernamesActivity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class SaveButtonListener implements OnClickListener {
	
	private GetUsernamesActivity thisClass;
	private EditText playerOne;
	private EditText playerTwo;

	public SaveButtonListener(GetUsernamesActivity getUsernamesActivity, EditText playerOneParam, EditText playerTwoParam) {
		thisClass = getUsernamesActivity;
		playerOne = playerOneParam;
		playerTwo = playerTwoParam;
	}

	@Override
	public void onClick(View v) {
		
		if ((playerOne.getText().toString().length() != 0) && (playerTwo.getText().toString().length() != 0)) {
			String playerOneName = playerOne.getText().toString();
			String playerTwoName = playerTwo.getText().toString();
			Intent intent = new Intent(thisClass,
					GameActivity.class);
			
			intent.putExtra("player_one", playerOneName);
			intent.putExtra("player_two", playerTwoName);
			thisClass.startActivity(intent);
		}
		
	}

}
