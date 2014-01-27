package com.amitkot.android.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class TelephoneReceiver extends BroadcastReceiver {
	public TelephoneReceiver() {
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle data = intent.getExtras();
		if (data != null) {
			String state = data.getString(TelephonyManager.EXTRA_STATE);
			String msg = new String();
			if (TelephonyManager.EXTRA_STATE_RINGING.equals(state)) {
				String number = data
						.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
				msg = "RINGING: " + number;
			} else if (TelephonyManager.EXTRA_STATE_OFFHOOK.equals(state)) {
				msg = "OFF HOOK";
			} else if (TelephonyManager.EXTRA_STATE_IDLE.equals(state)) {
				msg = "IDLE";
			}
			Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
		}
	}
}
