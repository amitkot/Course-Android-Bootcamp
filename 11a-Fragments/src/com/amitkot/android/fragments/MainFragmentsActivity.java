package com.amitkot.android.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.amitkot.android.fragments.util.Util;

public class MainFragmentsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_fragments);

		ViewGroup root = (ViewGroup) findViewById(R.id.content);
		Util.addActivityButton(this, "Static Layout Activity",
				StaticLayoutActivity.class, root);
		Util.addActivityButton(this, "Dynamic Layout Activity",
				DynamicLayoutActivity.class, root);
		Util.addActivityButton(this, "No Retain State Activity",
				NoRetainStateActivity.class, root);
		Util.addActivityButton(this, "Fragment Retain State Activity",
				FragmentRetainStateActivity.class, root);
		Util.addActivityButton(this, "Action Bar Activity",
				ActionBarActivity.class, root);
		Util.addActivityButton(this, "Pass Arguments Activity",
				PassArgumentActivity.class, root);
		Util.addActivityButton(this, "Dialog Fragment Activity",
				FragmentDialogActivity.class, root);
		Util.addActivityButton(this, "List Fragment Activity",
				ListFragmentActivity.class, root);
		Util.addActivityButton(this, "Food Preference Activity",
				FoodPreferenceActivity.class, root);

	}

}
