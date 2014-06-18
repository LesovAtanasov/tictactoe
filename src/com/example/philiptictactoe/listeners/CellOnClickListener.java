package com.example.philiptictactoe.listeners;

import com.example.philiptictactoe.view.GridCellView;

import android.graphics.Canvas;
import android.view.View;
import android.view.View.OnClickListener;

public class CellOnClickListener implements OnClickListener {

	@Override
	public void onClick(View view) {
		// FIXME: Remove harcoded values.
		((GridCellView) view).setLineDimensions(10, 10, 20, 20);
		view.draw(new Canvas());
		view.invalidate();
	}
}
