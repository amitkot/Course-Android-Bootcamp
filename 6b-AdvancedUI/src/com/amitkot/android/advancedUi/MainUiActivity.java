package com.amitkot.android.advancedUi;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Toast;

public class MainUiActivity extends Activity {

	protected static final int PAIRS_DATA_CODE = 340;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_ui);
	}

	public void usingResourcesInProgrammatic(View view) {
		final String options[] = { "0", "1", "2", "3", "4", "5" };
		new AlertDialog.Builder(this)
				.setTitle("How many pairs?")
				.setItems(options, new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						Intent intent = new Intent(MainUiActivity.this,
								ResourceInProgrammaticActivity.class);
						Integer num = Integer.valueOf(options[which]);
						intent.putExtra(
								ResourceInProgrammaticActivity.INTENT_KEY_NUMBER_OF_PAIRS,
								num);
						startActivityForResult(intent, PAIRS_DATA_CODE);

					}
				}).show();
	}
	
	public void dynamicScreenSize(View view) {
		Intent intent = new Intent(this, DynamicScreenActivity.class);
		startActivity(intent);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if (resultCode == RESULT_OK && requestCode == PAIRS_DATA_CODE) {
			String[] userData = data.getStringArrayExtra(ResourceInProgrammaticActivity.INTENT_KEY_USER_DATA);
			StringBuilder sb = new StringBuilder();
			for (String item : userData) {
				sb.append(item).append(", ");
			}
			Toast.makeText(this, sb.toString(), Toast.LENGTH_LONG).show();
		}
	}
}
