package com.amitkot.android.processes;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

public class MainProcessesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_processes);

		ViewGroup root = (ViewGroup) findViewById(R.id.content);
		Util.addActivityButton(this, "Worker Thread",
				WorkerThreadActivity.class, root);
		Util.addActivityButton(this, "Simple AsyncTask",
				SimpleAsyncTask.class, root);
		Util.addActivityButton(this, "AsyncTask Demo",
				AsyncTaskDemo.class, root);
	}

}
