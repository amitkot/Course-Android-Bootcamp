package com.amitkot.android.broadcastreceivers;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.Toast;

public class MainBroadcastActivity extends Activity {

	private static final String TAG = MainBroadcastActivity.class
			.getSimpleName();

	private boolean mTrackingBattery = false;

	private BatteryReceiver mReceiver;

	private static class BatteryReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			Bundle data = intent.getExtras();
			if (data != null) {
				logBundle(data);
				int status = data.getInt(BatteryManager.EXTRA_STATUS);
				String details = new String();
				switch (status) {
				case BatteryManager.BATTERY_STATUS_CHARGING:
					details = "Charging";
					break;
				case BatteryManager.BATTERY_STATUS_DISCHARGING:
					details = "Discharging";
					break;
				case BatteryManager.BATTERY_STATUS_FULL:
					details = "Full";
					break;
				case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
					details = "Not charging";
					break;
				default:
					details = "Unknown";
				}
				int level = data.getInt(BatteryManager.EXTRA_LEVEL);
				Toast.makeText(context,
						String.format("Battery: %s (%d)", details, level),
						Toast.LENGTH_SHORT).show();
			}

		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_broadcast);

		mReceiver = new BatteryReceiver();

		Switch batteryTracking = (Switch) findViewById(R.id.battery_switch);
		batteryTracking.setChecked(mTrackingBattery);
		batteryTracking
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (isChecked) {
							registerTracker();
						} else {
							unregisterTracker();
						}
					}
				});
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (mTrackingBattery) {
			registerTracker();
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (mTrackingBattery) {
			unregisterTracker();
		}
	}

	protected void registerTracker() {
		IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
		Intent intent = registerReceiver(mReceiver, filter);
		mTrackingBattery = true;
	}

	protected void unregisterTracker() {
		unregisterReceiver(mReceiver);
		mTrackingBattery = false;
	}

	static public void logBundle(Bundle bundle) {
		Log.d(TAG, "BEGIN bundle data");
		for (String key : bundle.keySet()) {
			Object value = bundle.get(key);
			Log.d(TAG, String.format("%s %s (%s)", key, value.toString(), value
					.getClass().getName()));
		}
		Log.d(TAG, "END bundle data");
	}
}
