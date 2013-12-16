package com.amitkot.android.app_lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class DialogActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog);
	}

	public void goBack(View view) {
		finish();
	}

}
