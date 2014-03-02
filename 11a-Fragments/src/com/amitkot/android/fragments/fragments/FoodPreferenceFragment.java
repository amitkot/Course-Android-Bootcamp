package com.amitkot.android.fragments.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.amitkot.android.fragments.R;

public class FoodPreferenceFragment extends PreferenceFragment {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		addPreferencesFromResource(R.xml.preferences);
	}
}
