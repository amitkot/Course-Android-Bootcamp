package com.amitkot.android.pref;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class PrefActivity extends PreferenceActivity {

	public static final String KEY_PREF_FRUIT_BOOL = "pref_eat_fruit";
	public static final String KEY_PREF_FRUIT_NAME = "pref_selected_fruit";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);
	}

}
