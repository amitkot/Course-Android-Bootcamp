package com.amitkot.android.actionbar;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

public class SpinnerActionbarActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spinner_actionbar);

		SpinnerAdapter adapter = ArrayAdapter.createFromResource(this,
				R.array.SpinnerOptions,
				android.R.layout.simple_spinner_dropdown_item);
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		OnNavigationListener mNavigationCallback = new OnNavigationListener() {

			@Override
			public boolean onNavigationItemSelected(int itemPosition,
					long itemId) {
				Intent intent;
				switch (itemPosition) {
				case 0:
					return false;

				case 1:
					intent = new Intent(SpinnerActionbarActivity.this, RemoveActionBarActivity.class);
					startActivity(intent);
					return true;

				case 2:
					intent = new Intent(SpinnerActionbarActivity.this, SplitActionsActivity.class);
					startActivity(intent);
					return true;
				}
				return false;
			}

		};
		actionBar.setListNavigationCallbacks(adapter, mNavigationCallback);

	}

}
