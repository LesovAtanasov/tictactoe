package com.example.philiptictactoe.adapter;

import java.util.List;

import com.example.philiptictactoe.R;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

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
		Button btn;
		if (convertView == null) {
			// if it's not recycled, initialize some attributes
			btn = new Button(mContext);
			btn.setLayoutParams(new GridView.LayoutParams(100, 55));
			btn.setPadding(8, 8, 8, 8);
		} else {
			btn = (Button) convertView;
		}
		btn.setText(filesnames[position]);
		// filenames is an array of strings
		btn.setTextColor(Color.WHITE);
		btn.setBackgroundResource(R.drawable.ic_launcher);
		btn.setId(position);

		return btn;
	}

}
