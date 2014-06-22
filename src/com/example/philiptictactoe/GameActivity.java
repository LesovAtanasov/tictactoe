package com.example.philiptictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import com.example.philiptictactoe.adapter.GridAdapter;

public class GameActivity extends Activity {
	
	private Player firstPlayer;
	private Player secondPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		GridView field = (GridView) findViewById(R.id.grid);
		
		String[] fieldList = new String[9];
		for(int i =0; i < 9;i++){
			fieldList[i] = "cell" + i;
		}
		
		field.setAdapter(new GridAdapter(fieldList,this));
		
		Intent intent = getIntent();
		firstPlayer = new Player(intent.getStringExtra("player_one").toString());
		secondPlayer = new Player(intent.getStringExtra("player_two").toString());
		
		TextView playerOne = (TextView) findViewById(R.id.player_one_name);
		playerOne.setText(firstPlayer.getName());
		
		TextView playerTwo = (TextView) findViewById(R.id.player_two_name);
		playerTwo.setText(secondPlayer.getName());
		
		TextView playerOneScore = (TextView) findViewById(R.id.player_one_score);
		playerOneScore.setText("" +firstPlayer.getStats());
		
		TextView playerTwoScore = (TextView) findViewById(R.id.player_two_score);
		playerTwoScore.setText("" +secondPlayer.getStats());
		
	}
}