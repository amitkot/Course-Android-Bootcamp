package com.amitkot.android.processes;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class SimpleAsyncTask extends Activity {

	private class SimpleTask extends AsyncTask<Integer, Void, Void> {

		private static final String TAG = "SimpleTask";

		@Override
		protected Void doInBackground(Integer... params) {
			int time = params[0];
			int steps = time / 100;
			for (int i = 0; i < steps; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {}
				Log.d(TAG, String.valueOf(i));
			}
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			Toast.makeText(SimpleAsyncTask.this, "Task is finished!", Toast.LENGTH_LONG).show();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_async_task);
		
		Toast.makeText(SimpleAsyncTask.this, "Before task", Toast.LENGTH_SHORT).show();
		SimpleTask task = new SimpleTask();
		task.execute(10000);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.simple_async_task, menu);
		return true;
	}
}
