package com.amitkot.android.processes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class AsyncTaskDemo extends Activity {

	private static final int SIZE_IN_MB = 5;
	private static final String FILE_DL_URL = "http://ipv4.download.thinkbroadband.com/"
			+ SIZE_IN_MB + "MB.zip";

	private AsyncDownloader mTask = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_async_task_demo);

		final ProgressBar progress = (ProgressBar) findViewById(R.id.progress);

		Button btn;
		btn = (Button) findViewById(R.id.btn_start);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mTask = new AsyncDownloader(AsyncTaskDemo.this, progress);
				Toast.makeText(AsyncTaskDemo.this,
						"Downloading file of size " + SIZE_IN_MB + "MB",
						Toast.LENGTH_LONG).show();

				mTask.execute(FILE_DL_URL);
			}
		});

		btn = (Button) findViewById(R.id.btn_cancel);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (mTask != null) {
					mTask.cancel(true);
					mTask = null;
				}
			}
		});

	}

}
