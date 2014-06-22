package com.example.philiptictactoe.listeners;

import android.content.Context;
import android.graphics.Canvas;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.PopupWindow;

import com.example.philiptictactoe.GameStatus;
import com.example.philiptictactoe.R;
import com.example.philiptictactoe.application.CrossSingleton;
import com.example.philiptictactoe.view.GridCellView;

public class CellOnClickListener implements OnClickListener {

	private static final int halfCellWidthDivisionConst = 2;
	private static final int halfCellHeightDivisionConst = 2;
	private static final boolean clicked = true;
	private GridCellView cell;
	private float cellHeight;
	private float cellWidth;
	private float halfCellWidth;
	private float halfCellHeight;
	private String gameStatus;
	private GridView grid;
	private PopupWindow popup;
	
	public CellOnClickListener(GridView parent) {
		this.grid = parent;
	}

	@Override
	public void onClick(View view) {
		cell = (GridCellView) view;
		if(!cell.getClicked()) {
			cell.setClicked(clicked);
			cellWidth = cell.getWidth();
			cellHeight = cell.getHeight();
			halfCellWidth = cellWidth / halfCellWidthDivisionConst;
			halfCellHeight = cellHeight / halfCellHeightDivisionConst;
			((GridCellView) view).setMainDiagonalDimensions(0, cellHeight, cellWidth, 0);
			((GridCellView) view).setSecondaryDiagonalDimensions(0, 0, cellWidth, cellHeight);
			((GridCellView) view).setCircleDimensions(halfCellWidth, halfCellHeight, halfCellWidth);
			view.draw(new Canvas());
			view.invalidate();
			CrossSingleton instance = CrossSingleton.getInstance();
			boolean status = instance.getCross();
			cell.setSymbolType(status);
			instance.setCross(!status);
			GameStatus checkStatus = new GameStatus(cell, grid);
			gameStatus = checkStatus.getGameStatus();
			if(gameStatus != null) {
				LayoutInflater inflater = (LayoutInflater)
					       view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				popup = new PopupWindow(inflater.inflate(R.layout.popup, null, false), 500, 500, true);
				if(gameStatus.equals("win")) {
					popup.showAtLocation(view, Gravity.CENTER, 0, 0); 
					System.out.println("WIN WIN WIN");
				} else if(gameStatus.equals("draw")) {
					System.out.println("DRAW DRAW DRAW");
				}
			}
		}
	}
}
