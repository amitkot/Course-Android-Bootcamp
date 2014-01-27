package com.amitkot.android.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class LogIntentService extends IntentService {
	public final static String KEY_DATA = "com.amitkot.android.service.log_intent_service.data";
	private static final String TAG = LogIntentService.class.getSimpleName();

	public LogIntentService() {
		super(TAG);
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		final String txt = intent.getStringExtra(KEY_DATA);
		Log.i(TAG, "From Service, thread:" + Thread.currentThread().getName()
				+ ", data: " + txt);
		Toast.makeText(this, txt, Toast.LENGTH_SHORT).show(); // Will do nothing
	}
}
