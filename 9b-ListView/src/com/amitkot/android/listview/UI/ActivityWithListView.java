package com.amitkot.android.listview.UI;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.amitkot.android.listview.R;

public class ActivityWithListView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_with_list_view);

		String[] items = { "First", "Second", "Third", "Fourth", "Fifth",
				"Last" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, items);
		ListView list = (ListView) findViewById(R.id.list);
		list.setAdapter(adapter);
	}

}
