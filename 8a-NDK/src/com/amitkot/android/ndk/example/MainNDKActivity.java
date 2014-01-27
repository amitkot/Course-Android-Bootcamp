package com.amitkot.android.ndk.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainNDKActivity extends Activity {

	static {
		System.loadLibrary("Example");
	}

	public native String messageFromNativeCode();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_ndk);
	}

	public void showMessage(View view) {
		String message = messageFromNativeCode();
		new AlertDialog.Builder(this).setMessage(message).show();
	}

	public void showMoreExamples(View view) {
		Intent intent = new Intent(this, ExamplesActivity.class);
		startActivity(intent);
	}

}
