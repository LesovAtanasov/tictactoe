package com.example.philiptictactoe;

import com.example.philiptictactoe.listeners.SaveButtonListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class GetUsernamesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_get_usernames);
		
		final EditText playerOne = (EditText) findViewById(R.id.username_player_one);
		
		final EditText playerTwo = (EditText) findViewById(R.id.username_player_two);
		
		Button saveButton = (Button) findViewById(R.id.save_button);
		
		saveButton.setOnClickListener(new SaveButtonListener(this, playerOne, playerTwo));
		
	}
}