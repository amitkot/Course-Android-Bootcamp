package com.amitkot.android.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class BoundService extends Service {

	public static final String TAG = BoundService.class.getSimpleName();
	private final IBinder mBinder = new BoundServiceBinder();

	public class BoundServiceBinder extends Binder {
		public void logText(String txt) {
			Log.i(TAG, txt);
		}

		public void toastText(String txt) {
			Toast.makeText(BoundService.this, txt, Toast.LENGTH_SHORT).show();
		}

		public void startThread(final String txt) {
			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {
					Log.i(TAG, "From Service, thread:"
							+ Thread.currentThread().getName() + ", data: "
							+ txt);
				}
			});
			t.start();
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}
}
