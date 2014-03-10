package com.amitkot.android.testing_sample_app;

import java.util.HashSet;

public class DataRepository {
	
	private HashSet<String> mSent;

	public DataRepository() {
		mSent = new HashSet<String>();
	}

	public boolean wasTextSent(String text) {
		return mSent.contains(text);
	}

	public boolean updateSendingText(String text) {
		return mSent.add(text);
	}
}
