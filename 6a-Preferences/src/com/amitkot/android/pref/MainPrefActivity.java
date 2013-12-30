package com.amitkot.android.pref;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

public class MainPrefActivity extends Activity {

	private SharedPreferences mPrefs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_pref);

		mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
	}

	public void openPreferences(View view) {
		Intent intent = new Intent(this, PrefActivity.class);
		startActivity(intent);
	}

	public void showValues(View view) {
		boolean fruitBool = mPrefs.getBoolean(PrefActivity.KEY_PREF_FRUIT_BOOL,
				true);
		String fruitTxt = mPrefs
				.getString(PrefActivity.KEY_PREF_FRUIT_NAME, "");

		String txt = "Fruit (" + fruitBool + ")\n" + "Which (" + fruitTxt + ")";

		Toast.makeText(this, txt, Toast.LENGTH_LONG).show();
	}

	public void disableFruits(View view) {
		Editor editor = mPrefs.edit();
		editor.putBoolean(PrefActivity.KEY_PREF_FRUIT_BOOL, false);
		editor.apply();
	}

	public void advancedFruits(View view) {
		Intent intent = new Intent(this, AdvancedFruitPrefActivity.class);
		startActivity(intent);
	}

}
