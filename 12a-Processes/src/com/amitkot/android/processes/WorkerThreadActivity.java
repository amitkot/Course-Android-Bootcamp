package com.amitkot.android.processes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class WorkerThreadActivity extends Activity {

	protected WorkerThread mThread = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_worker_thread);
		
		final TextView progress = (TextView) findViewById(R.id.progress);
		
		Button btn;
		btn = (Button) findViewById(R.id.btn_start);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mThread = new WorkerThread(progress);
				mThread.start();
			}
		});

		btn = (Button) findViewById(R.id.btn_cancel);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (mThread != null) {
					mThread.quit();
					mThread = null;
				}
			}
		});

	}

}
