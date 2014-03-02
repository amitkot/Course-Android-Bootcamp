package com.amitkot.android.network;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

public class MainNetworkActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_network);

		ViewGroup root = (ViewGroup) findViewById(R.id.content);
		Util.addActivityButton(this, "Image Download",
				ImageDownloadActivity.class, root);
	}

}
