package com.amitkot.android.services;

import com.amitkot.android.services.BoundService.BoundServiceBinder;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

public class MainServicesActivity extends Activity {

	private static final String TAG = MainServicesActivity.class
			.getSimpleName();
	protected BoundServiceBinder mBoundServiceBinder;
	protected boolean mBound;

	private ServiceConnection mConn = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.i(TAG, "Bound service disconnected");
			mBound = false;
			findViewById(R.id.send1).setEnabled(false);
			findViewById(R.id.send2).setEnabled(false);
			findViewById(R.id.send3).setEnabled(false);
			findViewById(R.id.unbindService).setEnabled(false);
			findViewById(R.id.sendThread).setEnabled(false);
		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.i(TAG, "Bound service connected");
			mBound = true;
			mBoundServiceBinder = (BoundServiceBinder) service;
			findViewById(R.id.send1).setEnabled(true);
			findViewById(R.id.send2).setEnabled(true);
			findViewById(R.id.send3).setEnabled(true);
			findViewById(R.id.unbindService).setEnabled(true);
			findViewById(R.id.sendThread).setEnabled(true);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_services);
	}

	public void startIntentService(View view) {
		String txt = "New intent service!";
		Log.i(TAG, "from Activity, thread:" + Thread.currentThread().getName()
				+ ", data: " + txt);

		Intent intent = new Intent(this, LogIntentService.class);
		intent.putExtra(LogIntentService.KEY_DATA, txt);
		startService(intent);
	}

	public void startUnboundService(View view) {
		String txt = "New unbound service!";
		Log.i(TAG, "from Activity, thread:" + Thread.currentThread().getName()
				+ ", data: " + txt);

		Intent intent = new Intent(this, UnboundService.class);
		intent.putExtra(UnboundService.KEY_DATA, txt);
		startService(intent);
	}

	public void bindBoundService(View view) {
		Intent service = new Intent(this, BoundService.class);
		bindService(service, mConn, Context.BIND_AUTO_CREATE);
	}

	public void unbindBoundService(View view) {
		unbindService(mConn);
		mBound = false;
		findViewById(R.id.send1).setEnabled(false);
		findViewById(R.id.send2).setEnabled(false);
		findViewById(R.id.send3).setEnabled(false);
		findViewById(R.id.unbindService).setEnabled(false);
		findViewById(R.id.sendThread).setEnabled(false);
	}

	public void sendBoundService1(View view) {
		mBoundServiceBinder.logText("1");
		mBoundServiceBinder.toastText("1");
	}

	public void sendBoundService2(View view) {
		mBoundServiceBinder.logText("2");
		mBoundServiceBinder.toastText("2");
	}

	public void sendBoundService3(View view) {
		mBoundServiceBinder.logText("3");
		mBoundServiceBinder.toastText("3");
	}
	
	public void sendOnThread(View view) {
		mBoundServiceBinder.startThread("sendOnThread");
	}
}
