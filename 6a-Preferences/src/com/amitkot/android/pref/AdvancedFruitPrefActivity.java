package com.amitkot.android.pref;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class AdvancedFruitPrefActivity extends PreferenceActivity {

	private static final String PREF_KEY_REGISTER_LISTENER = "second_screen_register_key";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.advanced_preferences);

		Preference register = findPreference(PREF_KEY_REGISTER_LISTENER);
		register.setOnPreferenceClickListener(new OnPreferenceClickListener() {

			@Override
			public boolean onPreferenceClick(Preference preference) {
				registerPrefChanges();
				return true;
			}
		});

	}

	public void registerPrefChanges() {
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(this);
		prefs.registerOnSharedPreferenceChangeListener(new OnSharedPreferenceChangeListener() {

			@Override
			public void onSharedPreferenceChanged(
					SharedPreferences sharedPreferences, String key) {
				String txt = "Preference changed: " + key;
				Toast.makeText(AdvancedFruitPrefActivity.this, txt,
						Toast.LENGTH_SHORT).show();
			}
		});
	}

}
