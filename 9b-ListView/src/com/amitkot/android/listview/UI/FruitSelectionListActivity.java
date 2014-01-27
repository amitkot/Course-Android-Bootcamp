package com.amitkot.android.listview.UI;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.amitkot.android.listview.R;

public class FruitSelectionListActivity extends ListActivity {

	protected ArrayAdapter<String> fruits;
	private int mLayout = android.R.layout.simple_list_item_1; // default
	private int mChoiceMode = ListView.CHOICE_MODE_NONE; // default

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		SpinnerAdapter adapter = ArrayAdapter.createFromResource(this,
				R.array.SelectionSpinnerOptions,
				android.R.layout.simple_spinner_dropdown_item);
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		OnNavigationListener mNavigationCallback = new OnNavigationListener() {

			@Override
			public boolean onNavigationItemSelected(int itemPosition,
					long itemId) {
				switch (itemPosition) {
				case 0: // default
					mLayout = android.R.layout.simple_list_item_1;
					mChoiceMode = ListView.CHOICE_MODE_NONE;
					break;
				case 1: // single choice
					mLayout = android.R.layout.simple_list_item_single_choice;
					mChoiceMode = ListView.CHOICE_MODE_SINGLE;
					break;
				case 2: // multiple choice
					mLayout = android.R.layout.simple_list_item_multiple_choice;
					mChoiceMode = ListView.CHOICE_MODE_MULTIPLE;
					break;
				default:
					throw new IllegalArgumentException();
				}
				initList(mLayout, mChoiceMode);
				return true;
			}
		};

		actionBar.setListNavigationCallbacks(adapter, mNavigationCallback);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.fruit_selection_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_selected:
			if (mChoiceMode == ListView.CHOICE_MODE_NONE) {  // do nothing
				return super.onOptionsItemSelected(item);
			}
			ListView listview = getListView();
			SparseBooleanArray selected = listview.getCheckedItemPositions();
			Toast.makeText(this, selected.size() + " items selected",
					Toast.LENGTH_SHORT).show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void initList(int layout, int choiceMode) {
		ArrayList<String> data = new ArrayList<String>();
		data.add("Apple");
		data.add("Banana");
		data.add("Apricot");
		data.add("Orange");
		data.add("Watermelon");
		data.add("Kiwi");
		data.add("Raspberry");
		data.add("Pineapple");
		data.add("Lychee");
		data.add("Tomato");
		data.add("Peach");
		data.add("Grape");
		data.add("Pear");
		data.add("Anona");
		data.add("Grapefruit");
		data.add("Melon");

		fruits = new ArrayAdapter<String>(FruitSelectionListActivity.this,
				layout, data);

		setListAdapter(fruits);

		ListView listview = getListView();
		listview.setChoiceMode(choiceMode);
	}
}