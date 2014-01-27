package com.amitkot.android.actionbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ActionsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_actions);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.actions, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_save:
			Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.action_help:
			Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.action_sort:
			Toast.makeText(this, "Sort", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.action_share:
			Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.action_send:
			Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
