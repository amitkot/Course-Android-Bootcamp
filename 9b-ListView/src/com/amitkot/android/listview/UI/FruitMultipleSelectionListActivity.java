package com.amitkot.android.listview.UI;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FruitMultipleSelectionListActivity extends ListActivity {

	protected ArrayAdapter<String> fruits;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		initList();
	}

	private void initList() {
		ArrayList<String> data = new ArrayList<String>();
		data.add("Apple");
		data.add("Banana");
		data.add("Apricot");

		fruits = new ArrayAdapter<String>(
				FruitMultipleSelectionListActivity.this,
				android.R.layout.simple_list_item_multiple_choice, data);

		setListAdapter(fruits);

		ListView listview = getListView();
		listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	}
}
