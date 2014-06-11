package Listeners;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.philiptictactoe.CreditsActivity;
import com.example.philiptictactoe.MainActivity;

public class CreditsButtonListener implements OnClickListener {

	private MainActivity thisClass;

	public CreditsButtonListener(MainActivity mainActivity) {
		thisClass = mainActivity;
	}

	@Override
	public void onClick(View v) {
		
		Intent intent = new Intent(thisClass,
				CreditsActivity.class);

		thisClass.startActivity(intent);
		
	}

}
