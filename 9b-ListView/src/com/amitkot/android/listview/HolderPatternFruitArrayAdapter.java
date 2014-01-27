package com.amitkot.android.listview;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class HolderPatternFruitArrayAdapter extends FruitArrayAdapter {
	
	private static class ViewHolder {
		TextView title;
		TextView desc;
		ImageView img;
	}

	public HolderPatternFruitArrayAdapter(Context context, List<Fruit> objects) {
		super(context, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		View itemView = convertView;
		if (itemView == null) {
			LayoutInflater inflater = LayoutInflater.from(getContext());
			itemView = inflater.inflate(R.layout.custom_list_item, parent,
					false);
			holder = new ViewHolder();
			holder.title = (TextView) itemView.findViewById(R.id.title);
			holder.desc = (TextView) itemView.findViewById(R.id.desc);
			holder.img = (ImageView) itemView.findViewById(R.id.img);

			itemView.setTag(holder);
		} else {
			holder = (ViewHolder) itemView.getTag();
		}

		Fruit fruit = getItem(position);
		holder.title.setText(fruit.name);
		holder.desc.setText(fruit.description);
		holder.img.setImageResource(fruit.imgResource);

		return itemView;
	}

}
