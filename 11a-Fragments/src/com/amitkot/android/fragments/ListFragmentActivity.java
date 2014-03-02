package com.amitkot.android.fragments;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class ListFragmentActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_fragment);

		String[] items = { "first", "second", "third", "fourth", "fifth",
				"sixth", "seventh", "eighth", "ninth", "tenth" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, items);
		ListFragment listFragment = new ListFragment();
		listFragment.setListAdapter(adapter);

		getFragmentManager().beginTransaction().add(R.id.content, listFragment)
				.commit();
	}

}
