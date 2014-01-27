package com.amitkot.android.listview.UI;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.SimpleAdapter.ViewBinder;

import com.amitkot.android.listview.R;

public class SimpleCustomViewFruitListActivity extends ListActivity {

	private static final String IMG_FIELD = "img";
	private static final String DESC_FIELD = "desc";
	private static final String TITLE_FIELD = "title";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ArrayList<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
		data.add(newDataItem("Apple", "Tasty and red||green||yellow", R.drawable.img_apple));
		data.add(newDataItem("Banana", "Yellow and tasty", R.drawable.img_banana));
		data.add(newDataItem("Lychee", "Special and bright", R.drawable.img_lychee));

		String[] fromFields = {TITLE_FIELD, DESC_FIELD, IMG_FIELD};

		int[] toIds = {R.id.title, R.id.desc, R.id.img};

		SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.custom_list_item, fromFields, toIds);
		adapter.setViewBinder(new ViewBinder() {
			
			@Override
			public boolean setViewValue(View view, Object data,
					String textRepresentation) {
				// TODO Auto-generated method stub
				return false;
			}
		});

		setListAdapter(adapter);
	}

	private HashMap<String, Object> newDataItem(final String title, final String desc, final int img) {
		return new HashMap() {{
			put(TITLE_FIELD, title);
			put(DESC_FIELD, desc);
			put(IMG_FIELD, img);
		}};
	}
}
