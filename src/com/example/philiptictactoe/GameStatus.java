package com.example.philiptictactoe;

import android.widget.GridView;

import com.example.philiptictactoe.view.GridCellView;

public class GameStatus {
	
	private static final int ZERO_CONST = 0;
	private static final int ONE_CONST = 1;
	private static final int TWO_CONST = 2;
	private static final int THREE_CONST = 3;
	private static final int SIX_CONST = 6;

	private GridCellView currentCell;
	private String gameStatus;
	private GridView grid;

	public GameStatus(GridCellView cell, GridView grid) {
		this.currentCell = cell;
		this.grid = grid;
		gameStatus = null;
		if(gameStatus == null) {
			gameStatus = checkRows();
			if(gameStatus == null) {
				gameStatus = checkCols();
				if(gameStatus == null) {
					gameStatus = checkDiagonals();
					if(gameStatus == null) {
						gameStatus = checkDraw();
					}
				}
			}
		}
	}

	private String checkDraw() {
		boolean flag = false;
		String status = null;
		GridCellView gridCurrentCellView;
		for(int i=0; i<9; i++) {
			gridCurrentCellView = (GridCellView) grid.getChildAt(i);
			if(gridCurrentCellView != null && gridCurrentCellView.getClicked()) {
				flag = true;
			} else {
				flag = false;
				return status;
			}
		}

		return status = "draw";
	}

	public String getGameStatus() {
		return gameStatus;
	}
	
	private String checkRows() {
		String status = null;
		if(currentCell.getClicked()) {
			if(currentCell.getId() >= ZERO_CONST && currentCell.getId() <= 2) {
				status = checkCurrentRow(status, ZERO_CONST);
			} else if(currentCell.getId() >= THREE_CONST && currentCell.getId() <= 5) {
				status = checkCurrentRow(status, THREE_CONST);
			} else if(currentCell.getId() >= SIX_CONST && currentCell.getId() <= 8) {
				status = checkCurrentRow(status, SIX_CONST);
			}
		}
		
		return status;
	}

	private String checkCurrentRow(String status, int firstCellInRow) {
		GridCellView gridFirstCellView = (GridCellView) grid.getChildAt(firstCellInRow);
		GridCellView gridSecondCellView = (GridCellView) grid.getChildAt(firstCellInRow+1);
		GridCellView gridThirdCellView = (GridCellView) grid.getChildAt(firstCellInRow+2);
		
		return checkSymbolMatch(status, gridFirstCellView, gridSecondCellView,
				gridThirdCellView);
	}

	private String checkSymbolMatch(String status, GridCellView gridFirstCellView,
			GridCellView gridSecondCellView, GridCellView gridThirdCellView) {
		boolean checkCellsInRowNotNull = gridFirstCellView.getSymbolType() != null && gridSecondCellView.getSymbolType() != null && gridThirdCellView.getSymbolType() != null;
		
		if(checkCellsInRowNotNull) {
			boolean checkCellsGotEqualSymbols = gridFirstCellView.getSymbolType().equals(gridSecondCellView.getSymbolType())
					&&  gridFirstCellView.getSymbolType().equals(gridThirdCellView.getSymbolType());
			
			if(checkCellsGotEqualSymbols) {
				status = "win";
			}
		}
		return status;
	}
	
	private String checkCols() {
		String status = null;
		if(currentCell.getClicked()) {
			if(currentCell.getId() == ZERO_CONST || currentCell.getId() == ZERO_CONST+3 || currentCell.getId() == ZERO_CONST+6) {
				status = checkCurrentCol(status, ZERO_CONST);
			} else if(currentCell.getId() == ONE_CONST || currentCell.getId() == ONE_CONST+3 || currentCell.getId() == ONE_CONST+6) {
				status = checkCurrentCol(status, ONE_CONST);
			} else if(currentCell.getId() == TWO_CONST || currentCell.getId() == TWO_CONST+3 || currentCell.getId() == TWO_CONST+6) {
				status = checkCurrentCol(status, TWO_CONST);
			}
		}
		
		return status;
	}
	
	private String checkCurrentCol(String status, int firstCellInRow) {
		GridCellView gridFirstCellView = (GridCellView) grid.getChildAt(firstCellInRow);
		GridCellView gridSecondCellView = (GridCellView) grid.getChildAt(firstCellInRow+3);
		GridCellView gridThirdCellView = (GridCellView) grid.getChildAt(firstCellInRow+6);
		
		return checkSymbolMatch(status, gridFirstCellView, gridSecondCellView,
				gridThirdCellView);
	}

	private String checkDiagonals() {
		String status = null;
		if(currentCell.getClicked()) {
			if(currentCell.getId() == ZERO_CONST || currentCell.getId() == ZERO_CONST+4 || currentCell.getId() == ZERO_CONST+8) {
				status = checkMainDiagonal(status, ZERO_CONST);
			} else if(currentCell.getId() == TWO_CONST || currentCell.getId() == TWO_CONST+2 || currentCell.getId() == TWO_CONST+4) {
				status = checkSecondaryDiagonal(status, TWO_CONST);
			} 
		}
		
		return status;
	}

	private String checkSecondaryDiagonal(String status, int firstCellInRow) {
		GridCellView gridFirstCellView = (GridCellView) grid.getChildAt(firstCellInRow);
		GridCellView gridSecondCellView = (GridCellView) grid.getChildAt(firstCellInRow+2);
		GridCellView gridThirdCellView = (GridCellView) grid.getChildAt(firstCellInRow+4);
		
		return checkSymbolMatch(status, gridFirstCellView, gridSecondCellView,
				gridThirdCellView);
	}

	private String checkMainDiagonal(String status, int firstCellInRow) {
		GridCellView gridFirstCellView = (GridCellView) grid.getChildAt(firstCellInRow);
		GridCellView gridSecondCellView = (GridCellView) grid.getChildAt(firstCellInRow+4);
		GridCellView gridThirdCellView = (GridCellView) grid.getChildAt(firstCellInRow+8);
		
		return checkSymbolMatch(status, gridFirstCellView, gridSecondCellView,
				gridThirdCellView);
	}
	
}
