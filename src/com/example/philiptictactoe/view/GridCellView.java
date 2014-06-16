package com.example.philiptictactoe.view;

import com.example.philiptictactoe.R;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class GridCellView extends View {

	private Drawable cell;

	public GridCellView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public GridCellView(Context context, ViewGroup parent) {
		super(context);
		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mInflater.inflate(R.drawable.rectangle_view, parent, false);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		
		setMeasuredDimension(50, 50);
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		super.onLayout(changed, left, top, right, bottom);
	}

	// @Override
	// protected void onDraw(Canvas canvas) {
	// super.onDraw(canvas);
	// cell.draw(canvas);
	// }
}
