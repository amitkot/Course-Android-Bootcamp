package com.amitkot.android.processes;

import android.util.Log;
import android.widget.TextView;

public class WorkerThread extends Thread {

	private static final String TAG = WorkerThread.class.getSimpleName();

	private int count = 0;
	private boolean mQuiting = false;

	private TextView mProgress;

	public WorkerThread(TextView progress) {
		mProgress = progress;
	}

	@Override
	public void run() {
		while (true) {
			if (mQuiting) {
				return;
			}
			try {
				sleep(500);
			} catch (InterruptedException e) {}
			count += 1;
			Log.i(TAG, "count is " + count);
			mProgress.post(new Runnable() {

				@Override
				public void run() {
					mProgress.setText(String.valueOf(count));
				}
			});
		}
	}

	public void quit() {
		mQuiting = true;
	}

};
