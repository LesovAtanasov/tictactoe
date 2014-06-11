package com.example.philiptictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GameActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		Intent intent = getIntent();
		final String playerOneName = intent.getStringExtra("player_one").toString();
		final String playerTwoName = intent.getStringExtra("player_two").toString();
		
		TextView playerOne = (TextView) findViewById(R.id.player_one_name);
		playerOne.setText(playerOneName);
		
		TextView playerTwo = (TextView) findViewById(R.id.player_two_name);
		playerTwo.setText(playerTwoName);
		
		GameField field = new GameField();
		field.drawField();
		
	}
	
}