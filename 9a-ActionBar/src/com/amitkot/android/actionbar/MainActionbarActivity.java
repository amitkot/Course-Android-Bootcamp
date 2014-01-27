package com.amitkot.android.actionbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActionbarActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_actionbar);
	}

	public void openEnableActionBarActivity(View view) {
		Intent intent = new Intent(this, EnableActionBarActivity.class);
		startActivity(intent);
	}

	public void openRemoveActionBarActivity(View view) {
		Intent intent = new Intent(this, RemoveActionBarActivity.class);
		startActivity(intent);
	}

	public void openActionsActivity(View view) {
		Intent intent = new Intent(this, ActionsActivity.class);
		startActivity(intent);
	}

	public void openSplitActionsActivity(View view) {
		Intent intent = new Intent(this, SplitActionsActivity.class);
		startActivity(intent);
	}

	public void openAppIconUpActivity(View view) {
		Intent intent = new Intent(this, AppIconUpActivity.class);
		startActivity(intent);
	}

	public void openSpinnerActionbarActivity(View view) {
		Intent intent = new Intent(this, SpinnerActionbarActivity.class);
		startActivity(intent);
	}
}
