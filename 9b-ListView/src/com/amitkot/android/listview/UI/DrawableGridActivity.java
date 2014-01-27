package com.amitkot.android.listview.UI;

import java.lang.reflect.Field;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.amitkot.android.listview.R;

public class DrawableGridActivity extends Activity {

	private static final String TAG = DrawableGridActivity.class.getSimpleName();

	private ImageListAdapter mAdapter;
	private GridView mGridView;

	private static class ImageListAdapter extends ArrayAdapter<Integer> {

		private Context mContext;

		public ImageListAdapter(Context context, ArrayList<Integer> data) {
			super(context, 0, data);
			mContext = context;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup root) {
			ImageView imageView;
			if (convertView == null) {
				imageView = new ImageView(mContext);
	            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
	            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
	            imageView.setPadding(8, 8, 8, 8);
			} else {
				imageView = (ImageView) convertView;
			}

			int imageResourceId = getItem(position);
			imageView.setImageResource(imageResourceId);
			return imageView;
		}
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drawable_grid);
		
		Resources res = getResources();
		String packageName = getPackageName();
		ArrayList<Integer> data = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			for (Field field : R.drawable.class.getFields()) {
				String resourceName = field.getName();
				int resourceImage = res.getIdentifier(resourceName, "drawable",
						packageName);
				data.add(resourceImage);
				Log.d(TAG, "adding R.drawble." + resourceName);
			}
		}
			
		mAdapter = new ImageListAdapter(this, data);
		
		mGridView = (GridView) findViewById(R.id.gridview);
		mGridView.setAdapter(mAdapter);
	}

}