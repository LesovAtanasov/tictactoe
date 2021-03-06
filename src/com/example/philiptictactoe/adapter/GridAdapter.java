package com.example.philiptictactoe.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import com.example.philiptictactoe.R;
import com.example.philiptictactoe.listeners.CellOnClickListener;
import com.example.philiptictactoe.view.GridCellView;

public class GridAdapter extends BaseAdapter {

	private String[] filesnames;
	private Context mContext;

	public GridAdapter(String[] filesnames, Context mContext) {
		this.filesnames = filesnames;
		this.mContext = mContext;

	}

	@Override
	public int getCount() {
		return filesnames.length;
	}

	@Override
	public Object getItem(int position) {
		return filesnames[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rectangle;
		if (convertView == null) {
			rectangle = new GridCellView(mContext, parent);
			rectangle.setId(position);
			rectangle.setLayoutParams(new GridView.LayoutParams(100, 55));
			rectangle.setPadding(8, 8, 8, 8);
			rectangle.setOnClickListener(new CellOnClickListener((GridView) parent));
		} else {
			rectangle = (View) convertView;
		}

		return rectangle;
	}

}
