package com.amitkot.android.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class UnboundService extends Service {
	public final static String KEY_DATA = "com.amitkot.android.service.unbound_service.data";
	private static final String TAG = LogIntentService.class.getSimpleName();

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		final String txt = intent.getStringExtra(KEY_DATA);
		Log.i(TAG, "from Service, thread:" + Thread.currentThread().getName()
				+ ", data: " + txt);
		Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
		return START_NOT_STICKY;
	}
}
