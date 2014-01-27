package com.amitkot.android.listview;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FruitArrayAdapter extends ArrayAdapter<Fruit> {

	public FruitArrayAdapter(Context context, List<Fruit> objects) {
		super(context, R.layout.custom_list_item, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View itemView = convertView;
		if (itemView == null) {
			LayoutInflater inflater = LayoutInflater.from(getContext());
			itemView = inflater.inflate(R.layout.custom_list_item, parent,
					false);
		}
		TextView title = (TextView) itemView.findViewById(R.id.title);
		TextView desc = (TextView) itemView.findViewById(R.id.desc);
		ImageView img = (ImageView) itemView.findViewById(R.id.img);

		Fruit fruit = getItem(position);
		title.setText(fruit.name);
		desc.setText(fruit.description);
		img.setImageResource(fruit.imgResource);

		return itemView;
	}

}
