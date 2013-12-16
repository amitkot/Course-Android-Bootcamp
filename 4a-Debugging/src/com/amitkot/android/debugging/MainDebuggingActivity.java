package com.amitkot.android.debugging;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainDebuggingActivity extends Activity {

    private static final String TAG = MainDebuggingActivity.class.getSimpleName();

	@Override
    protected void onCreate(Bundle savedInstanceState) {
		int i;
        Log.d(TAG, "Start of onCreate()");
        i = 30;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_debugging);
        Log.d(TAG, "End of onCreate()");
        i = 30 / 0;
    }

}
