package com.amitkot.android.fragments;

import android.app.Activity;
import android.os.Bundle;

import com.amitkot.android.fragments.fragments.FoodPreferenceFragment;

public class FoodPreferenceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_food_preference);

		getFragmentManager().beginTransaction()
				.replace(android.R.id.content, new FoodPreferenceFragment())
				.commit();
	}

}
