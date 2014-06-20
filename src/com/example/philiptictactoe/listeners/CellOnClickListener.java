package com.example.philiptictactoe.listeners;

import com.example.philiptictactoe.application.CrossSingleton;
import com.example.philiptictactoe.view.GridCellView;

import android.graphics.Canvas;
import android.view.View;
import android.view.View.OnClickListener;

public class CellOnClickListener implements OnClickListener {

	private GridCellView cell;
	private int cellHeight;
	private int cellWidth;

	@Override
	public void onClick(View view) {
		cell = (GridCellView) view;
		cellWidth = cell.getWidth();
		cellHeight = cell.getHeight();
		((GridCellView) view).setMainDiagonalDimensions(0, cellHeight, cellWidth, 0);
		((GridCellView) view).setSecondaryDiagonalDimensions(0, 0, cellWidth, cellHeight);
		view.draw(new Canvas());
		view.invalidate();
		CrossSingleton instance = CrossSingleton.getInstance();
		boolean status = instance.getCross();
		instance.setCross(!status);
	}
}
