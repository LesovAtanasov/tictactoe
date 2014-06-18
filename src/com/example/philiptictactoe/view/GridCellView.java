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

public class GridCellView extends View {

	private Paint drawPaint;

	private ViewGroup parent;

	private float lineStartX;

	private float lineStartY;

	private float lineEndX;

	private float lineEndY;

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
	}

	private void initPaint() {
		drawPaint = new Paint();
		drawPaint.setColor(Color.RED);
		drawPaint.setStrokeWidth(25);
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

	public void setLineDimensions(float lineStartX, float lineStartY,
			float lineEndX, float lineEndY) {
		// Set X start-end
		this.lineStartX = lineStartX;
		this.lineEndX = lineEndX;

		// Set Y start-end
		this.lineStartY = lineStartY;
		this.lineEndY = lineEndY;
	}

	private void initDefaultLineDimensions() {
		// Set Default X start-end
		this.lineStartX = 0;
		this.lineEndX = 0;

		// Set Default Y start-end
		this.lineStartY = 0;
		this.lineEndY = 0;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		// if(isCross)
		// {
		//
		canvas.drawLine(lineStartX, lineStartY, lineEndX, lineEndY, drawPaint);
		// }
		// else
		// {
//		canvas.drawCircle(cx, cy, radius, paint);
		// }
	}
}
