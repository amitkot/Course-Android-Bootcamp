package com.amitkot.android.app_lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainLifecycleActivity extends Activity {

	private static final String TAG = MainLifecycleActivity.class
			.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		notify("onCreate");
		setContentView(R.layout.activity_main_lifecycle);
	}

	@Override
	protected void onStart() {
		super.onStart();
		notify("onStart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		notify("onResume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		notify("onPause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		notify("onStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		notify("onDestroy");
	}

	private void notify(String text) {
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
		Log.d(TAG, "State changed - " + text);
	}

	public void showDialog(View view) {
		Intent intent = new Intent(this, DialogActivity.class);
		startActivity(intent);
	}
}
