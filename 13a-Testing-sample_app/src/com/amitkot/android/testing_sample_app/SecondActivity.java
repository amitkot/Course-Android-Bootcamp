package com.amitkot.android.testing_sample_app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		String data = getIntent().getStringExtra(MainSampleActivity.DATA_INTENT_KEY);
		TextView text = (TextView) findViewById(R.id.resultTextView);
		text.setText(data);
	}

}
