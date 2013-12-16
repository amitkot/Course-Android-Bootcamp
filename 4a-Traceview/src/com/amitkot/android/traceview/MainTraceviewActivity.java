package com.amitkot.android.traceview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainTraceviewActivity extends Activity {

	private static final String TAG = MainTraceviewActivity.class
			.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_traceview);
	}

	@Override
	protected void onResume() {
		super.onResume();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					Log.i(TAG, "before loop");
					for (int i=100000000; i < 1000000000; i++) {
						if (isPrime(i)) {
							Log.i(TAG, "new prime - " + i);
						}
					}
				}
			}

		});
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					Log.i(TAG, "before loop");
					for (int i=100000000; i < 1000000000; i++) {
						Log.i(TAG, "sum of " + i + " is " + 
									calcSum(i));
					}
				}
			}

		});
		t2.start();
	}

	private boolean isPrime(int i) {
		for (int j=2; j<i/3; j++) {
			if (i%j == 0) {
				return false;
			}
		}
		return true;
	};
	
	private long calcSum(int num) {
		long res = 0;
		for (; num > 0; num--) {
			res += num;
		}
		return res;
	}
}
