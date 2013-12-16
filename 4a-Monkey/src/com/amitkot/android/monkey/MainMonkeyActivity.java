package com.amitkot.android.monkey;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainMonkeyActivity extends Activity {

	private static final String TAG = MainMonkeyActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_monkey);
	}

	public void yesClicked(View view) {
		Log.i(TAG, "yes clicked");
	}

	public void noClicked(View view) {
		Log.i(TAG, "no clicked");
	}

	public void maybeClicked(View view) {
		Log.i(TAG, "maybe clicked");
	}
}
