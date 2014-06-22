package com.example.philiptictactoe.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.philiptictactoe.R;
import com.example.philiptictactoe.application.CrossSingleton;

public class GridCellView extends View {

	private static final String symbolTypeCross = "cross";

	private static final String symbolTypeCircle = "circle";

	private Paint drawPaint;

	private ViewGroup parent;

	private float mainStartX;

	private float mainStartY;

	private float mainEndX;

	private float mainEndY;

	private float secondaryStartX;

	private float secondaryEndX;

	private float secondaryStartY;

	private float secondaryEndY;

	private float circleY;

	private float circleX;

	private float circleRadius;

	private boolean isClicked;

	private String symbolType;

	public GridCellView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public GridCellView(Context context, ViewGroup parent) {
		super(context);
		this.parent = parent;
		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mInflater.inflate(R.drawable.rectangle_view, parent, false);
		setBackgroundResource(R.drawable.rectangle);

		initPaint();
		initDefaultLineDimensions();
		initDefaultCircleDimensions();
	}

	private void initPaint() {
		drawPaint = new Paint();
		drawPaint.setColor(Color.RED);
		drawPaint.setStrokeWidth(25);
		drawPaint.setStyle(Paint.Style.STROKE);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int parentWidth = parent.getWidth();
		int parentHeight = parent.getHeight();

		int childWidth = parentWidth / 3;
		int childHeight = parentHeight / 3;

		setMeasuredDimension(childWidth, childHeight);
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		super.onLayout(changed, left, top, right, bottom);
	}

	public void setMainDiagonalDimensions(float mainDiagonalStartX, float mainDiagonalStartY,
			float mainDiagonalEndX, float mainDiagonalEndY) {
		// Set X start-end
		this.mainStartX = mainDiagonalStartX;
		this.mainEndX = mainDiagonalEndX;

		// Set Y start-end
		this.mainStartY = mainDiagonalStartY;
		this.mainEndY = mainDiagonalEndY;
	}
	
	public void setSecondaryDiagonalDimensions(float secondaryDiagonalStartX, float secondaryDiagonalStartY,
			float secondaryDiagonalEndX, float secondaryDiagonalEndY) {
		// Set X start-end
		this.secondaryStartX = secondaryDiagonalStartX;
		this.secondaryEndX = secondaryDiagonalEndX;

		// Set Y start-end
		this.secondaryStartY = secondaryDiagonalStartY;
		this.secondaryEndY = secondaryDiagonalEndY;
	}
	
	public void setCircleDimensions(float circleX, float circleY,
			float circleRadius) {
		// Set Default circle X and Y
		this.circleX = circleX;
		this.circleY = circleY;

		// Set Default Circle radius
		this.circleRadius = circleRadius;
	}

	private void initDefaultLineDimensions() {
		// Set Default X start-end
		this.mainStartX = 0;
		this.mainEndX = 0;

		// Set Default Y start-end
		this.mainStartY = 0;
		this.mainEndY = 0;
	}
	
	private void initDefaultCircleDimensions() {
		// Set Default circle X and Y
		this.circleX = 0;
		this.circleY = 0;

		// Set Default Circle radius
		this.circleRadius = 0;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		CrossSingleton instance = CrossSingleton.getInstance();
		boolean isCross = instance.getCross();
		if(isCross) {
			canvas.drawLine(mainStartX, mainStartY, mainEndX, mainEndY, drawPaint);
			canvas.drawLine(secondaryStartX, secondaryStartY, secondaryEndX, secondaryEndY, drawPaint);
		} else {
			canvas.drawCircle(circleX, circleY, circleRadius, drawPaint);
		}
	}

	public void setClicked(boolean clicked) {
		this.isClicked = clicked;
	}
	
	public boolean getClicked() {
		return this.isClicked;
	}

	public void setSymbolType(boolean status) {
		if(status == true) {
			this.symbolType = symbolTypeCross;
		} else {
			this.symbolType = symbolTypeCircle;
		}
	}
	
	public String getSymbolType() {
		return this.symbolType;
	}
}
