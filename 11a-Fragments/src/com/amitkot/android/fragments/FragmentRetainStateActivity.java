package com.amitkot.android.fragments;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;

import com.amitkot.android.fragments.fragments.WorkerFragment;

public class FragmentRetainStateActivity extends Activity {

	private WorkerFragment mWorkerFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_retain_state);

		FragmentManager fm = getFragmentManager();
		mWorkerFragment = (WorkerFragment) fm.findFragmentByTag("worker");

		if (mWorkerFragment == null) {
			mWorkerFragment = WorkerFragment.newInstance();
			fm.beginTransaction().add(mWorkerFragment, "worker").commit();
		}

		Switch retainSwitch = (Switch) findViewById(R.id.switch_retain_state);
		retainSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				mWorkerFragment.setRetainInstance(isChecked);
			}
		});
	}

}
