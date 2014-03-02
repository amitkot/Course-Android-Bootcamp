package com.amitkot.android.fragments;

import android.util.Log;

public class WorkerThread extends Thread {

	private static final String TAG = WorkerThread.class.getSimpleName();

	private int count = 0;
	private boolean mQuiting = false;

	@Override
	public void run() {
		while (true) {
			if (mQuiting) {
				return;
			}
			Log.i(TAG, "count is " + count++);
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void quit() {
		mQuiting = true;
	}

};
