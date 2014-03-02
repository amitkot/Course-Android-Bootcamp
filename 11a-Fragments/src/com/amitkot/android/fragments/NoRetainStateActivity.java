package com.amitkot.android.fragments;

import android.app.Activity;
import android.os.Bundle;

public class NoRetainStateActivity extends Activity {

	private WorkerThread mWorker = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_no_retain_state);

		if (mWorker == null) {
			mWorker = new WorkerThread();
			mWorker.start();
		}
	}

	@Override
	protected void onDestroy() {
		mWorker.quit();
		super.onDestroy();
	}
}
