package Listeners;

import com.example.philiptictactoe.GetUsernamesActivity;
import com.example.philiptictactoe.MainActivity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class StartGameButtonListener implements OnClickListener {

	private MainActivity thisClass;

	public StartGameButtonListener(MainActivity mainActivity) {
		thisClass = mainActivity;
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(thisClass,
				GetUsernamesActivity.class);
		thisClass.startActivity(intent);
		
	}

}
