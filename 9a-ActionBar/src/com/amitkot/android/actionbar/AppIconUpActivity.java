package com.amitkot.android.actionbar;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

public class AppIconUpActivity extends Activity {

	private ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_app_icon_up);
		actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
	}

}
