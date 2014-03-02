package com.amitkot.android.fragments.fragments;

import android.app.Fragment;
import android.os.Bundle;

import com.amitkot.android.fragments.WorkerThread;

public class WorkerFragment extends Fragment {

	protected static final String TAG = WorkerFragment.class.getSimpleName();

	private WorkerThread mWorker = new WorkerThread();

	public static WorkerFragment newInstance() {
		return new WorkerFragment();
	}

	public WorkerFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mWorker.start();
	}

	@Override
	public void onDestroy() {
		mWorker.quit();

		super.onDestroy();
	}
}
