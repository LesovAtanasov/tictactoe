package com.example.philiptictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView text = (TextView) findViewById(R.id.text_view);
		text.setText("Text View");

		Button button = (Button) findViewById(R.id.button1);
		button.setText("Button View");
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("Annonymous");
			}
		});
	}

	public void buttonOnClick(View view) {
		System.out.println("Asad");
	}
}
