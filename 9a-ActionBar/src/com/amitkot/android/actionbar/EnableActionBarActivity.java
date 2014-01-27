package com.amitkot.android.actionbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class EnableActionBarActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enable_action_bar);
	}
	
	public void hideActionBarTemporarily(View view) {
		getActionBar().hide();
	}
}
