package com.amitkot.android.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainUiActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_ui);

		Button btn = (Button) findViewById(R.id.btn_programmatic);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainUiActivity.this,
						ProgrammaticActivity.class);
				startActivity(intent);
			}
		});
	}

	public void startLinearLayout(View view) {
		Intent intent = new Intent(this, LinearActivity.class);
		startActivity(intent);
	}

	public void startLinearLayout2(View view) {
		Intent intent = new Intent(this, LinearActivity2.class);
		startActivity(intent);
	}

	public void startRelativeLayout(View view) {
		Intent intent = new Intent(this, RelativeActivity.class);
		startActivity(intent);
	}

	public void startFrameLayout(View view) {
		Intent intent = new Intent(this, FrameActivity.class);
		startActivity(intent);
	}
}
