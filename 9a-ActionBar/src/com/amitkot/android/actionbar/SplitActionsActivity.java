package com.amitkot.android.actionbar;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SplitActionsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_split_actions);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.split_actions, menu);
		return true;
	}

}
